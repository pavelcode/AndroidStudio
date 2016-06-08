package com.cblue.framework.ormlite;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by pavel on 16/6/7.
 */
public class StudentDao {

    private Context context;
    private DataBaseHelper dataBaseHelper;
    private Dao<Student,Integer> stuDao;

    public StudentDao(Context context){
        this.context = context;
        try {
            dataBaseHelper = DataBaseHelper.getHelp(context);
            stuDao = dataBaseHelper.getStuDao();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int addStudent(Student student){
        int count = 0;
        try {
           count =  stuDao.create(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<Student> getAllStudent(){
        try {
            return stuDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Student getStudentById(int id){

        Student student = null;
        try {
            student = stuDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public int updateStudent(Student student){
        int count = 0;
        try {
            count = stuDao.update(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int  deleteStudentById(int id){
        int count = 0;
        try {
            count = stuDao.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }




}
