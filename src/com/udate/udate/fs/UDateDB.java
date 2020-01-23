package com.udate.udate.fs;

import com.udate.fs.Data;
import com.udate.fs.Database;
import com.udate.fs.Reference;

import java.util.HashMap;

public class UDateDB extends Database {
    private final static String DBNAME = "UDate";

//    public final static String USERTABLE = "users";
//    public final static String HOBBYTABLE = "hobbies";
//    public final static String LOCATIONTABLE = "location";

    public UDateDB() {
        super(DBNAME);

        addTable(UserTable.TABLE_NAME, new UserTable());
        addTable(HobbyTable.TABLE_NAME, new HobbyTable());
        addTable(LocationTable.TABLE_NAME, new LocationTable());
        addTable(LikeTable.TABLE_NAME, new LikeTable());

        getTable(UserTable.TABLE_NAME).addReference(new Reference(getTable(HobbyTable.TABLE_NAME), User.HOBBIES, Data.ID, Hobby.NAME));
        getTable(UserTable.TABLE_NAME).addReference(new Reference(getTable(LocationTable.TABLE_NAME), Hobby.LOCATIONS, Data.ID, Location.NAME));
    } // UDateDB:UdateDB
} // UDateDB