package com.silent.fiveghost.tourist.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.silent.fiveghost.tourist.R;
import com.silent.fiveghost.tourist.app.base.BaseFragment;
import com.silent.fiveghost.tourist.ui.activity.HomeActivity;
import com.silent.fiveghost.tourist.ui.activity.OrderFormActivity;
import com.zhy.autolayout.AutoLinearLayout;

/**
 * 你能看到我留在屏幕上的字，却看不到我滴在键盘上的泪！
 * Created by Nyh on 2018/1/13.
 */
/*
 * 订单Fragment
 */
@SuppressLint("ValidFragment")
public class OrderFragment extends BaseFragment {
    private TextView home_Search_Text;
    private ImageView home_Message_Image;
    private AutoLinearLayout ll_home_search;
    private CardView card;
    private CardView card2;
    private CardView card3;
    private CardView card4;

    public OrderFragment(HomeActivity homeActivity) {

    }

    @Override
    protected void initData(Bundle arguments) {

    }
    @Override
    protected void initView() {
        home_Search_Text = (TextView) this.findViewById(R.id.home_Search_Text);
        home_Message_Image = (ImageView) this.findViewById(R.id.home_Message_Image);
        ll_home_search = (AutoLinearLayout) this.findViewById(R.id.ll_home_search);
        card = (CardView) this.findViewById(R.id.card);
        card2 = (CardView) this.findViewById(R.id.card2);
        card3 = (CardView) this.findViewById(R.id.card3);
        card4 = (CardView) this.findViewById(R.id.card4);
    }

    @Override
    protected void setListener() {
        switch (getId()){
            case R.id.card:
                 startActivity(new Intent(getActivity(),OrderFormActivity.class));
                break;
            case R.id.card2:
                startActivity(new Intent(getActivity(),OrderFormActivity.class));
                break;
            case R.id.card3:
                startActivity(new Intent(getActivity(),OrderFormActivity.class));
                break;
            case R.id.card4:
                startActivity(new Intent(getActivity(),OrderFormActivity.class));
                break;
        }
    }

    @Override
    protected void onLazyLoad() {

    }
    @Override
    protected int getLayoutResouceId() {
        return R.layout.my_order;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_order, null);
        initView();
        return view;
    }
}
