package com.udate.udate;

import com.udate.fs.Data;
import com.udate.udate.fs.HobbyTable;
import com.udate.udate.fs.LocationTable;
import com.udate.udate.fs.User;
import com.udate.udate.fs.UserTable;

import java.util.*;


public class Matching {
    User loggedUser;
    UserTable table;

    public Matching(User user, UserTable table){
        this.loggedUser = user;
        this.table = table;
    }

    public TreeMap<User, Integer> doMatch(){
        HashMap<String, Data> users = table.getRecords();
        ArrayList<String> hobbyList = (ArrayList<String>) loggedUser.getHobbyList();
        TreeMap<User,Integer>  matchingList = new TreeMap<User, Integer>(Collections.reverseOrder());

        users.forEach((k, v) -> {
            int matchCounter = 0;
            if(!((User)v).getID().equals(loggedUser.getID())){
                for(int i = (hobbyList.size()) - 1; i >= 0; i--){
                    if (((User)v).getHobbies().contains(hobbyList.get(i))) {
                        matchCounter++;
                    }
                }
                //Lägg till i matchningslista
                matchingList.put((User)v,matchCounter);
            }
        });
        return matchingList;
    }

    public static void main(String[] args) {

        UserTable userTable = new UserTable();
        HobbyTable hobbyTable = new HobbyTable();
        LocationTable locationTable = new LocationTable();

        ArrayList<Data> users = userTable.search(User.NAME, "Johanna");
        User user = (User)users.get(0);
    }
}

