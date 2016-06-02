package com.cblue.hardware.sensor;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cblue.hardware.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 查看当前手机的传感器类型
 * 1 首先得到传感器的管理者
 * 2 根据管理者得到手机上所有的传感器
 * 3 得到传感器的名字，在ListView中显示出来
 * @author Administrator
 *
 */
public class SensorActivity01 extends AppCompatActivity {


    ListView mListView;
    SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_activity01);
        mListView = (ListView)findViewById(R.id.sensorlist);


        //首先得到传感器的管理者
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        //根据管理者得到手机上所有的传感器
        List<Sensor> sensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        //得到所有传感器的名字
        List<String> sensorsName = new ArrayList<String>();
        for(Sensor sensor:sensors){

            String sensorType = null;
            switch (sensor.getType()) {
                case Sensor.TYPE_ACCELEROMETER:
                    sensorType="加速度传感器accelerometer";
                    break;
                case Sensor.TYPE_GYROSCOPE:
                    sensorType="陀螺仪传感器gyroscope";
                    break;
                case Sensor.TYPE_LIGHT:
                    sensorType=" 环境光线传感器light";
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    sensorType="电磁场传感器magnetic field";
                    break;
                case Sensor.TYPE_ORIENTATION:
                    sensorType=" 方向传感器orientation" ;
                    break;
                case Sensor.TYPE_PRESSURE:
                    sensorType=" 压力传感器pressure";
                    break;
                case Sensor.TYPE_PROXIMITY:
                    sensorType= " 距离传感器proximity" ;
                    break;
                case Sensor.TYPE_TEMPERATURE:
                    sensorType= " 温度传感器temperature";
                    break;
                default:
                    sensorType= sensor.getName();
                    break;
            }
            sensorsName.add(sensorType);
        }
        //放入适配器中显示出来
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, sensorsName);
        mListView.setAdapter(mAdapter);



    }
}
