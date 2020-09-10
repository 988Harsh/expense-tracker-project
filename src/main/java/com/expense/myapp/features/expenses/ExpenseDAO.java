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
public interface ExpenseDAO {
        public List<Expense> findAll(int uid);

	public void save(Expense theExpense);

	public Expense findById(int theId);

	public void deleteById(int theId);
}
