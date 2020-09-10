/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.jwt.config;

/**
 *
 * @author Lenovo
 */
import com.expense.myapp.features.users.UserModel;
import java.io.Serializable;

public class JwtResponse implements Serializable {
    
    private UserModel user;
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    
    public JwtResponse(UserModel user,String jwttoken) {
        this.user = user;
        this.jwttoken = jwttoken;
    }
    public String getToken() {
        return this.jwttoken;
    }
    
    public UserModel getUser() {
        return user;
    }
    
}