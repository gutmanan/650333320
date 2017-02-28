/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Yair Etzion
 */
public class ApproveParticipationControl {

    public ResultSet getShowsInvatation(){
        
       String sql = "SELECT tblArtist.stageName, tblShowInvitation.showID, tblArtist.agentID\n" +
                    "FROM tblArtist INNER JOIN tblShowInvitation ON tblArtist.artistAlphaCode = tblShowInvitation.artistID\n" +
                    "WHERE (((tblArtist.agentID) Like \""+WindowManager.getTmpAgent().getId()+"\") AND ((tblShowInvitation.approval) Like \"Awaiting\"));";
       
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        return rs;
    }
    
    public ResultSet getShowDetails(int showId){
        
        String sql = "SELECT tblArtist.stageName, tblShow.showDate, tblPlace.name, tblShow.createDate, tblShow.ticketPrice, tblShow.minAge, [firstName]+\" \"+[lastName] AS Expr1\n" +
                        "FROM tblPlace INNER JOIN ((tblAgent INNER JOIN tblArtist ON tblAgent.ID = tblArtist.agentID) INNER JOIN tblShow ON (tblArtist.artistAlphaCode = tblShow.mainArtist) AND (tblAgent.ID = tblShow.agentID)) ON tblPlace.placeNumber = tblShow.place\n" +
                        "WHERE (((tblShow.showNumber) Like \""+showId+"\"));";
        
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        return rs;
        
    }
                  
    public ResultSet getArtistForShow(int showNum){
       
       String sql = "SELECT tblArtist.stageName, tblShowInvitation.approval\n" +
                    "FROM tblArtist INNER JOIN tblShowInvitation ON tblArtist.artistAlphaCode = tblShowInvitation.artistID\n" +
                    "WHERE (((tblShowInvitation.showID) Like \""+showNum+"\"));";
       
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        return rs;
    }
    
    public void approveParticipation(String stageName,int showNumber){
        
        String artistId = getArtistId(stageName);
        
        String sql = "UPDATE tblShowInvitation SET approval = 'approved' WHERE showID ='"+showNumber+"' AND artistID ='"+artistId+"'";
            
        HandsInTheAir.getDB().insert(sql);
        
        JOptionPane.showMessageDialog(null, "The artist is approved!");

        approveShow(showNumber);
    }
    
    public void cancelParticipation(String stageName,int showNumber){
        
        String artistId = getArtistId(stageName);
        
        String sql = "UPDATE tblShowInvitation SET approval = 'Awaiting' WHERE showID ='"+showNumber+"' AND artistID ='"+artistId+"'";
            
        HandsInTheAir.getDB().insert(sql);
        
        JOptionPane.showMessageDialog(null, "The artist is canceld!");
        
        cancelShow(showNumber);
        
    }

     public String getArtistId(String stageName){
        
        String sql = "SELECT tblArtist.artistAlphaCode, tblArtist.stageName\n" +
            "FROM tblArtist\n" +
            "WHERE (((tblArtist.stageName) Like \""+stageName+"\"));";
        
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        try {
            while(rs.next())
                return rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(ChangeArtistDetailsControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
     
    public HashMap<Date,String> getShowsForArtist(String stageName,Date dateShow){
       
        HashMap<Date,String> shows = new HashMap<Date,String>();
        
        try {
            String artistId = getArtistId(stageName);
            Date beginDate = (Date) dateShow.clone();
            Date lastDate = (Date) dateShow.clone();
            
            beginDate.setDate(beginDate.getDate()-7);
            lastDate.setDate(beginDate.getDate()+7);
            
            
            
            String sql = "SELECT tblArtist.stageName, tblShow.showDate, tblShow.status\n" +
                    "FROM tblArtist INNER JOIN tblShow ON tblArtist.artistAlphaCode = tblShow.mainArtist\n" +
                    "WHERE (((tblArtist.stageName) Like \""+stageName+"\")) AND (((tblShow.status) Like 'Approved'));";
            
            ResultSet rs = HandsInTheAir.getDB().query(sql);
            
            while(rs.next()){
                if (beginDate.before(rs.getDate(2)) && lastDate.after(rs.getDate(2)))
                    shows.put(rs.getDate(2), stageName);
            }
            
            sql ="SELECT tblShow.showDate, tblShow.mainArtist, tblArtist.stageName\n" +
                    "FROM (tblArtist INNER JOIN tblShowInvitation ON tblArtist.artistAlphaCode = tblShowInvitation.artistID) INNER JOIN tblShow ON (tblShow.showNumber = tblShowInvitation.showID) AND (tblArtist.artistAlphaCode = tblShow.mainArtist)\n" +
                    "WHERE (((tblShowInvitation.artistID) Like \""+getArtistId(stageName)+"\") AND ((tblShowInvitation.approval) Like 'approved'));";
            
            rs = HandsInTheAir.getDB().query(sql);
            
            while(rs.next()){
                if (beginDate.before(rs.getDate(1)) && lastDate.after(rs.getDate(1)))
                    shows.put(rs.getDate(1), rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApproveParticipationControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return shows;
    }

    public void approveShow(int showNumber){
        
        try {
            String sql = "SELECT tblShowInvitation.showID, tblShowInvitation.approval\n" +
                    "FROM tblShowInvitation\n" +
                    "WHERE (((tblShowInvitation.showID) Like \""+showNumber+"\") AND ((tblShowInvitation.approval) Like 'Awaiting'));";
            
            ResultSet rs = HandsInTheAir.getDB().query(sql);
            
            while(rs.next()){
                return;
            }
            
            sql = "UPDATE tblShow SET status = 'Approved' WHERE showNumber ='"+showNumber+"'";
            
            HandsInTheAir.getDB().insert(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ApproveParticipationControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void cancelShow(int showNumber){
        
            String sql = "UPDATE tblShow SET status = 'Canceled' WHERE showID ='"+showNumber+"'";
            
            HandsInTheAir.getDB().insert(sql);

            sql = "UPDATE tblShowInvitation SET approval = 'not agreed' WHERE showID ='"+showNumber+"'";
            
            HandsInTheAir.getDB().insert(sql);

    }
}
