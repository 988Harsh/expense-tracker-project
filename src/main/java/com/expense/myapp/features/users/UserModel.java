/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.users;

import com.expense.myapp.features.expenses.Expense;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 *
 * @author Lenovo
 */
@Entity
@Table(name="Users")
public class UserModel {

    
    public UserModel() {
    }

    public UserModel(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="email")
    private String email;
    
    
    @Column(name="password")
    private String password;

    @Column(name = "created_at", nullable = false, updatable=false)
    @CreationTimestamp
    private Date created_at;
    
    @Column(name="updated_at")
    @UpdateTimestamp
    private Date updated_at;
    
//    @JsonManagedReference
//    @JsonIgnore
//    @OneToMany(cascade = {CascadeType.ALL},fetch= FetchType.EAGER,mappedBy="user")//fetch=FetchType.EAGER,mappedBy="user", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
//    private List<Expense> expense; 
    
//    public void add(Expense expenses)
//    {
//        if(this.expense==null)
//        {
//            this.expense = new ArrayList<>();
//        }
//        
//        this.expense.add(expenses);
//        expenses.setUser(this);
//    }
//    
//    public void add(Tokens tokens)
//    {
//        if(this.tokens==null)
//        {
//            this.tokens = new ArrayList<>();
//        }
//        
//        this.tokens.add(tokens);
//        tokens.setUser(this);
//    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<Expense> getExpense() {
//        return expense;
//    }
//
//    public void setExpense(List<Expense> expense) {
//        this.expense = expense;
//    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    
    
    
    
    
}
