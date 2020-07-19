package dbms_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
Author: Vidish Joshi
*/
public class DBConnection {
    private static final String DB_DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USERNAME = "VIDISHJOSHI";
	private static final String DB_PASSWORD = "vidishjoshi";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			// load the Driver Class
			Class.forName(DB_DRIVER_CLASS);

			// create the connection now
			con = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
