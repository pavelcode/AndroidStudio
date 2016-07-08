package com.cblue.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cblue.androidstudio.R;

/**
 * 使用WebView实现加载网页，前进，后退，清除历史
 */
public class WebViewActivity03 extends AppCompatActivity implements TextView.OnEditorActionListener,View.OnClickListener{


    private EditText editText;
    private Button btn1,btn2,btn3;

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity03);

        editText = (EditText)findViewById(R.id.webview_activity03_et);
        editText.setOnEditorActionListener(this);

        btn1 = (Button)findViewById(R.id.webview_activity03_btn1);
        btn2 = (Button)findViewById(R.id.webview_activity03_btn2);
        btn3 = (Button)findViewById(R.id.webview_activity03_btn3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        webView = (WebView)findViewById(R.id.webview_activity03_wv);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.webview_activity03_btn1:
                //返回
                if(webView.canGoBack()){
                    webView.goBack();
                }

                break;
            case R.id.webview_activity03_btn2:
                //前进
                if(webView.canGoForward()){
                    webView.goForward();
                }
                break;

            case R.id.webview_activity03_btn3:
                //清除历史之后，就不能再前进，后退了
                  webView.clearHistory();
                break;
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        Log.i("aaa","----");
        if(keyEvent.getKeyCode()== KeyEvent.KEYCODE_ENTER){
            String url = editText.getText().toString();
            webView.loadUrl(url);
        }
        return false;
    }
}
