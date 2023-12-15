package PracticeBasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//fetching a whole table name from SQL

public class FetchWholeTableFromDatabase {
	public static void main(String[] args) throws ClassNotFoundException {
		

		try {///practice
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentregistration", "root", "Suraj123@");
			
			String sql = "select * from student";
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
					
			while(rs.next()) 
			{		
				String userData = rs.getString(1) + " " + rs.getString(2);
				System.out.println(userData);
			}
			
			st.close();
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
				
				
	}

}
