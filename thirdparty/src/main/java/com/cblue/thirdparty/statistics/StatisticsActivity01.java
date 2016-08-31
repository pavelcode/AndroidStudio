package com.cblue.thirdparty.statistics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cblue.thirdparty.jpushdemo.R;
import com.umeng.analytics.MobclickAgent;

/**
 * 友盟的统计代码
 */
public class StatisticsActivity01 extends AppCompatActivity {


    private final String mPageName = "AnalyticsHome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics_activity01);
        // SDK在统计Fragment时，需要关闭Activity自带的页面统计，
        // 然后在每个页面中重新集成页面统计的代码(包括调用了 onResume 和 onPause 的Activity)。
         MobclickAgent.openActivityDurationTrack(false);
        // MobclickAgent.setSessionContinueMillis(1000);
         MobclickAgent.startWithConfigure(new MobclickAgent.UMAnalyticsConfig(StatisticsActivity01.this, "574d53f267e58efcc7000ca7", "cblue", MobclickAgent.EScenarioType.E_UM_NORMAL));
         MobclickAgent.setScenarioType(StatisticsActivity01.this, MobclickAgent.EScenarioType.E_UM_NORMAL);
    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(mPageName);
        MobclickAgent.onResume(StatisticsActivity01.this);
    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(mPageName);
        MobclickAgent.onPause(StatisticsActivity01.this);
    }
}
