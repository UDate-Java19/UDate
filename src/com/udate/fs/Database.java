package com.udate.fs;

import java.util.ArrayList;

public class Database {
    String id;
    String baseDir;
    ArrayList<Table> tables;

    public Database (String id, String baseDir){
        this.id = id;
        this.baseDir = baseDir;

        // TODO: 2020-01-13 Vi behöver checka om mappar finns och skapa om det behövs
    }

   /* public boolean addTable(String name){}
    public boolean removeTable(String name){}
    public boolean removeTable(Table table){}
    public void removeAllTables(){}
    public Table getTable(String table){}
    public void openTables(){}
    */
}
