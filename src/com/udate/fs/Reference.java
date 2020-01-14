package com.udate.fs;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-13
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

public class Reference {
    private Table table;
    private String key;
    private String foreignKey;
    private String textKey;

    public Reference(Table table, String key, String foreignKey, String textKey){
        this.table = table;
        this.key = key;
        this.foreignKey = foreignKey;
        this.textKey = textKey;
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

    public String getTextKey() {
        return textKey;
    }

}
