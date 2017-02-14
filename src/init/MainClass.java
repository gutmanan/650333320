package init;

import gui.MainLogin;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainClass {

    private static DBManager DB = null;
    private static PDFManager PDF = null;
    private static XMLManager XML = null;
    private static String fileName = "MuzaMusic";
    private static PrintStream logFile;
    public static void main(String[] args) {
        
        try {
            //Define log file
            String dateNow = (new SimpleDateFormat("ddM_hhmm")).format(new Date());
            logFile = new PrintStream(new File(fileName+"_"+dateNow+".log"));
            //System.setErr(logFile);
            //System.setOut(logFile);
            
            DB = new DBManager();
            PDF = new PDFManager();
            XML = new XMLManager();
            /*XML.create("MuzaMusic_Shows");
            XML.write(getDB().query("SELECT tblShow.mainArtist, tblShow.date\n"
                                  + "FROM tblShow\n"
                                  + "WHERE ((Not (tblShow.status)=\"Canceled\"));"));
            XML.write(getDB().query("SELECT tblPerformance.artistID, tblShow.date\n"
                                  + "FROM tblShow INNER JOIN tblPerformance ON tblShow.ID = tblPerformance.showID\n"
                                  + "WHERE ((Not (tblShow.status)=\"Canceled\"))"));
            XML.export("MuzaMusic_Shows");
        */    
        MainLogin loginFrame = new MainLogin();  
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DBManager getDB() {
        return DB;
    }

    public static void setDB(DBManager DB) {
        MainClass.DB = DB;
    }
    
    public static PDFManager getPDF() {
        return PDF;
    }

    public static void setPDF(PDFManager PDF) {
        MainClass.PDF = PDF;
    }

}
