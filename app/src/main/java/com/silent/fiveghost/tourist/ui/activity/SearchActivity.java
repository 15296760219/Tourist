package com.silent.fiveghost.tourist.ui.activity;


import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.app.BaseActivity;
import com.silent.fiveghost.tourist.customview.FlowLayout;

public class SearchActivity extends BaseActivity implements View.OnClickListener {

    private String mNames[] = {
           "大理古城","丽江","玉龙雪山","昆明热门景点"
    };
    private FlowLayout mFlow_seacher;
    private ImageView mReturn_search;

    /**
     * 初始化布局
     */
    @Override
    protected void initLayout() {
        //是否有侧滑菜单
        setHaveLeftMenu(false);
        //是否允许屏幕旋转
        setScreenRoate(false);
        //是否允许全屏
        setAllowFullScreen(true);
        //设置布局
        setContentView(R.layout.activity_search);
        //是否是沉浸式状态栏
        setSteepStatusBar(true);
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }


    /**
     * 初始化控件
     */
    @Override
    protected void initView() {
        mReturn_search = findView(R.id.return_search);
        mReturn_search.setOnClickListener(this);
        mFlow_seacher = findView(R.id.flow_search);
        MarginLayoutParams lp = new MarginLayoutParams(
                LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 10;
        lp.rightMargin = 10;
        lp.topMargin = 10;
        lp.bottomMargin = 10;
        for(int i = 0; i < mNames.length; i ++){
            TextView view = new TextView(this);
            view.setText(mNames[i]);
            view.setTextColor(Color.WHITE);
            view.setBackgroundDrawable(getResources().getDrawable(R.drawable.shap_textview));
            mFlow_seacher.addView(view,lp);
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.return_search:
                finish();
                break;
        }
    }
}
