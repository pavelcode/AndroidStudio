package com.cblue.actionbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;

/**
 * SearchView实现
 * Created by pavel on 16/5/17.
 */
public class SearchViewActivity01 extends AppCompatActivity {


    SearchView searchView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbaractivity04_menu, menu);

        searchView = (SearchView) menu.findItem(R.id.my_search_item).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                //当点击搜索按钮,输入法搜索按钮,会触发这个方法.在这里做相应的搜索事件,query为用户输入的值
                //当输入框为空或者""时,此方法没有被调用
                Log.i("aaa", "搜索的内容"+query);
                //设置最小化为true  防止出现重复执行
                searchView.setIconified(true);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //当输入的文字发生变化的时候,会触发这个方法.在这里做匹配提示的操作等
                Log.i("aaa", "2222");
                return false;
            }

            });

        return super.onCreateOptionsMenu(menu);
    }






}
