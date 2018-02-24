package com.silent.fiveghost.tourist;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.silent.fiveghost.tourist.app.BaseActivity;
import com.silent.fiveghost.tourist.contract.InfoContract;
import com.silent.fiveghost.tourist.entry.RegisterBean;
import com.silent.fiveghost.tourist.entry.SendCodeBean;
import com.silent.fiveghost.tourist.presenter.InfoPresenter;

import java.util.HashMap;
import java.util.Map;

//注册
public class RegisterActivity extends BaseActivity implements View.OnClickListener {


    private ImageView im_register_back;
    private EditText ed_register_phone;
    private EditText ed_verificationCode;
    private EditText ed_register_password;
    private EditText ed_confirm_password;
    private Button get_verificationCode;
    //用户协议类
    private TextView tv_arggreeAgreement;
    private String str_password;
    private String str_confirm_password;

    private InfoPresenter infoPresenter;
    private String str_phone;
    private String str_verificationCode;
    private InfoPresenter infoPresenter1;
    private Map<String, String> map;
    private String s1;


    @Override
    protected void initLayout() {
        setContentView(R.layout.activity_register);
        initViews();

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    private void initViews() {
        map = new HashMap<>();

        //注册——返回按钮
        im_register_back = (ImageView) findViewById(R.id.im_register_back);
        im_register_back.setOnClickListener(this);
        //注册手机号
        ed_register_phone = (EditText) findViewById(R.id.ed_register_phone);
        //验证码
        ed_verificationCode = (EditText) findViewById(R.id.ed_verificationCode);
        //密码
        ed_register_password = (EditText) findViewById(R.id.ed_register_password);
        //确认密码   键盘键回车修改成 完成 但是图案和回车一样
        ed_confirm_password = (EditText) findViewById(R.id.ed_confirm_password);
        //获取验证码按钮
        get_verificationCode = (Button) findViewById(R.id.get_verificationCode);
        //用户服务协议
        tv_arggreeAgreement = (TextView) findViewById(R.id.tv_arggreeAgreement);
        tv_arggreeAgreement.setOnClickListener(this);
        //获取验证码监听
        get_verificationCode.setOnClickListener(this);

        //键盘监听

        ed_confirm_password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                EditText editText = new EditText(RegisterActivity.this);
                editText.setImeOptions(EditorInfo.IME_ACTION_GO);
                editText.setInputType(EditorInfo.TYPE_CLASS_TEXT);
               if (actionId == EditorInfo.IME_ACTION_GO) {
                    showToast("cao");
                   submit();

               }


                return false;
            }
        });
//
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //获取验证码
            case R.id.get_verificationCode:
                s1 = ed_register_phone.getText().toString();
                //Toast.makeText(this, "的撒发生的发生", Toast.LENGTH_SHORT).show();
                if ("".equals(s1)) {
                    Toast.makeText(RegisterActivity.this, "手机号为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                map.put("mobile", s1);
                map.put("module", "1");
                map.put("imei", getPhoneIMEI(RegisterActivity.this));
                infoPresenter = new InfoPresenter(new InfoContract.View<SendCodeBean>() {
                    @Override
                    public void success(SendCodeBean sendCodeBean) {
                        Log.e("TAG", "获取验证码:" + sendCodeBean.getErrcode());
                        if (sendCodeBean.getErrcode() == 1) {
                            ;
                          //   get_verificationCode.setText("注册");
                            Toast.makeText(RegisterActivity.this, "撒旦法是大风沙大", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(RegisterActivity.this, sendCodeBean.getErrmsg(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void failure(Throwable e) {
                        Toast.makeText(RegisterActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                        Log.e("TAG", e.toString());
                    }

                });
                //http://120.79.137.110:81/api/v1/sms/send
                infoPresenter.getData("http://120.79.137.110:81/api/v1/sms/send", map);
                //  request("http://120.79.137.110:81/api/v1/sms/send", map, buOne);
                break;
            //用户协议
            case R.id.tv_arggreeAgreement:
                startActivity(new Intent(RegisterActivity.this, UserserviceprotocolActivity.class));
                break;
            //返回
            case R.id.im_register_back:
                finish();
                break;
        }
    }

    //验证码未完成
    private void submit() {
        Toast.makeText(this, "dsfafdsasdafdsa", Toast.LENGTH_SHORT).show();
        // validate
        str_phone = ed_register_phone.getText().toString().trim();
        str_verificationCode = ed_verificationCode.getText().toString().trim();
        str_password = ed_register_password.getText().toString().trim();
        str_confirm_password = ed_confirm_password.getText().toString().trim();



        if (TextUtils.isEmpty(str_phone)) {
            Toast.makeText(this, "phone不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(str_verificationCode)) {
            Toast.makeText(this, "verificationCode不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(str_password)) {
            Toast.makeText(this, "password不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(str_confirm_password)) {
            Toast.makeText(this, "password不能为空", Toast.LENGTH_SHORT).show();
            return;
        } else {
            if (!(str_confirm_password.equals(str_password))) {
                Toast.makeText(this, "两次输入密码不一致", Toast.LENGTH_SHORT).show();
            }
        }

        // TODO validate success, do something

//        //判断手机号是否符合形式
//        if (!(Regular.getInstance().isMobileNO(str_phone))) {
//
//            Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
//
//        }
//        //判断密码是否是6位
//        if ((str_phone.length()!= 6)) {
//            Toast.makeText(this, "密码长度为6位", Toast.LENGTH_SHORT).show();
//        }


        infoPresenter1 = new InfoPresenter(new InfoContract.View<RegisterBean>() {

            private String trim3;
            private String trim2;
            private String trim1;

            @Override
            public void success(RegisterBean registerBean) {
                Toast.makeText(RegisterActivity.this, "wywywywyy", Toast.LENGTH_SHORT).show();
                trim1 = ed_register_phone.getText().toString().trim();
                trim2 = ed_verificationCode.getText().toString().trim();
                trim3 = ed_register_password.getText().toString().trim();
                Log.e("TAG", registerBean.getErrmsg() + "注册返回值");
                if (registerBean.getErrcode() == 1) {
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    finish();
                    //      startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

                } else {
                    Toast.makeText(RegisterActivity.this, registerBean.getErrmsg(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Map<String, String> map = new HashMap<>();
                map.put("tel", trim1);
                map.put("password", trim3);
                map.put("category", "2");
                map.put("code", trim2);
                infoPresenter1.getData("http://120.79.137.110:80/api/v1/auth/signup", map);
                // infoPresenter1.getData(Concat.BASE_URL2, map);


            }

            @Override
            public void failure(Throwable e) {
                Toast.makeText(RegisterActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }


    @SuppressLint("MissingPermission")
    public static String getPhoneIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (telephonyManager != null) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return "cuo";
            }
            return telephonyManager.getDeviceId();
        } else {
            return "cuo";
        }
    }
}
