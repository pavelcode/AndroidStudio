package com.cblue.nonification;


import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;



/**
 * Android5.0 自定义广播有问题
 * 发送一个简单的广播
 */
public class NotificationActivity01 extends AppCompatActivity implements View.OnClickListener {

    private Button btn_send;
    private Button btn_cancle;

    private NotificationManager manager;
    private NotificationCompat.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification01);
        btn_send = (Button)findViewById(R.id.notificationactivity01_btn_send);
        btn_cancle = (Button)findViewById(R.id.notificationactivity01_btn_cancle);
        btn_send.setOnClickListener(this);
        btn_cancle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.notificationactivity01_btn_send:

                manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                builder = new NotificationCompat.Builder(this);
                //TODO 通知必须加上图标
                builder.setSmallIcon(R.mipmap.ic_launcher);

                //发送一个简单通知
                /*
                builder.setTicker("通知来了");
                builder.setContentTitle("好消息");
                builder.setContentText("最近班里会来个美女");*/

                //发送一个大通知 4.1之前的使用这个，4.1之后的使用下面那个
                /*
                //NotificationCompat.InboxStyle indexStyle = new NotificationCompat.InboxStyle();
                NotificationCompat.BigTextStyle indexStyle = new NotificationCompat.BigTextStyle();
                indexStyle.setBigContentTitle("大广播");
                indexStyle.bigText( "事件1  事件2  事件3" );
                indexStyle.setSummaryText("summary");
                //图标是必须有的
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setStyle(indexStyle);*/

                //带进度条的通知
                /*
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentTitle("下载文件");
                builder.setContentText("正在下载。。。");
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO <=100
                        for (int i = 0; i <= 100; i += 5) {
                            //将setProgress的第三个参数设为true即可显示为无明确进度的进度条样式,而不是没有进度条
                            builder.setProgress(100, i, false);
                            manager.notify(0, builder.build());

                            try {
                                Thread.sleep(5 * 100);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                        builder.setContentText("下载完成");
                        builder.setProgress(0, 0, false);

                        // id相同，使用新设置的属性的通知，代替之前的通知
                        manager.notify(0, builder.build());

                    }
                }).start();
                 */


                //得到自定义通知布局文件对象
                RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification_customer);
                //给布局文件对象属性设置值
                remoteViews.setImageViewResource(R.id.iv1, R.mipmap.ic_launcher);
                remoteViews.setTextViewText(R.id.tv1, "好消息：");
                remoteViews.setTextViewText(R.id.tv2, "要放假了");
                //把布局对象放入到通知的内容中
                builder.setContent(remoteViews);


                //设置一个提醒动作  默认铃声和振动
                //builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);

                //添加一个跳转动作
                /*
                Intent intent = new Intent(this,NotificationActivity02.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this,1000,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);
                ///设置点击之后，通知取消，这个必须与跳转动作配合使用，如果只是设置了取消，但是没有跳转，无效
                builder.setAutoCancel(true);*/
                //TODO 带进度条的广播，这个需要注释掉，否则会一次两个广播
                manager.notify((int)System.currentTimeMillis(),builder.build());



                break;
            case R.id.notificationactivity01_btn_cancle:
                manager.cancelAll();
                break;
        }

    }
}
