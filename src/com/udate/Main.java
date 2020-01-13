package com.udate;

/*
*  Main file for testing the DB while developing it.
*
* */

import com.udate.fs.Data;

public class Main {

    public static void main(String[] args) {
        Data data = new Data("test");
        data.data.put("name", "test");
        if(data.save()){
            System.out.println("Noice, it wurked!");
        } else System.out.println("It went feri wrung!");
        data.data.put("name", "");
        data.load();
        System.out.println(data.data);
    }
}
