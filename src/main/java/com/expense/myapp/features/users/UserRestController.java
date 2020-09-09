/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.users;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lenovo
 */
@RestController
@RequestMapping("/api")
public class UserRestController {

	private UserService userService;

    public UserRestController() {
    }
	
        
        
        
	@Autowired
	public UserRestController(UserService theUserService) {
		userService = theUserService;
	}
	
	// expose "/users" and return list of users
	@GetMapping("/users")
	public List<UserModel> findAll() {
		return userService.findAll();
	}

	// add mapping for GET /users/{userId}
	
	@GetMapping("/users/{userId}")
	public UserModel getUser(@PathVariable int userId) {
		
		UserModel theUser = userService.findById(userId);
		
		if (theUser == null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		return theUser;
	}
	
	// add mapping for POST /users - add new user
	
	@PostMapping("/users")
	public UserModel addUser(@RequestBody UserModel theUser) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theUser.setId(0);
		
		userService.save(theUser);
		
		return theUser;
	}
	
	// add mapping for PUT /users - update existing user
	
	@PutMapping("/users")
	public UserModel updateUser(@RequestBody UserModel theUser) {
		
		userService.save(theUser);
		
		return theUser;
	}
	
	// add mapping for DELETE /users/{userId} - delete user
	
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable int userId) {
		
		UserModel tempUser = userService.findById(userId);
		
		// throw exception if null
		
		if (tempUser == null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		userService.deleteById(userId);
		
		return "Deleted user id - " + userId;
	}
}