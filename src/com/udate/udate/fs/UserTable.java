package com.udate.udate.fs;

import com.udate.fs.Data;
import com.udate.fs.Table;

public class UserTable extends Table {

    public final static String TABLE_NAME = "user";

    public UserTable(){
        super(TABLE_NAME);
    }

    @Override
    public Data createDataObject(String folderName, String fileName) {
        return new User(folderName, fileName);
    }

    public void addRecord(String name, String username, String address, String city, String zip, String email, String[] hobbies) {
        User user = new User(this.name);
        user.getData().put(User.NAME, name);
        user.getData().put(User.USERNAME, username);
        user.getData().put(User.ADDRESS, address);
        user.getData().put(User.CITY, city);
        user.getData().put(User.ZIP, zip);
        user.getData().put(User.EMAIL, email);

        user.getData().put(User.HOBBIES, hobbies);

        super.addRecord(user);
    } // addRecord
}


