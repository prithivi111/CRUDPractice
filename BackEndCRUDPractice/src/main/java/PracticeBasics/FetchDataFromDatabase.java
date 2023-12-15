package PracticeBasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//fetching a single name from SQL i.e DQL statement. 
//Therefore we will be using executeQuery method of Statement Interface which returns the object of ResultSet Interface. 

public class FetchDataFromDatabase {
	public static void main(String[] args) throws ClassNotFoundException {
		

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentregistration", "root", "Suraj123@");
			
			String sql = "select name from student where mobile=1231233";
			Statement st = con.createStatement();
			//Here the Statement is interface. As we cannot create the object of Statement interface, but luckily we have
			//the method called createStatement() inside Statement.This createStatement() method will return
			//the object of statement and gets stored in 'st'.
			
						
			ResultSet rs = st.executeQuery(sql);
			// Here when we are executing the query using 'st.executeQuery(sql), if you go and see the mySQL, you will the Suraj and 
			// also the title 'name' in the output, right ?
			//So, st.executeQuery(sql) will not only give you the required data 'Suraj' but the whole table structure.
			//So you need to store that structure in the ResultSet interface because ResultSet has the power to store the data in table
			//structure.
			
			rs.next();
			//we need to do this because, the pointer needs to the next element of the table stored in 'rs'.
			
			String name = rs.getString("name"); //here we can write either column name or column index. 
			//now, we are fetching only the Suraj from the table which is stored in 'rs'.
			
			System.out.println(name);
			
			
			st.close();
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
				
				
	}

}
