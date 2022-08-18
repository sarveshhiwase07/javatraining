package com.stackoverme;

public class UserExistsException extends Exception {
	UserExistsException(String msg){
		super(msg);
	}
}
