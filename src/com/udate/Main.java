package com.udate;

/*
*  Main file for testing the DB while developing it.
*
* */

import com.udate.udate.fs.User;
import com.udate.udate.fs.UserTable;

import java.util.Set;

public class Main {

    public static void main(String[] args) {

        UserTable userTable = new UserTable("hihi");
        User user = new User("hihi");
        user.getData().put("name", "peter");
        user.getData().put("userName", "piddaRabbit");
        System.out.println(userTable.dataMap.size());
        userTable.addRecord(user);
        System.out.println(userTable.dataMap.size());
        //userTable.deleteRecord(user);
        //System.out.println(userTable.dataList.size());
        //userTable.deleteAll();
        //System.out.println(userTable.dataList.size());

        Set set = userTable.getKeys();
        System.out.println(set);



//        Data data = new Data("test");
//        data.data.put("name", "test");

//        if(data.save()){
//            System.out.println("Noice, it wurked!");
//        } else System.out.println("It went feri wrung!");
//        data.data.put("name", "");
//        data.load();
//        System.out.println(data.data);
    }
}
