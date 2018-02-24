package com.silent.fiveghost.tourist.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.ui.fragment.AllFragment;
import com.silent.fiveghost.tourist.ui.fragment.EvaluationFragment;
import com.silent.fiveghost.tourist.ui.fragment.HaveNotStartedFragment;
import com.silent.fiveghost.tourist.ui.fragment.OffTheStocksFragment;
import com.silent.fiveghost.tourist.ui.fragment.UnderwayFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderFormActivity extends AppCompatActivity {
    private ImageView return_published_order;
    private ImageView search_published_order;
    private TabLayout tab_orderForm;
    private ViewPager pager_orderForm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.published_order);
        initView();
        initData();
    }
    private void initData() {
        List<String> listTab=new ArrayList<>();
        listTab.add("全部");
        listTab.add("未开始");
        listTab.add("进行中");
        listTab.add("待评价");
        listTab.add("已完成");
        List<Fragment> listFragment=new ArrayList<>();
        listFragment.add(new AllFragment());
        listFragment.add(new HaveNotStartedFragment());
        listFragment.add(new UnderwayFragment());
        listFragment.add(new EvaluationFragment());
        listFragment.add(new OffTheStocksFragment());
        MyViewPagerAdapter adapter=new MyViewPagerAdapter(listTab,listFragment,getSupportFragmentManager());
        tab_orderForm.setupWithViewPager(pager_orderForm);
        pager_orderForm.setCurrentItem(0);
        pager_orderForm.setAdapter(adapter);
    }
    private void initView() {
        return_published_order = (ImageView) findViewById(R.id.return_published_order);
        search_published_order = (ImageView) findViewById(R.id.search_published_order);
        tab_orderForm = (TabLayout) findViewById(R.id.tab_orderForm);
        pager_orderForm = (ViewPager) findViewById(R.id.pager_orderForm);
    }
}
