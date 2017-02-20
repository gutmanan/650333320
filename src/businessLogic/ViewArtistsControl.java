/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Yair Etzion
 */
public class ViewArtistsControl {
    
    public ResultSet getArtists(){
        
       String sql = "SELECT tblArtist.*\n" +
                    "FROM tblArtist\n" +
                    "ORDER BY tblArtist.stageName";
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        return rs;
    }
    
    public ArrayList<String> getFans(){
        
        ArrayList<String> arr = new ArrayList<String>();
                
        String sql = "SELECT tblFanOf.*, tblArtist.stageName\n" +
                        "FROM tblArtist INNER JOIN tblFanOf ON tblArtist.artistAlphaCode = tblFanOf.artistID\n" +
                        "WHERE (((tblFanOf.userID) Like \""+WindowManager.getTmpUser().getUserAlphaCode()+"\")) ORDER BY tblFanOf.userID;";
        
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        
        try {
            while (rs.next())
                arr.add(rs.getString(3));
        } catch (SQLException ex) {
            Logger.getLogger(ViewArtistsControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arr;
    }
    
    public boolean becomeFan(String artistCode){
        
        ArrayList<String> arr = getFans();
        
        if (arr.contains(artistCode)){
            JOptionPane.showMessageDialog(null, "You are already a fan of this artist");
            return false;
        }
        
        String qry = ("INSERT INTO tblFanOf (userID, artistID) VALUES('"
                +WindowManager.getTmpUser().getUserAlphaCode()+"','"+artistCode+"')");
                
        HandsInTheAir.getDB().insert(qry);
        
        JOptionPane.showMessageDialog(null, "You are now a fan of this artist :)");
        
        return true;
    }
    
}

