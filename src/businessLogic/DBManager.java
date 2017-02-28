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
import java.sql.Timestamp;
import java.util.Date;
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
    
    public void updateActive(){
        
        try {
            String sql = "SELECT tblArtist.artistAlphaCode, tblArtist.IsActive, tblArtist.activationDate\n" +
                    "FROM tblArtist";
            ResultSet rs = HandsInTheAir.getDB().query(sql);
            
            while(rs.next()){
                if (rs.getBoolean(2)) continue;
                if (rs.getDate(3)==null || rs.getDate(3).before(new Date())){
                    Timestamp ts = new Timestamp(new Date().getTime());
                    sql = "UPDATE tblArtist SET IsActive = "+true+", activationDate = "+ts+
                            " WHERE artistAlphaCode = '"+rs.getString(1)+"'";
                    
                    HandsInTheAir.getDB().insert(sql);
                            } 
                
            }
        } catch (SQLException ex) {                
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void cancelShowsAfterWaiting(){
        
        try {
            String sql = "SELECT tblShow.showNumber, tblShow.status, tblShow.createDate\n" +
                            "FROM tblShow\n" +
                            "WHERE (((tblShow.status) Like \"Awaiting\"));";
            
            String sql2 = "SELECT tblConstants.dateOfChange, tblConstants.propasalWaitDays\n" +
                            "FROM tblConstants\n" +
                            "ORDER BY tblConstants.dateOfChange DESC;";
            
            ResultSet rs = HandsInTheAir.getDB().query(sql);

            ResultSet rs2 = HandsInTheAir.getDB().query(sql2);
            int waitDays = 0;
            
            while(rs2.next())
                waitDays = rs2.getInt(2);
                
            while(rs.next()){
                Date date = rs.getDate(3);
                date.setDate(date.getDate()+waitDays);
                Date today = new Date();
                if (today.after(date)){
                    sql = "UPDATE tblShow SET status = 'Canceled'"+
                            " WHERE showNumber = '"+rs.getInt(1)+"'";
                    
                    HandsInTheAir.getDB().insert(sql);
                    
                    sql = "UPDATE tblShowInvitation SET approval = 'not agreed' WHERE showID ='"+rs.getInt(1)+"'";
            
                    HandsInTheAir.getDB().insert(sql);
  
                }
            }
        } catch (SQLException ex) {                
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
