package com.udate.udate.fs;

import com.udate.fs.Data;
import com.udate.fs.Table;

public class UserTable extends Table {

    public UserTable(String name){
        super(name);
    }

    @Override
    public Data createDataObject(String folderName, String fileName) {
        return new User(folderName, fileName);
    }
}




