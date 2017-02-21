/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

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
public class ViewShowsForUserControl {

    public ResultSet getShows(){
        
       String sql = "SELECT tblShow.showNumber, tblShow.createDate, tblShow.showDate, tblArtist.stageName, tblPlace.name, tblPlace.city, tblShow.ticketPrice, tblShow.minAge\n" +
                    "FROM tblArtist INNER JOIN (tblPlace INNER JOIN tblShow ON tblPlace.placeNumber = tblShow.place) ON tblArtist.artistAlphaCode = tblShow.mainArtist\n" +
                    "WHERE (((tblShow.status)='Approval'))\n" +
                    "ORDER BY tblShow.showDate";
       
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
            Logger.getLogger(ViewShowsForUserControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
        
    public ResultSet getShowsPerPlace(String placeName){
       
       String sql = "SELECT tblShow.showNumber, tblArtist.stageName, tblShow.showDate, tblShow.status, tblShow.createDate, tblShow.ticketPrice, tblShow.minAge\n" +
                    "FROM tblPlace INNER JOIN (tblArtist INNER JOIN tblShow ON tblArtist.artistAlphaCode = tblShow.mainArtist) ON tblPlace.placeNumber = tblShow.place\n" +
                    "WHERE (((tblPlace.name) Like \""+placeName+"\"))";
       
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        return rs;
    }
            
    public ResultSet getArtistForShow(int showNum){
       
       String sql = "SELECT tblShowInvitation.artistID, tblArtist.stageName\n" +
                    "FROM tblArtist INNER JOIN tblShowInvitation ON tblArtist.artistAlphaCode = tblShowInvitation.artistID\n" +
                    "WHERE (((tblShowInvitation.showID) Like \""+showNum+"\"))";
       
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        return rs;
    }
    
    public Double getTicketPriceForShow(int showNum){
       
        try {
            String sql = "SELECT tblShow.ticketPrice\n" +
                    "FROM tblShow\n" +
                    "WHERE (((tblShow.showNumber) Like \""+showNum+"\"))";
            
            ResultSet rs = HandsInTheAir.getDB().query(sql);
            
            while(rs.next())
                return rs.getDouble(1);
        } catch (SQLException ex) {
            Logger.getLogger(ViewShowsForUserControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0.0;
    }
    
    public int isAbleToBuy(String userId,int showNum,String presale,int numOfTicketsLeft){
        
        if (numOfTicketsLeft==0) return 0;
        
        if (presale!=null && buyPresale(userId, showNum, presale))
            return 1;
        
        else{
            try {
                String sql = "SELECT tblShow.*, tblConstants.dateOfChange, tblConstants.regularSaleDays\n" +
                        "FROM tblShow, tblConstants\n" +
                        "WHERE (((tblShow.showNumber) Like \""+showNum+"\"))\n" +
                        "ORDER BY tblConstants.dateOfChange DESC";
                
                ResultSet rs = HandsInTheAir.getDB().query(sql);
                
                while (rs.next()){
                    Date showDate = rs.getDate(3);
                    showDate.setDate(showDate.getDate()-rs.getInt(11));
                    if (showDate.before(new Date()))
                        return 2;
                    else return 3;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ViewShowsForUserControl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return 5;
    }
    
    public boolean buyPresale(String userId, int showNum,String presale){
        
        try {
            String sql = "SELECT tblShow.showNumber, tblArtist.artistAlphaCode, tblArtist.stageName, tblFanOf.userID\n" +
                    "FROM (tblArtist INNER JOIN tblFanOf ON tblArtist.artistAlphaCode = tblFanOf.artistID) INNER JOIN tblShow ON tblArtist.artistAlphaCode = tblShow.mainArtist\n" +
                    "WHERE (((tblShow.showNumber) Like \""+showNum+"\") AND ((tblFanOf.userID) Like \""+userId+"\"))";
            
            ResultSet rs = HandsInTheAir.getDB().query(sql);
                    
            if (rs.next()){
                if (presale.equals("Yes"))
                    return true;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ViewShowsForUserControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public int getDiscount(){
        try {
            String sql = "SELECT tblConstants.dateOfChange, tblConstants.presaleDiscount\n" +
                    "FROM tblConstants\n" +
                    "ORDER BY tblConstants.dateOfChange DESC";
            
            ResultSet rs = HandsInTheAir.getDB().query(sql);
            
            while(rs.next())
                return rs.getInt(2);
            

        } catch (SQLException ex) {
            Logger.getLogger(ViewShowsForUserControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public ResultSet getTicketPerUser(int showNum){
        
        String sql = "SELECT Sum(tblTicketOrder.numOfRegularTickets) AS SumOfnumOfRegularTickets, Sum(tblTicketOrder.numOfPresaleTickets) AS SumOfnumOfPresaleTickets\n" +
                        "FROM tblTicketOrder\n" +
                        "WHERE (((tblTicketOrder.showID) Like \""+showNum+"\") AND ((tblTicketOrder.userID) Like \""+WindowManager.getTmpUser().getUserAlphaCode()+"\"))";
        
        ResultSet rs = HandsInTheAir.getDB().query(sql);
        
        return rs;
    }

    public void buyTickets(int numOfTickets, Integer showNum, String text) {
        if (getNumOfTicketsLeft(showNum)-numOfTickets < 0){
            JOptionPane.showMessageDialog(null, "Not enough tickets left");
            return;
        }
        try {
            String qry = null;
            int num1 = 0;
            int num2 = 0;
            
            ResultSet rs = getTicketPerUser(showNum);
            while(rs.next()){
                num1 = rs.getInt(1);
                num2 = rs.getInt(2);
            }
            
            if (text.equals("Presale :")){
                qry = "UPDATE tblTicketOrder SET numOfRegularTickets = "+num1+",numOfPresaleTickets = "
                        +(num2+numOfTickets)+" WHERE showID="+showNum+" AND userID="+WindowManager.getTmpUser().getUserAlphaCode();
            }
            
            else{
              qry = "UPDATE tblTicketOrder SET numOfRegularTickets="+(num1+numOfTickets)+",numOfPresaleTickets="+num2
                      +" WHERE showID="+showNum+" AND userID=\""+WindowManager.getTmpUser().getUserAlphaCode()+"\""; 
            }
            
            if (num1==0 && num2==0){
                if(text.equals("Presale :"))
                    qry =("INSERT INTO tblPlace (showID, userID, numOfRegularTickets, numOfPresaleTickets) VALUES('"
                        +showNum+"','"+WindowManager.getTmpUser().getUserAlphaCode()+"','"+num1+"','"
                        +num2+numOfTickets+"')");
                else
                    qry =("INSERT INTO tblPlace (showID, userID, numOfRegularTickets, numOfPresaleTickets) VALUES('"
                        +showNum+"','"+WindowManager.getTmpUser().getUserAlphaCode()+"','"+num1+numOfTickets+"','"
                        +num2+"')");
            }
            
            HandsInTheAir.getDB().insert(qry);
            
            JOptionPane.showMessageDialog(null, "You bought the tickets  successfuly!");
        } catch (SQLException ex) {
            Logger.getLogger(ViewShowsForUserControl.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    

    
}
