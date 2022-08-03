import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllTest {

	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			System.out.println("Creating a statment");
			Statement statement = conn.createStatement();
			System.out.println("Fetching results from the database");
			
			ResultSet rs = statement.executeQuery("SELECT * FROM STUDENT");
			System.out.println("+-------------------------------------------------------------------------+");
			System.out.println("Rollno StudentName  BirthDate   physics chemistry  maths  total  grade" );
				
				while(rs.next()) {
					int rollno = rs.getInt(1);
					String studentName = rs.getString(2);
					String birthDate = rs.getString(3);
					int physics = rs.getInt(4);
					int chemistry = rs.getInt(5);
					int maths = rs.getInt(6);
					int total = rs.getInt(7);
					String grade = rs.getString(8);
					
					System.out.println(rollno + "        " + studentName + "       "+  birthDate + "   " + physics + "       " + chemistry + "       " + maths + "       " + total + "    " + grade );
				} 
				System.out.println("+-------------------------------------------------------------------------+");
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
