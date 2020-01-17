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

        if (!userTable.addRecord(new User( "Johanna", "Johansson", "Hemgatan 1", "Malmö", "333 33",
                "johanna@gmail.com", "hobby/1579177328157.row","Female", "49")))
            System.out.println("Hörru, användaren finns redan!!!!");

        if (!userTable.addRecord(new User( "Gösta", "g-man", "Gösatan 1", "Malmö", "333 33",
                "gosta@gpost.com", "","Male", "58")))
            System.out.println("Hörru, användaren finns redan!!!!");

        ArrayList<Data> users = userTable.search(User.NAME, "Johanna");
        if (users.size() > 0) {
            System.out.println("Search, found " + users.size() + " record(s) : " + users.get(0));

            HashMap resolvedData = userTable.getResolvedData(users.get(0));
            System.out.println("Hobbies i klartext:  " + resolvedData);

            if (!userTable.deleteRecord(users.get(0)))
                System.out.println("Det gick inte att radera posten " + users.get(0));
            else
                System.out.println("Post raderad!");
        } // if users...

        hobbyTable.getRecords().forEach((k, v) -> {
            System.out.println((Data)v + " " + hobbyTable.getResolvedData((Data)v));
        });

        users = userTable.search(User.SEX, "Male");
        System.out.println("Search for Males, found " + users.size());
        for (Data d : users) System.out.println(d);

        users = userTable.search(User.SEX, "Female");
        System.out.println("Search for Females, found " + users.size());
        for (Data d : users) System.out.println(d);

//        hobbyTable.addRecord(new Hobby("Go-Cart", "Drive the cart, GOGO!", ""));
//        hobbyTable.addRecord(new Hobby("Picnic", "Fight the ants!", "location/1579093279714.row"));
//        Set set = userTable.getKeys();
//        System.out.println(set);

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

    }
}
