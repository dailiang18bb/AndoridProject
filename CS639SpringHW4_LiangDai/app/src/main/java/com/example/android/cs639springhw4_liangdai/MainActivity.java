package com.example.android.cs639springhw4_liangdai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {




    CircleAnimatoinView mCircleView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mCircleView = findViewById(R.id.charles_circleView);


    }
}
