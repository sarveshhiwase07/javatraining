package com.stackoverme;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;


public class UserDAOImpl extends BaseDAO implements UserDAO {
	
	@Override
	public void saveUser(User user) throws SQLException, UserExistsException {
		try {
	    	PreparedStatement pst = conn.prepareStatement("INSERT INTO USER VALUES (?, ?, ?, ?)");
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM USER WHERE EMAIL='" + user.getEmail() + "'");
			
				if(rs.next()) {
					throw new UserExistsException("User Exists With that Email");
				} else {
					pst.setString(1, user.getName());
					pst.setString(2, user.getEmail());
					pst.setString(3, user.getPassword());
					pst.setString(4, user.getMobileNumber());
					
					int rows = pst.executeUpdate();
					if(rows != 0)
						System.out.println("User Inserted succesfully");
				}
			}  catch (SQLException e) {
				throw e;
			}
	}

	@Override
	public User findUser(String userEmail,String userPassword) throws SQLException, UserDoesNotExistsException {
		try {
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery("SELECT * FROM USER WHERE EMAIL='" + userEmail + "' AND PASSWORD='" + userPassword + "'");
			
			if(rs.next()) {
				User userObj = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				return userObj;
			} else {
				throw new UserDoesNotExistsException("User Does not Exists With that Email");
			}
		} catch(SQLException e) {
			throw e;
		}
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(String userEmail) {
		// TODO Auto-generated method stub
		
	}

	

}
