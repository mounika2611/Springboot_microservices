package com.ecommerce.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.userservice.entity.User;
import com.ecommerce.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	
	 @Autowired
	    private UserRepository userRepository;
	 
	 
	 @Override
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }
	 
	 
	 @Override
	    public User getUserByName(String userName) {
	        return userRepository.findByUserName(userName);
	    }
	 public User saveUser(User user) {
	       
	       
	        return userRepository.save(user);
	    }
	

   
	

}
