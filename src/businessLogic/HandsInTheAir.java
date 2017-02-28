package businessLogic;

import entity.Artist;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

public class HandsInTheAir {

    private static DBManager DB = null;
    private static PDFManager PDF = null;
    private static XMLManager XML = null;
    private static DebugManager DM = null;
    private static String fileName = "MuzaMusic";
    private static PrintStream logFile;
    
    public static void main(String[] args) {
        try {
            //Define log file
            //String dateNow = (new SimpleDateFormat("ddM_hhmm")).format(new Date());
            //logFile = new PrintStream(new File(fileName+"_"+dateNow+".log"));
            //System.setErr(logFile);
            //System.setOut(logFile);
            DM = new DebugManager() {};
            DB = new DBManager();
            PDF = new PDFManager();
            XML = new XMLManager("MuzaMusic_Sessions");
            XML.importXML();
            XML.create("MuzaMusic_Shows");
            XML.write(getDB().query("SELECT tblArtist.*\n" + "FROM tblArtist;"), getArtistShows());
            XML.export("MuzaMusic_Shows");
            DB.updateActive();
            DB.cancelShowsAfterWaiting();
        WindowManager.openLogin();
        } catch (SQLException e) {
            e.printStackTrace();
        } /*catch (FileNotFoundException ex) {
            Logger.getLogger(HandsInTheAir.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    public static void writeLog(String info) {
        //logFile.print("\n"+info);
    }
    public static XMLManager getXML() {
        return XML;
    }
    public static DebugManager getDM() {
        return DM;
    }
    public static void setDebug(JFrame frame) {
        JRootPane rootPane = frame.getRootPane();
        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, InputEvent.CTRL_MASK), "myAction");
        rootPane.getActionMap().put("myAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (DM.isVisible()) {
                    DM.dispose();
                    return;
                }
                DM.setVisible(true);
            }
        });
    }
    public static DBManager getDB() {
        return DB;
    }
    public static void setDB(DBManager DB) {
        HandsInTheAir.DB = DB;
    }
    public static PDFManager getPDF() {
        return PDF;
    }
    public static void setPDF(PDFManager PDF) {
        HandsInTheAir.PDF = PDF;
    }
    public static HashMap<String, ArrayList<Timestamp>> getArtistShows() {
        HashMap<String, ArrayList<Timestamp>> artistShows = new HashMap<>();
        ResultSet rs1 = getDB().query("SELECT tblShow.mainArtist, tblShow.showDate\n"
                                  + "FROM tblShow\n"
                                  + "WHERE ((Not (tblShow.status)=\"Canceled\"))");
        ResultSet rs2 = getDB().query("SELECT tblShowInvitation.artistID, tblShow.showDate\n"
                                  + "FROM tblShow INNER JOIN tblShowInvitation ON tblShow.showNumber = tblShowInvitation.showID\n"
                                  + "WHERE ((Not (tblShow.status)=\"Canceled\"))");
        try {
            while (rs1.next()) {
                if (artistShows.containsKey(rs1.getString(1))) {
                    artistShows.get(rs1.getString(1)).add(rs1.getTimestamp(2));
                } else {
                    artistShows.put(rs1.getString(1), new ArrayList<Timestamp>());
                    artistShows.get(rs1.getString(1)).add(rs1.getTimestamp(2));
                }
            }
            while (rs2.next()) {
                if (artistShows.containsKey(rs2.getString(1))) {
                    artistShows.get(rs2.getString(1)).add(rs2.getTimestamp(2));
                } else {
                    artistShows.put(rs2.getString(1), new ArrayList<Timestamp>());
                    artistShows.get(rs2.getString(1)).add(rs2.getTimestamp(2));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(HandsInTheAir.class.getName()).log(Level.SEVERE, null, ex);
        }
        return artistShows;
    }
}
