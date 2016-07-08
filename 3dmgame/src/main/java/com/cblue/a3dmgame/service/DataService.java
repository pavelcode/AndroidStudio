package com.cblue.a3dmgame.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.cblue.a3dmgame.entity.Article;
import com.cblue.a3dmgame.utils.DBManager;
import com.cblue.a3dmgame.utils.HttpUtils;
import com.cblue.a3dmgame.utils.JsonUtils;

import java.util.List;

/**
 * 下载数据
 * Created by pavel on 16/6/13.
 */
public class DataService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("aaa","下载数据");
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpUtils.loadStr(getApplicationContext(), "http://www.3dmgame.com/sitemap/api.php?row=10&typeid=1&paging=1&page=1", new HttpUtils.JsonParseCallBack() {
                    @Override
                    public void parseObjectStrToObject(String jsonStr) {
                        List<Article> articleList = JsonUtils.parsArticle(jsonStr);
                        DBManager dbManager = new DBManager(getApplicationContext());
                        for (int i = 0; i < articleList.size(); i++) {
                            Article article = articleList.get(i);
                            Log.i("aaa",article.toString());
                            //create table article(_id varchar(10),title varchar(20),litpic varchar(50),shorttitle varchar(20),pubdate varchar(20),click varchar(10),typeid int ,primary key(_id))
                            String sql = "insert into article values(?,?,?,?,?,?,?)";
                            dbManager.exeSQL(
                                    sql,
                                    new Object[]{article.getId(),
                                            article.getTitle(),
                                            article.getLitpic(),
                                            article.getShorttitle(),
                                            article.getPubdate(),
                                            article.getClick(),
                                            1});

                        }

                    }
                });
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }
}
