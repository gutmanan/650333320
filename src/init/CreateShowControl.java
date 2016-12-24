
package init;

import core.Address;
import core.Agent;
import core.Artist;
import core.Place;
import gui.CreateShow;
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
        ResultSet rs1 = MainClass.getDB().query("SELECT tblArtist.*\n" +
                                            "FROM tblAgent INNER JOIN tblArtist ON tblAgent.ID = tblArtist.agentID\n" +
                                            "WHERE (((tblArtist.agentID)=\""+WindowManager.getTmpAgent().getId()+"\"))");
        ResultSet rs2 = MainClass.getDB().query("SELECT tblPerformance.artistID\n" +
                                            "FROM tblShow INNER JOIN tblPerformance ON tblShow.ID = tblPerformance.showID\n" +
                                            "WHERE (((tblPerformance.showID)=[tblShow].[ID]) AND ((tblShow.date)=#"+selectedDate+"#))");  
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
        ResultSet rs3 = MainClass.getDB().query("SELECT tblPlace.*, tblFavoritePlace.agentID\n" +
                                            "FROM tblPlace INNER JOIN tblFavoritePlace ON tblPlace.ID = tblFavoritePlace.placeID\n" +
                                            "WHERE (((tblFavoritePlace.agentID)=\""+WindowManager.getTmpAgent().getId()+"\"))");    
        ResultSet rs4 = MainClass.getDB().query("SELECT tblPlace.*, tblShow.date, tblShow.place\n" +
                                            "FROM tblPlace INNER JOIN tblShow ON tblPlace.ID = tblShow.place\n" +
                                            "WHERE (((tblShow.date)=#"+selectedDate+"#) AND ((tblShow.place)=[tblPlace].[ID]))");  
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
    public Place getPlace(String placeID) {
        Place tmp = null;
        ResultSet rs = MainClass.getDB().query("SELECT tblPlace.*\n" +
                                                "FROM tblPlace\n" +
                                                "WHERE tblPlace.ID="+placeID);
        try {
            while (rs.next()) {
                tmp = new Place(rs.getInt(1), rs.getString(2),new Address(rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)), 
                                      rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }
    public Collection<Artist> getAvailableAdditionalArtists(Date selectedDate, String mainArtistID) {
        ResultSet rs2 = MainClass.getDB().query("SELECT tblPerformance.artistID\n" +
                                            "FROM tblShow INNER JOIN tblPerformance ON tblShow.ID = tblPerformance.showID\n" +
                                            "WHERE (((tblPerformance.showID)=[tblShow].[ID]) AND ((tblShow.date)=#"+selectedDate+"#))");

        ResultSet rs1 = MainClass.getDB().query("SELECT tblAppreciation.appreciatedArtistID, tblArtist.*\n" +
                                          "FROM tblArtist INNER JOIN (tblAppreciation AS tblAppreciation_1 INNER JOIN tblAppreciation ON tblAppreciation_1.artistID = tblAppreciation.appreciatedArtistID) ON tblArtist.ID = tblAppreciation.artistID\n" +
                                          "WHERE (((tblArtist.ID)=[tblAppreciation_1].[appreciatedArtistID]) AND ((tblAppreciation.appreciatedArtistID)=\""+mainArtistID+"\") AND ((tblArtist.active)=Yes))");
        
        final HashMap<String,Artist> availableAdditionalArtists = new HashMap<>();
        try {
            while (rs1.next()) {
                availableAdditionalArtists.put(rs1.getString(1), 
                new Artist(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5), true, 
                new Agent(rs1.getString(7))));
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
    public Artist getArtist(String artistID) {
        Artist tmp = null;
        ResultSet rs4 = DBManager.query("SELECT tblArtist.*\n" +
                                        "FROM tblArtist " +
                                        "WHERE tblArtist.ID=\""+artistID+"\"");
        try {
            while (rs4.next()) {
                tmp = new Artist(rs4.getString(1), rs4.getString(2), 
                                 rs4.getString(3), rs4.getString(5), 
                                 rs4.getString(4), rs4.getBoolean(6), new Agent(rs4.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }
}
