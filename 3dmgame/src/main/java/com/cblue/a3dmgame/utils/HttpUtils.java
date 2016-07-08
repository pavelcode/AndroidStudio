package com.cblue.a3dmgame.utils;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

/**
 * Created by pavel on 16/7/5.
 */
public class HttpUtils {


    public static void loadStr(Context context, String url,final JsonParseCallBack jsonParseCallBack){
        RequestQueue requestQueue= Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // System.out.print(response.toString());
                Log.i("aaa", response.toString());
                jsonParseCallBack.parseObjectStrToObject(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("aaa","Error is"+error);
            }
        });
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        requestQueue.add(jsonObjectRequest);
    }

    public interface JsonParseCallBack{
        public void parseObjectStrToObject(String jsonStr);
    }

}
