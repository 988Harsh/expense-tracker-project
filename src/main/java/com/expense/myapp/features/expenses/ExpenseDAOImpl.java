/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.expenses;

import com.expense.myapp.features.users.UserModel;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lenovo
 */
@Repository
public class ExpenseDAOImpl implements ExpenseDAO{

    private EntityManager em;
    
    @Autowired
    public ExpenseDAOImpl(EntityManager em){
        this.em = em;
    }
    
    
	@Override
        @Transactional
	public List<Expense> findAll(int uid) {
		
		// get the current hibernate session
		Session currentSession = em.unwrap(Session.class);
				
		// create a query  ... sort by last name
		Query<Expense> theQuery = 
				currentSession.createQuery("from Expense where user_id=:uid",Expense.class);
                theQuery.setParameter("uid",uid);
		
		// execute query and get result list
		List<Expense> Expenses = theQuery.getResultList();
				
		// return the results		
		return Expenses;
	}

	@Override
	public void save(Expense theExpense) {

		// get current hibernate session
		Session currentSession = em.unwrap(Session.class);
		
		// save/upate the Expense ... finally LOL
		currentSession.saveOrUpdate(theExpense);
		
	}

	@Override
	public Expense findById(int theId) {

		// get the current hibernate session
		Session currentSession = em.unwrap(Session.class);
		
		// now retrieve/read from database using the primary key
		Expense theExpense = currentSession.get(Expense.class, theId);
		
		return theExpense;
	}

	@Override
	public void deleteById(int theId) {

		// get the current hibernate session
		Session currentSession = em.unwrap(Session.class);
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Expense where id=:ExpenseId");
		theQuery.setParameter("ExpenseId", theId);
		
		theQuery.executeUpdate();		
	}
    
}
