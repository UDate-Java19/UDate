package com.udate.udate.fs;

        import com.udate.fs.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User extends Data {

    public final static String NAME = "name";
    public final static String USERNAME = "username";
    public final static String CITY = "city";
    public final static String EMAIL = "email";
    public final static String HOBBIES = "hobbies";
    public final static String GENDER = "gender";
    public final static String AGE = "age";

    ArrayList<String> hobbies = new ArrayList<String>();

    public User(String fileName) {
        super(fileName);
    }

    public User(String name, String userName, String city, String email,
                String hobbies, String gender, String age) {
        this("", name, userName, city, email, hobbies, gender, age);
    }

    public User(String fileName, String name, String userName, String city, String email,
                String hobbies, String gender, String age) {
        super(fileName);
        setName(name);
        setUsername(userName);
        setCity(city);
        setEmail(email);
        setHobbies(hobbies);
        setGender(gender);
        setAge(age);
    }
    @Override
    public boolean load() {
        super.load();

        String[] split = getData().get(User.HOBBIES).split(",");
        this.hobbies = new ArrayList<String>(Arrays.asList(split));
        return true;
    } // load

    @Override
    public String getFolderName() {
        return UserTable.TABLE_NAME;
    } // getFolderName

    public User(String fileName) {
        super(fileName);
    }

    @Override
    public boolean load() {
        super.load();

        String[] split = getData().get(User.HOBBIES).split(",");
        this.hobbies = new ArrayList<String>(Arrays.asList(split));
        return true;
    } // load

    public void addHobby(String hobby){
        hobbies.add(hobby);
        getData().put(User.HOBBIES, hobbies.toString());
    }

    public void removeHobby(String hobby){
        hobbies.remove(hobby);
        getData().put(User.HOBBIES, hobbies.toString());
    }

    @Override
    public String getFolderName() {
        return UserTable.TABLE_NAME;
    } // getFolderName

    public String getName() {
        return (String)getData().get(User.NAME);
    }

    public void setName(String name) {
        getData().put(User.NAME, name);
    }

    public String getUsername() {
        return (String)getData().get(User.USERNAME);
    }

    public String getCity() {
        return (String)getData().get(User.CITY);
    }

    public String getEmail() {
        return (String)getData().get(User.EMAIL);
    }

    public String getHobbies() {
        return (String)getData().get(User.HOBBIES);
    }

    public List<String> getHobbyList() {
        return hobbies;
    } // getHobbyList

    public String getGender(){
        return (String)getData().get(User.GENDER);
    }

    public String getAge(){
        return (String)getData().get(User.AGE);
    }

    public void setUsername(String userName) {
            getData().put(User.USERNAME, userName);
    }

    private void setCity(String city) {
            getData().put(User.CITY, city);
    }

    public void setEmail(String email) {
        getData().put(User.EMAIL, email);
    }

    public void setHobbies(String hobbies) {
        getData().put(User.HOBBIES, hobbies);
        String[] split = hobbies.split(",");
        this.hobbies = new ArrayList<String>(Arrays.asList(split));//(ArrayList<String>) Arrays.asList(split);
    } // setHobbies

    public void setGender(String sex){
        getData().put(User.GENDER, sex);
    }

    public void setAge(String age){
        getData().put(User.AGE, age);
    }

    @Override
    public String toString() {
        return String.format("User{Username: %s, Name: %s, Sex: %s, Age: %s, Email: %s, City: %s, Hobbies: %s.}",
                getUsername(), getName(), getGender(), getAge(), getEmail(), getCity(), getHobbies());
    }
}
