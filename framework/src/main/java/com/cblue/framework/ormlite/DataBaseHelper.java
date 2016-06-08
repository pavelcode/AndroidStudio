package com.cblue.framework.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by pavel on 16/6/7.
 */
public class DataBaseHelper extends OrmLiteSqliteOpenHelper {


    private static final String DATABASENAME="myormlite.db";
    private static final int DATABASEVERSION=1;

    public DataBaseHelper(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            Log.i("aaa","----onCreate");
            TableUtils.createTable(connectionSource,Student.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {


        try {
            if(newVersion>oldVersion) {
                TableUtils.dropTable(connectionSource, Student.class, true);
                this.onCreate(database,connectionSource);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private static DataBaseHelper dataBaseHelper;
    //得到单例的help对象
    public static synchronized DataBaseHelper getHelp(Context context){
        if(dataBaseHelper==null){
            synchronized (Student.class){
                if(dataBaseHelper==null){
                    dataBaseHelper = new DataBaseHelper(context);
                }
            }
        }
        return dataBaseHelper;
    }

    //每一个表都有一个Dao对象
    private Dao<Student,Integer> stuDao;
    //获得Dao对象
    public  Dao<Student,Integer> getStuDao()throws Exception{
        if(stuDao==null){
            stuDao = getDao(Student.class);
        }
        return stuDao;
    }

    @Override
    public void close() {
        super.close();
        stuDao = null;
    }



}
