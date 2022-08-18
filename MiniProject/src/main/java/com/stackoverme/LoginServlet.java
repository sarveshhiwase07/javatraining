package com.stackoverme;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conn;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Database Driver loaded....");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/get940", "root", "secondguy"); 
			System.out.println("Connected to the DB : "+conn);	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery("SELECT * FROM USER WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "'");
			
			if(rs.next()) {
				System.out.println(rs.getString(1));
				RequestDispatcher rd = request.getRequestDispatcher("Dashboard.jsp");
				User userObj = new User(rs.getString(1),rs.getString(2),rs.getString(4));
				request.setAttribute("userObj", userObj);
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/login.html");
				rd.forward(request, response);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
