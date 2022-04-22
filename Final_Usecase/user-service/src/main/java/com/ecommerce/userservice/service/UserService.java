package com.ecommerce.userservice.service;

import java.util.List;

import com.ecommerce.userservice.entity.User;

public interface UserService {
	
	
	    List<User> getAllUsers();
	   
	    User getUserByName(String userName);
		User saveUser(User user);
	
	   

}
