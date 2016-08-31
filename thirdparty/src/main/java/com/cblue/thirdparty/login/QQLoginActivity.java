package com.cblue.thirdparty.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.cblue.thirdparty.jpushdemo.R;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * 友盟实现的第三方登录
 */
public class QQLoginActivity extends AppCompatActivity {

    UMShareAPI mShareAPI  = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qqlogin_activity);
        PlatformConfig.setQQZone("100424468","c7394704798a158208a74ab60104f0ba");
        mShareAPI = UMShareAPI.get(this);
        if(mShareAPI!=null){
            SHARE_MEDIA platform =  SHARE_MEDIA.QQ;
            mShareAPI.doOauthVerify(this, platform, umAuthListener);
        }
    }

    UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText( getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mShareAPI.onActivityResult(requestCode, resultCode, data);
    }
}
