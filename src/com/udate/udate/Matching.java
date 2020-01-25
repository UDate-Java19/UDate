package com.udate.udate;

import com.udate.fs.Data;
import com.udate.udate.fs.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;


public class Matching {
    private static final int MATCHLIST_LIMIT = 10;
    User loggedUser;
    UserTable table;
    private UDateDB db = new UDateDB();



    public Matching(User user, UserTable table){
        this.loggedUser = user;
        this.table = table;

    }

    public HashMap<User, Integer> doMatch(){
        HashMap<String, Data> users = table.getRecords();
        ArrayList<String> hobbyList = (ArrayList<String>) loggedUser.getHobbyList();
        //TreeMap<User, Integer>  matchingList = new TreeMap<User, Integer>(Collections.reverseOrder());
        HashMap<User, Integer>  matchingList = new HashMap<>();

        users.forEach((k, v) -> {
            int matchCounter = 0;
            if(!((User)v).getID().equals(loggedUser.getID())){
                for(int i = (hobbyList.size()) - 1; i >= 0; i--) {
                    if (((User) v).getHobbies().contains(hobbyList.get(i))) {
                        matchCounter++;
                    }
                }
                // Lägg till i matchningslista
                matchingList.put((User)v, matchCounter);
            }
        });
        Map<User, Integer> sorted = matchingList // ber hashmapen att sortera alla "poäng"
                .entrySet()
                .stream()
                .sorted(comparingByValue(Comparator.reverseOrder()))
                .limit(MATCHLIST_LIMIT)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        return (HashMap<User, Integer>) sorted;
    }

    public static void main(String[] args) {

        UserTable userTable = new UserTable();
        HobbyTable hobbyTable = new HobbyTable();
        LocationTable locationTable = new LocationTable();

        ArrayList<Data> users = userTable.search(User.NAME, "Johanna");
        User user = (User)users.get(0);
        Matching test = new Matching(user, userTable);
        HashMap list = test.doMatch();
        list.forEach((k, v) -> {
            System.out.println(v);
        });

    }
}

