package com.cblue.baidumap;

import android.app.Activity;
import android.os.Bundle;

import com.baidu.mapapi.map.MapView;

/*
*   地图基本配置
* */
public class BaidumapActivity01 extends Activity {

    MapView mapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO 这行代码非常关键，不要忘写
        //SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.baidumap_activity01);
        mapView = (MapView)findViewById(R.id.baidumapactivity01_mapview);
    }


    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mapView.onDestroy();
    }

}
