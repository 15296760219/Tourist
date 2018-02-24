package com.silent.fiveghost.tourist.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.app.BaseActivity;

/**
 * 订单内容  详情版
 */
public class OrderdetailsActivity extends BaseActivity{
    @Override
    protected void initLayout() {
        //是否有侧滑菜单
        setHaveLeftMenu(false);
        //是否允许屏幕旋转
        setScreenRoate(false);
        //是否允许全屏
        setAllowFullScreen(true);
        //设置布局
        setContentView(R.layout.activity_orderdetails);
        //是否是沉浸式状态栏
        setSteepStatusBar(true);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }
}
