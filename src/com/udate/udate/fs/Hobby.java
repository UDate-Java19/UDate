package com.udate.udate.fs;

import com.udate.fs.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Hobby extends Data {

    public final static String NAME = "name";
    public final static String DESCRIPTION  = "description";
    public final static String LOCATIONS = "locations";

    List<String> locations = new ArrayList<String>();

    public Hobby(String fileName) {super(fileName); }

    public Hobby(HashMap<String, String> hm){
        super("");
        setName(hm.get(NAME));
        setDescription(hm.get(DESCRIPTION));
        setLocations(hm.get(LOCATIONS));
    } // Hobby

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
    }

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
        locations = locations.replace("[", "").replace("]","").replace(" ", "");
        getData().put(Hobby.LOCATIONS, locations);

        if (!locations.equals("")) {
            String[] split = locations.split(",");
            this.locations = Arrays.asList(split);
        } // if !locations...
    } // setLocations

    public void addLocation(String location){
        locations.add(location);
        getData().put(Hobby.LOCATIONS, locations.toString().replace("[", "").replace("]","").replace(" ", ""));
    }

    public void removeLocation(String location){
        locations.remove(location);
        getData().put(Hobby.LOCATIONS, locations.toString().replace("[", "").replace("]","").replace(" ", ""));
    }

    public List<String> getLocationList() {
        return locations;
    } // getLocationList

    @Override
    public String toString() {
        return String.format("Hobby: %s%nBeskrivning: %s%nPlatser: %s", getName(), getDescription(), getLocations());
    }
}
