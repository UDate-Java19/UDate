package com.udate;

/*
*  Main file for testing the DB while developing it.
*
* */

import com.udate.fs.Data;
import com.udate.fs.Reference;
import com.udate.udate.fs.Hobby;
import com.udate.udate.fs.HobbyTable;
import com.udate.udate.fs.User;
import com.udate.udate.fs.UserTable;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Database.save(new Hobby("Motorcycling"));

        UserTable userTable = new UserTable();
        HobbyTable hobbyTable = new HobbyTable();
        userTable.addReference(new Reference(userTable, User.HOBBIES, Data.ID, User.HOBBIES));

//        userTable.addRecord(new User( "Carl", "Carlson", "Carl Gatan 1", "Malmö", "222 22",
//                "Carl@gmail.com", "","Male", "23"));
//        userTable.addRecord(new User("Johan", "johanson", "Johan Gatan 1", "Svedala", "666 66",
//                "Johan@gmail.com", "","Female", "19"));

//        hobbyTable.addRecord(new Hobby("Go-Cart", "Drive the cart, GOGO!", ""));
//        hobbyTable.addRecord(new Hobby("Picnic", "Fight the ants!", "location/1579093279714.row"));

        ArrayList<Data> users = userTable.search(User.NAME, "Johan");
        System.out.println("Search, found " + users.size() + " record(s)");
        HashMap resolvedData = users.get(0).getResolvedData();
        System.out.println(resolvedData);
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
