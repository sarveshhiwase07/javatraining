package com.stackoverme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	Connection conn;

	public BaseDAO() {
		super();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Database Driver loaded....");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/get940", "root", "secondguy"); 
			System.out.println("Connected to the DB : "+conn);	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
