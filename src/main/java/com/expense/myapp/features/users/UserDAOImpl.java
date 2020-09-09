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
	public List<UserModel> findAll() {
		
		// get the current hibernate session
		Session currentSession = em.unwrap(Session.class);
				
		// create a query  ... sort by last name
		Query<UserModel> theQuery = 
				currentSession.createQuery("from UserModel",UserModel.class);
		
		// execute query and get result list
		List<UserModel> Users = theQuery.getResultList();
				
		// return the results		
		return Users;
	}

	@Override
        @Transactional
	public UserModel save(UserModel theUser) {

		// get current hibernate session
		Session currentSession = em.unwrap(Session.class);
		
			currentSession.saveOrUpdate(theUser);
	// save/upate the UserModel ... finally LOL
                
                return theUser;
		
	}

	@Override
	public UserModel findById(int theId) {

		// get the current hibernate session
		Session currentSession = em.unwrap(Session.class);
		
		// now retrieve/read from database using the primary key
		UserModel theUser = currentSession.get(UserModel.class, theId);
		
		return theUser;
	}

	@Override
        @Transactional
	public void deleteById(int theId) {

		// get the current hibernate session
		Session currentSession = em.unwrap(Session.class);
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from UserModel where id=:UserId");
		theQuery.setParameter("UserId", theId);
		
		theQuery.executeUpdate();		
	}
    
        @Override
        @Transactional
        public UserModel findByUsername(String username){
            
                Session currentSession = em.unwrap(Session.class);
				
		// create a query  ... sort by last name
		Query<UserModel> theQuery = 
				currentSession.createQuery("from UserModel where name=:UserName");//,UserModel.class
                theQuery.setParameter("UserName",username);
		
		// execute query and get result list
		UserModel user = theQuery.getResultList().get(0);
		
//                System.out.println(user.getName());
		// return the results		
		return user;
        }
        
}
