/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.users;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
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
@Table(name="Users")
public class Users {

    public Users() {
    }

    public Users(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
//        this.expenses = expenses;
//        this.tokens = tokens;
    }

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="email")
    private String email;
    
    
    @Column(name="password")
    private String password;

//    @JsonManagedReference
//    @OneToMany(fetch=FetchType.EAGER,
//            mappedBy="user", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    private List<Expenses> expenses; 
//
//    @JsonManagedReference
//    @OneToMany(fetch=FetchType.EAGER,
//            mappedBy="user", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    private List<Tokens> tokens; 
    
    
//    public void add(Expenses expenses)
//    {
//        if(this.expenses==null)
//        {
//            this.expenses = new ArrayList<>();
//        }
//        
//        this.expenses.add(expenses);
//        expenses.setUser(this);
//    }
    
//    public void add(Tokens tokens)
//    {
//        if(this.tokens==null)
//        {
//            this.tokens = new ArrayList<>();
//        }
//        
//        this.tokens.add(tokens);
//        tokens.setUsers(this);
//    }
    
    
    public long getId() {
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
    
    
    
    
}