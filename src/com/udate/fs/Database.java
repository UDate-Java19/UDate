package com.udate.fs;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private String name = "";
    private String baseDir = "";
    private HashMap<String, Table> tables = new HashMap<>();

    public Database(String name) {
        this.name = name;
    } // Database:Database

    public Database(String name, String baseDir) {
        this(name);
        this.baseDir = baseDir;
        if (!baseDir.equals(""))
            checkCreateFolder();
    } // Database:Database

    public String getName() {
        return name;
    }

    public String getBaseDir() {
        return baseDir;
    }

    public HashMap<String, Table> getTables() {
        return tables;
    }

    private void checkCreateFolder() {
        File folder = new File("./" + name);
        if (!folder.exists()) {
            folder.mkdir();
        } // if !folder...
    } // createFolder

    public void addTable(String name, Table table) {
        tables.put(name, table);
    }

    public void removeTable(String name) {
        tables.remove(name);
    } // removeTable

    public boolean dropTable(String name) {
        Table t = tables.get(name);
        removeTable(name);
        return t.delete();
    } // dropTable

    public Table getTable(String table) {
        return tables.get(table);
    } // getTable

    public boolean addRecord(Data data) {
        return getTable(data.getFolderName()).addRecord(data);
    } // addRecord

    public boolean deleteRecord(Data data) {
        return getTable(data.getFolderName()).deleteRecord(data);
    } // deleteRecord

    public HashMap<String, Data> getRecords(String table) {
        return getTable(table).getRecords();
    } // getRecords

    public ArrayList<Data> search(String table, String searchField, String searchTerm) {
        return getTable(table).search(searchField, searchTerm);
    } // search

    public HashMap<String, String> getResolvedData(Data data) {
        return getTable(data.getFolderName()).getResolvedData(data);
    } // getResolvedData
} // class Database

