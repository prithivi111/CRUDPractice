package PracticeJDBCandDAOInsertionUpdateFetchDelete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	
	public int save (Student std) throws SQLException {
		int count =0;
		try {
			Connection conn = DBConnection.getConnection();
			String sql = "insert into student (name, address, mobile, email, password, cPassword)" + "values (?,?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, std.getName());
			ps.setString(2, std.getAddress());
			ps.setInt(3, std.getMobile());
			ps.setString(4, std.getEmail());
			ps.setString(5, std.getPassword());
			ps.setString(6, std.getcPassword());
			
			count = ps.executeUpdate();
			
			if(count==1) {
				System.out.println("Data entered successfully.");
			}
			
			ps.close();
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		}
			
		return count;
	}

	
		
	public int update () throws SQLException {
		int count =0;
		try {
			String newAddress = "Coralville";
			String email = "suraj123gmail.com";
			
			Connection conn = DBConnection.getConnection();
			String sql = "update student set address=? where email=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newAddress);
			ps.setString(2, email);
			
			count = ps.executeUpdate();
			
			if(count==1) {
				System.out.println("Data updated successfully.");
			}
			
			ps.close();
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		}
			
		return count;
	}
	
	//Here we are trying to fetch the data directly from the database and printing
	public void fetch() throws SQLException {
		
		try {	
			String fetchData = " ";
			Connection conn = DBConnection.getConnection();
			String sql = "select * from student";;
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			//here we are trying to fetch the data directly from the database and printing
			while(rs.next()) {
				fetchData = rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getInt(3) + " | " + rs.getString(4) + " | " +
							rs.getString(5) + " | " + rs.getString(6);			
				System.out.println(fetchData);
			}
			st.close();
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		}
	
	}
	
	public Student getStudentByName (String nameFetch) {
		
		Student std = new Student();
		try {
			Connection conn = DBConnection.getConnection();
			String sql = "select * from student where name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nameFetch);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				//setting object values from resultset
				
				std.setName(rs.getString(1));
				std.setAddress(rs.getString(2));
				std.setMobile(rs.getInt(3));
				std.setEmail(rs.getString(4));
				std.setPassword(rs.getString(5));
				std.setcPassword(rs.getString(6));
				
				conn.close();
				ps.close();
			}
			
		} catch (Exception e){
			e.printStackTrace();

		}
		return std;
		
	}
	
	public void delete(String nameDelete) {
		int status = 0;
		try{
			Connection conn = DBConnection.getConnection();
			String sql ="delete from student where name=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nameDelete );
			
			status = ps.executeUpdate();
			
			if(status == 1) {
				System.out.println("The DATA deleted successfully");
			}
			
			conn.close();
			ps.close();
			
		}catch (Exception e){
			e.printStackTrace();

		}
		
	}
	
	//Here we are trying to fetch the data from DB and store in array creating objects
	public List<Student> getAllStudentDetails() throws SQLException {
		//Here we are creating the array list of student object because we do not know how many students data are there.
		
		List<Student> stdList = new ArrayList<Student>();
		
		try {
			Connection conn = DBConnection.getConnection();
			String sql ="select * from student"; //we have 5 records in our database.
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Student std = new Student();
				//setting object values from result set
				std.setName(rs.getString(1));
				std.setAddress(rs.getString(2));
				std.setMobile(rs.getInt(3));
				std.setEmail(rs.getString(4));
				std.setPassword(rs.getString(5));
				std.setcPassword(rs.getString(6));
				
				stdList.add(std);
			}
			
			conn.close();
			ps.close();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
			return stdList;
	}
}