package PracticeBasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

//But what if there are more than one rows to be inserted into the DB?
//Here comes the use of preparedStatement(), which is taught by Subhensir.
//Now we will not be using createStatement();

public class InsertingValuesinDBWithMultipleRowData {
	public static void main(String[] args) throws SQLException {

		int status = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentregistration", "root",
					"Suraj123@");
			
			String name = "Mahes";
			String address ="India";
			int mobile = 12233332;
			String email = "mahesh123@gmail.com";
			String password = "mahesh123@";
			String cPassword = "mahesh123@";
			
			//This is something we did for one row
			//String sql = "insert into student values ('" + name + "','" + address + "'," + mobile + ",'" + email + "','" + password + "','" + cPassword +"')";
			
			//But now we will be doing like below since like below because, we know the query but we don't know the values.
			String sql = "insert into student values (?,?,?,?,?,?)";
			
			//And, now we we will be using PreparedStatement(sql) and we need to pass the parameter, which 
			//we haven't done in createStatement().
			//Please remember that since the value is changing, we will be using PreparedStatement().

			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, name);
			st.setString(2, address);
			st.setInt(3, mobile);
			st.setString(4, email);
			st.setString(5, password);
			st.setString(6, cPassword);
					
			status = st.executeUpdate(); 
			//As we know that inserting is DML statement so we are using executeUpdate(), but not executeQuery()
			//Also, if we use prepareStatement(), then we do not have to insert the parameter inside executeUpdate() method,
			//which we have done in executeUpdate() while trying to insert the 1 row data using createStatement before.
			
			System.out.println(status + "rows(s) affected");

			st.close();
			con.close();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}
}

	
