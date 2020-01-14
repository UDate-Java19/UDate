package com.udate.udate.fs;

import com.udate.fs.Data;

public class User extends Data {
    public final static String NAME = "name";
    public final static String USERNAME = "username";

    public User(String folderName, String fileName) {
        super(folderName, fileName);
    }


    public User(String folderName) {
        super(folderName);
    }
}
