import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ModifyTest {
	public static void main(String[] args) 
	{
		try {
			System.out.println("Registering driver...");    
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver registered....");
			
			System.out.println("Trying to connect to the DB");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
			
			System.out.println("Connected to the DB : "+conn);
			
			System.out.println("trying to make a Prepared statment");
			PreparedStatement pst = conn.prepareStatement("UPDATE STUDENT SET STUDENTNAME=?, BIRTHDATE=? WHERE ROLLNO=?");
			System.out.println("Prepared Statement created : "+pst);
			
			
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Enter employee number : ");
			int rollno = scan1.nextInt();
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from student where rollno="+rollno);
			
			if(rs.next()) {
			
				Scanner scan2 = new Scanner(System.in);
				System.out.println("Enter employee name   : ");
				String sname = scan2.next();
				
				Scanner scan3 = new Scanner(System.in);
				System.out.println("Enter employee salary : ");
				String sbirthdate = scan3.next();
				Date dob = Date.valueOf(sbirthdate);
				
				pst.setInt(3, rollno);//fill up the question mark with its value
				pst.setString(1, sname);
				pst.setDate(2, dob);

				System.out.println("Trying to execute the prepared statement....");
				int rows = pst.executeUpdate();
				
				System.out.println("Prepred Statement executed, updated the records :..."+rows);
				
			}
			else {
				StudentNotFoundException ex = new StudentNotFoundException("This student number does not exists : "+rollno);
				throw ex;
			}

			st.close();
			pst.close();	conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		    
	}
}