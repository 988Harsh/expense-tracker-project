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
public class UsersRestController {

	private UsersService userService;

    public UsersRestController() {
    }
	
        
        
        
	@Autowired
	public UsersRestController(UsersService theUsersService) {
		userService = theUsersService;
	}
	
	// expose "/users" and return list of users
	@GetMapping("/users")
	public List<Users> findAll() {
		return userService.findAll();
	}

	// add mapping for GET /users/{userId}
	
	@GetMapping("/users/{userId}")
	public Users getUsers(@PathVariable int userId) {
		
		Users theUsers = userService.findById(userId);
		
		if (theUsers == null) {
			throw new RuntimeException("Users id not found - " + userId);
		}
		
		return theUsers;
	}
	
	// add mapping for POST /users - add new user
	
	@PostMapping("/users")
	public Users addUsers(@RequestBody Users theUsers) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theUsers.setId(0);
		
		userService.save(theUsers);
		
		return theUsers;
	}
	
	// add mapping for PUT /users - update existing user
	
	@PutMapping("/users")
	public Users updateUsers(@RequestBody Users theUsers) {
		
		userService.save(theUsers);
		
		return theUsers;
	}
	
	// add mapping for DELETE /users/{userId} - delete user
	
	@DeleteMapping("/users/{userId}")
	public String deleteUsers(@PathVariable int userId) {
		
		Users tempUsers = userService.findById(userId);
		
		// throw exception if null
		
		if (tempUsers == null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		userService.deleteById(userId);
		
		return "Deleted user id - " + userId;
	}
}