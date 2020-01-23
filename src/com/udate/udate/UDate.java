package com.udate.udate;

import com.udate.fs.Data;
import com.udate.fs.Database;
import com.udate.fs.Reference;
import com.udate.udate.fs.*;

import java.util.ArrayList;

public class UDate {
    UDateDB db;
    private  User loggedInUser;
    private HobbyTable hobbyTable;
    private LocationTable locationTable;
    private UserTable userTable;
    UserTable table;

    public UDate(User user, UserTable table) {
        this.loggedInUser = user;
        this.table = table;
    }


    public UDate() {
        createTables();
    }

    public void run() {
        addHobbies();
        addLocations();
        createReference();
        addUsers();
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

    private void addUsers() {
    }

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

    //Radera och logga ut inloggad användare
    public void logOutUser() {
       loggedInUser = null;
    }

    public static void main(String[] args) {
//        UDateDB db = new UDateDB();
//
//        //ArrayList<Data> users = userTable.search(User.NAME, "Johanna");
//
//        loggedInUser = (User) db.getRecords(UserTable.TABLE_NAME).get(12);
//        User likedUser = (User) db.search(UserTable.TABLE_NAME, User.USERNAME, "g-man").get(0);
//        Like lp = likedUser.hasLikedMe(db, loggedInUser);
//        if (lp != null) {
//            likedUser.likeBack(lp);
//        } else {
//            likedUser.likeUser(db, loggedInUser);
//        }
//
//        db.getRecords("like");
//
//
//        // User user = (User)users.get(0);
    }
}




