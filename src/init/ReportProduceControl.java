/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import core.Agent;
import core.Artist;
import core.E_STATUS;
import core.Place;
import core.Show;
import gui.CreateShow;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportProduceControl {

    public ReportProduceControl() {
    }
    
    public HashMap<Integer, Integer> getPresaleAmonutPerShow(int year) {
        Date yearStart = new Date(year-1900, 0, 1);
        Date yearEnd = new Date(year-1900, 11, 31);
        ResultSet rs1 = MainClass.getDB().query("SELECT tblShow.ID\n" +
                                                "FROM tblShow\n" +
                                                "WHERE (((tblShow.date)>=#"+yearStart+"# And (tblShow.date)<=#"+yearEnd+"#) AND ((tblShow.status)=\"approved\"));");
        ResultSet rs2 = MainClass.getDB().query("SELECT tblShow.ID, tblTicketOrder.numOfTickets\n" +
                                                "FROM (tblTicketOrder INNER JOIN tblFanOf ON tblTicketOrder.userID = tblFanOf.userID) INNER JOIN tblShow ON (tblTicketOrder.showID = tblShow.ID) AND (tblFanOf.artistID = tblShow.mainArtist)\n" +
                                                "WHERE ((DateDiff(\"d\",[createDate],[date])>21) AND (DateDiff(\"d\",[purchaseDate],[date])>14))");
        ResultSet rs3 = MainClass.getDB().query("SELECT tblShow.ID, tblTicketOrder.numOfTickets\n" +
                                                "FROM tblShow INNER JOIN ((tblTicketOrder INNER JOIN tblFanOf ON tblTicketOrder.userID = tblFanOf.userID) INNER JOIN tblPerformance ON (tblFanOf.artistID = tblPerformance.artistID) AND (tblTicketOrder.showID = tblPerformance.showID)) ON (tblShow.ID = tblTicketOrder.showID) AND (tblShow.ID = tblPerformance.showID)\n" +
                                                "WHERE ((DateDiff(\"d\",[createDate],[date])>21) AND (DateDiff(\"d\",[purchaseDate],[date])>14))");
        HashMap<Integer,Integer> presaleAmonutPerShow = new HashMap<>();
        try {
            while (rs1.next()) {            
                presaleAmonutPerShow.put(rs1.getInt(1),0);
            }
            while (rs2.next()) {            
                if (presaleAmonutPerShow.containsKey(rs2.getInt(1))) {
                    presaleAmonutPerShow.put(rs2.getInt(1), rs2.getInt(2));
                }
            }
            while (rs3.next()) {            
                if (presaleAmonutPerShow.containsKey(rs3.getInt(1))) {
                    presaleAmonutPerShow.put(rs3.getInt(1), presaleAmonutPerShow.get(rs3.getInt(1))+rs3.getInt(2));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return presaleAmonutPerShow;
    }
    public HashMap<Integer, Integer> getRegularAmonutPerShow(int year) {
        Date yearStart = new Date(year-1900, 0, 1);
        Date yearEnd = new Date(year-1900, 11, 31);
        ResultSet rs1 = MainClass.getDB().query("SELECT tblShow.ID\n" +
                                                "FROM tblShow\n" +
                                                "WHERE (((tblShow.date)>=#"+yearStart+"# And (tblShow.date)<=#"+yearEnd+"#) AND ((tblShow.status)=\"approved\"));");
        ResultSet rs2 = MainClass.getDB().query("SELECT tblShow.ID, tblTicketOrder.numOfTickets\n" +
                                                "FROM tblShow INNER JOIN tblTicketOrder ON tblShow.ID = tblTicketOrder.showID\n" +
                                                "WHERE ((DateDiff(\"d\",[purchaseDate],[date])<=14))");
        ResultSet rs3 = MainClass.getDB().query("SELECT tblShow.ID, tblTicketOrder.numOfTickets\n" +
                                                "FROM tblShow INNER JOIN tblTicketOrder ON tblShow.ID = tblTicketOrder.showID\n" +
                                                "WHERE ((DateDiff(\"d\",[createDate],[date])<=21))");
        
        HashMap<Integer,Integer> regularAmonutPerShow = new HashMap<>();
        try {
            while (rs1.next()) {            
                regularAmonutPerShow.put(rs1.getInt(1),0);
            }
            while (rs2.next()) {            
                if (regularAmonutPerShow.containsKey(rs2.getInt(1))) {
                    regularAmonutPerShow.put(rs2.getInt(1), rs2.getInt(2));
                }
            }
            while (rs3.next()) {            
                if (regularAmonutPerShow.containsKey(rs3.getInt(1))) {
                    regularAmonutPerShow.put(rs3.getInt(1), regularAmonutPerShow.get(rs3.getInt(1))+rs3.getInt(2));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return regularAmonutPerShow;
    }
    
    public int getMissingCountForOpenPlace(int placeID) {
        int counter = 0;
        ResultSet rs4 = DBManager.query("SELECT tblOpenPlace.*\n" +
                                        "FROM tblOpenPlace " +
                                        "WHERE tblOpenPlace.ID=\""+placeID+"\"");
        try {
            while (rs4.next()) {
                for (int i = 3; i < 7; i++) {
                    if (!rs4.getBoolean(i)) {
                        counter++;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return counter; 
    }
    
    public HashMap<Integer, Double> getProfitableShows(int year) {
        HashMap<Integer, Double> profitableShows = new HashMap<>();
        Date yearStart = new Date(year-1900, 0, 1);
        Date yearEnd = new Date(year-1900, 11, 31);
        ResultSet rs1 = MainClass.getDB().query("SELECT tblShow.ID\n" +
                                                "FROM tblShow\n" +
                                                "WHERE (((tblShow.date)>=#"+yearStart+"# And (tblShow.date)<=#"+yearEnd+"#) AND ((tblShow.status)=\"approved\"));");
        try {
            while (rs1.next()) {
                Show tmpShow = getShow(rs1.getInt(1));
                int totalMissing = getMissingCountForOpenPlace(tmpShow.getPlace().getPlaceNumber());
                int totalPresale = getPresaleAmonutPerShow(year).get(tmpShow.getShowNumber())*tmpShow.getTicketPrice();
                int totalRegular = getRegularAmonutPerShow(year).get(tmpShow.getShowNumber())*tmpShow.getTicketPrice();
                profitableShows.put(rs1.getInt(1), ((totalPresale+totalRegular)*0.7)-(totalMissing*(totalPresale+totalRegular)*0.02));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportProduceControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return crunchifySortMap(profitableShows);
    }
    
    public Show getShow(int showID) {
        Show tmp = null;
        ResultSet rs4 = DBManager.query("SELECT tblShow.*\n" +
                                        "FROM tblShow " +
                                        "WHERE tblShow.ID=\""+showID+"\"");
        try {
            while (rs4.next()) {
                tmp = new Show(rs4.getInt(1), new Artist(rs4.getString(2)), rs4.getDate(3), new Place(rs4.getInt(4)), 
                               E_STATUS.valueOf(rs4.getString(5)), rs4.getDate(6), rs4.getInt(7), 
                               rs4.getInt(8), new Agent(rs4.getString(9)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateShow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp; 
    }
    
    public static <K, V extends Comparable<? super V>> HashMap<K, V> crunchifySortMap(final Map<K, V> mapToSort) {
		List<Map.Entry<K, V>> entries = new ArrayList<Map.Entry<K, V>>(mapToSort.size());
 
		entries.addAll(mapToSort.entrySet());
 
		// Sorts the specified list according to the order induced by the specified comparator
		Collections.sort(entries, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(final Map.Entry<K, V> entry1, final Map.Entry<K, V> entry2) {
				// Compares this object with the specified object for order
				return entry2.getValue().compareTo(entry1.getValue());
			}
		});
 
		HashMap<K, V> sortedCrunchifyMap = new LinkedHashMap<K, V>();
 
		// The Map.entrySet method returns a collection-view of the map
		for (Map.Entry<K, V> entry : entries) {
			sortedCrunchifyMap.put(entry.getKey(), entry.getValue());
		}
		return sortedCrunchifyMap;
	}
    public ArrayList<String> getParticipatedArtists(int showID) {
        ResultSet rs = MainClass.getDB().query("SELECT tblArtist.ID\n" +
                                                "FROM tblArtist INNER JOIN tblPerformance ON tblArtist.ID = tblPerformance.artistID\n" +
                                                "WHERE (((tblPerformance.showID)="+showID+"))");
        ArrayList<String> artists = new ArrayList<>();
        try {
            while (rs.next()) {
                artists.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportProduceControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return artists;
    }
}
