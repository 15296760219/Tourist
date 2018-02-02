package com.silent.fiveghost.tourist.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.silent.fiveghost.tourist.R;

import java.util.List;

/**
 * 你能看到我留在屏幕上的字，却看不到我滴在键盘上的泪！
 * Created by Nyh on 2018/2/1.
 */

public class MyPagerAdapter extends PagerAdapter{
    private List<Integer> mData;
    private Context mContext;

    public MyPagerAdapter(List<Integer> data, Context context) {
        mData = data;
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View inflate = LayoutInflater.from(container.getContext()).inflate(R.layout.pager_item, container, false);
        ImageView imageView1 = (ImageView) inflate.findViewById(R.id.img_card_item);
        Glide.with(mContext).load(mData.get(position)).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.RESULT).into(imageView1);
        container.addView(inflate);
        return inflate;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(((View) object));
    }
}
