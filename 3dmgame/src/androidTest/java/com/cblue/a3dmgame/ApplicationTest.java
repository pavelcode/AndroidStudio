package com.cblue.a3dmgame;

import android.app.Application;
import android.database.Cursor;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.cblue.a3dmgame.entity.Article;
import com.cblue.a3dmgame.utils.DBManager;
import com.cblue.a3dmgame.utils.HttpUtils;
import com.cblue.a3dmgame.utils.JsonUtils;

import java.util.List;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }


    public void test(){
        DBManager dbManager = new DBManager(getContext());
        Cursor cursor = dbManager.queryAll();
        Log.i("aaa","cursor.size="+cursor.getCount());


        boolean flag =  dbManager.isExistRecoder("575456");
        Log.i("aaa","flag="+flag);

        HttpUtils.loadStr(getContext(),"http://www.3dmgame.com/sitemap/api.php?row=10&typeid=1&paging=1&page=1", new HttpUtils.JsonParseCallBack() {
            @Override
            public void parseObjectStrToObject(String jsonStr) {
                Log.i("aaa","jsonStr="+jsonStr);
                List<Article> articleList = JsonUtils.parsArticle(jsonStr);
                Log.i("aaa",articleList.toString());
            }
        });
    }


}