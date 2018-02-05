package com.silent.fiveghost.tourist.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.app.BaseActivity;

/**
 * 路线详情
 */
public class RouteActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mReturn_toute;
    private Button mSign_route;

    @Override
    protected void initLayout() {
        //是否有侧滑菜单
        setHaveLeftMenu(false);
        //是否允许屏幕旋转
        setScreenRoate(false);
        //是否允许全屏
        setAllowFullScreen(true);
        //设置布局
        setContentView(R.layout.activity_route);
        //是否是沉浸式状态栏
        setSteepStatusBar(true);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mReturn_toute = findView(R.id.return_route);
        mReturn_toute.setOnClickListener(this);
        mSign_route = findViewById(R.id.sign_route);
        mSign_route.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.return_route:
                finish();
                break;
            case R.id.sign_route:
                startActivity(OrderContentActivity.class);
                break;
        }
    }
}
