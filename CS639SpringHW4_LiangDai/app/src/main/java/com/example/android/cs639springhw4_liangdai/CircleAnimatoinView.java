package com.example.android.cs639springhw4_liangdai;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorInt;
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
    int flag = 0;
//    int radius,speed;
//    String colour;

    int radius = dpToPx(20);
    int speed = dpToPx(10);
    int colour = Color.RED;


    public void setCircleRadius(int radius) {
        this.radius = dpToPx(radius);
    }

    public void setCircleColor(int color) {
        this.colour = color;
    }

    public void setCircleSpeed(int speed) {
        this.speed = dpToPx(speed);
    }


    /**
     * initial the paintbrush
     */
    public void init(int colour) {
        mPaintAxis.setStrokeWidth(5);
        mPaintAxis.setAntiAlias(false);
        mPaintAxis.setColor(colour);


    }


    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        init(colour);
        canvas.drawCircle(mCircleX, mCircleY, radius, mPaintAxis);
        moveCircle(speed);
        invalidate();


    }


    public CircleAnimatoinView(Context context) {
        super(context);


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
            if (mCircleX >= getWidth() - radius) flag = 1;
        } else if (flag == 1) {
            mCircleX = mCircleX - speed;
            if (mCircleX <= radius) flag = 0;
        }
    }





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
