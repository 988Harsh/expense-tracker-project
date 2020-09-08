/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.expenses;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface ExpenseService {
        public List<Expense> findAll();
	
	public Expense findById(int theId);
	
	public void save(Expense theUser);
	
	public void deleteById(int theId);
}

