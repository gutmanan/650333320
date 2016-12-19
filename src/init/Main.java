package init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	
	 public static final String connectionString =
			 		"jdbc:ucanaccess://src/init/MuzaDataBase.accdb;COLUMNORDER=DISPLAY";
	 public static final String sql = "SELECT *" + "FROM tblArtist";
	 public static void main(String[] args) {
		 try {
			 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			 try (Connection conn = DriverManager.getConnection(connectionString)) {
				 // SOME CODE EXECUTING QUERIES ON 'conn'
				 
				 System.out.println("doing something!");
				 PreparedStatement stmt = conn.prepareStatement(sql);
				 ResultSet rs = stmt.executeQuery();
				 while (rs.next()) {
					System.out.println(rs.getString(1));
				}
                                WindowManager.openLogin();
                                
                                 
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
		 } catch (ClassNotFoundException e) {
			 e.printStackTrace();
		 }
		 
		 
	 }
}
