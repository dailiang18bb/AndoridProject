package com.example.android.cs639springhw4_liangdai;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;


/**
 * Created by charles on 3/19/18.
 */

public class CircleAnimatoinView extends View {


    private Paint mPaintAxis = new Paint();
    int mCircleX = dpToPx(50);
    int mCircleY = dpToPx(50);
    int radius = dpToPx(20);
    int speed = dpToPx(10);
    int colour = Color.BLACK;
    int flag = 0;



    /**
     * initial the paintbrush
     */
    public void init(int colour) {
        mPaintAxis.setStrokeWidth(5);
        mPaintAxis.setAntiAlias(false);                       //设置画笔为无锯齿
        mPaintAxis.setColor(colour);                    //设置画笔颜色
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
        init(colour);

    }


    public CircleAnimatoinView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(colour);

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


    /**
     * addButton
     */


    public void addColorClickListeners() {
        /**
         * Create an anonymous inner class that'll be used for our onClickListener.
         * See: https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html
         * Also: https://stackoverflow.com/questions/355167/how-are-anonymous-inner-classes-used-in-java
         */
        View.OnClickListener colorListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //extract color from the view that we clicked on. Since the background of the view
                //was just a color value in XML, Android converts it to a ColorDrawable
                //cast the background to a ColorDrawable, extract the color from the Drawable, and
                //then assign that color to the animal
                int viewBackgroundColor = ((ColorDrawable) view.getBackground()).getColor();


            }
        };
    }


}
