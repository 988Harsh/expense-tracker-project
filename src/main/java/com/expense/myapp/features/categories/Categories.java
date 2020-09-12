/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.categories;


import com.expense.myapp.features.expenses.Expense;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

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
//    private List<Expense> expense; 
    
    
    @Column(name="type")
    private String type;
    
    @Column(name = "created_at", nullable = false, updatable=false)
    @CreationTimestamp
    private Date created_at;
    
    @Column(name="updated_at")
    @UpdateTimestamp
    private Date updated_at;

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
    

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

//    public List<Expense> getExpense() {
//        return expense;
//    }
//
//    public void setExpense(List<Expense> expenses) {
//        this.expense = expenses;
//    }

}
