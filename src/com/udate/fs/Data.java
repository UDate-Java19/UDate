package com.udate.fs;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Data {
    private final static String EXTENSION = ".row";

    private String fileName = "";
    private HashMap data = new HashMap<String, String>();;
    private String folderName;
    private HashMap<String, Reference> references = new HashMap<>();

    public Data() {
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public Data(String fileName){
        //if(!folderName.equals(""))
           // this.fileName = String.format("%s/%s", folderName, fileName);
        //else
            this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public HashMap getData() {
        return data;
    }

    public String getID() {
        return (String)data.get("id");
    }
    public HashMap getResolvedData() {

        HashMap <String, String> newData = (HashMap<String, String>) data.clone();

        data.forEach((fieldKey, v) -> {
            if (references.containsKey(fieldKey)) {
                Reference ref = references.get(fieldKey);
                String[] keyList = newData.get(ref.getKey()).split(",");

                String newList = replaceData(ref, keyList);
                newData.put(ref.getKey(), newList);
            }
        });
        return newData;
    }

    private String replaceData(Reference ref, String[] keyList) {
        StringBuilder newList = new StringBuilder();

        for (String s : keyList){
            Data refData = ref.getRefTable().search(ref.getRefKey(), s).get(0);
            newList.append(refData.getData().get(ref.getRefTextKey()));
            newList.append(",");
        }

        String temp = newList.toString();
        temp = temp.substring(0, temp.length() - 1);
        return temp;
    }

    public String getFolderName() {
        return folderName;
    }

    public HashMap getReferences() {
        return references;
    }

    private void createFileName(){
        fileName = String.format("%s/%d%s", folderName, System.currentTimeMillis(), EXTENSION);
        data.put("id", fileName);
    } //createFileName

    public boolean save(){
        if(folderName.equals("")){
            System.out.println("folderName not set :(");
            return false;
        }
        if(fileName.equals("")) createFileName();

        Path path = Paths.get(fileName);
        StringBuilder output = new StringBuilder();

        data.forEach((k, v) ->
                output.append(k).append("|").append(v).append(System.lineSeparator()));

        try {
            Files.write(path, output.toString().getBytes());
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean load(){
        if(fileName.equals("")){
            return false;
        }
        Path path = Paths.get(fileName);
        try {
            List<String> list = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (String s : list) {
                String[] line = s.split("\\|");
                data.put(line[0], line[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete() {
        File file = new File(fileName);
        System.out.println("data.delete = " + fileName);
        return file.delete();
    }

    public void addReference(Reference ref){
        references.put(ref.getKey(), ref);
    }
}
