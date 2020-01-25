package com.udate.udate.fs;

import com.udate.fs.Data;

import java.util.HashMap;

public class Location extends Data {
    public final static String NAME = "name";
    public final static String ADDRESS = "address";

    public Location(String fileName) {
        super(fileName);
    }

    public Location(HashMap<String, String> hm){
        super("");
        setName(hm.get(NAME));
        setAddress(hm.get(ADDRESS));
    } // Location

    public Location(String fileName, String name, String address){
        super(fileName);
        setName(name);
        setAddress(address);
    }

    public void setName(String name){
        getData().put(Location.NAME, name);
    }

    public void setAddress(String address){
        getData().put(Location.ADDRESS, address);
    }

    public String getName() {
        return (String)getData().get(Location.NAME);
    }

    public  String getAddress() {
        return (String)getData().get(Location.ADDRESS);
    }

    @Override
    public String getFolderName() {
        return LocationTable.TABLE_NAME;
    }

    @Override
    public String toString() {
        return String.format("Platsnamn: %s%nAdress: %s", getName(), getAddress());
    } // toString
} // class Location




