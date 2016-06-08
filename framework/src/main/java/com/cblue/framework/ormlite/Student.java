package com.cblue.framework.ormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**

 * Created by pavel on 16/6/7.
 */
@DatabaseTable(tableName = "studentinfo")
public class Student implements Serializable {
    @Override
    public String toString() {
        return "Student{" +
                "stuid=" + stuid +
                ", name='" + name + '\'' +
                '}';
    }

    @DatabaseField(generatedId = true)
    int stuid;
    @DatabaseField(canBeNull = false,columnName = "stuname")
    String name;

    public Student() {
    }

    public Student(int stuid, String name) {
        this.stuid = stuid;
        this.name = name;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
