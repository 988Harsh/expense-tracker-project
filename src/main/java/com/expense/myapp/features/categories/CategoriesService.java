/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.categories;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface CategoriesService {
        public List<Categories> findAll();
	
	public Categories findById(int theId);
	
	public Categories save(Categories theCategory);
	
	public void deleteById(int theId);
        
        public Categories findByCategoryname(String type);
}
