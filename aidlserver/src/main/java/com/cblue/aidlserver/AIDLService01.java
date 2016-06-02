package com.cblue.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.List;

public class AIDLService01 extends Service {
    public AIDLService01() {
    }

    class AIDLInfaceImpl extends IMyAidlInterface.Stub{
        @Override
        public int add(int x, int y) throws RemoteException {
            return x+y;
        }

        @Override
        public  List<String> getData(List<String> list) throws RemoteException {
            Log.i("aaa","aidlService--getData");
            for(int i=0;i<list.size();i++){
                list.set(i,list.get(i)+"back");
            }
            return list;
        }

        @Override
        public Person getPerson(Person p) throws RemoteException {
            p.setName(p.getName()+"back");
            return p;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new AIDLInfaceImpl();
    }
}
