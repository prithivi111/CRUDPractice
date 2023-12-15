package PracticeJDBCandDAOInsertionUpdateFetchDelete;

import java.sql.SQLException;

public class StudentService {

	static StudentDAO dao = new StudentDAO();

	public static void main(String[] args) throws SQLException {
		insertion(); 
		//This is only inserting one record in database and back-end part
		//dao.update();
		//dao.fetch(); 
				
		//Scanner sc= new Scanner(System.in);
		//System.out.println("Enter the name you want to fetch");
		//String nameFetch = sc.next();
		//Student std = dao.getStudentByName(nameFetch);  //fetching the student by name and address
		//System.out.println(std.getName() + " | " + std.getAddress());
		
		/* Scanner sc= new Scanner(System.in);
		 * System.out.println("Enter the name you want to delete"); String nameDelete =
		 * sc.next(); dao.delete(nameDelete);
		 * sc.close(); */
		
		/*List<Student> ls = dao.getAllStudentDetails(); 
		 * for(Student std:ls) {
		 * 		System.out.println(std.getName()+ " | " + std.getAddress()); 
		 * }*/
	}

	public static void insertion() throws SQLException {
	 		 Student student = new	Student("Umeda", "Tokyo", 9841, "umeda123@gmail.com", "umeda123@", "umeda123@"); 
	       dao.save(student);  
	   }
	
	public static void registration(Student student) {
		try {
			dao.save(student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
