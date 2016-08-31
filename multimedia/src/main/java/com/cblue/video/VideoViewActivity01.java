package com.cblue.video;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import com.cblue.image.R;

/**
 * 使用真机测试
 * VideoView播放视频
 * Created by pavel on 16/5/26.
 */
public class VideoViewActivity01 extends AppCompatActivity {
    VideoView videoView;
    MediaController controller;
    public static final String TAG = "VideoPlayActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoview_activity01);
        videoView = (VideoView) findViewById(R.id.vedioview_activity01_videoview01);
        // 使用系统自带的控制器
        controller = new MediaController(this);
        videoView.setMediaController(controller);
        //试过 不设置也可以成功
        //controller.setMediaPlayer(videoView);
        //播放本地视频
        //String path = Environment.getExternalStorageDirectory()+ File.separator+"girl.mp4";
        //Log.i(TAG, path);
        //videoView.setVideoPath(path);
          /*
          播放网络视频
     http://vf1.mtime.cn/Video/2015/03/20/mp4/150320094140850937_480.mp4；
     http://biggame1.b0.upaiyun.com/mp4/551afdd301f2de21adac87045f4b2c3f.mp4；
     http://biggame1.b0.upaiyun.com/mp4/09b3e57ac49db94cc8ad6afc2e926ae9.mp4；
     http://biggame1.b0.upaiyun.com/video/c62d78f7a3f87bde8d56ca63016aacde.mp4；
     http://biggame1.b0.upaiyun.com/video/a9d366a3c18911e631bf9327d458feb9.mp4
     */

        videoView.setVideoURI(Uri.parse("http://vf1.mtime.cn/Video/2015/03/20/mp4/150320094140850937_480.mp4"));
        //videoView.setVideoURI(Uri.parse(pathString));
        //设置请求焦点
        videoView.requestFocus();
        videoView.start();

    }




	/*@Override
	public void start() {
		// TODO Auto-generated method stub
		videoView.start();

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		if(videoView.isPlaying()){
			videoView.pause();
		}

	}

	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return videoView.getDuration();
	}

	@Override
	public int getCurrentPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void seekTo(int pos) {
		// TODO Auto-generated method stub
		videoView.seekTo(pos);

	}

	@Override
	public boolean isPlaying() {
		// TODO Auto-generated method stub
		return videoView.isPlaying();
	}

	@Override
	public int getBufferPercentage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean canPause() {
		// TODO Auto-generated method stub
		return videoView.canPause();
	}

	//拖动条是否能向后拖动
	@Override
	public boolean canSeekBackward() {
		// TODO Auto-generated method stub
		return videoView.canSeekBackward();
	}
	//拖动条是否能向前拖动
	@Override
	public boolean canSeekForward() {
		// TODO Auto-generated method stub
		return videoView.canSeekForward();
	}*/

}
