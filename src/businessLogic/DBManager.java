/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.io.File;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shai Gutman
 */
public class DBManager {

    private static Connection conn = null;
    private static String dbFile;
    
    public DBManager() {
        try {
            dbFile = (new File("sources/MuzaDataBase.accdb")).getAbsolutePath();
            conn = DriverManager.getConnection("jdbc:ucanaccess://"+dbFile+";COLUMNORDER=DISPLAY");
            DebugManager.setDatabaseStatus(true);
        } catch (SQLException ex) {
            try{
                dbFile = (new File("src/sources/MuzaDataBase.accdb")).getAbsolutePath();
                conn = DriverManager.getConnection("jdbc:ucanaccess://"+dbFile+";COLUMNORDER=DISPLAY");
                DebugManager.setDatabaseStatus(true);
            } catch (SQLException ex1) {
                DebugManager.setDatabaseStatus(false);
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        /*
        String id = "ab1";
        String fn = "aa";
        String ln = "bb";
        String pn = "052-4353467";
        String myURL = "http://example.com/pages/";
        String pass = "12d";
        insert("INSERT INTO tblAgent (ID, firstName, lastName, phoneNumber, email, password) VALUES('"+id+"','"+fn+"','"+ln+"','"+pn+"','"+myURL+"','"+pass+"')");
        */
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
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(qry, Statement.RETURN_GENERATED_KEYS);
            ResultSet result = stmt.getGeneratedKeys();
            if(result.next()){
                id = result.getInt(1);
                DebugManager.objectsPlusPlus();
                return id;
            }
            DebugManager.objectsPlusPlus();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return --id;
    }
}
