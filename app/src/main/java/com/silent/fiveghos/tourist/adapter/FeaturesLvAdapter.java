package com.silent.fiveghos.tourist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


import com.silent.fiveghos.tourist.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 天使之所以会飞，是因为她把自己看的很轻...
 */

public class FeaturesLvAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mList = new ArrayList();

    public FeaturesLvAdapter(Context context, List<String> list) {
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
            view = LayoutInflater.from(mContext).inflate(R.layout.item_features, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView img_item_features;
        public CheckBox like_item_features;
        public TextView title_item_features;
        public TextView new_item_features;
        public TextView one_item_features;
        public TextView two_item_features;
        public TextView three_item_features;
        public TextView price_item_features;
        public TextView payment_item_features;
        public TextView comments_item_features;
        public TextView collection_item_features;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.img_item_features = (ImageView) rootView.findViewById(R.id.img_item_features);
            this.like_item_features = (CheckBox) rootView.findViewById(R.id.like_item_features);
            this.title_item_features = (TextView) rootView.findViewById(R.id.title_item_features);
            this.new_item_features = (TextView) rootView.findViewById(R.id.new_item_features);
            this.one_item_features = (TextView) rootView.findViewById(R.id.one_item_features);
            this.two_item_features = (TextView) rootView.findViewById(R.id.two_item_features);
            this.three_item_features = (TextView) rootView.findViewById(R.id.three_item_features);
            this.price_item_features = (TextView) rootView.findViewById(R.id.price_item_features);
            this.payment_item_features = (TextView) rootView.findViewById(R.id.payment_item_features);
            this.comments_item_features = (TextView) rootView.findViewById(R.id.comments_item_features);
            this.collection_item_features = (TextView) rootView.findViewById(R.id.collection_item_features);
        }

    }
}
