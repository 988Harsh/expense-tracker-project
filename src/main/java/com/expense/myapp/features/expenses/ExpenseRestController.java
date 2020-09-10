/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.expenses;

import com.expense.myapp.features.categories.Categories;
import com.expense.myapp.features.categories.CategoriesService;
import com.expense.myapp.features.users.UserModel;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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

        @Autowired
        private CategoriesService categoriesService;
    public ExpenseRestController() {
    }
	
        
        
        
	@Autowired
	public ExpenseRestController(ExpenseService theExpenseService) {
		expenseService = theExpenseService;
	}
	
	// expose "/expenses" and return list of expenses
	@GetMapping("/expenses")
	public List<ExpenseDTORes> findAll(HttpServletRequest req) {
                UserModel user = (UserModel)req.getAttribute("user");
                
//                System.out.println(user.getName());
		List<Expense> expenses = expenseService.findAll(user.getId());
                
                List<ExpenseDTORes> res = new ArrayList<>();
                
                for(Expense ex : expenses){
                    res.add(ex.mapResponse());
                }
                return res;
	}

	// add mapping for GET /expenses/{expenseId}
	
	@GetMapping("/expenses/{expenseId}")
	public ExpenseDTORes getExpense(@PathVariable int expenseId) {
		
		Expense theExpense = expenseService.findById(expenseId);
		
		if (theExpense == null) {
			throw new RuntimeException("Expense id not found - " + expenseId);
		}
		
		return theExpense.mapResponse();
	}
	
	// add mapping for POST /expenses - add new expense
	
	@PostMapping("/expenses")
	public ExpenseDTORes addExpense(@RequestBody ExpenseDTO expense,HttpServletRequest req) {
		
                UserModel user = (UserModel)req.getAttribute("user");
                
                Expense theExpense = new Expense(expense.getDescription(),expense.getAmount());
                System.out.println("controller "+expense.getCategory());
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
                Categories expenseCategory = categoriesService.findByCategoryname(expense.getCategory());
                
                theExpense.setId(0);
		theExpense.setUser(user);
                theExpense.setCategory(expenseCategory);
                
                expenseService.save(theExpense);
                return theExpense.mapResponse();
	}
	
	// add mapping for PUT /expenses - update existing expense
	
	@PutMapping(value="/expenses")
	public ExpenseDTORes updateExpense(@RequestBody ExpenseDTO expense,HttpServletRequest req) {
		
                UserModel user = (UserModel)req.getAttribute("user");
                Expense theExpense = new Expense(expense.getDescription(),expense.getAmount());
                
                System.out.println("controller "+user.getName()+" and "+expense.getCategory());
		Categories expenseCategory = categoriesService.findByCategoryname(expense.getCategory());
                
                theExpense.setUser(user);
                theExpense.setCategory(expenseCategory);
		
                expenseService.save(theExpense);
		
		return theExpense.mapResponse();
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