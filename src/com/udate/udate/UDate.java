package com.udate.udate;

import com.udate.fs.Data;
import com.udate.fs.Reference;
import com.udate.udate.fs.*;

public class UDate {

    private HobbyTable hobbyTable;
    private LocationTable locationTable;
    private UserTable userTable;

   public UDate(){
       createTables();
   }

    public void run() {
        addHobbies();
        addLocations();
        createReference();
        //addUsers();
        printAllPosts();
        searchUser();
        deleteLocation();
        editHobby();
        logInUser();
        logOutUser();
    }

    private void createTables() {
       userTable = new UserTable();
       locationTable = new LocationTable();
       hobbyTable = new HobbyTable();
    }

    private void addLocations() {
        locationTable.addRecord("India", "India"); //byt ut sen
        locationTable.addRecord("Malmö", "in the park");
        locationTable.addRecord("Palace", "4th street");
        locationTable.addRecord("Spa", "Åhus");
    }

    private void addHobbies() {
        hobbyTable.addRecord("fishing", "lovely fishing in lake");
        hobbyTable.addRecord("eat out", "lovely romantic dinner");
        hobbyTable.addRecord("cricket", "nice game of cricket");
    }

    private void createReference() {
        userTable.addReference(new Reference(userTable, User.HOBBIES, Data.ID, Hobby.NAME));
    }

    /*private void addUsers() {
        userTable.addRecord("Snehal", "snehalLovesYou", "malmövägen",
                "malmö", "34567", "snehal@gmail.com", " ", "f", "25");
        userTable.addRecord("Janis", "janisIsGreat", "bjuvvägeen",
                "bjuv", "34567", "janis@awesome.com", " ", "m", "45");

    }*/

    private void printAllPosts() {
       hobbyTable.getRecords();
    }

    private void searchUser() {

    }

    private void deleteLocation() {
    }

    private void editHobby() {
    }

    private void logInUser() {
    }

    private void logOutUser() {
    }


}
