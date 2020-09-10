/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.categories;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name="Categories")
public class Categories {

    public Categories() {
    }

    public Categories( String type) {
//        this.expenses = expenses;
        this.type = type;
    }

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    
//    @JsonManagedReference
//    @OneToMany(fetch=FetchType.EAGER,
//            mappedBy="category", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    private List<Expenses> expenses; 
    
    
    @Column(name="type")
    private String type;
    
    
    

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String category_type) {
        this.type = category_type;
    }

//    public List<Expenses> getExpenses() {
//        return expenses;
//    }
//
//    public void setExpenses(List<Expenses> expenses) {
//        this.expenses = expenses;
//    }

}
