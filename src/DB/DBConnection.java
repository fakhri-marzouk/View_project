package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	Connection con =null ;
	public static Connection conDB() throws SQLException {
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver") ;
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/projet_java","root","");
			return con ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
