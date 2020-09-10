/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.expenses;

/**
 *
 * @author Lenovo
 */
public class ExpenseDTORes {
 
    private int id;
    private String description;
    private String type;
    private float amount;

    public ExpenseDTORes(int id, String description, String type, float amount) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public float getAmount() {
        return amount;
    }
    
    
    
}
