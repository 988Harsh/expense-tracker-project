/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.expenses;


import com.expense.myapp.features.categories.Categories;
import com.expense.myapp.features.users.UserModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="Expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="description")
    private String description;
    
    @Column(name="amount")
    private float amount;
    
    @Column(name = "created_at", nullable = false, updatable=false)
    @CreationTimestamp
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date created_at;
    
    @Column(name="updated_at")
    @UpdateTimestamp
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date updated_at;
    
    @JsonManagedReference
    @ManyToOne( cascade= { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="category_id")
    private Categories category; 
    
    @JsonManagedReference
    @ManyToOne
    private UserModel user; 
    
    public Expense() {
    }

    public Expense(String description, float amount) {
        this.description = description;
        this.amount = amount;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

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
    
    
    
    public ExpenseDTORes mapResponse(){
        
        ExpenseDTORes res = new ExpenseDTORes(this.getId(),this.getDescription(),this.getCategory().getType(),this.getAmount(),this.getCreated_at(),this.getUpdated_at());
        
        return res;
        
    }
    
    
    
}
