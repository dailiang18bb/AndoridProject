package com.example.android.customviewbarchart;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by charles on 3/2/18.
 */

public class CharlesView extends View {

    private Paint mPaintRect = new Paint();
    private Paint mPaintAxis = new Paint();
    private Paint mPaintText = new Paint();
    private Paint mPaintTop = new Paint();
    String topValue = "";
    ArrayList<Integer> countList = new ArrayList<Integer>();
    ArrayList<String> dateList = new ArrayList<String>();

    public CharlesView(Context context) {
        super(context);
        init();
    }

    private void init() {

        mPaintRect.setColor(Color.GRAY);
        mPaintAxis.setColor(Color.BLACK);
        mPaintAxis.setStrokeWidth(5);
        mPaintText.setTextSize(dpToPx(12));
        mPaintText.setColor(Color.BLACK);
        mPaintTop.setColor(Color.BLUE);

//        countList.add(20);
//        countList.add(50);
//        dateList.add("02/24");
//        dateList.add("04/05");
    }

    //override the onDraw method
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // draw initial axis
        canvas.drawLine(50, getHeight() - 50, getWidth() - 50, getHeight() - 50, mPaintAxis);
        canvas.drawLine(50, 50, 50, getHeight() - 50, mPaintAxis);
        canvas.drawText("0", 30, getHeight() - 50, mPaintText);
        canvas.drawText(topValue, 20, 50, mPaintText);

        //draw rect
        for (int i = 0; i < countList.size(); i++) {
            if (countList.size() > 1) {
                // get the top value
                topValue = Integer.toString(Collections.max(countList));
                if (countList.get(i) == Collections.max(countList)) {
                    //top value rect color blue
                    canvas.drawRect(80 * (i + 1) + 30 * i, 50, 80 * (i + 1) + 30 * i + 80, getHeight() - 50, mPaintTop);
                    canvas.drawText(dateList.get(i), 80 * (i + 1) + 30 * i, getHeight() - 20, mPaintText);

                } else {
                    //other value rect color gray
                    canvas.drawRect(80 * (i + 1) + 30 * i, getHeight() - (countList.get(i) * (getHeight() - 100) / Collections.max(countList)), 80 * (i + 1) + 30 * i + 80, getHeight() - 50, mPaintRect);
                    canvas.drawText(dateList.get(i), 80 * (i + 1) + 30 * i, getHeight() - 20, mPaintText);
                }
            } else {
                topValue = Integer.toString(countList.get(i));
                canvas.drawRect(80 * (i + 1) + 30 * i, 50, 80 * (i + 1) + 30 * i + 80, getHeight() - 50, mPaintTop);
                canvas.drawText(dateList.get(i), 80 * (i + 1) + 30 * i, getHeight() - 20, mPaintText);
            }
        }

    }

    public CharlesView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    //add data to ArrayList
    public void add(String date, int count) {
        dateList.add(date);
        countList.add(count);

        //redraw graph
        invalidate();
    }

    private static int dpToPx(int dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, Resources.getSystem().getDisplayMetrics());
    }
}