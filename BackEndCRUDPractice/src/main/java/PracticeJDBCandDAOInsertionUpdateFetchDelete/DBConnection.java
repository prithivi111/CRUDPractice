package PracticeJDBCandDAOInsertionUpdateFetchDelete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() throws ClassNotFoundException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentregistration", "root", "Suraj123@");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return conn;
		
	}
}
