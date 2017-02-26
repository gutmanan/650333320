
package businessLogic;

import entity.Address;
import entity.Agent;
import entity.Artist;
import entity.Place;
import boundary.CreateShow;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateShowControl {

    public CreateShowControl() {
    }
    
    public Set<String> getAvailableMainArtistForDate(Date selectedDate) {
        ResultSet rs1 = HandsInTheAir.getDB().query("SELECT tblArtist.*\n" +
                                            "FROM tblAgent INNER JOIN tblArtist ON tblAgent.ID = tblArtist.agentID\n" +
                                            "WHERE (((tblArtist.agentID)=\""+WindowManager.getTmpAgent().getId()+"\"))");
        ResultSet rs2 = HandsInTheAir.getDB().query("SELECT tblShowInvitation.artistID\n" +
                                            "FROM tblShow INNER JOIN tblShowInvitation ON tblShow.showNumber = tblShowInvitation.showID\n" +
                                            "WHERE (((tblShowInvitation.showID)=[tblShow].[showNumber]) AND ((tblShow.showDate)=#"+selectedDate+"#))");  
        HashMap<String,String> availableMainArtist = new HashMap<>();
        try {
            while (rs1.next()) {
                availableMainArtist.put(rs1.getString(1), rs1.getString(2));
            }
            while (rs2.next()) {
                if (availableMainArtist.containsKey(rs2.getString(1))) {
                    availableMainArtist.remove(rs2.getString(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return availableMainArtist.keySet();
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
    public Collection<Artist> getAvailableAdditionalArtists(Date selectedDate, String mainArtistID) {
        
        ResultSet rs2 = HandsInTheAir.getDB().query("SELECT tblShowInvitation.artistID\n" +
                                            "FROM tblShow INNER JOIN tblShowInvitation ON tblShow.showNumber = tblShowInvitation.showID\n" +
                                            "WHERE (((tblShowInvitation.showID)=[tblShow].[showNumber]) AND ((tblShow.showDate)=#"+selectedDate+"#))");

        ResultSet rs1 = HandsInTheAir.getDB().query("SELECT tblAppreciation.appreciatedArtistID, tblArtist.*\n" +
                                          "FROM tblArtist INNER JOIN (tblAppreciation AS tblAppreciation_1 INNER JOIN tblAppreciation ON tblAppreciation_1.artistID = tblAppreciation.appreciatedArtistID) ON tblArtist.artistAlphaCode = tblAppreciation.artistID\n" +
                                          "WHERE (((tblArtist.artistAlphaCode)=[tblAppreciation_1].[appreciatedArtistID]) AND ((tblAppreciation.appreciatedArtistID)=\""+mainArtistID+"\") AND ((tblArtist.IsActive)=Yes))");
        
        final HashMap<String,Artist> availableAdditionalArtists = new HashMap<>();
        try {
            while (rs1.next()) {
                /*availableAdditionalArtists.put(rs1.getString(1), 
                new Artist(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5), true, 
                new Agent(rs1.getString(7))));
            */
            }
            while (rs2.next()) {
                if (availableAdditionalArtists.containsKey(rs2.getString(1))) {
                    availableAdditionalArtists.remove(rs2.getString(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return availableAdditionalArtists.values();
    }
    public Artist getArtistDetails(String artistID) {
        Artist tmp = null;
        ResultSet rs4 = DBManager.query("SELECT tblArtist.*\n" +
                                        "FROM tblArtist " +
                                        "WHERE tblArtist.ID=\""+artistID+"\"");
        try {
            while (rs4.next()) {
                /*tmp = new Artist(rs4.getString(1), rs4.getString(2), 
                                 rs4.getString(3), rs4.getString(5), 
                                 rs4.getString(4), rs4.getBoolean(6), new Agent(rs4.getString(7)));
            */
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
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
}
