// IMyAidlInterface.aidl
package com.cblue.aidlserver;

// Declare any non-default types here with import statements
import com.cblue.aidlserver.Person;

interface IMyAidlInterface {

       //一个基本类型传递
       int add(int x,int y);

       //一个数组传递
        List<String> getData(in List<String> list);

        //一个对象传递
        Person getPerson(in Person p);
}
