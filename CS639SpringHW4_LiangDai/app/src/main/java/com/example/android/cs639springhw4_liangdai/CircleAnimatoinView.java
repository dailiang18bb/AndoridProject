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



    private void init() {


        mPaintAxis.setStrokeWidth(5);
        mPaintAxis.setAntiAlias(false);                       //设置画笔为无锯齿
        mPaintAxis.setColor(Color.BLACK);                    //设置画笔颜色
        mPaintAxis.drawColor(Color.WHITE);                  //白色背景
        mPaintAxis.setStrokeWidth((float) 3.0);              //线宽
        mPaintAxis.setStyle(Paint.Style.STROKE);                   //空心效果


    }



    //override the onDraw method
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // draw initial axis

        canvas.drawCircle(dpToPx(50),dpToPx(50),dpToPx(10),mPaintAxis);



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



}
