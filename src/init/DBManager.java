/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import core.Agent;
import java.io.File;

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
    
    public DBManager(){
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
        insert("aaa");
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
    
    public static void insert(String a) {
       /* try {          
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT tblAgent" + "(ID, firstName, lastName, phoneNumber, email)"
                                 + "VALUES(" + "jj66" + ", '" + "two" + "', " + "three" + "0526548732" + "fds@gmail.com" + ")");
            stmt.close();
         }
        catch(Exception e) {
            e.printStackTrace();
        }*/

       Statement stmt = null;
       try{
           stmt = conn.createStatement();
           String statment = "INSERT into tblAgent"+" VALUES(aa)";
            stmt.executeUpdate(statment);
       }
       catch(Exception w){
       
       }
    }
}
