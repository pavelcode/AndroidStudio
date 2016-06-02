package com.cblue.baidumap;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;

/**
 *
 * 百度地图覆盖物基本用法
 * Created by pavel on 16/5/23.
 */
public class BaidumapActivity04 extends Activity {



    private MapView mapView;
    private BaiduMap baiduMap;

    private BitmapDescriptor picA = BitmapDescriptorFactory.fromResource(R.drawable.icon_marka);
    private Marker markerA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baidumap_activity04);
        mapView = (MapView)findViewById(R.id.baidumapactivity04_mapview);
        baiduMap = mapView.getMap();

        //设置地图的缩放比率
        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.zoomTo(14.0f);
        baiduMap.setMapStatus(mapStatusUpdate);


        //设置覆盖物属性
        LatLng llA = new LatLng(39.9223, 116.414977);
        //zIndex显示层的次序  dragable设置marker是否能被拖拽
        OverlayOptions ooA = new MarkerOptions().position(llA).icon(picA)
                .zIndex(9).draggable(true);
        //在地图上添加覆盖物
        markerA = (Marker) baiduMap.addOverlay(ooA);

        //给地图设置拖动监听 
        baiduMap.setOnMarkerDragListener(new BaiduMap.OnMarkerDragListener() {

            @Override
            public void onMarkerDragStart(Marker arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                // TODO Auto-generated method stub
                Log.i("aaa",marker.getPosition().latitude+"---"+marker.getPosition().longitude);

            }

            @Override
            public void onMarkerDrag(Marker arg0) {
                // TODO Auto-generated method stub

            }
        });

    }



}
