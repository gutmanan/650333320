package businessLogic;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.PrintStream;
import java.sql.SQLException;
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
            /*XML.create("MuzaMusic_Shows");
            XML.write(getDB().query("SELECT tblShow.mainArtist, tblShow.date\n"
                                  + "FROM tblShow\n"
                                  + "WHERE ((Not (tblShow.status)=\"Canceled\"));"));
            XML.write(getDB().query("SELECT tblPerformance.artistID, tblShow.date\n"
                                  + "FROM tblShow INNER JOIN tblPerformance ON tblShow.ID = tblPerformance.showID\n"
                                  + "WHERE ((Not (tblShow.status)=\"Canceled\"))"));
            XML.export("MuzaMusic_Shows");
        */    
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

}
