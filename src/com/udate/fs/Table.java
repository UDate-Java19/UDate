package com.udate.fs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract public class Table {
    protected String name;
    private HashMap<String, Data> dataMap = new HashMap<>();
    private HashMap<String, Reference> references = new HashMap<>();

    abstract public Data createDataObject(String fileName);
    abstract public Data createDataObject(HashMap<String, String> hm);

    public Table (String name){
        this.name = name;
        checkCreateFolder();

        // TODO: 2020-01-13 Om vi vill att den ska läsas automatiskt så ska det göras här.
        loadRecords();
    } // Table:Table

    private void checkCreateFolder(){
        File folder = new File("./" + name);
        if (!folder.exists()){
            folder.mkdir();
        } // if !folder...
    } // checkCreateFolder

    private void loadRecords() {
        try (Stream<Path> walk = Files.walk(Paths.get("./" + name))) {
            List<String> result = walk.filter(Files::isRegularFile)
                    .map(Path::toString).collect(Collectors.toList());

            result.forEach(fileName -> {
                    Data data = createDataObject(fileName);
//                    System.out.println("i table loadRecords, data.filename = " + data.getFileName() + " ,filename=" + fileName);
                    data.load();
                    this.dataMap.put(data.getFileName(), data);
            });

        } catch (IOException e) {
            e.printStackTrace();
        } // catch
    } // loadRecords

   public boolean delete(){
       File file = new File(name);
//       System.out.println("data.delete = " + name);
       return file.delete();
   } // delete

    public boolean deleteRecord(Data data){
        dataMap.remove(data.getID());
        return data.delete();
    } // deleteRecord

    public void deleteAll(){
        dataMap.forEach((k,d) -> d.delete());
        dataMap.clear();
    } // deleteAll

    public void saveAll(Data data){
        dataMap.forEach((k,d) -> d.save());
    }

    public boolean addRecord(Data data){
//        data.setFolderName(name);
        data.save();
        dataMap.put(data.getFileName(), data);
        return true;
    }  // addRecord

    public Set getKeys(){
        if(dataMap.isEmpty()){
            return null;
        } // if dataMap...
        else{
            Map.Entry<String, Data> entry = dataMap.entrySet().iterator().next();
            Data d = entry.getValue();
            HashMap h = d.getData();
            return h.keySet();
        } // else
    } // getKeys

    public Data getRecord(String id){
        return dataMap.get(id);
    }

    public ArrayList<Data> search(String key, String value){
        ArrayList<Data> result = new ArrayList<>();
        dataMap.forEach((k, d) -> {
           if( d.getData().containsKey(key) && d.getData().containsValue(value)){
               result.add(d);
           }
        });
        return result;
    } // search

    public void addReference(Reference ref){
        references.put(ref.getKey(), ref);
    }

    public HashMap<String, Data> getRecords(){
        return dataMap;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, String> getResolvedDataRaw(Data data){
        return data.getResolvedDataHM(references);
    } // getResolvedData

    public Data getResolvedData(Data data){
        return createDataObject(getResolvedDataRaw(data));
    } // getResolvedData
} // class Table