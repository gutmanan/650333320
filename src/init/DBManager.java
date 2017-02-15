/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import com.itextpdf.text.pdf.PdfGraphics2D;
import core.Agent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.ucanaccess.jdbc.UcanaccessDriver;

/**
 *
 * @author Shai Gutman
 */
public class DBManager {

    private static Connection conn = null;
    private static String dbFile;
    
    public DBManager() {
        try {
            System.out.println("Trying to load DB...");
            dbFile = (new File("sources/MuzaDataBase.accdb")).getAbsolutePath();
            conn = DriverManager.getConnection("jdbc:ucanaccess://"+dbFile+";COLUMNORDER=DISPLAY");
            System.out.println("DB was loaded!");
        } catch (SQLException ex) {
            try{
                dbFile = (new File("src/sources/MuzaDataBase.accdb")).getAbsolutePath();
                conn = DriverManager.getConnection("jdbc:ucanaccess://"+dbFile+";COLUMNORDER=DISPLAY");
                System.out.println("DB was loaded!");
            } catch (SQLException ex1) {
                System.out.println("Error loading DB!");
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        String id = "ab1";
        String fn = "aa";
        String ln = "bb";
        String pn = "052-4353467";
        String myURL = "http://example.com/pages/";
        String pass = "12d";
        insert("INSERT INTO tblAgent (ID, firstName, lastName, phoneNumber, email, password) VALUES('"+id+"','"+fn+"','"+ln+"','"+pn+"','"+myURL+"','"+pass+"')");
    }
    
    public static ResultSet query(String qry) {
        ResultSet rs = null;
        try {
            PreparedStatement stmt = conn.prepareStatement(qry);
            rs = stmt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
      return rs;
    }
    
    public static int insert(String qry){
        int id = -1;
        HandsInTheAir.writeLog("Sending UPDATE Query: "+qry);
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(qry, Statement.RETURN_GENERATED_KEYS);
            ResultSet result = stmt.getGeneratedKeys();
            if(result.next()){
                id = result.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
}
