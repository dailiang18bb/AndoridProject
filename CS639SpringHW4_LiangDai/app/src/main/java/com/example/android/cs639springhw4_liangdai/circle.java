package com.example.android.cs639springhw4_liangdai;

/**
 * Created by charles on 3/21/18.
 */

/**
 * circle object
 */
public class circle {

    String name, circleColor;
    int circleRadius, circleSpeed;

    public circle(String name) {
        this.name = name;
    }

    public void setCircleRadius(int radius) {
        circleRadius = radius;
    }

    public void setCircleColor(String color) {
        circleColor = color;
    }

    public void setCircleSpeed(int speed) {
        circleSpeed = speed;
    }


}
