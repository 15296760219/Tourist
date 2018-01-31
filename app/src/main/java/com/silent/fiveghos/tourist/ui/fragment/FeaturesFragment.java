package com.silent.fiveghos.tourist.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.silent.fiveghos.tourist.R;
import com.silent.fiveghos.tourist.adapter.FeaturesLvAdapter;
import com.silent.fiveghos.tourist.app.base.BaseFragment;
import com.silent.fiveghos.tourist.ui.activity.HomeActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 你能看到我留在屏幕上的字，却看不到我滴在键盘上的泪！
 * Created by Nyh on 2018/1/13.
 */
/*
 * 特色Fragment
 */
@SuppressLint("ValidFragment")
public class FeaturesFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private List<String> mList = new ArrayList<>();
    private TextView text_sales;
    private ImageView img_sales;
    private LinearLayout sales_options_features;
    private TextView text_collection;
    private ImageView img_collection;
    private LinearLayout collection_options_features;
    private TextView text_news;
    private TextView img_news;
    private RelativeLayout news_options_features;
    private ListView lv_features;
    private ImageView city_options_features;

    public FeaturesFragment(HomeActivity homeActivity) {
    }

    @Override
    protected void initData(Bundle arguments) {

    }

    @Override
    protected void initView() {
        sales_options_features = (LinearLayout) findViewById(R.id.sales_options_features);
        text_sales = (TextView) findViewById(R.id.text_sales);
        img_sales = (ImageView) findViewById(R.id.img_sales);
        sales_options_features.setOnClickListener(this);

        collection_options_features = (LinearLayout) findViewById(R.id.collection_options_features);
        text_collection = (TextView) findViewById(R.id.text_collection);
        img_collection = (ImageView) findViewById(R.id.img_collection);
        collection_options_features.setOnClickListener(this);

        news_options_features = (RelativeLayout) findViewById(R.id.news_options_features);
        text_news = (TextView) findViewById(R.id.text_news);
        img_news = (TextView) findViewById(R.id.img_news);
        news_options_features.setOnClickListener(this);

        city_options_features = (ImageView) findViewById(R.id.city_options_features);
        city_options_features.setOnClickListener(this);

        lv_features = (ListView) findViewById(R.id.lv_features);
        lv_features.setOnItemClickListener(this);

        for (int i = 0; i < 10; i++) {
            mList.add("");
        }
        FeaturesLvAdapter adapter = new FeaturesLvAdapter(getActivity(), mList);
        lv_features.setAdapter(adapter);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void onLazyLoad() {

    }

    @Override
    protected int getLayoutResouceId() {
        return R.layout.fragment_features;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sales_options_features:
                text_sales.setTextAppearance(getActivity(),R.style.options_features_green);
                img_sales.setVisibility(View.VISIBLE);
                text_collection.setTextAppearance(getActivity(),R.style.options_features_grey);
                img_collection.setVisibility(View.GONE);
                text_news.setTextAppearance(getActivity(),R.style.options_features_grey);
                break;

            case R.id.collection_options_features:
                text_sales.setTextAppearance(getActivity(),R.style.options_features_grey);
                img_sales.setVisibility(View.GONE);
                text_collection.setTextAppearance(getActivity(),R.style.options_features_green);
                img_collection.setVisibility(View.VISIBLE);
                text_news.setTextAppearance(getActivity(),R.style.options_features_grey);
                break;

            case R.id.news_options_features:
                text_sales.setTextAppearance(getActivity(),R.style.options_features_grey);
                img_sales.setVisibility(View.GONE);
                text_collection.setTextAppearance(getActivity(),R.style.options_features_grey);
                img_collection.setVisibility(View.GONE);
                text_news.setTextAppearance(getActivity(),R.style.options_features_green);
                break;

            case R.id.city_options_features:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> view, View view1, int i, long l) {

    }
}
