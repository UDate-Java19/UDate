package com.udate.udate.fs;

import com.udate.fs.Data;
import com.udate.fs.Table;

public class LocationTable extends Table {
    
    public final static String TABLE_NAME = "location";

    public LocationTable() {
        super(TABLE_NAME);
    }

    public LocationTable(String name) {super(name);
    }

    @Override
    public Data createDataObject(String fileName) {
        return new Location(fileName);
    }


//    public void addRecord(String name, String address) {
//        Location location = new Location(this.name);
//        location.getData().put(Location.NAME, name);
//        location.getData().put(Location.ADDRESS, address);
//
//        addRecord(location);
//    }

//    public void addRecord(Location location){
//        super.addRecord(location);
//    }
    }
