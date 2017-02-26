/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.awt.Desktop;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Yair Etzion
 */
public class ViewPlaceInfoForAgentControl {

    public ResultSet getPlaces(){
        
       String sql = "SELECT tblPlace.*\n" +
                    "FROM tblPlace\n" +
                    "ORDER BY tblPlace.name;";
       
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        return rs;
    }
    
    public ResultSet getOpenPlaceDetails(int placeNum){
       
       String sql = "SELECT tblOpenPlace.*\n" +
                    "FROM tblOpenPlace\n" +
                    "WHERE (((tblOpenPlace.ID) Like \""+placeNum+"\"))";
       
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        return rs;
    }
    
    public ResultSet getPlaceInfo(int placeNum){
       
       String sql = "SELECT tblPlace.*\n" +
                    "FROM tblPlace\n" +
                    "WHERE (((tblPlace.placeNumber) Like \""+placeNum+"\"))";
       
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        return rs;
    }
    
    public void viewUrl(String url){
          try {
                Desktop.getDesktop().browse(new URL(url).toURI());          
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
    public ResultSet getFavoritePlaces(){
       
       String sql = "SELECT tblPlace.name, tblPlace.city, tblPlace.email, tblPlace.phoneNumber\n" +
                    "FROM tblPlace INNER JOIN tblFavoritePlace ON tblPlace.placeNumber = tblFavoritePlace.placeID\n" +
                    "WHERE (((tblFavoritePlace.agentID) Like \""+WindowManager.getTmpAgent().getId()+"\"))\n" +
                    "ORDER BY tblPlace.name";
       
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        return rs;
    }
    
    public boolean CheckIfFavorite(int placeNum){
        try {
            String sql = "SELECT tblFavoritePlace.agentID, tblFavoritePlace.placeID\n" +
                    "FROM tblFavoritePlace\n" +
                    "WHERE (((tblFavoritePlace.agentID) Like \""+WindowManager.getTmpAgent().getId()+"\") AND ((tblFavoritePlace.placeID) Like \""+placeNum+"\"));";
            
            ResultSet rs = HandsInTheAir.getDB().query(sql);
            
            while (rs.next())
                return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewPlaceInfoForAgentControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
                    
    }
    
    public void addFavoritePlace(int placeNum){
       
       String qry = ("INSERT INTO tblFavoritePlace (agentID, placeID) VALUES('"
                +WindowManager.getTmpAgent().getId()+"','"+placeNum+"')");
                
        HandsInTheAir.getDB().insert(qry);
        JOptionPane.showMessageDialog(null, "The place was added successfuly!");  

    }
    
    public void removeFavoritePlace(int placeNum){
       
       String sql = "DELETE FROM tblFavoritePlace " +
                    "WHERE agentID = '"+WindowManager.getTmpAgent().getId()+"' AND placeID = '"+placeNum+"'";

        HandsInTheAir.getDB().insert(sql);
        JOptionPane.showMessageDialog(null, "The place was removed successfuly!"); 

    }
    
}
