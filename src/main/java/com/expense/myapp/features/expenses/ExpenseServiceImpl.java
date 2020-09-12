/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.expenses;

import com.expense.myapp.features.users.UserModel;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class ExpenseServiceImpl implements ExpenseService{
   
   private ExpenseDAOImpl expenseDaoImpl;
   
    @Autowired
    public ExpenseServiceImpl(ExpenseDAOImpl theExpenseRepo) {
        expenseDaoImpl = theExpenseRepo;
    }   

   
	
	@Override
	public Res findAll(int uid, int page) {
		return expenseDaoImpl.findAll(uid,page);
	}
        
        @Override
	public List<ExpenseDTORes> findAllPages(int uid) {
		return expenseDaoImpl.findAllPages(uid);
	}

	@Override
	public Expense findById(int uid,int theId) {
		Expense result = expenseDaoImpl.findById(uid,theId);
		
//		Expense theExpense = null;
//		if (result.isPresent()) {
//		}
//		else {
//			// we didn't find the expense
//			throw new RuntimeException("Did not find expense id - " + theId);
//		}
		
		return result;
	}

	@Override
	public Expense save(Expense theExpense) {
		return expenseDaoImpl.save(theExpense);
	}
        
        

	@Override
	public void deleteById(int theId) {
		expenseDaoImpl.deleteById(theId);
	}
   
   
   
   
   
}

