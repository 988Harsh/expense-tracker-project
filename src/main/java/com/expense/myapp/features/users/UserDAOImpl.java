/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.users;

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
public class UserDAOImpl implements UserDAO{

    private EntityManager em;
    
    @Autowired
    public UserDAOImpl(EntityManager em){
        this.em = em;
    }
    
    
	@Override
        @Transactional
	public List<User> findAll() {
		
		// get the current hibernate session
		Session currentSession = em.unwrap(Session.class);
				
		// create a query  ... sort by last name
		Query<User> theQuery = 
				currentSession.createQuery("from User",User.class);
		
		// execute query and get result list
		List<User> Users = theQuery.getResultList();
				
		// return the results		
		return Users;
	}

	@Override
	public void save(User theUser) {

		// get current hibernate session
		Session currentSession = em.unwrap(Session.class);
		
		// save/upate the User ... finally LOL
		currentSession.saveOrUpdate(theUser);
		
	}

	@Override
	public User findById(int theId) {

		// get the current hibernate session
		Session currentSession = em.unwrap(Session.class);
		
		// now retrieve/read from database using the primary key
		User theUser = currentSession.get(User.class, theId);
		
		return theUser;
	}

	@Override
	public void deleteById(int theId) {

		// get the current hibernate session
		Session currentSession = em.unwrap(Session.class);
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from User where id=:UserId");
		theQuery.setParameter("UserId", theId);
		
		theQuery.executeUpdate();		
	}
    
}
