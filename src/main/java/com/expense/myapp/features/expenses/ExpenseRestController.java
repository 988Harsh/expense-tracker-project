/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.expenses;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lenovo
 */
@RestController
@RequestMapping("/api")
public class ExpenseRestController {

	private ExpenseService expenseService;

    public ExpenseRestController() {
    }
	
        
        
        
	@Autowired
	public ExpenseRestController(ExpenseService theExpenseService) {
		expenseService = theExpenseService;
	}
	
	// expose "/expenses" and return list of expenses
	@GetMapping("/expenses")
	public List<Expense> findAll() {
		return expenseService.findAll();
	}

	// add mapping for GET /expenses/{expenseId}
	
	@GetMapping("/expenses/{expenseId}")
	public Expense getExpense(@PathVariable int expenseId) {
		
		Expense theExpense = expenseService.findById(expenseId);
		
		if (theExpense == null) {
			throw new RuntimeException("Expense id not found - " + expenseId);
		}
		
		return theExpense;
	}
	
	// add mapping for POST /expenses - add new expense
	
	@PostMapping("/expenses")
	public Expense addExpense(@RequestBody Expense theExpense) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theExpense.setId(0);
		
		expenseService.save(theExpense);
		
		return theExpense;
	}
	
	// add mapping for PUT /expenses - update existing expense
	
	@PutMapping("/expenses")
	public Expense updateExpense(@RequestBody Expense theExpense) {
		
		expenseService.save(theExpense);
		
		return theExpense;
	}
	
	// add mapping for DELETE /expenses/{expenseId} - delete expense
	
	@DeleteMapping("/expenses/{expenseId}")
	public String deleteExpense(@PathVariable int expenseId) {
		
		Expense tempExpense = expenseService.findById(expenseId);
		
		// throw exception if null
		
		if (tempExpense == null) {
			throw new RuntimeException("Expense id not found - " + expenseId);
		}
		
		expenseService.deleteById(expenseId);
		
		return "Deleted expense id - " + expenseId;
	}
}