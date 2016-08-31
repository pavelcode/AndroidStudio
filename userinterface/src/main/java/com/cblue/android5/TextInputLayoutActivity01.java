package com.cblue.android5;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cblue.androidstudio.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 使用TextInputLayout实现Editor的信息提示，错误验证，控件颜色style文件中<item name="colorAccent">#3498db</item>
 */
public class TextInputLayoutActivity01 extends AppCompatActivity implements View.OnClickListener {


    TextInputLayout textInputLayout;
    Button btn;

    //验证输入内容
    Pattern pattern = Pattern.compile("^[A-Za-z0-9]+$");
    Matcher matcher = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textinputlayout_activity01);

        textInputLayout = (TextInputLayout)findViewById(R.id.textinputlayout_activity01_til);
        //提示信息
        textInputLayout.setHint("请输入字母数字");
        btn = (Button) findViewById(R.id.textinputlayout_activity01_btn);
        btn.setOnClickListener(this);
        //开启错误提示功能


    }

    private boolean validateContent(String content){
         matcher = pattern.matcher(content);
         return matcher.matches();
    }

    @Override
    public void onClick(View view) {

        String content = textInputLayout.getEditText().getText().toString();
        if(!validateContent(content)){
            Log.i("aaa",validateContent(content)+"");
            textInputLayout.setErrorEnabled(true);
            textInputLayout.setError("只能输入字母或数字");
            Log.i("aaa","222");
        }else {
            Toast.makeText(TextInputLayoutActivity01.this, "验证通过", Toast.LENGTH_SHORT).show();
            textInputLayout.setErrorEnabled(false);
        }


    }
}
