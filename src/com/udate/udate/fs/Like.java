package com.udate.udate.fs;
import com.udate.fs.Data;

import java.util.HashMap;

public class Like extends Data {

    public static final String USER_ID = "userId";
    public static final String LIKES_USER_ID = "likedUserId";
    public static final String LIKED_BACK = "likedBack";

    public Like(String fileName) {super(fileName); }

    public Like(HashMap<String, String> hm){
        super("");
        setUserId(hm.get(USER_ID));
        setLikedUserId(hm.get(LIKES_USER_ID));
        setLikedBack(hm.get(LIKED_BACK));
    } // Like

    public Like(String fileName, String userId, String likedUserId) {
        super(fileName);
        setUserId(userId);
        setLikedUserId(likedUserId);
        setLikedBack("0");
    }

    public void setUserId(String user){ getData().put(Like.USER_ID, user); }

    public void setLikedUserId(String likes){ getData().put(Like.LIKES_USER_ID, likes); }

    public void setLikedBack(String likesBack){ getData().put(Like.LIKED_BACK, likesBack); }

    @Override
    public String getFolderName() {
        return LikeTable.TABLE_NAME;
    }

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
