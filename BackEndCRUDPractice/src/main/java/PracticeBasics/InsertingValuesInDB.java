package PracticeBasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//now we are inserting the values into the database using the SQL query by the Java
//Here we are not getting the data from the database, rather we are inserting the data into the database.
//So, we will be using DML statement not DQL statement. So, instead of using executeQuery method() that is used for fetching data,
//we will be using executeUpate() method, which will not return the object but return the integer value.
//If you insert the one row it will return 1, if you insert two rows, it will return 2.
//Since we will be getting the integer, we cannot write the ResultSet interface and store the value in 'rs' like we did for fetching data.
//We will be using count/status to store the integer.

public class InsertingValuesInDB {
	public static void main(String[] args) throws SQLException{
		
		int status = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentregistration", "root", "Suraj123@");
			
			String sql = "insert into student values ('Raja', 'Nepal', 223993, 'raja123@gmail.com', 'Raja123@', 'Raja1123@')";
			
			Statement st = con.createStatement();
			status = st.executeUpdate(sql); //because it is DML we are using executeUpdate(), but not executeQuery()
			
			System.out.println(status + "rows(s) affected");
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	
		
		
		
		
		
	}
}
