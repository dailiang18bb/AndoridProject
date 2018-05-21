package com.pace.cs639spring.hw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import android.graphics.PorterDuff;

public class MainActivity extends AppCompatActivity {

    public ImageView birdImageView;
    public ImageView catImageView;
    public ImageView dogImageView;
    public TextView birdTextView;
    public TextView catTextView;
    public TextView dogTextView;
    public Button redBtn;
    public Button orangeBtn;
    public Button yellowBtn;
    public Button blueBtn;
    public Button greenBtn;
    public ImageView selectedPet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //get from XML
        birdImageView = (ImageView) findViewById(R.id.birdImage);
        catImageView = (ImageView) findViewById(R.id.catImage);
        dogImageView = (ImageView) findViewById(R.id.dogImage);
        birdTextView = (TextView) findViewById(R.id.birdText);
        catTextView = (TextView) findViewById(R.id.catText);
        dogTextView = (TextView) findViewById(R.id.dogText);
        redBtn = (Button) findViewById(R.id.redButton);
        orangeBtn = (Button) findViewById(R.id.orangeButton);
        yellowBtn = (Button) findViewById(R.id.yellowButton);
        blueBtn = (Button) findViewById(R.id.blueButton);
        greenBtn = (Button) findViewById(R.id.greenButton);
        selectedPet = null;

        //default all invisible
        birdTextView.setVisibility(View.INVISIBLE);
        catTextView.setVisibility(View.INVISIBLE);
        dogTextView.setVisibility(View.INVISIBLE);

        //listen bird
        birdImageView.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View view) {

                                                 if (birdTextView.getVisibility() == View.VISIBLE) {
                                                     birdTextView.setVisibility(View.INVISIBLE);
                                                 } else {
                                                     birdTextView.setVisibility(View.VISIBLE);
                                                     catTextView.setVisibility(View.INVISIBLE);
                                                     dogTextView.setVisibility(View.INVISIBLE);
                                                     selectedPet = (ImageView) findViewById(R.id.birdImage);
                                                 }
                                             }
                                         }
        );

        //listen cat
        catImageView.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {

                                                if (catTextView.getVisibility() == View.VISIBLE) {
                                                    catTextView.setVisibility(View.INVISIBLE);
                                                } else {
                                                    birdTextView.setVisibility(View.INVISIBLE);
                                                    catTextView.setVisibility(View.VISIBLE);
                                                    dogTextView.setVisibility(View.INVISIBLE);
                                                    selectedPet = (ImageView) findViewById(R.id.catImage);
                                                }
                                            }
                                        }
        );

        //listen dog
        dogImageView.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {

                                                if (dogTextView.getVisibility() == View.VISIBLE) {
                                                    dogTextView.setVisibility(View.INVISIBLE);
                                                } else {
                                                    birdTextView.setVisibility(View.INVISIBLE);
                                                    catTextView.setVisibility(View.INVISIBLE);
                                                    dogTextView.setVisibility(View.VISIBLE);
                                                    selectedPet = (ImageView) findViewById(R.id.dogImage);
                                                }
                                            }
                                        }
        );

        //button active
        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedPet == null) {
                    Toast.makeText(getApplicationContext(), "Please selected a pet which you want to change the color", Toast.LENGTH_LONG).show();
                } else {
                    selectedPet.setColorFilter(0XFFFF0000, PorterDuff.Mode.SRC_IN);
                }
            }
        });
        orangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedPet == null) {
                    Toast.makeText(getApplicationContext(), "Please selected a pet which you want to change the color", Toast.LENGTH_LONG).show();
                } else {
                    selectedPet.setColorFilter( 0xFFFFDD44, PorterDuff.Mode.SRC_IN);
                }
            }
        });
        yellowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedPet == null) {
                    Toast.makeText(getApplicationContext(), "Please selected a pet which you want to change the color", Toast.LENGTH_LONG).show();
                } else {
                    selectedPet.setColorFilter(0xffffff00, PorterDuff.Mode.SRC_IN);
                }
            }
        });
        blueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedPet == null) {
                    Toast.makeText(getApplicationContext(), "Please selected a pet which you want to change the color", Toast.LENGTH_LONG).show();
                } else {
                    selectedPet.setColorFilter(0xFF0000FF, PorterDuff.Mode.SRC_IN);
                }
            }
        });
        greenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedPet == null) {
                    Toast.makeText(getApplicationContext(), "Please selected a pet which you want to change the color", Toast.LENGTH_LONG).show();
                } else {
                    selectedPet.setColorFilter(0xFF00FF00, PorterDuff.Mode.SRC_IN);
                }
            }
        });
    }
}
