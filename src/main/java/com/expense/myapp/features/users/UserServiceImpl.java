/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.users;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class UserServiceImpl implements UserService{
   
   private UserDAOImpl userDaoImpl;
   
    @Autowired
    public UserServiceImpl(UserDAOImpl theUserRepo) {
        userDaoImpl = theUserRepo;
    }   

   
	
	@Override
	public List<User> findAll() {
		return userDaoImpl.findAll();
	}

	@Override
	public User findById(int theId) {
		User result = userDaoImpl.findById(theId);
		
//		User theUser = null;
		
//		if (result.isPresent()) {
//			theUser = result.get();
//		}
//		else {
//			// we didn't find the user
//			throw new RuntimeException("Did not find user id - " + theId);
//		}
		
		return result;
	}

	@Override
	public void save(User theUser) {
		userDaoImpl.save(theUser);
	}

	@Override
	public void deleteById(int theId) {
		userDaoImpl.deleteById(theId);
	}
   
   
   
   
   
}
