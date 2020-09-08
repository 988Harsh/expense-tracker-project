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
        public List<User> findAll();

	public void save(User theUser);

	public User findById(int theId);

	public void deleteById(int theId);
}
