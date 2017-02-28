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


/**
 *
 * @author Yair Etzion
 */
public class ViewShowsForAgentControl {

    public ResultSet getShowsCreated(){
        
       String sql = "SELECT tblShow.showNumber, tblShow.showDate, tblArtist.stageName, tblPlace.name, tblShow.status, tblShow.createDate, tblShow.ticketPrice, tblShow.minAge, tblShow.agentID\n" +
                    "FROM tblPlace INNER JOIN (tblArtist INNER JOIN tblShow ON tblArtist.artistAlphaCode = tblShow.mainArtist) ON tblPlace.placeNumber = tblShow.place\n" +
                    "WHERE (((tblShow.agentID) Like \""+WindowManager.getTmpAgent().getId()+"\"))\n" +
                    "ORDER BY tblShow.showDate DESC;";
       
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        return rs;
    }
    
    public int getNumOfTicketsLeft(int showNumber){
       
       String sql = "SELECT tblTicketOrder.showID, Sum(tblTicketOrder.numOfRegularTickets) AS SumOfnumOfRegularTickets, Sum(tblTicketOrder.numOfPresaleTickets) AS SumOfnumOfPresaleTickets, tblPlace.maxCapacity\n" +
                    "FROM tblPlace INNER JOIN (tblShow INNER JOIN tblTicketOrder ON tblShow.showNumber = tblTicketOrder.showID) ON tblPlace.placeNumber = tblShow.place\n" +
                    "GROUP BY tblTicketOrder.showID, tblPlace.maxCapacity\n" +
                    "HAVING (((tblTicketOrder.showID) Like \""+showNumber+"\"))";
                    
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        try {
            while (rs.next())
                return (rs.getInt(4)-rs.getInt(2)-rs.getInt(3));
        } catch (SQLException ex) {
            Logger.getLogger(ViewShowsForAgentControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sql = "SELECT tblShow.showNumber, tblPlace.maxCapacity\n" +
                "FROM tblPlace INNER JOIN tblShow ON tblPlace.placeNumber = tblShow.place;";
        
        rs = HandsInTheAir.getDB().query(sql);
        
        try {
            while (rs.next())
                return rs.getInt(2);
        } catch (SQLException ex) {
            Logger.getLogger(ViewShowsForAgentControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
          
    public ResultSet getArtistForShow(int showNum){
       
       String sql = "SELECT tblArtist.stageName, tblShowInvitation.approval\n" +
                    "FROM tblArtist INNER JOIN tblShowInvitation ON tblArtist.artistAlphaCode = tblShowInvitation.artistID\n" +
                    "WHERE (((tblShowInvitation.showID) Like \""+showNum+"\"));";
       
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        return rs;
    }
    
    
public void getGoogleMapsLoc(String placeName){

       String sql = "SELECT tblPlace.name, tblPlace.location\n" +
                    "FROM tblPlace\n" +
                    "WHERE (((tblPlace.name) Like \'"+placeName+"\'));";
                    
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        try {
            while (rs.next())
                viewUrl(rs.getURL(2).toString());
                
        } catch (SQLException ex) {
            Logger.getLogger(ViewShowsForAgentControl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
}
    
    
    public void viewUrl(String url){
          try {
                Desktop.getDesktop().browse(new URL(url).toURI());          
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    

}
