package com.cblue.designpattern.mvc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cblue.designpattern.R;

/**
 * Created by pavel on 16/5/25.
 */
public class LoginActivity extends AppCompatActivity {

    EditText et1,et2;
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        et1 = (EditText)findViewById(R.id.login_name);
        et2 = (EditText)findViewById(R.id.login_password);
        btn = (Button)findViewById(R.id.login_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserBean userBean =new UserBean();
                userBean.setName(et1.getText().toString());
                userBean.setPassword(et2.getText().toString());
                String msg = login(userBean);
            }
        });
    }

    public String login(UserBean userBean){
        boolean status = false;
        String n = userBean.getName();
        String p = userBean.getPassword();
        if(n!=null&&"zhang".equals(n)){
            if(p!=null&&"123".equals(p)){
                status = true;
            }
        }
        if(status){
            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
        }
        return null;
    }

}
