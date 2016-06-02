package com.cblue.cache.lrucache;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.cblue.cache.R;

/**
 * 使用LruCache在GridView显示图片
 * Created by pavel on 16/5/23.
 */
public class LruCacheActivity01 extends AppCompatActivity {



    private GridView mGridView;
    private String [] imageUrls = Images.imageUrls;
    private ImageAdapter mImageAdapter;
    private FileUtils fileUtils;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lrucacheactivity01);
        fileUtils = new FileUtils(this);
        mGridView = (GridView) findViewById(R.id.lrucacheactivity01_gv);
        mImageAdapter = new ImageAdapter(this, mGridView, imageUrls);
        mGridView.setAdapter(mImageAdapter);
    }

    @Override
    protected void onDestroy() {
        mImageAdapter.cancelTask();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add("删除手机中图片缓存");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                fileUtils.deleteFile();
                Toast.makeText(getApplication(), "清空缓存成功", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
