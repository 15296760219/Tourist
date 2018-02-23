package com.silent.fiveghost.tourist.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.app.BaseActivity;

public class ReleaseActivity extends BaseActivity implements View.OnClickListener {
    private Button btn_release;

    @Override
    protected void initLayout() {
        //是否有侧滑菜单
        setHaveLeftMenu(false);
        //是否允许屏幕旋转
        setScreenRoate(false);
        //是否允许全屏
        setAllowFullScreen(true);
        //设置布局
        setContentView(R.layout.release_itinerary);
        //是否是沉浸式状态栏
        setSteepStatusBar(true);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        btn_release = findViewById(R.id.btn_release);
        btn_release.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_release:
//                startActivity();
                break;
        }
    }
}
