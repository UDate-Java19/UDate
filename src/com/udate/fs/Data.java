package com.udate.fs;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-13
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Data {
    private final static String EXTENSION = ".row";
    private String fileName;
    public HashMap data;
    private String folderName;
    private ArrayList<Reference> references;

    public Data(String folderName){
        this.folderName = folderName;
        this.fileName = "";
        data = new HashMap<String, String>();
    }

    private void createFileName(){
        fileName = String.format("%s/%d%s", folderName, System.currentTimeMillis(), EXTENSION);
        // TODO: 2020-01-13 Se så att filnamn inte redan finns 
    } //createFileName

    public boolean save(){
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
}

