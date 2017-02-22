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
import java.sql.Timestamp;
import java.util.Date;
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
    
    public void updateDetails(String artistId , String facebook,String eMail,String date,String bio){
        Date checkedDate = null;
        String  qry = null;
        
        if (!(ValidatorManager.isValidEmailAddress(eMail))){
            JOptionPane.showMessageDialog(null, "The Email field is incorrect. \n Example : abc@def.com");
            return;
        }

        if (!(ValidatorManager.isValidURL(facebook)) || !(ValidatorManager.checkFacebook(facebook))){
            JOptionPane.showMessageDialog(null, "The facebook field is incorrect or empty. \n Please enter full URL address");
            return;
        }
                
        if (bio.length()==0){
            JOptionPane.showMessageDialog(null, "The biography field is empty");
            return;
        }
        
        if (date==null || date.isEmpty()){
            Timestamp ts = new Timestamp(new Date().getTime());
            qry = "UPDATE tblArtist SET biography = '"+bio+"',email = '"
                        +eMail+"',facebook = '"
                        +facebook+"', IsActive = '"+true+"', activationDate = '"+ts+"' WHERE artistAlphaCode=\'"+artistId+"\'";
            activateSql(qry);
            return;
        }
        
        checkedDate = ValidatorManager.isValidDate(date);
        
        if (checkedDate!=null && checkedDate.after(new Date())){
            Timestamp ts = new Timestamp(checkedDate.getTime());
            qry = "UPDATE tblArtist SET biography = '"+bio+"',email = '"+eMail+"',facebook = '"+facebook+"', IsActive = '"+false+"', activationDate = '"+ts+"' WHERE artistAlphaCode=\'"+artistId+"\'"; 
                 
                        
                    

            activateSql(qry);
        }
        
        else{
            JOptionPane.showMessageDialog(null, "The Activation Date is already past or incorrect.\n  Date example : dd/MM/yyyy");
        }
   
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
    
    public void viewUrl(String url){
          try {
                Desktop.getDesktop().browse(new URL(url).toURI());          
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
    public void activateSql(String sql){
        
        HandsInTheAir.getDB().insert(sql);
        
        JOptionPane.showMessageDialog(null, "The artist details was changed successfuly!");
        
    }
}
