package com.cblue.baidumap;

import android.app.Activity;
import android.os.Bundle;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMapOptions;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapView;


/*
* 显示基本地图（交通地图、卫星地图、热力地图）
* */
public class BaidumapActivity02 extends Activity {

    private MapView mapView;
    private BaiduMap baiduMap;
    private BaiduMapOptions baiduMapOptions;
    private MapStatus mapStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
       // SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.baidumap_activity02);
        mapView = (MapView)findViewById(R.id.baidumapactivity02_mapview);
        baiduMap = mapView.getMap();
        baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);//普通地图或卫星图
        //baiduMap.setTrafficEnabled(true);//打开交通图
        baiduMap.setBaiduHeatMapEnabled(true);// 打开热力图
    }

    @Override
    protected void onPause() {
        super.onPause();
        // activity 暂停时同时暂停地图控件
        mapView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // activity 恢复时同时恢复地图控件
        mapView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // activity 销毁时同时销毁地图控件
        mapView.onDestroy();
    }

}
