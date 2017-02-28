
package businessLogic;

import entity.Address;
import entity.Agent;
import entity.Artist;
import entity.Place;
import boundary.CreateShow;
import entity.E_STATUS;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CreateShowControl {

    public CreateShowControl() {
    }
    
    public Collection<Artist> getAvailableMainArtistForDate(Date selectedDate) {
        ResultSet rs1 = HandsInTheAir.getDB().query("SELECT tblArtist.*\n" +
                                            "FROM tblAgent INNER JOIN tblArtist ON tblAgent.ID = tblArtist.agentID\n" +
                                            "WHERE (((tblArtist.agentID)=\""+WindowManager.getTmpAgent().getId()+"\"))");
        ResultSet rs2 = HandsInTheAir.getDB().query("SELECT tblShowInvitation.artistID\n" +
                                            "FROM tblShow INNER JOIN tblShowInvitation ON tblShow.showNumber = tblShowInvitation.showID\n" +
                                            "WHERE (((tblShowInvitation.showID)=[tblShow].[showNumber]) AND ((tblShow.showDate)=#"+selectedDate+"#))");  
        HashMap<String,Artist> availableMainArtist = new HashMap<>();
        try {
            while (rs1.next()) {
                availableMainArtist.put(rs1.getString(1), getArtistDetails(rs1.getString(1)));
            }
            while (rs2.next()) {
                if (availableMainArtist.containsKey(rs2.getString(1))) {
                    availableMainArtist.remove(rs2.getString(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return availableMainArtist.values();
    }
    public Set<String> getAvailablePlacesForDate(Date selectedDate) {
        ResultSet rs3 = HandsInTheAir.getDB().query("SELECT tblPlace.*, tblFavoritePlace.agentID\n" +
                                            "FROM tblPlace INNER JOIN tblFavoritePlace ON tblPlace.placeNumber = tblFavoritePlace.placeID\n" +
                                            "WHERE (((tblFavoritePlace.agentID)=\""+WindowManager.getTmpAgent().getId()+"\"))");    
        ResultSet rs4 = HandsInTheAir.getDB().query("SELECT tblPlace.*, tblShow.showDate, tblShow.place\n" +
                                            "FROM tblPlace INNER JOIN tblShow ON tblPlace.placeNumber = tblShow.place\n" +
                                            "WHERE (((tblShow.showDate)=#"+selectedDate+"#) AND ((tblShow.place)=[tblPlace].[placeNumber]))");  
        HashMap<String,String> availableShows = new HashMap<>();
        try {
            while (rs3.next()) {
                availableShows.put(rs3.getString(1), rs3.getString(2));
            }
            while (rs4.next()) {
                if (availableShows.containsKey(rs4.getString(1))) {
                    availableShows.remove(rs4.getString(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return availableShows.keySet();
    }
    public Place getPlaceDetails(String placeID) {
        Place tmp = null;
        ResultSet rs = HandsInTheAir.getDB().query("SELECT tblPlace.*\n" +
                                                "FROM tblPlace\n" +
                                                "WHERE tblPlace.placeNumber="+placeID);
        try {
            while (rs.next()) {
                tmp = new Place(rs.getInt(1), rs.getString(2), new Address(rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)), rs.getString(7), 
                                      rs.getString(8), rs.getString(9), rs.getInt(10));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }
    public ArrayList<String> getAvailableAdditionalArtists(Date selectedDate, String mainArtistID) {
        ResultSet rs2 = HandsInTheAir.getDB().query("SELECT tblShowInvitation.artistID\n" +
                                            "FROM tblShow INNER JOIN tblShowInvitation ON tblShow.showNumber = tblShowInvitation.showID\n" +
                                            "WHERE (((tblShowInvitation.showID)=[tblShow].[showNumber]) AND ((tblShow.showDate)=#"+selectedDate+"#))");
        ResultSet rs1 = HandsInTheAir.getDB().query("SELECT tblAppreciation.appreciatedArtistID\n" +
                                            "FROM tblArtist INNER JOIN (tblAppreciation AS tblAppreciation_1 INNER JOIN tblAppreciation ON tblAppreciation_1.artistID = tblAppreciation.appreciatedArtistID) ON tblArtist.artistAlphaCode = tblAppreciation.artistID\n" +
                                            "WHERE (((tblArtist.IsActive)=Yes) AND ((tblAppreciation.artistID)=\""+mainArtistID+"\") AND ((tblAppreciation_1.appreciatedArtistID)=\""+mainArtistID+"\"))");
        ArrayList<String> availableAdditionalArtists = new ArrayList<>();
        try {
            while (rs1.next()) {
                availableAdditionalArtists.add(rs1.getString(1));
            }
            while (rs2.next()) {
                if (availableAdditionalArtists.contains(rs2.getString(1))) {
                    availableAdditionalArtists.remove(availableAdditionalArtists.indexOf(rs2.getString(1)));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return availableAdditionalArtists;
    }
    public Artist getArtistDetails(String artistID) {
        ResultSet rs4 = DBManager.query("SELECT tblArtist.*\n" +
                                        "FROM tblArtist " +
                                        "WHERE tblArtist.artistAlphaCode=\""+artistID+"\"");
        try {
            while (rs4.next()) {
                
                return new Artist(rs4.getString(1), rs4.getString(2), rs4.getString(3), rs4.getString(4), rs4.getString(5), 
                        rs4.getBoolean(6), new Agent(rs4.getString(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<String> getPlacesExcluding(Date selectedDate, Set<String> favs) {
        ArrayList<String> tmp = new ArrayList();
        ResultSet rs3 = HandsInTheAir.getDB().query("SELECT tblPlace.*\n" +
                                            "FROM tblPlace");
        ResultSet rs4 = HandsInTheAir.getDB().query("SELECT tblPlace.*\n" +
                                            "FROM tblPlace INNER JOIN tblShow ON tblPlace.placeNumber = tblShow.place\n" +
                                            "WHERE (((tblShow.showDate)=#"+selectedDate+"#) AND ((tblShow.place)=[tblPlace].[placeNumber]))");  
        try {
            while (rs3.next()) {
                tmp.add(rs3.getString(1));
            }
            while (rs4.next()) {
                if (tmp.contains(rs4.getString(1))) {
                    tmp.remove(tmp.indexOf(rs4.getString(1)));
                }
            }
            for (String p : favs) {
                if (tmp.contains(p)) {
                    tmp.remove(tmp.indexOf(p));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }
    public int newShow(String artist, String agent, Timestamp showDate, String start, int place, String ticketPrice, String minAge) {
        
        if (!checkOpenPlace(showDate, place)){
            JOptionPane.showMessageDialog(null, "You choose open place. You cant creat show during monthes January, February, December");
            return -1;
        }

        
        if (start.length()==0 || !(ValidatorManager.onlyContainsNumbers(start)) || !checkShowTime(start)){
            JOptionPane.showMessageDialog(null, "The Start time field must be a number between 0-23.");
            return -1;
        }
        
        if (ticketPrice.length()==0 || !(ValidatorManager.onlyContainsNumbers(ticketPrice))){
            JOptionPane.showMessageDialog(null, "The Ticket price field must be a number.");
            return -1;
        }
        
        if (minAge.length()==0 || !(ValidatorManager.onlyContainsNumbers(minAge))){
            JOptionPane.showMessageDialog(null, "The Minimum age field must be a number.");
            return -1;
        }
        showDate.setHours(Integer.valueOf(start));
        String qry = "INSERT INTO tblShow (mainArtist, showDate, place, status, createDate, ticketPrice, minAge, agentID)\n"
                   + "VALUES('"+artist+"','"+showDate+"','"+place+"','"+E_STATUS.Awaiting+"','"+new Timestamp(new java.util.Date().getTime())+"'"
                   + ",'"+ticketPrice+"','"+minAge+"','"+agent+"')";
        return DBManager.insert(qry);
    }
    public boolean newArtistInvitations(int showID, String artist) {
        String qry = "INSERT INTO tblShowInvitation (showID, artistID, approval)\n"
                   + "VALUES('"+showID+"','"+artist+"','"+E_STATUS.Awaiting+"')";
        if (DBManager.insert(qry) == -2) {
            return true;
        }
        return false;
    }
 
    public void approveParticipation(int showID){

        ResultSet rs = HandsInTheAir.getDB().query("SELECT tblShowInvitation.showID, tblShowInvitation.artistID, tblArtist.agentID\n" +
                        "FROM tblArtist INNER JOIN tblShowInvitation ON tblArtist.artistAlphaCode = tblShowInvitation.artistID\n" +
                        "WHERE (((tblShowInvitation.showID) Like '"+showID+"'));");
        boolean flg = true;
        try{
        while (rs.next()){
            flg = false;
            if (rs.getString(3).equals(WindowManager.getTmpAgent().getId())){
            String sql = "UPDATE tblShowInvitation SET approval = 'approved' WHERE showID = '"+showID+"'  AND artistID ='"+rs.getString(2)+"'";
          
            HandsInTheAir.getDB().insert(sql);
            }
        }

        if (flg){
            String sql = "UPDATE tblShow SET status = 'Approved' WHERE showNumber = '"+showID+"'";
            HandsInTheAir.getDB().insert(sql);  
  
        }
        
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Something wrong. Please try again latter..");
        }

    }
    
    public boolean checkOpenPlace(Timestamp showDate, int place){
                String sql = "SELECT tblOpenPlace.ID\n" +
                        "FROM tblOpenPlace\n" +
                        "WHERE (((tblOpenPlace.ID) Like '"+place+"'));";
                
                ResultSet rs = HandsInTheAir.getDB().query(sql);
                
        try {
            while(rs.next())
                if (showDate.getMonth()==11 || showDate.getMonth()==0 ||showDate.getMonth()==1)
                    return false;
        } catch (SQLException ex) {
            Logger.getLogger(CreateShowControl.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                return true;
    }
    
    public boolean checkShowTime(String s){

        try {
            Long i = Long.parseLong(s);
            if (i>23 || i<0)
            return false;
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;

    }
}
