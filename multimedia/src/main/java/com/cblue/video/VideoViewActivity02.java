package com.cblue.video;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.cblue.image.R;

/**
 * VideoView播放视频
 * 全屏显示   切换横竖屏
 *
 * onRestoreInstanceState onSaveInstanceState 不成功  onSaveInstanceState不执行
 */
public class VideoViewActivity02 extends Activity implements View.OnClickListener {

    Button btn1,btn2;
    VideoView videoView;
    boolean isFullScreen = false;
    MediaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoview_activity02);
        videoView = (VideoView)findViewById(R.id.customer_vedioview);
        btn1 = (Button)findViewById(R.id.full_screen);
        btn2 = (Button)findViewById(R.id.horizontal_screen);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        // 使用系统自带的控制器
        controller = new MediaController(this);
        videoView.setMediaController(controller);
        //试过 不设置也可以成功
        //controller.setMediaPlayer(videoView);
        //播放本地视频
        //String path = Environment.getExternalStorageDirectory()+ File.separator+"girl.mp4";
        //Log.i(TAG, path);
        //videoView.setVideoPath(path);
        //播放网络视频
        //http://mp4.68mtv.com/mp43/37932-ONEREPUBLIC-stopandstare[68mtv.com].mp4
        videoView.setVideoURI(Uri.parse("http://mp4.68mtv.com/mp43/37932-ONEREPUBLIC-stopandstare[68mtv.com].mp4"));
        //videoView.setVideoURI(Uri.parse(pathString));
        //设置请求焦点
        videoView.requestFocus();
        videoView.start();
    }


    //获得数据
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        int currentposition = savedInstanceState.getInt("currentposition");
        Log.i("aaa","onRestoreInstanceState----"+currentposition);
        videoView.seekTo(currentposition);
        //super.onRestoreInstanceState(savedInstanceState);


    }

    //保存数据
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {

        int currentPosition =  videoView.getCurrentPosition();
        Log.i("aaa","onSaveInstanceState---"+currentPosition);
        outState.putInt("currentposition",currentPosition);
        //super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.full_screen:
                //全屏
                if(!isFullScreen){
                    RelativeLayout.LayoutParams layoutParams=
                            new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
                    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                    videoView.setLayoutParams(layoutParams);

                    isFullScreen = true;//改变全屏/窗口的标记
                    btn1.setText("窗口模式");
                }else{//设置RelativeLayout的窗口模式
                    RelativeLayout.LayoutParams lp=new  RelativeLayout.LayoutParams(320,240);
                    lp.addRule(RelativeLayout.CENTER_IN_PARENT);
                    videoView.setLayoutParams(lp);
                    isFullScreen = false;//改变全屏/窗口的标记
                    btn1.setText("全屏模式");
                }

                break;
            case R.id.horizontal_screen:
                //如果是竖屏，切换横屏
                int currentPosition =  videoView.getCurrentPosition();
                Log.i("aaa","horizontal_screen---"+currentPosition);
                if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }else{
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                videoView.seekTo(currentPosition);
                videoView.start();

                break;
        }
    }
}
