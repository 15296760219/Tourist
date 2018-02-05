package com.silent.fiveghost.tourist.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.ocnyang.pagetransformerhelp.cardtransformer.AlphaPageTransformer;
import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.adapter.HomeListViewAdapter;
import com.silent.fiveghost.tourist.adapter.HomeRecyclerViewAdapter;
import com.silent.fiveghost.tourist.adapter.MyPagerAdapter;
import com.silent.fiveghost.tourist.app.base.BaseFragment;
import com.silent.fiveghost.tourist.ui.activity.HomeActivity;
import com.silent.fiveghost.tourist.ui.activity.SearchActivity;
import com.silent.fiveghost.tourist.customview.ObservableScrollView;
import com.zhy.autolayout.AutoLinearLayout;


import java.util.ArrayList;
import java.util.List;

/**
 * 你能看到我留在屏幕上的字，却看不到我滴在键盘上的泪！
 * Created by Nyh on 2017/12/25.
 */

/*
 * 首页Fragment
 */

@SuppressLint("ValidFragment")
public class HomeFragment extends BaseFragment implements ObservableScrollView.ScrollViewListener {

    private Context mContext;
    private TextView home_Search_Text;
    private ImageView home_Message_Image;
    private ImageView image_Zhoubian;
    private TextView text_Zhoubian;
    private ImageView iamge_Rili;
    private TextView text_Rili;
    private ImageView image_Zhinan;
    private TextView text_Zhinan;
    private ImageView image_Dingwei;
    private TextView text_Dingwei;
    private ImageView image_Zutuan;
    private TextView text_Zutuan;
    private TextView text_Popular;
    private ImageView image_Popular;
    private LinearLayout home_Popular;
    private RecyclerView home_Routes_Recycler;
    private TextView text_Guidestyle;
    private ImageView image_Guidestyle;
    private LinearLayout home_Guidestyle;
    private ListView list_Guidestyle;
    private HomeRecyclerViewAdapter mHomeRecyclerViewAdapter;
    private List<String> mImgesUrl;
    private ViewPager mCardViewPager;
    private ObservableScrollView mScroll_home;
    private AutoLinearLayout mLl_home_search;
    private int imageHeight = 400;

    public HomeFragment(HomeActivity homeActivity) {
        this.mContext = homeActivity;
    }


    /**
     * @param arguments 接收到的从其他地方传递过来的参数
     */
    @Override
    protected void initData(Bundle arguments) {


    }

    /**
     * 初始化View
     */
    @Override
    protected void initView() {
        mLl_home_search = findViewById(R.id.ll_home_search);
        home_Search_Text = findViewById(R.id.home_Search_Text);
        home_Message_Image = findViewById(R.id.home_Message_Image);
        mScroll_home = findViewById(R.id.scroll_home);
        image_Zhoubian = findViewById(R.id.image_Zhoubian);
        image_Dingwei = findViewById(R.id.image_Dingwei);
        image_Guidestyle = findViewById(R.id.image_Guidestyle);
        image_Popular = findViewById(R.id.image_Popular);
        image_Zutuan = findViewById(R.id.image_Zutuan);
        image_Zhinan = findViewById(R.id.image_Zhinan);
        text_Dingwei = findViewById(R.id.text_Dingwei);
        text_Guidestyle = findViewById(R.id.text_Guidestyle);
        text_Popular = findViewById(R.id.text_Popular);
        text_Zutuan = findViewById(R.id.text_Zutuan);
        text_Zhoubian = findViewById(R.id.text_Zhoubian);
        text_Zhinan = findViewById(R.id.text_Zhinan);
        text_Rili = findViewById(R.id.text_Rili);
        text_Dingwei = findViewById(R.id.text_Dingwei);
        home_Routes_Recycler = findViewById(R.id.home_Routes_Recycler);
        home_Guidestyle = findViewById(R.id.home_Guidestyle);
        home_Popular = findViewById(R.id.home_Popular);
        list_Guidestyle = findViewById(R.id.list_Guidestyle);
        mCardViewPager = findViewById(R.id.cardViewPager);
        mLl_home_search.bringToFront();
        mScroll_home.setScrollViewListener(this);

    }

    /**
     * 事件监听
     */
    @Override
    protected void setListener() {
        //点击搜索框的页面跳转
        home_Search_Text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BaseFragment里面封装的方法,直接跳转
                readyGo(SearchActivity.class);

            }
        });


        list_Guidestyle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO

            }
        });
        mHomeRecyclerViewAdapter.setOnClickListener(new HomeRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                //TODO


            }
        });
    }

    /**
     * 设置数据的方法
     */
    @Override
    protected void onLazyLoad() {
        mCardViewPager.setOffscreenPageLimit(3);
        ArrayList<Integer> mData = new ArrayList<>();
        mData.add(R.mipmap.ic_launcher);
        mData.add(R.mipmap.ic_launcher);
        mData.add(R.mipmap.ic_launcher);
        mData.add(R.mipmap.ic_launcher);
        mData.add(R.mipmap.ic_launcher);
        mData.add(R.mipmap.ic_launcher);
        mCardViewPager.setAdapter(new MyPagerAdapter(mData, mContext));
//        mCardViewPager.setPageMargin();
        mCardViewPager.setPageTransformer(true, new AlphaPageTransformer());

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        home_Routes_Recycler.setLayoutManager(staggeredGridLayoutManager);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(R.mipmap.ic_launcher);
        integers.add(R.mipmap.ic_launcher);
        integers.add(R.mipmap.ic_launcher);
        integers.add(R.mipmap.ic_launcher);
        mHomeRecyclerViewAdapter = new HomeRecyclerViewAdapter(integers, mContext);
        mHomeRecyclerViewAdapter.addHeight(integers);
        home_Routes_Recycler.setAdapter(mHomeRecyclerViewAdapter);
        HomeListViewAdapter homeListViewAdapter = new HomeListViewAdapter();
        list_Guidestyle.setAdapter(homeListViewAdapter);


    }

    /**
     * @return 当前Fragment要展示的布局，注意如果报错是因为这里返回的是0
     */
    @Override
    protected int getLayoutResouceId() {
        return R.layout.frag_home;
    }

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (y <= 0) {
            mLl_home_search.setBackgroundColor(Color.argb((int) 0, 255, 255, 255));
        } else if (y > 0 && y <= imageHeight) {
            float scale = (float) y / imageHeight;
            float alpha = (255 * scale);
            // 只是layout背景透明
            mLl_home_search.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
        } else {
            mLl_home_search.setBackgroundColor(Color.argb((int) 255, 255, 255, 255));
        }
    }
}


