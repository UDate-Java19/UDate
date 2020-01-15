package com.udate.udate.fs;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-15
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

import com.udate.fs.Data;

public class Hobby extends Data {

    public final static String ID = "id";
    public final static String NAME = "name";
    public final static String DESCRIPTION  = "description";
    public final static String LOCATIONS  = "locations";

    public Hobby(String folderName, String fileName) {super(folderName, fileName); }

    public Hobby(String folderName) {super(folderName); }
}
