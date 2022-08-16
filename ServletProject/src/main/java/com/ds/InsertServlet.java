package com.ds;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insertservlet")
public class InsertServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
	 Connection conn;
    /**
     * @see GenericServlet#GenericServlet()
     */
    public InsertServlet() {
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
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("\t\tservice()");
	    response.setContentType("text/html");
	    String country =  request.getParameter("countryname"); //read this HTML tag's value
	    String capital =  request.getParameter("capital");
	    String primeminister =  request.getParameter("primeminister");
	    String population =  request.getParameter("population");
	    String currency =  request.getParameter("currency");
	    PrintWriter pw = response.getWriter();
	   
	    try {
	    	PreparedStatement pst = conn.prepareStatement("INSERT INTO MYCOUNTRIES VALUES (?, ?, ?, ?, ?)");
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM MYCOUNTRIES WHERE COUNTRYNAME='" + country + "'");
			
			if(rs.next()) {
				pw.println("Country already exists");
			} else {
				pst.setString(1, country);
				pst.setString(2, capital);
				pst.setString(3, primeminister);
				pst.setString(4, population);
				pst.setString(5, currency);
				
				int rows = pst.executeUpdate();
				System.out.println("Inserted record succesfully " + rows);
				pw.println("<h2> The country  was inserted succesfully</h2>");
			}
	}  catch (SQLException e) {
		e.printStackTrace();
	}
	}

}
