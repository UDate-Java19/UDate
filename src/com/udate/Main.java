package com.udate;

/*
*  Main file for testing the DB while developing it.
*
* */

import com.udate.fs.Table;
import com.udate.udate.fs.*;

import java.util.Set;

public class Main {

    public static void main(String[] args) {

    /*    UserTable userTable = new UserTable("user");
        HobbyTable hobbyTable = new HobbyTable("hobby");
        hobbyTable.addRecord("Cycling", "Vi cyklar en cykel");
        hobbyTable.addRecord("Fishing", "Vi fiskar fisk");
        hobbyTable.addRecord("Bowling", "Vi bowlar en boll");*/

        LocationTable locationTable = new LocationTable("location");
        locationTable.addRecord("David's car center", "kungsgatan 39, Malmö");
        locationTable.addRecord("Swedbank stadion", "Stadiongatan 1, Malmö");
        locationTable.addRecord("Pildammsparken","Malmö");
        locationTable.addRecord("Kungsparken", "Lund");
        locationTable.addRecord("Stadsparken", "Helsingborg");
        locationTable.addRecord("Bulltofta DGC", "Musikvägen, Göteborg");
        locationTable.addRecord("Brohult DGC", "Låtgatan, Brohult");
        locationTable.addRecord("Jalla Jalla", "Bergsgatan 3, Malmö");
        locationTable.addRecord("Ice Bar", "Bergsgatan, Malmö");
        locationTable.addRecord("Mineral Restaurang", "Stroget 5, Copenhagen");
        locationTable.addRecord("Bastard", "Carl Hillsgatan 5, Malmö");







//        hobbyTable.getRecords().forEach((v, k) -> System.out.print(v.toString(), k.toString));
        //  hobby.getData().put(Hobby.ID, "0");
//        UserTable userTable = new UserTable("hihi");
//        User user = new User("hihi");
//        user.getData().put("name", "peter");
//        user.getData().put("userName", "piddaRabbit");
//        System.out.println(userTable.dataMap.size());
//        userTable.addRecord(user);
//        System.out.println(userTable.dataMap.size());
        //userTable.deleteRecord(user);
        //System.out.println(userTable.dataList.size());
        //userTable.deleteAll();
        //System.out.println(userTable.dataList.size());

//        Set set = userTable.getKeys();
//        System.out.println(set);

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
