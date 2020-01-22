package com.udate.udate.fs;

import com.udate.fs.Data;

public class Like extends Data {

    public final static String USER = "user";
    public final static String LIKED = "liked";
    public final static Boolean LIKESBACK = false;

    @Override
    public String getFolderName() {
        return null;
    }

    public Like(String fileName) {super(fileName);
    }

    public Like(String ID, String user, String liked, Boolean likesback){
        super(ID);
    }



}
