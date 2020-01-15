package com.udate.udate.fs;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-15
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

import com.udate.fs.Data;
import com.udate.fs.Table;

public class LocationTable extends Table {
    @Override
    public Data createDataObject(String folderName, String fileName) {
        return new Location(folderName, fileName);
    }
}
