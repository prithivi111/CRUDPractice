package PracticeBasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//What if we don't have whole set of data as
//"insert into student values ('Raja', 'Nepal', 223993, 'raja123@gmail.com', 'Raja123@', 'Raja1123@')";
//but individual datas?

public class InsertingValuesinDBWithSingleRowData {

	public static void main(String[] args) throws SQLException {

		int status = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentregistration", "root",
					"Suraj123@");
			
			String name = "Ali";
			String address ="Nepal";
			int mobile = 1232;
			String email = "ali123@gmail.com";
			String password = "ali123@";
			String cPassword = "ali123@";
			
			//we have to do like this
			String sql = "insert into student values ('" + name + "','" + address + "'," + mobile + ",'" + email + "','" + password + "','" + 
			          cPassword +"')";
			
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
