package com.cblue.framework;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.cblue.framework.ormlite.Student;
import com.cblue.framework.ormlite.StudentDao;

import java.util.List;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }



    public void testDataBase()throws Exception{
        StudentDao studentDao = new StudentDao(getContext());
       // studentDao.addStudent(new Student(3,"zhangsan"));

       // studentDao.updateStudent(new Student(1,"lisi"));

        studentDao.deleteStudentById(2);
        List<Student> students =  studentDao.getAllStudent();
        for(Student student:students){
            Log.i("aaa",student.toString());
        }
        Student student = studentDao.getStudentById(1);
        Log.i("aaa",student.toString());

       // Student student = studentDao.getStudentById(3);
       // Log.i("aaa",student.toString());

    }
}