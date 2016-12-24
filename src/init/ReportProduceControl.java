/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import core.Show;
import gui.CreateShow;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportProduceControl {

    public ReportProduceControl() {
    }
    
    public void /*HashMap<Show, Integer>*/ getPresaleAmonutPerShow(int year) {
        Date yearStart = new Date(year-1900, 0, 1);
        Date yearEnd = new Date(year-1900, 11, 31);
        ResultSet rs1 = MainClass.getDB().query("SELECT tblShow.*\n" +
                                                "FROM tblShow\n" +
                                                "WHERE (((tblShow.date)>=#"+yearStart+"# And (tblShow.date)<=#"+yearEnd+"#) AND ((tblShow.status)=\"approved\"));");
        ResultSet rs2 = MainClass.getDB().query("SELECT tblShow.ID, tblTicketOrder.numOfTickets\n" +
                                                "FROM (tblTicketOrder INNER JOIN tblFanOf ON tblTicketOrder.userID = tblFanOf.userID) INNER JOIN tblShow ON (tblTicketOrder.showID = tblShow.ID) AND (tblFanOf.artistID = tblShow.mainArtist)\n" +
                                                "WHERE ((DateDiff(\"d\",[createDate],[date])>21) AND (DateDiff(\"d\",[purchaseDate],[date])>14))");
        ResultSet rs3 = MainClass.getDB().query("SELECT tblShow.ID, tblTicketOrder.numOfTickets\n" +
                                                "FROM tblShow INNER JOIN ((tblTicketOrder INNER JOIN tblFanOf ON tblTicketOrder.userID = tblFanOf.userID) INNER JOIN tblPerformance ON (tblFanOf.artistID = tblPerformance.artistID) AND (tblTicketOrder.showID = tblPerformance.showID)) ON (tblShow.ID = tblTicketOrder.showID) AND (tblShow.ID = tblPerformance.showID)\n" +
                                                "WHERE ((DateDiff(\"d\",[createDate],[date])>21) AND (DateDiff(\"d\",[purchaseDate],[date])>14))");
        HashMap<String,Integer> presaleAmonutPerShow = new HashMap<>();
        try {
            while (rs1.next()) {            
                presaleAmonutPerShow.put(rs1.getString(1),0);
            }
            while (rs2.next()) {            
                if (presaleAmonutPerShow.containsKey(rs2.getString(1))) {
                    presaleAmonutPerShow.put(rs2.getString(1), rs2.getInt(2));
                }
            }
            while (rs3.next()) {            
                if (presaleAmonutPerShow.containsKey(rs3.getString(1))) {
                    presaleAmonutPerShow.put(rs3.getString(1), presaleAmonutPerShow.get(rs3.getString(1))+rs3.getInt(2));
                }
            }
            for (Map.Entry<String, Integer> entry : presaleAmonutPerShow.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println(key+" "+value);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateShow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
