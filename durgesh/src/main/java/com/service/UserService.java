package com.service;

import java.util.List;

public interface UserService  {

	//create user
	
	User insertUser(User u);
	
	//get all user
	
	List<User> getAllUser();
	
	// get user by id
	
	User getuserById(String id);
}
