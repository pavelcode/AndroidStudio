package com.cblue.webview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.cblue.androidstudio.R;

/**
 * 使用WebChrome客户端查看加载网页加载进度，得到网页标题
 */
public class WebViewActivity02 extends AppCompatActivity {


    private WebView webView;
    String url ="http://www.baidu.com";
    ProgressBar progressBar;
    LinearLayout linearLayout;
    final Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity02);
        webView = (WebView) findViewById(R.id.webview_activity02_wv);
        linearLayout = (LinearLayout) findViewById(R.id.webview_activity02_ll);

        webView.loadUrl(url);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                Log.i("aaa","progress---"+newProgress);
                activity.setTitle("load.....");
                activity.setProgress(newProgress);
                if(newProgress==100){
                    activity.setTitle("加载完成");
                }
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                Log.i("aaa","title----"+title);
            }

        });
    }
}
