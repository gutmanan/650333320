/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.sql.ResultSet;

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
        
   /* public ResultSet checkAppreciate(String name){
        
    }*/
}
