package com.cblue.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.cblue.androidstudio.R;

/**
 * 使用WebView加载网页
 * 注：添加网络权限
 */
public class WebViewActivity01 extends AppCompatActivity {


    String url = "http://www.baidu.com";
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity01);

        mWebView = (WebView)findViewById(R.id.webview_activity01_wv);
        //得到WebView的设置对象
        WebSettings webSettings = mWebView.getSettings();
        //设置支持放大缩小
        webSettings.setBuiltInZoomControls(true);
        //加载网页
         mWebView.loadUrl(url);

        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // 自身加载新链接,不做外部跳转
                mWebView.loadUrl(url);
                return true;
            }

        });



    }
}
