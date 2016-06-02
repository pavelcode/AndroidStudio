package com.cblue.designpattern.mvp;

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
public class LoginActivity extends AppCompatActivity implements LoginView {


    EditText et1,et2;
    Button btn;
    LoginPresenter loginPresenter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        et1 = (EditText)findViewById(R.id.login_name);
        et2 = (EditText)findViewById(R.id.login_password);
        btn = (Button)findViewById(R.id.login_btn);

        loginPresenter = new LoginPresenterImpl(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.login();
            }
        });
    }

    @Override
    public String getName() {
        return et1.getText().toString();
    }

    @Override
    public String getPassword() {
        return et2.getText().toString();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(LoginActivity.this,msg, Toast.LENGTH_SHORT).show();
    }
}
