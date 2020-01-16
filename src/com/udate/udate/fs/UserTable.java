package com.udate.udate.fs;

import com.udate.fs.Data;
import com.udate.fs.Table;

public class UserTable extends Table {

    public final static String TABLE_NAME = "user";

    public UserTable(){
        super(TABLE_NAME);
    }

    @Override
    public Data createDataObject(String fileName) {
        return new User(fileName);
    }

    public void addRecord(User user){
        super.addRecord(user);
    }

    public void addRecord(String name, String username, String address, String city, String zip, String email, String hobbies, String sex, String age) {
        User user = new User(this.name, name, username, address, city, zip, email, hobbies, sex, age);
//        user.getData().put(User.NAME, name);
//        user.getData().put(User.USERNAME, username);
//        user.getData().put(User.ADDRESS, address);
//        user.getData().put(User.CITY, city);
//        user.getData().put(User.ZIP, zip);
//        user.getData().put(User.EMAIL, email);
//
//        user.getData().put(User.HOBBIES, hobbies);

        super.addRecord(user);
    } // addRecord
}




