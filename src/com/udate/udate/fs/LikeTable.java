package com.udate.udate.fs;
import com.udate.fs.Data;
import com.udate.fs.Table;

public class LikeTable extends Table {
        public final static String TABLE_NAME = "like";

        public LikeTable(){
            super(TABLE_NAME);
        }

        @Override
        public Data createDataObject(String fileName) { return new Like(fileName); }

        public void addRecord(Like like){ super.addRecord(like); }

        public void addRecord(String userId, String likedUserId, String likesBack) {
            Like like = new Like(this.name);
            like.getData().put(Like.USER_ID, userId);
            like.getData().put(Like.LIKES_USER_ID, likedUserId);
            like.getData().put(Like.LIKED_BACK, likesBack);
            addRecord(like);
        }
}
