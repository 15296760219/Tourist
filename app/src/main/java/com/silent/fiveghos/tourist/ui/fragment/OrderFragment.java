package com.silent.fiveghos.tourist.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.silent.fiveghos.tourist.R;
import com.silent.fiveghos.tourist.app.base.BaseFragment;
import com.silent.fiveghos.tourist.ui.activity.HomeActivity;

/**
 * 你能看到我留在屏幕上的字，却看不到我滴在键盘上的泪！
 * Created by Nyh on 2018/1/13.
 */
/*
 * 订单Fragment
 */
@SuppressLint("ValidFragment")
public class OrderFragment extends BaseFragment {

    private CardView mCard;

    public OrderFragment(HomeActivity homeActivity) {

    }

    @Override
    protected void initData(Bundle arguments) {

    }

    @Override
    protected void initView() {
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
}
