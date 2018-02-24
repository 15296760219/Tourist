package com.silent.fiveghost.tourist.ui.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.app.BaseActivity;
import com.silent.fiveghost.tourist.contract.InfoContract;
import com.silent.fiveghost.tourist.ui.fragment.FeaturesFragment;
import com.silent.fiveghost.tourist.ui.fragment.HomeFragment;
import com.silent.fiveghost.tourist.ui.fragment.OrderFragment;
import com.silent.fiveghost.tourist.ui.fragment.PersonalFragment;


public class HomeActivity extends BaseActivity implements InfoContract.View, RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private FrameLayout home_container;
    private RadioButton radio_one;
    private RadioButton radio_two;
    private ImageView release;
    private RadioButton radio_four;
    private RadioButton radio_five;
    private RadioGroup radio_group_button;
    private Fragment personalFragment;
    private Fragment orderFragment;
    private Fragment releaseFragment;
    private Fragment featuresFragment;
    private Fragment homeFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void initLayout() {

        //是否有侧滑菜单
        setHaveLeftMenu(false);
        //是否允许屏幕旋转
        setScreenRoate(false);
        //是否允许全屏
        setAllowFullScreen(true);
        //设置布局
        setContentView(R.layout.activity_home2);
        //是否是沉浸式状态栏
        setSteepStatusBar(true);
    }

    /*
     * 填充数据
     *
     * 可在此方法中创建Presenter层
     */
    @Override
    protected void initData() {


    }

    private void setDefaultFragment() {
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        homeFragment = new HomeFragment(HomeActivity.this);
        fragmentTransaction.add(R.id.home_container, homeFragment);
//        fragmentTransaction.commit();
//        smartFragmentReplace(R.id.home_container,homeFragment);
    }

    /*
     * 初始化控件
     */
    @Override
    protected void initView() {
        home_container = findView(R.id.home_container);
        radio_group_button = findView(R.id.radio_group_button);
        radio_one = findView(R.id.radio_one);
        radio_two = findView(R.id.radio_two);
        release = findView(R.id.release);
        release.setOnClickListener(this);
        radio_four = findView(R.id.radio_four);
        radio_five = findView(R.id.radio_five);
        radio_group_button.setOnCheckedChangeListener(this);
        radio_one.setChecked(true);
        setDefaultFragment();
    }


    /*
  * 有侧滑页面的方法
  */
    @Override
    protected void addLeftMenu(boolean enable) {
        //如果为true则表示有测换
        if (enable) {

            //不做处理
        } else {


        }


    }

    /*
     * 在此方法中保存数据
     */
    @Override
    protected void saveInstanceState(Bundle outState) {
        super.saveInstanceState(outState);
    }

    /*
     * 请求成功的回调
     */
    @Override
    public void success(Object o) {


    }

    /*
     * 失败的回调
     */
    @Override
    public void failure(Throwable e) {


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (checkedId) {
            case R.id.radio_one:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment(HomeActivity.this);
                }
                fragmentTransaction.replace(R.id.home_container, homeFragment);
                break;
            case R.id.radio_two:
                if (personalFragment == null) {
                    personalFragment = new PersonalFragment(HomeActivity.this);
                }
                fragmentTransaction.replace(R.id.home_container, personalFragment);
                break;
            case R.id.radio_four:
                if (orderFragment == null) {
                    orderFragment = new OrderFragment(HomeActivity.this);
                }
                fragmentTransaction.replace(R.id.home_container, orderFragment);
                break;
            case R.id.radio_five:
                if (featuresFragment == null) {
                    featuresFragment = new FeaturesFragment(HomeActivity.this);
                }
                fragmentTransaction.replace(R.id.home_container, featuresFragment);
                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.release:
                startActivity(ReleaseActivity.class);
                break;
        }
    }
}

