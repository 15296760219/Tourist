package com.silent.fiveghost.tourist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.silent.fiveghost.tourist.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 天使之所以会飞，是因为她把自己看的很轻...
 */

public class OrderLvAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mList = new ArrayList();

    public OrderLvAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup group) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_order, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView img_item_order;
        public CheckBox like_item_order;
        public TextView title_item_order;
        public TextView new_item_order;
        public LinearLayout ll_item_order;
        public TextView price_item_order;
        public TextView payment_item_order;
        public TextView comments_item_order;
        public TextView collection_item_order;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.img_item_order = (ImageView) rootView.findViewById(R.id.img_item_order);
            this.like_item_order = (CheckBox) rootView.findViewById(R.id.like_item_order);
            this.title_item_order = (TextView) rootView.findViewById(R.id.title_item_order);
            this.new_item_order = (TextView) rootView.findViewById(R.id.new_item_order);
            this.ll_item_order = (LinearLayout) rootView.findViewById(R.id.ll_item_order);
            this.price_item_order = (TextView) rootView.findViewById(R.id.price_item_order);
            this.payment_item_order = (TextView) rootView.findViewById(R.id.payment_item_order);
            this.comments_item_order = (TextView) rootView.findViewById(R.id.comments_item_order);
            this.collection_item_order = (TextView) rootView.findViewById(R.id.collection_item_order);
        }

    }
}

