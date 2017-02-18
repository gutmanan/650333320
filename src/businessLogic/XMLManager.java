
package businessLogic;

import java.io.*;
import java.sql.*;
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
    public static void write(ResultSet rs) {
        try {
            while (rs.next()) {
                Element show = doc.createElement("Artist");
                Attr attr = doc.createAttribute("ID");
                attr.setValue(rs.getString(1));
                show.setAttributeNode(attr);
                
                Element el = doc.createElement("ShowDate");
                el.appendChild(doc.createTextNode(rs.getString(2)));
                show.appendChild(el);
                
                rootElement.appendChild(show);
            }
        } catch (SQLException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        } catch (TransformerException  ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
