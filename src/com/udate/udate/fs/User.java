package com.udate.udate.fs;

        import com.udate.fs.Data;

public class User extends Data {

    public final static String NAME = "name";
    public final static String USERNAME = "username";
    public final static String ADDRESS = "address";
    public final static String CITY = "city";
    public final static String ZIP = "zip";
    public final static String EMAIL = "email";
    public final static String HOBBIES = "hobbies";

    public User(String fileName, String name) {
        super(fileName);
        setName(name);
    }

    public User(String folderName) {
        super(folderName);
    }

    public String getName() {
        return (String)getData().get(User.NAME);
    }

    public void setName(String name) {
        getData().put(User.NAME, name);
    }

    public String getUsername() {
        return (String)getData().get(User.USERNAME);
    }

    public String getAddress() {
        return (String)getData().get(User.ADDRESS);
    }

    public String getCity() {
        return (String)getData().get(User.CITY);
    }

    public String getZip() {
        return (String)getData().get(User.ZIP);
    }

    public String getHobbies() {
        return (String)getData().get(User.HOBBIES);
    }
}
