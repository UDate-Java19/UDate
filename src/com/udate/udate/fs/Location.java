package com.udate.udate.fs;

import com.udate.fs.Data;

public class Location extends Data {

    public final static String ID = "id";
    public final static String NAME = "name";
    public final static String ADDRESS = "address";

    public Location(String fileName) {
        super(fileName);
    }

    public void setName(String name){
        getData().put(Location.NAME, name);
    }

    public void setAddress(String address){
        getData().put(Location.ADDRESS, address);
    }

    public String getId() {
        return (String)getData().get(Location.ID);
    }

    public String getName() {
        return (String)getData().get(Location.NAME);
    }

    public  String getADDRESS() {
        return (String)getData().get(Location.ADDRESS);
    }

}




