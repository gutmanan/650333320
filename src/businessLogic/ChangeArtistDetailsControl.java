/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Yair Etzion
 */
public class ChangeArtistDetailsControl {
    
    public ChangeArtistDetailsControl(){
        
    }
    
    public ResultSet getArtistsPerAgent(){
        
            String sql = "SELECT tblArtist.*, tblArtist.stageName\n" +
                            "FROM tblArtist\n" +
                            "WHERE (((tblArtist.agentID) Like \""+WindowManager.tmpAgent.getId()+"\"))\n" +
                            "ORDER BY tblArtist.stageName";

        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        return rs;
        
        }
    
    public ResultSet getAllArtists(){
        
        String sql = "SELECT  tblArtist.artistAlphaCode, tblArtist.stageName, tblArtist.email, tblArtist.facebook, tblArtist.IsActive, tblArtist.activationDate\n" +
                    "FROM tblArtist\n" +
                    "ORDER BY tblArtist.stageName";    

        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        return rs;
        
        }
        
    public ResultSet checkAppreciate(String artistId,String artistId2){
        
        String sql = "SELECT tblAppreciation.*\n" +
                    "FROM tblAppreciation\n" +
                    "WHERE (((tblAppreciation.artistID) Like \""+artistId+"\") AND ((tblAppreciation.appreciatedArtistID) Like \""+artistId2+"\"))";
        
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        return rs;

    }
    
    public void updateDetails(String artistId , String Facebook,String eMail,String date,String bio){
        
        
        
    }
    
    public boolean newApp(String artistId, String artistToAppStageName, boolean flg){
       
        try {
           
            if (flg){
                JOptionPane.showMessageDialog(null, "The artist is already appreciated");
                return false;
            }
            
            String sql = "SELECT tblArtist.artistAlphaCode\n" +
                    "FROM tblArtist\n" +
                    "WHERE (((tblArtist.stageName) Like \""+artistToAppStageName+"\"))";
            
            ResultSet rs = HandsInTheAir.getDB().query(sql);
            
            String artistToAddCode = null;
            
            while(rs.next())
                artistToAddCode = rs.getString(1);

            if (artistToAddCode==null) return false;
            
            String qry = ("INSERT INTO tblAppreciation (artistID, appreciatedArtistID) VALUES('"
            +artistId+"','"+artistToAddCode+"')");
            
            HandsInTheAir.getDB().insert(qry);
            JOptionPane.showMessageDialog(null, "The artist was added successfuly!");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ChangeArtistDetailsControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
        
    }
    
    public boolean deleteApp(String artistId, String artistToDeleteApp, boolean flg){
        try {
            
        if (!flg){
            JOptionPane.showMessageDialog(null, "The artist is already not appreciated");
            return false;
        }
        
        String sql = "SELECT tblArtist.artistAlphaCode\n" +
                    "FROM tblArtist\n" +
                    "WHERE (((tblArtist.stageName) Like \""+artistToDeleteApp+"\"))";           
            
        ResultSet rs = HandsInTheAir.getDB().query(sql);
            
        String artistToDeleteCode = null;
            
        while(rs.next())
            artistToDeleteCode = rs.getString(1);
                
        sql = "DELETE FROM tblAppreciation WHERE artistID = '"+artistId+"' AND appreciatedArtistID = '"+artistToDeleteCode+"'";
              
        
        HandsInTheAir.getDB().insert(sql);
        
        JOptionPane.showMessageDialog(null, "The artist was removed successfuly!");
        
        } catch (SQLException ex) {
            Logger.getLogger(ChangeArtistDetailsControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
    
}
