package com.pace.cs639spring.hw3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kachi on 2/21/2018.
 */

public class BarGraphView extends View {

    //key is the date in millis
    //value is the number of students
    private Map<Long, Integer> mAttendanceMap = new HashMap<>();

    Point mTopLeft, mBottomLeft, mBottomRight;
    int mMax; //will hold the maximum value of students in our hash map

    int mBarColor; //color as integer
    int mMaxColor; //color as integer

    public BarGraphView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Homework);
        mBarColor = a.getColor(R.styleable.Homework_barColor, Color.GRAY); //get standard bar color from xml
        mMaxColor = a.getColor(R.styleable.Homework_maxColor, Color.BLACK); //get max bar color from xml
        a.recycle();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mTopLeft = new Point(dpToPx(25), dpToPx(15)); //topmost point of the y-axis
        mBottomLeft = new Point(dpToPx(25), getHeight() - dpToPx(20)); //graph origin
        mBottomRight = new Point(getWidth() - dpToPx(10), getHeight() - dpToPx(20)); //rightmost point of x-axis

        drawAxes(canvas);
        drawBars(canvas);
    }

    private void drawAxes(Canvas canvas) {
        //setup the paint used to draw our axes & the numbers on the y axis
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        paint.setTextSize(dpToPx(14));

        canvas.drawLine(mTopLeft.x, mTopLeft.y, mBottomLeft.x, mBottomLeft.y, paint); //draw y-axis
        canvas.drawLine(mBottomLeft.x, mBottomLeft.y, mBottomRight.x, mBottomRight.y, paint); //draw x-axis

        //if we have students present, label the lowest value and highest value on the y-axis
        if (mAttendanceMap.size() > 0) {
            canvas.drawText(getContext().getString(R.string.zero), mBottomLeft.x - dpToPx(10), mBottomLeft.y, paint);
            int maxStudentCount = Collections.max(mAttendanceMap.values());
            mMax = maxStudentCount + (5 - (maxStudentCount % 5)); //round value to nearest 5
            canvas.drawText(String.valueOf(mMax), mTopLeft.x - dpToPx(20), mTopLeft.y + dpToPx(10), paint);
        }
    }

    private void drawBars(Canvas canvas) {
        //create paint to be used to draw the non-maximum bars
        Paint barPaint = new Paint();
        barPaint.setColor(mBarColor);

        //create paint to be used to draw the maximum bar
        Paint maxBarPaint = new Paint();
        maxBarPaint.setColor(mMaxColor);

        //create paint to be used to draw the text for the dates
        Paint textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(dpToPx(12));

        List<Long> keys = new ArrayList<>(mAttendanceMap.keySet());
        Collections.sort(keys); //sort our dates in ascending order

        //get the highest student count in our data
        int highestCount = mAttendanceMap.isEmpty() ? 0 :  Collections.max(mAttendanceMap.values());

        //the leftmost area where we can start drawing our bars on the x-axis
        int startingPointX = mTopLeft.x + dpToPx(10);
        //the rightmost area where we can draw bars on the x-axis
        int endingPointX = mBottomRight.x - dpToPx(5);

        int totalAvailableHorizontalDrawingSpace = endingPointX - startingPointX;
        //since we can only have 5 bars on the screen at a time, divide our graph into 5 columns of equal length
        float totalAvailableHorizontalSpaceForSingleBar = totalAvailableHorizontalDrawingSpace /5;
        //each bar is only going to take up 2/3 of the space that they're allowed to draw in
        float barWidth = (totalAvailableHorizontalSpaceForSingleBar * 2)/3;

        float totalAvailableVerticalDrawingSpace = mBottomLeft.y - mTopLeft.y;

        //loop through our data points
        for (int index=0; index < keys.size(); index++) {
            long dateInMillis = keys.get(index);
            int studentCount = mAttendanceMap.get(dateInMillis);
            boolean isMaximumValue = keys.size() > 1 && studentCount == highestCount;

            //find the ratio between this student count & the maximum student count
            //ie if studentCount = 7 and mMax = 14, this value will be .5
            float studentCountToMaxRatio = (float)studentCount/(float)mMax;

            //subtract by 1 since we want a percentage of how far we should be from the top of our y axis
            float ratioFromTop = 1 - studentCountToMaxRatio;

            float barStartingPoint = startingPointX + (index * totalAvailableHorizontalSpaceForSingleBar);

            //draw the left of the bar at a point that will draw the bar in the center of our available space
            float barLeft = barStartingPoint + (totalAvailableHorizontalSpaceForSingleBar - barWidth)/2;
            float barTop = mTopLeft.y + (totalAvailableVerticalDrawingSpace * ratioFromTop);
            float barRight = barLeft + barWidth;
            float barBottom = mBottomLeft.y;
            canvas.drawRect(barLeft, barTop, barRight, barBottom, isMaximumValue ? maxBarPaint : barPaint);

            //format date
            String date = DateFormat.format("MM/dd", dateInMillis).toString();
            //draw text directly underneath the bar beneath the x-axis
            canvas.drawText(date, barLeft + dpToPx(10), mBottomLeft.y + dpToPx(15), textPaint);

        }
    }

    public void addData(long timeInMillis, int numberOfStudents) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        //remove all hour, minute, second & millisecond information from the date so that
        //the time we receive represents the starts of the day. This is how we are going to
        //make sure that a date that represents 2/28/2018 1:30PM and a date that represents
        //2/28/2018 2:30PM all have the same map key since they'll both get converted to
        //2/28/2018 12AM
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        mAttendanceMap.put(calendar.getTimeInMillis(), numberOfStudents);

        //if we have more than 5 data points, remove older values
        if (mAttendanceMap.size() > 5) {
            Long oldestDate = Collections.min(mAttendanceMap.keySet());
            mAttendanceMap.remove(oldestDate);
        }

        invalidate(); //redraw graph
    }

    private int dpToPx(int dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, getContext().getResources().getDisplayMetrics());
    }
}
