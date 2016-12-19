package init;

import gui.MainLogin;
import static init.WindowManager.loginFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    private static DBManager DB = null;

    public static void main(String[] args) {

        DB = new DBManager();
        try {
            MainLogin loginFrame= new MainLogin();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static DBManager getDB() {
        return DB;
    }

    public static void setDB(DBManager DB) {
        Main.DB = DB;
    }

}
