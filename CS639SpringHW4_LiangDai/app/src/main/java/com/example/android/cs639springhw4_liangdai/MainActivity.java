package com.example.android.cs639springhw4_liangdai;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    CircleAnimatoinView mCircleView;

    //circle mCircleExample = new circle("example");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mCircleView = findViewById(R.id.charles_circleView);
        mCircleView.setCircleColor(R.integer.example_colour);
        mCircleView.setCircleRadius(Integer.parseInt(getString(R.string.example_radius)));
        mCircleView.setCircleSpeed(Integer.parseInt(getString(R.string.example_speed)));


    }

    /**
     * addButton
     */
    public void addCircle(View view){
        CircleAnimatoinView mCircleView1;
        mCircleView1 = findViewById(R.id.myCircleView1);

        EditText radiusEditText = (EditText) findViewById(R.id.radiusEditView);
        EditText speedEditText = (EditText) findViewById(R.id.speedEditText);

        mCircleView1.setCircleColor(R.integer.example_colour);
        mCircleView1.setCircleRadius(Integer.parseInt(radiusEditText.getText().toString()));
        mCircleView1.setCircleSpeed(Integer.parseInt(speedEditText.getText().toString()));

    }








}
