package com.udate.udate.fs;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-15
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

import com.udate.fs.Data;
import com.udate.fs.Table;

public class HobbyTable extends Table {

    public HobbyTable(String name){
        super(name);
    }

    @Override
    public Data createDataObject(String folderName, String fileName) {
        return new Hobby(folderName, fileName);
    }

    public void addRecord(String name, String description  ) {
        Hobby hobby = new Hobby(this.name);
        hobby.getData().put(Hobby.NAME, name);
        hobby.getData().put(Hobby.DESCRIPTION, description);
        super.addRecord(hobby);
    } // addRecord
} // HobbyTable
