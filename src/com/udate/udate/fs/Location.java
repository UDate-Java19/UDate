package com.udate.udate.fs;

import com.udate.fs.Data;

public class Location extends Data {

    public final static String NAME = "name";
    public final static String ADDRESS = "address";

    public Location(String fileName) {
        super(fileName);
    }

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
        return HobbyTable.TABLE_NAME;
    } // getFolderName

    @Override
    public String toString() {
        return String.format( "Location{Name: %s, Address: %s}", getName(), getAddress());
    }
}




