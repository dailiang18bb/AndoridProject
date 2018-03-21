package com.example.android.cs639springhw4_liangdai;

import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    CircleAnimatoinView mCircleView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCircleView = findViewById(R.id.charles_circleView);




    }


    public void addCircle(int mRadius, int mSpeed,int mColour){
        CircleAnimatoinView mCircleView1;
        mCircleView1 = findViewById(R.id.myCircleView1);



        //int viewBackgroundColor = ((ColorDrawable) view.getBackground()).getColor();




    }








}
