package com.udate;

/*
*  Main file for testing the DB while developing it.
*
* */

import com.udate.fs.Data;
import com.udate.udate.fs.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        UDateDB db = new UDateDB();

//        UserTable userTable = new UserTable();
//        HobbyTable hobbyTable = new HobbyTable();
//        LocationTable locationTable = new LocationTable();

//        userTable.addReference(new Reference(hobbyTable, User.HOBBIES, Data.ID, Hobby.NAME));
//        hobbyTable.addReference(new Reference(locationTable, Hobby.LOCATIONS, Data.ID, Location.NAME));

        if (!db.addRecord(new User( "Kent Kovalent", "Kentaq", "Malmö",
                "johanna@gmail.com", "hobby/1579177328157.row","Male", "44")))
            System.out.println("Hörru, användaren finns redan!!!!");
        else
            System.out.println("Added Kent");

        if (!db.addRecord(new User( "Gösta", "g-man", "Malmö",
                "gosta@gpost.com", "","Male", "58")))
            System.out.println("Hörru, användaren finns redan!!!!");
        else
            System.out.println("Added Gösta");

        ArrayList<Data> users = db.search(UserTable.TABLE_NAME, User.NAME, "Johanna");
        if (users.size() > 0) {
            System.out.println("Search, found " + users.size() + " record(s) : " + users.get(0));

            HashMap<String, String> resolvedData = db.getResolvedData((User)users.get(0));
            System.out.println("Hobbies i klartext:  " + resolvedData);

//            if (!db.deleteRecord(users.get(0)))
//                System.out.println("Det gick inte att radera posten " + users.get(0));
//            else
//                System.out.println("Post raderad!");
        } // if users...
        else
            System.out.println("Hittade ej Johanna!");

        db.getRecords(HobbyTable.TABLE_NAME).forEach((k, v) -> {
            System.out.println(v + " " + db.getResolvedData((Hobby)v));
        });

        users = db.search(UserTable.TABLE_NAME, User.GENDER, "Male");
        System.out.println("Search for Males, found " + users.size());
        for (Data d : users) System.out.println(d);

        users = db.search(UserTable.TABLE_NAME, User.GENDER, "Female");
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
