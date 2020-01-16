package com.udate;

/*
*  Main file for testing the DB while developing it.
*
* */

import com.udate.fs.Data;
import com.udate.fs.Reference;
import com.udate.udate.fs.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Database.save(new Hobby("Motorcycling"));

        UserTable userTable = new UserTable();
        HobbyTable hobbyTable = new HobbyTable();
        LocationTable locationTable = new LocationTable();

        userTable.addReference(new Reference(hobbyTable, User.HOBBIES, Data.ID, Hobby.NAME));
        hobbyTable.addReference(new Reference(locationTable, Hobby.LOCATIONS, Data.ID, Location.NAME));

//        userTable.addRecord(new User( "Carl", "Carlson", "Carl Gatan 1", "Malmö", "222 22",
//                "Carl@gmail.com", "","Male", "23"));
//        userTable.addRecord(new User("Johan", "johanson", "Johan Gatan 1", "Svedala", "666 66",
//                "Johan@gmail.com", "","Female", "19"));

//        hobbyTable.addRecord(new Hobby("Go-Cart", "Drive the cart, GOGO!", ""));
//        hobbyTable.addRecord(new Hobby("Picnic", "Fight the ants!", "location/1579093279714.row"));

        ArrayList<Data> users = userTable.search(User.NAME, "Johan");
        System.out.println("Search, found " + users.size() + " record(s) : " + users.get(0));

        HashMap resolvedData = userTable.getResolvedData(users.get(0));
        System.out.println(resolvedData);

        hobbyTable.getRecords().forEach((k, v) -> {
            System.out.println((Data)v + " " + hobbyTable.getResolvedData((Data)v));
        });

//        resolvedData.forEach(System.out::println);

//        hobbyTable.addRecord(new Hobby("", "", """Cycling", "Vi cyklar en cykel"));
//        hobbyTable.addRecord("Fishing", "Vi fiskar fisk");
//        hobbyTable.addRecord("Bowling", "Vi bowlar en boll");

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
