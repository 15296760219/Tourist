package com.silent.fiveghost.tourist.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 你看得到我留在屏幕上的字，却看不到我滴在键盘上的泪！
 * Created by Nyh on 2018/2/23.
 */

public class TouristListView extends ListView {
    public TouristListView(Context context) {
        super(context);
    }

    public TouristListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //测量的大小由一个32位的数字表示，前两位表示测量模式，后30位表示大小，这里需要右移两位才能拿到测量的大小
        int heightSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightSpec);
    }
}
