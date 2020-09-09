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
public interface UserDAO {
        public List<UserModel> findAll();

	public UserModel save(UserModel theUser);

	public UserModel findById(int theId);

	public void deleteById(int theId);
        
        public UserModel findByUsername(String username);
}
