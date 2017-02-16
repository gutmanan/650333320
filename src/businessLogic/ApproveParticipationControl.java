/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;


import entity.Agent;
import entity.Artist;
import entity.E_STATUS;
import entity.Place;
import entity.Show;
import boundary.CreateShow;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApproveParticipationControl {

    public ApproveParticipationControl() {
    }
    
    public HashMap<String, String> getArtistsWaitingForApproval() {
        ResultSet rs = HandsInTheAir.getDB().query("SELECT tblPerformance.showID,  tblArtist.*\n" +
                                               "FROM tblArtist INNER JOIN tblPerformance ON tblArtist.ID = tblPerformance.artistID\n" +
                                               "WHERE (((tblPerformance.approvel)=\"Waiting\") AND ((tblArtist.agentID)=\""+WindowManager.getTmpAgent().getId()+"\"))");
        HashMap<String, String> artistsWaitingForApproval = new HashMap<>();
        try {
            while (rs.next()) {
                artistsWaitingForApproval.put(rs.getString(2), rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApproveParticipationControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return artistsWaitingForApproval;
    }
    public Show getShowDetails(String showID) {
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
}
