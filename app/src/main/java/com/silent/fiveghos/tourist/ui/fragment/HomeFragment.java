package com.silent.fiveghos.tourist.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.silent.fiveghos.tourist.R;
import com.silent.fiveghos.tourist.adapter.HomeListViewAdapter;
import com.silent.fiveghos.tourist.adapter.HomeRecyclerViewAdapter;
import com.silent.fiveghos.tourist.app.base.BaseFragment;
import com.silent.fiveghos.tourist.ui.activity.HomeActivity;
import com.silent.fiveghos.tourist.ui.activity.SearchActivity;
import com.stx.xhb.xbanner.XBanner;

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
public class HomeFragment extends BaseFragment implements XBanner.XBannerAdapter {

    private Context mContext;
    private TextView home_Search_Text;
    private ImageView home_Message_Image;
    private XBanner home_banner;
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
    protected void initView(){
         home_Search_Text = findViewById(R.id.home_Search_Text);
         home_Message_Image = findViewById(R.id.home_Message_Image);
         home_banner = findViewById(R.id.home_banner);
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
        home_Guidestyle  = findViewById(R.id.home_Guidestyle);
         home_Popular = findViewById(R.id.home_Popular);
        list_Guidestyle = findViewById(R.id.list_Guidestyle);

    }

    /**
     * 事件监听
     */
    @Override
    protected void setListener(){
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
    protected void onLazyLoad(){
        List<String> imgesUrl = new ArrayList<>();
        imgesUrl.add("http://7xi8d6.com1.z0.glb.clouddn.com/20180115085556_8AeReR_taeyeon_ss_15_1_2018_7_58_51_833.jpeg");
        imgesUrl.add("http://7xi8d6.com1.z0.glb.clouddn.com/20180109085038_4A7atU_rakukoo_9_1_2018_8_50_25_276.jpeg");
        imgesUrl.add("http://7xi8d6.com1.z0.glb.clouddn.com/20171228085004_5yEHju_Screenshot.jpeg");
        imgesUrl.add("http://7xi8d6.com1.z0.glb.clouddn.com/20180102083655_3t4ytm_Screenshot.jpeg");
        //添加广告数据
        home_banner.setData(imgesUrl,null);//第二个参数为提示文字资源集合




        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        home_Routes_Recycler.setLayoutManager(staggeredGridLayoutManager);
        mHomeRecyclerViewAdapter = new HomeRecyclerViewAdapter();
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
    public void loadBanner(XBanner banner, Object model, View view, int position) {

    }
}


