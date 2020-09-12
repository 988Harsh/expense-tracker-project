/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.expenses;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class ExpenseDTORes {
 
    private int id;
    private String description;
    private String type;
    private float amount;
    private Date created_at;
    private Date updated_at;

    public ExpenseDTORes(int id, String description, String type, float amount, Date created_at, Date updated_at) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
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
