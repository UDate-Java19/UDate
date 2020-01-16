package com.udate.udate;

import com.udate.fs.Reference;
import com.udate.udate.fs.*;

public class UDate {

    private HobbyTable hobbytable;
    private LocationTable locationtable;
    private UserTable usertable;

   public UDate(){
       createTables();
   }


    public void run() {
        addHobbies();
        addLocations();
        //createReference();
        addUsers();
        printAllPosts();
    }

    private void createTables() {
       usertable = new UserTable();
       locationtable = new LocationTable();
       hobbytable = new HobbyTable();
    }

    private void addLocations() {
        locationtable.addRecord("India", "India"); //byt ut sen
        locationtable.addRecord("Malmö", "in the park");
        locationtable.addRecord("Palace", "4th street");
        locationtable.addRecord("Spa", "Åhus");
    }

    private void addHobbies() {
        hobbytable.addRecord("fishing", "lovely fishing in lake");
        hobbytable.addRecord("eat out", "lovely romantic dinner");
        hobbytable.addRecord("cricket", "pildammsparken");
    }

    //private void createReference() {
    //    Reference ref = new Reference(hobbytable, );
    //}

    private void addUsers() {
       usertable.addRecord("Snehal", "snehalLovesYou", "malmövägen",
               "malmö", "34567", "snehal@gmail.com", new String[]{"fishing", "cricket"});
       usertable.addRecord("janis", "janisIsGreat", "lönnvägen",
               "bjuv", "5678", "janis@awesome.com", new String []{"eat out", "cricket"});
    }

    private void printAllPosts() {
       hobbytable.getRecords();
    }


}
