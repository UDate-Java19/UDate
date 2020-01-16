package com.udate;

/*
*  Main file for testing the DB while developing it.
*
* */

import com.udate.fs.Table;
import com.udate.udate.UDate;
import com.udate.udate.fs.Hobby;
import com.udate.udate.fs.HobbyTable;
import com.udate.udate.fs.User;
import com.udate.udate.fs.UserTable;

import java.util.Set;

public class Main {

    public static void main(String[] args) {

        UDate udate = new UDate();
        udate.run();

    }
}
