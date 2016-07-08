package com.cblue.a3dmgame.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by pavel on 16/7/5.
 */
public class DBManager {

    private DBHelper dbHelper;

    public DBManager(Context context) {
        super();
        // TODO Auto-generated constructor stub
        dbHelper = new DBHelper(context);
    }

    public boolean exeSQL(String sql, Object[] bindArgs) {
        try {
            SQLiteDatabase database = dbHelper.getWritableDatabase();
            database.execSQL(sql, bindArgs);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return false;
    }


    public boolean isExistRecoder(String id){
        boolean flag = false;
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        try{
            Cursor cursor=database.query("article", null,"_id=?", new String[]{id}, null, null, null);
            if(cursor.getCount()>0){
                flag = true;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }



    public Cursor queryArticleByTypeId(String typeid) {

        SQLiteDatabase database = dbHelper.getReadableDatabase();
        try {

            Cursor cursor=database.query("article", null,"typeid=?", new String[]{typeid}, null, null, null);
            return cursor;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;

    }


    public Cursor queryAll() {

        SQLiteDatabase database = dbHelper.getReadableDatabase();
        try {

            Cursor cursor=database.query("article", null,null, null, null, null, null);
            return cursor;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;

    }


}
