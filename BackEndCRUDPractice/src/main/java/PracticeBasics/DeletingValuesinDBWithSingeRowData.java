package PracticeBasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletingValuesinDBWithSingeRowData {
	public static void main(String[] args) throws SQLException {

		int status = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentregistration", "root",
					"Suraj123@");
			String name = "Ali";
			String sql = "delete from student where name = ?";

			PreparedStatement st = con.prepareStatement(sql);	
			st.setString(1, name);
					
			status = st.executeUpdate(); 
			
				System.out.println(status + "rows(s) affected");
				System.out.println("Data deleted successfully");

			st.close();
			con.close();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}
}
