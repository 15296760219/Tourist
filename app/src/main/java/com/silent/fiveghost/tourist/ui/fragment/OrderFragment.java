package com.silent.fiveghost.tourist.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.app.base.BaseFragment;
import com.silent.fiveghost.tourist.ui.activity.HomeActivity;
import com.silent.fiveghost.tourist.ui.activity.SearchActivity;
import com.zhy.autolayout.AutoLinearLayout;

/**
 * 你能看到我留在屏幕上的字，却看不到我滴在键盘上的泪！
 * Created by Nyh on 2018/1/13.
 */
/*
 * 订单Fragment
 */
@SuppressLint("ValidFragment")
public class OrderFragment extends BaseFragment implements View.OnClickListener {

    private TextView home_Search_Text;
    private CardView mCard;

    public OrderFragment(HomeActivity homeActivity) {

    }

    @Override
    protected void initData(Bundle arguments) {

    }

    @Override
    protected void initView() {
        home_Search_Text = findViewById(R.id.home_Search_Text);
        home_Search_Text.setOnClickListener(this);
        mCard = findViewById(R.id.card);
    }

    @Override
    protected void setListener() {
        mCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected void onLazyLoad() {

    }

    @Override
    protected int getLayoutResouceId() {
        return R.layout.my_order;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_Search_Text:
                readyGo(SearchActivity.class);
                break;
        }
    }
}
