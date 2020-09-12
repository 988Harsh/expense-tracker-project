/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expense.myapp.features.expenses;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Res {
    private long count;
    private List<ExpenseDTORes> ex;

    public Res(long count, List<ExpenseDTORes> ex) {
        this.count = count;
        this.ex = ex;
    }

    public long getCount() {
        return count;
    }

    public List<ExpenseDTORes> getEx() {
        return ex;
    }
    
}
