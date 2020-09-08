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
public class UsersServiceImpl implements UsersService{
   
   private UsersRepository userRepository;
   
    @Autowired
    public UsersServiceImpl(UsersRepository theUserRepo) {
        userRepository = theUserRepo;
    }   

   
	
	@Override
	public List<Users> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Users findById(int theId) {
		Optional<Users> result = userRepository.findById(theId);
		
		Users theUsers = null;
		
		if (result.isPresent()) {
			theUsers = result.get();
		}
		else {
			// we didn't find the user
			throw new RuntimeException("Did not find user id - " + theId);
		}
		
		return theUsers;
	}

	@Override
	public void save(Users theUsers) {
		userRepository.save(theUsers);
	}

	@Override
	public void deleteById(int theId) {
		userRepository.deleteById(theId);
	}
   
   
   
   
   
}
