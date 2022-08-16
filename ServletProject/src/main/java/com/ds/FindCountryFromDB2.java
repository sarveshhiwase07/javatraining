package com.ds;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class FindCountryFromDB2
 */
@WebServlet("/FindCountryFromDB2")
public class FindCountryFromDB2 extends GenericServlet {
	private static final long serialVersionUID = 1L;
       Connection conn;
    /**
     * @see GenericServlet#GenericServlet()
     */
    public FindCountryFromDB2() {
    	  super();
          System.out.println("FindCountryFromDatabaseServlet()");
      	
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

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("\t\tservice()");
	    response.setContentType("text/html");
	    String country =  request.getParameter("countryName"); //read this HTML tag's value
	    PrintWriter pw = response.getWriter();
	   
	    try {
			Statement st = conn.createStatement();
			System.out.println("statement created.."+st);
			ResultSet rs = st.executeQuery("SELECT * FROM MYCOUNTRIES WHERE  COUNTRYNAME='"+country+"'");
			System.out.println("Query fired...got the result...");
			if(rs.next()) {
				String foundCountryName = rs.getString(1);
				String foundCapitalName = rs.getString(2);
				pw.println("<h2> The capital of "+foundCountryName+" is "+foundCapitalName+"</h2>");
			}
			else {
				System.out.println("No record found...");
			}
			rs.close();
			st.close();
	}  catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
} 

}

