package com.udate.udate.fs;


import com.udate.fs.Data;
import com.udate.fs.Table;

import java.util.HashMap;

public class HobbyTable extends Table {

    public final static String TABLE_NAME = "hobby";
    public HobbyTable(){
        super(TABLE_NAME);
    }

    @Override
    public Data createDataObject(String fileName) {
        return new Hobby(fileName);
    }

    @Override
    public Data createDataObject(HashMap<String, String> hm) {return new Hobby(hm); };

//    public void addRecord(Hobby hobby){
//        super.addRecord(hobby);
//    }
//
//    public void addRecord(String name, String description  ) {
//        Hobby hobby = new Hobby(this.name);
//        hobby.getData().put(Hobby.NAME, name);
//        hobby.getData().put(Hobby.DESCRIPTION, description);
//        addRecord(hobby);
//    } // addRecord
} // HobbyTable
