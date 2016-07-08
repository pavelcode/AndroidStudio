package com.cblue.a3dmgame.utils;

import com.cblue.a3dmgame.entity.Article;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavel on 16/7/6.
 */
public class JsonUtils {


    //解析文章列表
    public static List<Article> parsArticle(String jsonStr) {
        List<Article> artcles = new ArrayList<Article>();
        try {
            JSONObject object = new JSONObject(jsonStr);
            JSONObject object2 = object.getJSONObject("data");
            for (int i = 0; i < 9; i++) {
                JSONObject element = object2.getJSONObject(i + "");
                Article article = new Article();
                article.setId(element.getString("id"));
                article.setLitpic(element.getString("litpic"));
                article.setTitle(element.getString("shorttitle"));
                article.setPubdate(element.getString("pubdate"));
                article.setClick(element.getString("click"));
                artcles.add(article);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return artcles;
    }
}
