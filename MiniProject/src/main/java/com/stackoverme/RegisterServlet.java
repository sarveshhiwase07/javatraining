package com.stackoverme;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDao = new UserDAOImpl();
	
    public RegisterServlet() {
        super();
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String mobileNumber = request.getParameter("mnumber");
		User userObj = new User(name,email,password,mobileNumber);
		
		try{
			userDao.saveUser(userObj);
			RequestDispatcher rd = request.getRequestDispatcher("Dashboard.jsp");
			rd.forward(request, response);
		} catch(SQLException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.forward(request, response);
		} catch(UserExistsException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/register.html");
			rd.include(request, response);
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
