/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.users;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author Lenovo
 */
//@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
