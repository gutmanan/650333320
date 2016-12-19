/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import core.Agent;
import static init.Main.connectionString;
import static init.Main.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * test
 * @author Shai Gutman
 */
public abstract class Queries {
    
        public static final String connectionString = "jdbc:ucanaccess://src/init/MuzaDataBase.accdb;COLUMNORDER=DISPLAY";

        public static ArrayList<Agent> getAgents() {
            String sql = "SELECT *" + "FROM tblAgent";
            ArrayList<Agent> agnts = new ArrayList<>();
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                try (Connection conn = DriverManager.getConnection(connectionString)) {
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery();
                        while (rs.next()) {
                               agnts.add(new Agent(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
                       }
                } catch (SQLException e) {
                        e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                    e.printStackTrace();
            }
           return agnts;
        }
        
        public static void getAvailableArtists() {
            String sql2 = "SELECT *" + "FROM tblShow " + "WHERE date = '#20/08/2017#'";
            //String sql3 = "SELECT *" + "FROM tblPreformance" + "WHERE showID = ";
           // ArrayList<Artist> artist = new ArrayList<>();
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                try (Connection conn = DriverManager.getConnection(connectionString)) {
                        PreparedStatement stmt = conn.prepareStatement(sql2);
                        ResultSet rs = stmt.executeQuery();
                        while (rs.next()) {
                            System.out.println(rs.getString(1));
                        }
                } catch (SQLException e) {
                        e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                    e.printStackTrace();
            }
        }
}
