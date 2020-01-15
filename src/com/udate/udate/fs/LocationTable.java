package com.udate.udate.fs;

import com.udate.fs.Data;
import com.udate.fs.Table;

public class LocationTable extends Table {
    
    private final static String LOCATION_TABLE = "location";

    public LocationTable() {
        super(LOCATION_TABLE);
    }

    public LocationTable(String name) {super(name);
    }

    @Override
    public Data createDataObject(String fileName) {
        return new Location(fileName);
    }


    public void addRecord(String name, String address) {
        Location location = new Location(this.name);
        location.getData().put(Location.NAME, name);
        location.getData().put(Location.ADDRESS, address);

        super.addRecord(location);
    }

}
