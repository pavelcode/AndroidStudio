package com.cblue.service;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 使用DownLoadManager完成下载,并查看下载文件的路径（只能针对HTTP协议）
 * Created by pavel on 16/5/19.
 */
public class DownloadManagerActivity01 extends AppCompatActivity implements View.OnClickListener{


    DownloadManager downloadManager;
    String url="http://img13.360buyimg.com/vclist/jfs/t2653/171/2099795068/16081/e5adf358/57567ea9N546cbd87.jpg";

    Button btn1,btn2;
    long downloadReference;  //下载任务的ID

    BroadcastReceiver receiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.downloadservice_activity01);
        btn1 = (Button)findViewById(R.id.downloadservice_activity01_btn1);
        btn2 = (Button)findViewById(R.id.downloadservice_activity01_btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.downloadservice_activity01_btn1:
                //开始下载
                downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse(url);
                DownloadManager.Request request = new DownloadManager.Request(uri);
                //设置大文件在wifi下才能下载(TODO这行不能添加，否则下载有问题)
                //request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
                //设置通知栏显示 (API11)
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                request.setTitle("下载");
                request.setDescription("百度云APK");
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"baiduyun.png");

                //开始下载文件 返回的是下载请求的ID
                downloadReference = downloadManager.enqueue(request);
                Log.i("aaa","downloadReference="+downloadReference);

                IntentFilter filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);

                receiver = new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {

                        long reference = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
                        Log.i("aaa","reference="+reference);
                        Log.i("aaa","intent.getAction()="+intent.getAction());

                        if(intent.getAction().equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)){
                            if(downloadReference==reference) {
                                Toast.makeText(DownloadManagerActivity01.this, "编号：" + reference + "的下载任务已经完成！", Toast.LENGTH_SHORT).show();
                                //构建查询对象
                                DownloadManager.Query myDownloadQuery = new DownloadManager.Query();
                                myDownloadQuery.setFilterById(reference);
                                //开始查询
                                Cursor myDownload = downloadManager.query(myDownloadQuery);
                                if (myDownload.moveToFirst()) {
                                    //得到文件名字的字段id
                                    int fileNameIdx = myDownload.getColumnIndex(DownloadManager.COLUMN_LOCAL_FILENAME);
                                    //得到文件名字
                                    String fileName = myDownload.getString(fileNameIdx);
                                    Log.d("aaa", fileName);
                                }
                                myDownload.close();
                            }
                        }
                    }
                };
                registerReceiver(receiver, filter);

                break;
            case R.id.downloadservice_activity01_btn2:
                //停止下载
                downloadManager.remove(downloadReference);
                Toast.makeText(DownloadManagerActivity01.this, "取消编号："+downloadReference+"的下载任务！", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
