
package businessLogic;

import entity.Artist;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class XMLManager {
    
    private static Document doc = null;
    private static Element rootElement = null;
    private static String fileName;
    private static HashMap<String, ArrayList<java.util.Date>> occupied;
    
    public XMLManager(String filename) {  
        this.fileName = filename;
        this.occupied = new HashMap<String, ArrayList<java.util.Date>>();
    }
    public void importXML() {
        try {
            File file = new File(fileName+".xml");
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            DebugManager.setXMLStatus(true);
            if (doc.hasChildNodes()) {
                printNote(doc.getChildNodes());
            } 
        } catch (ParserConfigurationException ex) {     
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            try {
                File file = new File(fileName+".xml");
                DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document doc = dBuilder.parse(file);
                DebugManager.setXMLStatus(true);
                if (doc.hasChildNodes()) {
                    printNote(doc.getChildNodes());
                }
            } catch (Exception e) {
                DebugManager.setXMLStatus(false);
                System.out.println(e.getMessage());
            }
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void printNote(NodeList nodeList) {
    for (int count = 0; count < nodeList.getLength(); count++) {
	Node tempNode = nodeList.item(count);
	if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
            if (tempNode.hasAttributes()) {
                NamedNodeMap nodeMap = tempNode.getAttributes();
                for (int i = 0; i < nodeMap.getLength(); i++) {
                    Node node = nodeMap.item(i);
                    String string = node.getNodeValue();
                    String lastArtist = null;
                    if (!occupied.containsKey(string) && ValidatorManager.isAlphaCode(string)) {
                        occupied.put(string, new ArrayList<java.util.Date>());
                        lastArtist = string;
                    } else if (lastArtist != null)
                        occupied.get(lastArtist).add(new java.util.Date(Long.valueOf(string)));
                }
            }
            if (tempNode.hasChildNodes()) {
                printNote(tempNode.getChildNodes());
            }
	}
    }
  }
    public static void create(String title) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.newDocument();
            rootElement = doc.createElement(title);
            doc.appendChild(rootElement);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void write(ResultSet rs, HashMap<String, ArrayList<Timestamp>> artistShows) {
        try {
            while (rs.next()) {
                // append child elements to root element
                rootElement.appendChild(getArtist(doc, rs.getString(1), rs.getString(2), rs.getString(4)
                                                  , rs.getBoolean(6), rs.getTimestamp(9), rs.getString(8)));
            }
            NodeList nl = rootElement.getChildNodes();
            for (int i = 0; i < nl.getLength(); i++) {
                NamedNodeMap nnm = nl.item(i).getAttributes();
                String artist = nnm.item(0).getNodeValue();
                if (artistShows.containsKey(artist)) {
                    for (Timestamp date : artistShows.get(artist)) {
                        nl.item(i).appendChild(getShow(doc, date));
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static Node getArtist(Document doc, String id, String stageName, String email
                                               , Boolean isActive, Timestamp activation, String agent) {
        Element artist = doc.createElement("Artist");
        artist.setAttribute("id", id);
        artist.appendChild(getArtistElements(doc, artist, "stageName", stageName));
        artist.appendChild(getArtistElements(doc, artist, "email", email));
        artist.appendChild(getArtistElements(doc, artist, "isActive", isActive.toString()));
        artist.appendChild(getArtistElements(doc, artist, "activationDate", String.valueOf(activation)));
        artist.appendChild(getArtistElements(doc, artist, "agentID", agent));
        return artist;
    }
    private static Node getShow(Document doc, Timestamp date) {
        Element show = doc.createElement("Show");
        show.setAttribute("date", String.valueOf(date));
        return show;
    }
    private static Node getArtistElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
    public static void export(String fileName) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            factory.setAttribute("indent-number", 2);
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fileName+".xml"));
            transformer.transform(source, result);
            DebugManager.setXML1Status(true);
        } catch (TransformerException  ex) {
            DebugManager.setXML1Status(false);
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static HashMap<String, ArrayList<java.util.Date>> getOccupied() {
        return occupied;
    }
    
}