package com.silent.fiveghost.tourist;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.silent.fiveghost.tourist.entry.LoginBean;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.RegisterActivity;
import com.silent.fiveghost.tourist.contract.InfoContract;
import com.silent.fiveghost.tourist.presenter.InfoPresenter;
import com.silent.fiveghost.tourist.ui.activity.HomeActivity;
import com.silent.fiveghost.tourist.utils.KeyboardUtils;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends AppCompatActivity implements InfoContract.View<LoginBean>, View.OnClickListener {
    private EditText login_username;
    private EditText login_password;
    private Button bu_login;
    private TextView tv_forgrt_password;
    //是否状态栏透明
    protected boolean isSetStatusBar = false;
    private TextView tv_register;
    private Map<String, String> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        if (isSetStatusBar) {
            steepStatusBar();
        }


        InfoPresenter infoPresenter = new InfoPresenter(this);



    }

    private void initView() {
        login_username = (EditText) findViewById(R.id.login_username);
        login_password = (EditText) findViewById(R.id.login_password);
        bu_login = (Button) findViewById(R.id.bu_login);
       //忘记密码
        tv_forgrt_password = (TextView) findViewById(R.id.tv_forgrt_password);
        //注册
        tv_register = (TextView) findViewById(R.id.tv_register);
        bu_login.setOnClickListener(this);

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
        //忘记密码
        tv_forgrt_password.setOnClickListener(new View.OnClickListener() {
            private AutoLinearLayout li;
            private PopupWindow popupWindow;
            private Button bu_forget_getcode;
            private EditText ed_forget_confirmpassword;
            private EditText ed_forget_password;
            private EditText ed_forget_name;
            private ImageView finshimageView;

            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(LoginActivity.this).inflate(R.layout.popup_forget, null);
                //结束
                finshimageView = view.findViewById(R.id.forget_finsh);
                ed_forget_name = view.findViewById(R.id.ed_forget_name);
                ed_forget_password = view.findViewById(R.id.ed_forget_password);
                ed_forget_confirmpassword = view.findViewById(R.id.ed_forget_confirmpassword);
                bu_forget_getcode = view.findViewById(R.id.bu_forget_getcode);
                li = view.findViewById(R.id.li);

                popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,true);
//                popupWindow.showAsDropDown(login_username,0,-400);
                popupWindow.showAtLocation(view, Gravity.CENTER,0,0);
                popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
                popupWindow.setTouchable(true);

                finshimageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });


                KeyboardUtils.showSoftInput(LoginActivity.this);
          //      KeyboardUtils.showSoftInput(li);





            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bu_login:
              // submit();

                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
                break;

        }
    }

    private void submit() {
        // validate
        String username = login_username.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "  用户名/手机号/邮箱", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = login_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "   6位数字或字母", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
    }


    @Override
    public void success(LoginBean loginBean) {

    }

    @Override
    public void failure(Throwable e) {

    }

    /**
     * [沉浸状态栏]
     */
    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}
