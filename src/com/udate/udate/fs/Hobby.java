package com.udate.udate.fs;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-15
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

import com.udate.fs.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hobby extends Data {

    public final static String NAME = "name";
    public final static String DESCRIPTION  = "description";
    public final static String LOCATIONS = "locations";

    List<String> locations = new ArrayList<String>();

    public Hobby(String fileName) {super(fileName); }

//    public Hobby(String folderName, String fileName) {super(folderName, fileName); }

    public Hobby(String name, String description, String locations){
        this("", name, description, locations);
    }

    public Hobby(String fileName, String name, String description, String locations){
        super(fileName);
        setName(name);
        setDescription(description);
        setLocations(locations);
    }

    @Override
    public String getFolderName() {
        return HobbyTable.TABLE_NAME;
    } // getFolderName

    public String getName() {
        return (String)getData().get(Hobby.NAME);
    }

    public String getDescription() {
        return (String)getData().get(Hobby.DESCRIPTION);
    }

    public String getLocations() {
        return (String)getData().get(Hobby.LOCATIONS);
    }


    public void setName(String name) {
        getData().put(Hobby.NAME, name);
    }

    public void setDescription(String description) {
        getData().put(Hobby.DESCRIPTION, description);
    }

    public void setLocations(String locations) {
        getData().put(Hobby.LOCATIONS, locations);
        String[] split = locations.split(",");
        this.locations = Arrays.asList(split);
    }
    public void addLocation(String location){
        locations.add(location);
        getData().put(User.HOBBIES, locations.toString());
    }

    public void removeLocation(String location){
        locations.remove(location);
        getData().put(User.HOBBIES, locations.toString());
    }

    @Override
    public String toString() {
        return String.format("Hobby{Name: %s, Locations: %s, Description: %s.}",
        getName(), getLocations(), getDescription());
    } // toString
}  //class Hobby
