/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import core.Agent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
   
    public DBManager(){
        try {
            conn = DriverManager.getConnection("jdbc:ucanaccess://src/init/MuzaDataBase.accdb;COLUMNORDER=DISPLAY");
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
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
}
