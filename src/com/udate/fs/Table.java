package com.udate.fs;

import java.util.ArrayList;

public class Table {
    String id;
    ArrayList<Data> data;
    ArrayList<Reference> references;

    public Table (String id){
        this.id = id;
        data = new ArrayList<>();

        // TODO: 2020-01-13 Om vi vill att den ska läsas automatiskt så ska det göras här.
    }

    public Table (String id, ArrayList references){
        this(id);
        this.references = references;

    }

//
//    public boolean saveAll(Data data){}
//    public boolean addRecord(Data data){}
//    public boolean deleteRecord(Data data){}
//    public boolean deleteAll(Data data){}
//    public boolean getKeys(){}
//    public Data getRecord(String id){}
    public ArrayList<Data> search(String key, String value){
        ArrayList<Data>  result = new ArrayList<>();
        data.forEach(d -> {
           if( d.data.containsKey(key) && d.data.containsValue(value)){
               result.add(d);
           }
        });
        return result;
    }

}
