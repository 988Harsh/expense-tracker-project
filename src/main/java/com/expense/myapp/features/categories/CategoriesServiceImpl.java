/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.categories;

import com.expense.myapp.features.users.*;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class CategoriesServiceImpl implements CategoriesService{
   
    private CategoriesRepository categoriesRepository;
   
    @Autowired
    private PasswordEncoder bcryptEncoder;
   
    @Autowired
    public CategoriesServiceImpl(CategoriesRepository theCategoryRepo) {
        categoriesRepository = theCategoryRepo;
    }   

   
	
	@Override
	public List<Categories> findAll() {
		return categoriesRepository.findAll();
	}

	@Override
	public Categories findById(int theId) {
		Optional<Categories> result = categoriesRepository.findById(theId);
		
		Categories theCategory = null;
		
		if (result.isPresent()) {
			theCategory = result.get();
		}
		else {
			// we didn't find the user
			throw new RuntimeException("Did not find Category id - " + theId);
		}
		
		return theCategory;
	}

	@Override
	public Categories save(Categories theCategory) {
		return categoriesRepository.save(theCategory);
	}

	@Override
	public void deleteById(int theId) {
		categoriesRepository.deleteById(theId);
	}
   
        @Override
	public Categories findByCategoryname(String type) {
		Optional<Categories> result = categoriesRepository.findByCategoryType(type);
                
                Categories theCategory = null;
		
		if (result.isPresent()) {
			theCategory = result.get();
		}
		else {
			// we didn't find the user
			throw new RuntimeException("Did not find Category Type - " + type);
		}
		
		return theCategory;
                
	}

    
   
   
   
   
}
