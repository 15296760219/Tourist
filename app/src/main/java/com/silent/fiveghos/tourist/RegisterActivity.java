package com.silent.fiveghos.tourist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.silent.fiveghos.tourist.utils.Regular;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBt_Register_Enter;
    private EditText mEt_Register_name;
    private EditText mEt_Register_password;
    private Button mBtn_Register_finish;
    private ImageView im_register_back;
    private ImageView im_register_more;
    private EditText ed_register_phone;
    private EditText ed_verificationCode;
    private EditText ed_register_password;
    private EditText ed_confirm_password;
    private Button get_verificationCode;
    //用户协议类
    private TextView tv_arggreeAgreement;
    private String password;
    private String confirm_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();


    }

    private void initView() {
        im_register_back = (ImageView) findViewById(R.id.im_register_back);
        im_register_more = (ImageView) findViewById(R.id.im_register_more);
        ed_register_phone = (EditText) findViewById(R.id.ed_register_phone);
        ed_verificationCode = (EditText) findViewById(R.id.ed_verificationCode);
        ed_register_password = (EditText) findViewById(R.id.ed_register_password);
        //确认密码   键盘键回车修改成 完成 但是图案和回车一样
        ed_confirm_password = (EditText) findViewById(R.id.ed_confirm_password);
        get_verificationCode = (Button) findViewById(R.id.get_verificationCode);
        tv_arggreeAgreement = (TextView) findViewById(R.id.tv_arggreeAgreement);

        get_verificationCode.setOnClickListener(this);

//键盘监听
        ed_confirm_password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == event.KEYCODE_ENTER) {
                    // do some your things
                    //判断  未完成
                    submit();
                    //*****
                    //还有以及 用户名 密码的 存储 从 服务器 获取 验证码
                   //......
                }


                return false;
            }
        });

            //用户协议
        tv_arggreeAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,UserserviceprotocolActivity.class));
            }
        });

        //返回按钮
        im_register_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_verificationCode:

                break;
        }
    }

    //验证码未完成
    private void submit() {
        // validate
        String phone = ed_register_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "phone不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String verificationCode = ed_verificationCode.getText().toString().trim();
        if (TextUtils.isEmpty(verificationCode)) {
            Toast.makeText(this, "verificationCode不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        password = ed_register_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "password不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        confirm_password = ed_confirm_password.getText().toString().trim();
        if (TextUtils.isEmpty(confirm_password)) {
            Toast.makeText(this, "password不能为空", Toast.LENGTH_SHORT).show();
            return;
        } else {
            if (!(confirm_password.equals(password))) {
                Toast.makeText(this, "两次输入密码不一致", Toast.LENGTH_SHORT).show();
            }
        }

        // TODO validate success, do something

        //判断手机号是否符合形式
        if (!(Regular.getInstance().isMobileNO(phone))) {

            Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();

        }


        //判断密码是否是6位
        if (!(password.length() == 6)) {
            Toast.makeText(this, "密码长度为6位", Toast.LENGTH_SHORT).show();
        }


    }

}
