package com.udate.fs;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-13
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

public class Reference {
    Table table;
    String key;
    String foreignKey;

    public Reference(Table table, String key, String foreignKey){
        this.table = table;
        this.key = key;
        this.foreignKey = foreignKey;
    }

    public Table getTable() {
        return table;
    }

    public String getKey() {
        return key;
    }

    public String getForeignKey() {
        return foreignKey;
    }

}
