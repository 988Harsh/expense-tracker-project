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
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class JwtAuthenticationController {

        @Autowired
        private UserService userService;
    
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

        @Autowired
        private PasswordEncoder bcrypt;
        
	@RequestMapping(value = "/authenticate",headers="Accept=application/json", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
//
//                String username = req.getParameter("username");
//                String password = req.getParameter("Password");
//                JwtRequest authenticationRequest = new JwtRequest(username,password);
                
                authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
                UserModel user = userService.findByUsername(authenticationRequest.getUsername());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
//                System.out.println(token + " /auth ");

		return ResponseEntity.ok(new JwtResponse(user,token));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserModel user) throws Exception {
            final UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
				new ArrayList<>());
            final String token = jwtTokenUtil.generateToken(userDetails);
            user = userDetailsService.save(user);
            
            return ResponseEntity.ok(new JwtResponse(user,token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
                        System.out.println(password+" "+username +" /auth");
//                        System.out.println(username + " " + bcrypt.encode(password) );
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}