/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.swing.JOptionPane;

/**
 *
 * @author Yair Etzion
 */
public class CreateArtistControl {
    
    public CreateArtistControl(){
        
    }
    
    
    public void newArtist(String stageName, String biography, String email, String facebook, boolean isActive, DataSource source, String agentID){
        
        String id = UUID.randomUUID().toString().substring(0,7);
        
        try {
            String sql = "SELECT tblArtist.artistAlphaCode FROM tblArtist WHERE (((tblArtist.artistAlphaCode) Like \""+id+"\"))";
            ResultSet rs = HandsInTheAir.getDB().query(sql);
            if (rs!=null && rs.next()){
                id = UUID.randomUUID().toString().substring(0,7);
            }
            
            sql = "SELECT tblArtist.stageName FROM tblArtist WHERE (((tblArtist.stageName) Like \""+stageName+"\"))";
            rs = HandsInTheAir.getDB().query(sql);
            if (rs!=null && rs.next()){
                JOptionPane.showMessageDialog(null, "The artist stage name is already exsist");
                return;
            }
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Something wrong. Please try again latter..");
             return;
        }
        
        if (stageName.length()==0){
            JOptionPane.showMessageDialog(null, "The stage name field is empty");
            return;
        }
        
        if (!(ValidatorManager.isValidEmailAddress(email))){
            JOptionPane.showMessageDialog(null, "The Email field is incorrect. \n Example : abc@def.com");
            return;
        }
        
        if (!(ValidatorManager.isValidURL(facebook))){
            JOptionPane.showMessageDialog(null, "The facebook field is incorrect or empty. \n Please enter full URL address");
            return;
        }
                
        if (biography.length()==0){
            JOptionPane.showMessageDialog(null, "The biography field is empty");
            return;
        }
        
        String qry = ("INSERT INTO tblArtist (artistAlphaCode, stageName, biography, email, facebook, IsActive, Signature, agentID) VALUES('"
                +id+"','"+stageName+"','"+biography+"','"
                +email+"','"+facebook+"','"+isActive+"','"+source+"','"+WindowManager.getTmpAgent().getId()+"')");
                    
        HandsInTheAir.getDB().insert(qry);
        
        JOptionPane.showMessageDialog(null, "The artist was added successfuly!");

    }
}
