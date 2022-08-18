package com.stackoverme;

public class UserDoesNotExistsException extends Exception {
	UserDoesNotExistsException(String msg){
		super(msg);
	}
}
