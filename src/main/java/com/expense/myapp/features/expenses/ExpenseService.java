/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.expenses;

import com.expense.myapp.features.users.UserModel;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface ExpenseService {
        public Res findAll(int uid,int page);
	
        public List<ExpenseDTORes> findAllPages(int uid);
        
	public Expense findById(int uid,int theId);
	
	public Expense save(Expense theExpense);
	
        
	public void deleteById(int theId);
}

