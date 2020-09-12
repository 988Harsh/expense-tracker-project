/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.categories;

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

@RestController
@RequestMapping("/api")
public class CategoriesRestController {

	private CategoriesService categoryService;

    public CategoriesRestController() {
    }
	
        
        
        
	@Autowired
	public CategoriesRestController(CategoriesService theCategoriesService) {
		categoryService = theCategoriesService;
	}
	
	// expose "/categories" and return list of categories
	@GetMapping("/categories")
	public List<Categories> findAll() {
		return categoryService.findAll();
	}

	// add mapping for GET /categories/{categoryId}
	
	@GetMapping("/categories/{categoryId}")
	public Categories getCategories(@PathVariable int categoryId) {
		
		Categories theCategories = categoryService.findById(categoryId);
		
		if (theCategories == null) {
			throw new RuntimeException("Categories id not found - " + categoryId);
		}
		
		return theCategories;
	}
	
	// add mapping for POST /categories - add new Category
	
	@PostMapping("/categories")
	public Categories addCategories(@RequestBody Categories theCategories) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theCategories.setId(0);
		
		categoryService.save(theCategories);
		
		return theCategories;
	}
	
	// add mapping for PUT /categories - update existing Category
	
	@PutMapping("/categories")
	public Categories updateCategories(@RequestBody Categories theCategories) {
		
		categoryService.save(theCategories);
		
		return theCategories;
	}
	
	// add mapping for DELETE /categories/{categoryId} - delete Category
	
	@DeleteMapping("/categories/{categoryId}")
	public String deleteCategories(@PathVariable int categoryId) {
		
		Categories tempCategories = categoryService.findById(categoryId);
		
		// throw exception if null
		
		if (tempCategories == null) {
			throw new RuntimeException("Categories id not found - " + categoryId);
		}
		
		categoryService.deleteById(categoryId);
		
		return "Deleted Category id - " + categoryId;
	}
	
}
