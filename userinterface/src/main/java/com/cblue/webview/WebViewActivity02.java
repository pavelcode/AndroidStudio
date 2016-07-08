package com.cblue.webview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.cblue.androidstudio.R;

/**
 * 使用WebChrome客户端查看加载网页加载进度，得到网页标题
 * 添加了Progressbar，让显示更加人性化
 */
public class WebViewActivity02 extends AppCompatActivity {


    private WebView webView;
    String url ="http://henan.163.com/16/0707/08/BRBVP54H02270ILI.html";
    ProgressBar progressBar;
    final Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity02);

        webView = (WebView) findViewById(R.id.webview_activity02_wv);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        //设置不让WebView显示，只是让ProgressBar显示，当加载成功之后，让WebView显示，ProgressBar消失
        webView.setVisibility(View.INVISIBLE);
        progressBar = (ProgressBar)findViewById(R.id.webview_activity02_progressbar);


        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                Log.i("aaa","progress---"+newProgress);
                activity.setTitle("load.....");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressBar.setProgress(newProgress);

                if(newProgress==100){
                    activity.setTitle("加载完成");
                    webView.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
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
