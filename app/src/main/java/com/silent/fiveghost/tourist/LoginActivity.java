package com.silent.fiveghost.tourist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.silent.fiveghost.tourist.app.BaseActivity;
import com.silent.fiveghost.tourist.entry.ForgetBean;
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


public class LoginActivity extends BaseActivity implements InfoContract.View<LoginBean>, View.OnClickListener {
    private EditText login_username;
    private EditText login_password;
    private Button bu_login;
    private TextView tv_forgrt_password;

    //忘记
    private AutoLinearLayout li;
    private PopupWindow popupWindow;
    private Button bu_forget_getcode;
    private EditText ed_forget_code;
    private EditText ed_forget_password;
    private EditText ed_forget_name;
    private ImageView finshimageView;

    private TextView tv_register;
    private Map<String, String> map = new HashMap<>();
    private String str_username;
    private String str_password;


    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_login);
        initViews();
        InfoPresenter infoPresenter = new InfoPresenter(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    private void initViews() {
        login_username = (EditText) findViewById(R.id.login_username);
        login_password = (EditText) findViewById(R.id.login_password);
        bu_login = (Button) findViewById(R.id.bu_login);
        //忘记密码
        tv_forgrt_password = (TextView) findViewById(R.id.tv_forgrt_password);
        //注册
        tv_register = (TextView) findViewById(R.id.tv_register);
        bu_login.setOnClickListener(this);
        //点击注册
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
        //忘记密码
        tv_forgrt_password.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(LoginActivity.this).inflate(R.layout.popup_forget, null);
                //结束
                finshimageView = view.findViewById(R.id.forget_finsh);
                ed_forget_name = view.findViewById(R.id.ed_forget_name);
                ed_forget_password = view.findViewById(R.id.ed_forget_password);
                ed_forget_code = view.findViewById(R.id.ed_forget_confirmpassword);
                ed_forget_code.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        EditText editText = new EditText(LoginActivity.this);
                        editText.setImeOptions(EditorInfo.IME_ACTION_GO);
                        editText.setInputType(EditorInfo.TYPE_CLASS_TEXT);
                        forgetsubmit();



                        return false;
                    }
                });
                bu_forget_getcode = view.findViewById(R.id.bu_forget_getcode);
                li = view.findViewById(R.id.li);
                popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
//                popupWindow.showAsDropDown(login_username,0,-400);
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
                popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
                popupWindow.setTouchable(true);

                //finsh按钮
                finshimageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });

                //软键盘弹出
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

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                initdatas();
                // loginsubmit();

                break;

        }
    }

    private void initdatas() {
        //账号密码存储
        SharedPreferences preferences = getSharedPreferences("the_username_and_password", LoginActivity.MODE_PRIVATE);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("username", str_username);
        edit.putString("password", str_password);
        edit.commit();

    }

    private void forgetsubmit() {
        String str_forget_name = ed_forget_name.getText().toString();
        String str_forget_password = ed_forget_password.getText().toString();
        String str_forget_code = ed_forget_code.getText().toString();
        if (TextUtils.isEmpty(str_forget_name)) {
            showToast("注册所用手机号");
            return;
        }

        if (TextUtils.isEmpty(str_forget_password)) {
            showToast("请输入密码");
            return;
        }

        if (TextUtils.isEmpty(str_forget_code)) {
            showToast("请输入验证码");
            return;
        }
        InfoPresenter infoPresenter = new InfoPresenter(new InfoContract.View<ForgetBean>(){

            @Override
            public void success(ForgetBean forgetBean) {

                if (forgetBean.getErrcode() == 1) {
                    showToast("修改成功");
                    popupWindow.dismiss();
                } else {
                    showToast(forgetBean.getErrmsg());
                }

            }

            @Override
            public void failure(Throwable e) {

            }
        });
        HashMap<String, String> map = new HashMap<>();
        map.put("tel", str_forget_name);
        map.put("password",str_forget_password);
        map.put("code", str_forget_code);
        infoPresenter.getData("http://120.79.137.110:80/api/v1/auth/reset-password", map);

    }

    private void loginsubmit() {
        // validate
        str_username = login_username.getText().toString().trim();
        if (TextUtils.isEmpty(str_username)) {
            Toast.makeText(this, " 请输入帐号", Toast.LENGTH_SHORT).show();
            return;
        }

        str_password = login_password.getText().toString().trim();
        if (TextUtils.isEmpty(str_password)) {
            Toast.makeText(this, " 请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


        InfoPresenter infoPresenter = new InfoPresenter(new InfoContract.View<LoginBean>() {

            private int errcode;

            @Override
            public void success(LoginBean loginBean) {
                errcode = loginBean.getErrcode();
                if (errcode == 1) {
                    showToast("登录成功");
                    startActivity(HomeActivity.class);
                } else {
                    showToast("登录失败");
                }
            }

            @Override
            public void failure(Throwable e) {

            }
        });

        HashMap<String, String> map = new HashMap<>();
        map.put("tel", str_username);
        map.put("password", str_password);
        infoPresenter.getData("http://120.79.137.110:80/api/v1/auth/login", map);
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
