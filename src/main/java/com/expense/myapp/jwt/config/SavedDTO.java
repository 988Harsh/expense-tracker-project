/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.jwt.config;

import com.expense.myapp.features.users.UserModel;

/**
 *
 * @author Lenovo
 */
public class SavedDTO {
    private UserModel user; private String token;

    public SavedDTO() {
    }

    public SavedDTO(UserModel user, String token) {
        this.user = user;
        this.token = token;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
