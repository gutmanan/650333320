
package businessLogic;

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

public abstract class XMLManager {
    
    private static Document doc = null;
    private static Element rootElement = null;
        
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
                if (artistShows.containsKey(rs.getString(1))) {
                    for (Timestamp date : artistShows.get(rs.getString(1))) {
                        rootElement.appendChild(getShow(doc, date));
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
 
    // utility method to create text node
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
            DebugManager.setXMLStatus(true);
        } catch (TransformerException  ex) {
            DebugManager.setXMLStatus(false);
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}