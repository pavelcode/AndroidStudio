package com.cblue.framework.dragger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cblue.framework.R;


import javax.inject.Inject;

/**
 * 简单使用dragger2，查看依赖注入，控制反转的原理
 */
public class LoginActivity extends AppCompatActivity {

    @Inject
    UserPresenter userPresenter;
    EditText et1,et2;
    Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserComponent userComponent = DaggerUserComponent.builder().userModule(new UserModule()).build();
        userComponent.inject(this);

        et1 = (EditText)findViewById(R.id.username);
        et2 = (EditText)findViewById(R.id.userpass);
        btn1 = (Button)findViewById(R.id.login_btn);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et1.getText().toString();
                String password = et2.getText().toString();
                 User user = new User(name,password);
                 boolean flag = userPresenter.login(user);
                 if(flag){
                     Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                 }else{
                     Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                 }


            }
        });
    }
}
