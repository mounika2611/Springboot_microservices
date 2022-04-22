package com.ecommerce.userservice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ecommerce.userservice.entity.User;
import com.ecommerce.userservice.http.header.HeaderGenerator;
import com.ecommerce.userservice.service.UserService;

@RestController

public class UserController {
	
	 @Autowired
	    private UserService userService;
	    
	    @Autowired
	    private HeaderGenerator headerGenerator;
	    
	   
	
	 @GetMapping (value = "/users")
	    public ResponseEntity<List<User>> getAllUsers(){
	        List<User> users =  userService.getAllUsers();
	        
	        if(!users.isEmpty()) {
	        	return new ResponseEntity<List<User>>(users,headerGenerator.getHeadersForSuccessGetMethod(),
	        		HttpStatus.OK);
	        }
	        return new ResponseEntity<List<User>>(headerGenerator.getHeadersForError(),
	        		HttpStatus.NOT_FOUND);
	    }
	 @GetMapping (value = "/users", params = "name")
	    public ResponseEntity<User> getUserByName(@RequestParam("name") String userName){
	    	User user = userService.getUserByName(userName);
	    	if(user != null) {
	    		return new ResponseEntity<User>(
	    				user,
	    				headerGenerator.
	    				getHeadersForSuccessGetMethod(),
	    				HttpStatus.OK);
	    	}
	        return new ResponseEntity<User>(
	        		headerGenerator.getHeadersForError(),
	        		HttpStatus.NOT_FOUND);
	    }
	
	   @PostMapping (value = "/users")
	    public ResponseEntity<User> addUser(@RequestBody User user, HttpServletRequest request){
	    	if(user != null)
	    		try {
	    			userService.saveUser(user);
	    			return new ResponseEntity<User>(
	    					user,
	    					headerGenerator.getHeadersForSuccessPostMethod(request, user.getId()),
	    					HttpStatus.CREATED);
	    		}catch (Exception e) {
	    			e.printStackTrace();
	    			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	    	return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	   }
}
