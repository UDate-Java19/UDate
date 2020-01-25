package com.udate.udate.fs;

import com.udate.fs.Data;
import com.udate.fs.Table;

import java.util.HashMap;

public class UserTable extends Table {

    public final static String TABLE_NAME = "user";

    public UserTable(){
        super(TABLE_NAME);
    }

    @Override
    public Data createDataObject(String fileName) {
        return new User(fileName);
    }

    @Override
    public Data createDataObject(HashMap<String, String> hm) {return new User(hm); };

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

    public boolean addRecord(String name, String username, String email, String hobbies, String gender, String age) {
        return addRecord(new User(this.name, name, username, email, hobbies, gender, age));
    } // addRecord
} // UserTable




