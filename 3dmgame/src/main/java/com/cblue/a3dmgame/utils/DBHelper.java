package com.cblue.a3dmgame.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pavel on 16/7/5.
 */
public class DBHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "article.db";
    private final static int VERSON = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSON);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table article(_id varchar(10),title varchar(20),litpic varchar(50),shorttitle varchar(20),pubdate varchar(20),click varchar(10),typeid int ,primary key(_id))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}
