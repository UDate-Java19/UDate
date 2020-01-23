package com.udate.udate;

import com.udate.fs.Data;
import com.udate.udate.fs.Hobby;
import com.udate.udate.fs.Location;
import com.udate.udate.fs.User;

import java.util.*;

class SortLists {
    // function to sort hashmap by values
    public static HashMap<String, Data> sortHobbyListByName(HashMap<String, Data> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Data> > list =
                new LinkedList<Map.Entry<String, Data> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Data> >() {
            public int compare(Map.Entry<String, Data> o1,
                               Map.Entry<String, Data> o2)
            {
                return (((Hobby)o1.getValue())).getName().compareTo(((Hobby)o2.getValue()).getName());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Data> temp = new LinkedHashMap<String, Data>();
        for (Map.Entry<String, Data> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    } // sortHobbyListByName

    public static HashMap<String, Data> sortUserListByName(HashMap<String, Data> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Data> > list =
                new LinkedList<Map.Entry<String, Data> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Data> >() {
            public int compare(Map.Entry<String, Data> o1,
                               Map.Entry<String, Data> o2)
            {
                return (((User)o1.getValue())).getName().compareTo(((User)o2.getValue()).getName());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Data> temp = new LinkedHashMap<String, Data>();
        for (Map.Entry<String, Data> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    } // sortUserListByName

    public static HashMap<String, Data> sortLocationListByName(HashMap<String, Data> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Data> > list =
                new LinkedList<Map.Entry<String, Data> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Data> >() {
            public int compare(Map.Entry<String, Data> o1,
                               Map.Entry<String, Data> o2)
            {
                return (((Location)o1.getValue())).getName().compareTo(((Location)o2.getValue()).getName());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Data> temp = new LinkedHashMap<String, Data>();
        for (Map.Entry<String, Data> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    } // sortLocationListByName
} // class SortHobbyList
