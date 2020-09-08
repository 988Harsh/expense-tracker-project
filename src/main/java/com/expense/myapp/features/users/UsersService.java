/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.users;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface UsersService {
        public List<Users> findAll();
	
	public Users findById(int theId);
	
	public void save(Users theUsers);
	
	public void deleteById(int theId);
}
