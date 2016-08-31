package com.cblue.video;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.cblue.image.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


/**
 * https://github.com/lipangit/JieCaoVideoPlayer/
 * http://blog.csdn.net/qiushi_1990/article/details/50896130
 *  最低版本在14以上
 */
public class ListViewVedioActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_vedio);
        listView = (ListView) findViewById(R.id.activity_vedio_listview);
        listView.setAdapter(new VideoListAdapter(this));

    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }



}
class VideoListAdapter extends BaseAdapter {

    String[] video = {"http://mp4.68mtv.com/mp43/37932-ONEREPUBLIC-stopandstare[68mtv.com].mp4",
            "http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4"};
    String[] pic = {"http://img4.jiecaojingxuan.com/2016/5/1/3430ec64-e6a7-4d8e-b044-9d408e075b7c.jpg",
            "http://img4.jiecaojingxuan.com/2016/3/14/2204a578-609b-440e-8af7-a0ee17ff3aee.jpg"};
    String[] title = {"嫂子真紧", "嫂子抬腿"};


    Context context;

    public VideoListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return video.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView) {
            viewHolder = new ViewHolder();

            LayoutInflater mInflater = LayoutInflater.from(context);
            convertView = mInflater.inflate(R.layout.activity_listview_vedio_item, null);
            viewHolder.jcVideoPlayer = (JCVideoPlayerStandard) convertView.findViewById(R.id.videoplayer);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //加载视频和标题
        viewHolder.jcVideoPlayer.setUp(video[position], title[position]);
        //加载图片
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(context));
        imageLoader.displayImage(pic[position], viewHolder.jcVideoPlayer.thumbImageView);

        return convertView;
    }

    class ViewHolder {
        JCVideoPlayerStandard jcVideoPlayer;
    }
}