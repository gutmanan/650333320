package init;

import com.itextpdf.text.DocumentException;
import gui.MainLogin;
import static init.WindowManager.loginFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainClass {

    private static DBManager DB = null;
    private static PDFManager PDF = null;

    public static void main(String[] args) {

        DB = new DBManager();
        PDF = new PDFManager();
        try {
            MainLogin loginFrame = new MainLogin();  
        } catch (SQLException e) {
            e.printStackTrace();
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
