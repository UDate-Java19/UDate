package com.udate.udate.fs;

import com.udate.fs.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class User extends Data {
    public final static String NAME = "name";
    public final static String USERNAME = "username";
    public final static String ADDRESS = "address";
    public final static String CITY = "city";
    public final static String ZIP = "zip";
    public final static String EMAIL = "email";
    public final static String HOBBIES = "hobbies";
    public final static String SEX = "sex";
    public final static String AGE = "age";

    List<String> hobbies = new ArrayList<String>();

    public User(String name, String userName, String address, String city, String zip, String email,
                String hobbies, String sex, String age) {
        this("", name, userName, address, city, zip, email, hobbies, sex, age);
    }

    public User(String fileName, String name, String userName, String address, String city, String zip, String email,
                String hobbies, String sex, String age) {
        super(fileName);
        setName(name);
        setUsername(userName);
        setAddress(address);
        setCity(city);
        setZip(zip);
        setEmail(email);
        setHobbies(hobbies);
        setSex(sex);
        setAge(age);
    }

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

    public User(String fileName) {
        super(fileName);
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

    public String getEmail() {
        return (String)getData().get(User.EMAIL);
    }

    public String getZip() {
        return (String)getData().get(User.ZIP);
    }

    public String getHobbies() {
        return (String)getData().get(User.HOBBIES);
    }

    public List<String> getHobbyList() {
        return hobbies;
    } // getHobbyList

    public String getSex(){
        return (String)getData().get(User.SEX);
    }

    public String getAge(){
        return (String)getData().get(User.AGE);
    }

    public void setUsername(String userName) {
            getData().put(User.USERNAME, userName);
    }

    public void setAddress(String address) {
        getData().put(User.ADDRESS, address);
    }

    public void setCity(String city) {
        getData().put(User.CITY, city);
    }

    public void setEmail(String email) {
        getData().put(User.EMAIL, email);
    }

    public void setZip(String zip) {
        getData().put(User.ZIP, zip);
    }

    public void setHobbies(String hobbies) {
        getData().put(User.HOBBIES, hobbies);
        String[] split = hobbies.split(",");
        this.hobbies = Arrays.asList(split);
    }

    public void setSex(String sex){
        getData().put(User.SEX, sex);
    }

    public void setAge(String age){
        getData().put(User.AGE, age);
    }

    @Override
    public String toString() {
        return String.format("User{Username: %s, Name: %s, Sex: %s, Age: %s, Email: %s, Address: %s, City: %s, Zip: %s, Hobbies: %s.}",
                getUsername(),getName(), getSex(), getAge(), getEmail(), getAddress(), getCity(), getZip(), getHobbies());
    }
}
