package com.silent.fiveghos.tourist;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class RaisedView extends View {

    private Paint mPaint;
    private Path mWavePath;
    private boolean isMeasured = false;
    private int mViewWidth;
    private int mViewHeight;
    private int mViewColor;
    private boolean isSetWaveHeight = false;
    /**
     * 波浪起伏幅度
     */
    private Point mPoint1, mPoint2, mPoint3, mPoint4, mPoint5, mPoint6, mPoint7;
    private float hc;
    private RectF rectF;

    public RaisedView(Context context) {
        super(context);
        init(context, null);
    }

    public RaisedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Paint paint = new Paint();
        //mWavePath.setStyle(Paint.Style.STROKE);

        init(context, attrs);
    }

    public RaisedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RaisedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        //  mPaint.setStyle();
        //这是设置颜色的
        mPaint.setColor(Color.WHITE);


        mWavePath = new Path();
    }


    private void setPointsList() {
        int width = getWidth();
        int height = getHeight();
        //  移动到第一个点

        mPoint1 = new Point(width / 8, height / 2);
        mPoint2 = new Point(0, height / 2);
        mPoint3 = new Point(0, height);
        mPoint4 = new Point(width, height);
        mPoint5 = new Point(width, height / 2);
        mPoint6 = new Point(width / 8 * 7, height / 2);
       mPoint7 = new Point(width / 2, height / 4*3);
        hc = mPoint6.getX() - mPoint7.getX();
        rectF = new RectF(mPoint1.getX(), mPoint1.getY() - hc, mPoint6.getX(), mPoint1.getY() + hc);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        mWavePath.reset();
        setPointsList();
        //moveTo() 方法可把窗口的左上角移动到一个指定的坐标。moveto是移动到某个坐标，lineto是从当前坐标连线到某个坐标。
        mWavePath.moveTo(mPoint1.getX(), mPoint1.getY());
        mWavePath.lineTo(mPoint2.getX(), mPoint2.getY());
        mWavePath.lineTo(mPoint3.getX(), mPoint3.getY());
        mWavePath.lineTo(mPoint4.getX(), mPoint4.getY());
        mWavePath.lineTo(mPoint5.getX(), mPoint5.getY());
        mWavePath.lineTo(mPoint6.getX(), mPoint6.getY());
        mWavePath.lineTo(mPoint7.getX(), mPoint7.getY());
        //arcTo也是画曲线的方法，而且他画出的曲线也是正圆的一段弧线。
        mWavePath.arcTo(rectF, 0, 180);

        //mWavePath.close();
        // mPaint的Style是FILL，会填充整个Path区域
        canvas.drawPath(mWavePath, mPaint);
    }


    class Point {
        private float x;
        private float y;

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }

    }
}
