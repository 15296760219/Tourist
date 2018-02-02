package com.silent.fiveghost.tourist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.silent.fiveghost.tourist.R;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;

/**
 * 你能看到我留在屏幕上的字，却看不到我滴在键盘上的泪！
 * Created by Nyh on 2018/1/16.
 */

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> {

    public OnItemClickListener mOnItemClickListener;
    private ArrayList<Integer> mIntegers;
    private ArrayList<Integer> integers;
    private Context mContext;
    public HomeRecyclerViewAdapter(ArrayList<Integer> integers, Context context) {
        this.mContext=context;
        this.integers=integers;
    }

    public interface OnItemClickListener{
        void onClick(View view, int position);
    }
    public void setOnClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener=onItemClickListener;
    }
    public void addHeight(ArrayList<Integer> integers){
        mIntegers = new ArrayList<Integer>();
        for (int i = 0; i < integers.size(); i++) {
        int random = (int) (Math.random() * 200+100);

        mIntegers.add(random);
        }

    }
    @Override
    public HomeRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recycler_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HomeRecyclerViewAdapter.ViewHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams = holder.mTitle_hot_item.getLayoutParams();
        layoutParams.height=mIntegers.get(position);
        holder.mTitle_hot_item.setLayoutParams(layoutParams);

    }

    @Override
    public int getItemCount() {
        return integers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public  TextView mTitle_hot_item;
        public   TextView mContent_hot_content;

        public ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
            mTitle_hot_item =  itemView.findViewById(R.id.title_hot_item);
            mContent_hot_content = itemView.findViewById(R.id.content_hot_content);
        }
    }
}
