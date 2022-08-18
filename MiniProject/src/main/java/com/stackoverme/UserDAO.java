package com.stackoverme;

import java.sql.SQLException;
import java.util.List;


public interface UserDAO {
	void saveUser(User user) throws SQLException, UserExistsException; //C
	List<User> findAllUsers();
	void modifyUser(User user); //U
	void removeUser(String userEmail); //D
	User findUser(String userEmail, String userPassword) throws SQLException, UserDoesNotExistsException;
}
