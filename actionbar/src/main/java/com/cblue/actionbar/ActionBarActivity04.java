package com.cblue.actionbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;

/**
 * SearchView实现
 * Created by pavel on 16/5/17.
 */
public class ActionBarActivity04 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbaractivity04_menu,menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();

        return true;
    }
}
