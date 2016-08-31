package com.cblue.android5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cblue.androidstudio.R;

/**
 * Created by pavel on 16/7/14.
 */
public class TabLayoutFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        String value = getArguments().getString("CONTENT");
        Log.i("aaa","value"+value);
        View view = inflater.inflate(R.layout.tablayout_fragment,container,false);
        TextView tv = (TextView)view.findViewById(R.id.tablayout_fragment_tv);
        tv.setText(value);
        return view;
    }
}
