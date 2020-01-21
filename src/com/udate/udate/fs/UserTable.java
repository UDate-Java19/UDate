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

    public boolean userNameExists(String userName){
        return search(User.USERNAME, userName).size() != 0;
    }

    public boolean addRecord(Data user){
        if (userNameExists(((User)user).getUsername()))
            return false;
        else
            super.addRecord(user);

        return true;
    } // addRecord

    public boolean addRecord(String name, String username, String address, String city, String zip, String email, String hobbies, String sex, String age) {
        return addRecord(new User(this.name, name, username, address, city, zip, email, hobbies, sex, age));
    } // addRecord
} // UserTable




