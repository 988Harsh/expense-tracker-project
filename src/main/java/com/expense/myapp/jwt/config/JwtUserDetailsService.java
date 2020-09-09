/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.jwt.config;

/**
 *
 * @author Lenovo
 */
import com.expense.myapp.features.users.UserModel;
import com.expense.myapp.features.users.UserService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

        @Autowired
        private UserService userService;
    
	private UserModel userDao = new UserModel();

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                System.out.println(username+" userdetailsservice");
		UserModel user = userService.findByUsername(username);
                if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
				new ArrayList<>());
	}

	public UserModel save(UserModel user) {
                userDao.setName(user.getName());
		userDao.setPassword(bcryptEncoder.encode(user.getPassword()));
                userDao.setEmail(user.getEmail());
		return userService.save(userDao);
	}

}

