package com.udate.fs;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private String id;
    private String baseDir;
    private HashMap<String, Table> tables = new HashMap<>();

    public Database (String id, String baseDir){
        this.id = id;
        this.baseDir = baseDir;
        checkCreateFolder();
    }

    public String getId() {
        return id;
    }

    public String getBaseDir() {
        return baseDir;
    }

    public HashMap<String, Table> getTables() {
        return tables;
    }

    private void checkCreateFolder(){
        File folder = new File("./" + id);
        if (!folder.exists()){
            folder.mkdir();
        }
    }

   public void addTable(String name, Table table){
        tables.put(name, table);
   }

   /*
    public boolean removeTable(String name){}
    public boolean removeTable(Table table){}
    public void removeAllTables(){}
    public Table getTable(String table){}
    public void openTables(){}
    */
}
