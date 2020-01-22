package com.udate.udate.fs;
import com.udate.fs.Data;

public class Like extends Data {

    public static final String USER_ID = "id";
    public static final String LIKES_USER_ID = "likedUserId";
    public static final String LIKED_BACK = "0";

    public Like(String fileName) {
        super(fileName);
    }

    @Override
    public String getFolderName() {
        return LikeTable.TABLE_NAME;
    }

//    public Like(String folderName) {
//        super(folderName);
//    }
//
//    public Like(String fileName) {super(fileName);
//    }

    public void setUserId(String user){ getData().put(Like.USER_ID, user); }

    public void setLikedUserId(String likes){ getData().put(Like.LIKES_USER_ID, likes); }

    public void setLikedBack(String likesBack){ getData().put(Like.LIKED_BACK, likesBack); }

    public String getUserId() {
        return (String)getData().get(Like.USER_ID);
    }

    public  String getLikedUserId() {
        return (String)getData().get(Like.LIKES_USER_ID);
    }

    public  String getLikedBack() {
        return (String)getData().get(Like.LIKED_BACK);
    }



}
