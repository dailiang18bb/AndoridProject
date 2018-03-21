package com.example.android.cs639springhw4_liangdai;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;


/**
 * Created by charles on 3/19/18.
 */

public class CircleAnimatoinView extends View {


    private Paint mPaintAxis = new Paint();
    int mCircleX = dpToPx(50);
    int mCircleY = dpToPx(50);
    int speed = 10;
    int radius = dpToPx(20);
    int flag = 0;

    /**
     * initial the paintbrush
     */
    private void init() {
        mPaintAxis.setStrokeWidth(5);
        mPaintAxis.setAntiAlias(false);                       //设置画笔为无锯齿
        mPaintAxis.setColor(Color.BLACK);                    //设置画笔颜色
        //mPaintAxis.setStyle(Paint.Style.STROKE);                   //空心效果


    }


    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mCircleX, mCircleY, radius, mPaintAxis);
        moveCircle(speed);
        invalidate();
    }


    public CircleAnimatoinView(Context context) {
        super(context);
        init();
    }


    public CircleAnimatoinView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private static int dpToPx(int dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, Resources.getSystem().getDisplayMetrics());
    }

    /**
     * move the circle by the speed
     */
    private void moveCircle(int speed) {
        if (flag == 0) {
            mCircleX = mCircleX + speed;
            if (mCircleX == getWidth() - radius) flag = 1;
        } else if (flag == 1) {
            mCircleX = mCircleX - speed;
            if (mCircleX == radius) flag = 0;
        }
    }
}
