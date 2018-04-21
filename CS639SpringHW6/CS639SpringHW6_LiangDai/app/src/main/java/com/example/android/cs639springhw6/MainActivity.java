package com.example.android.cs639springhw6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {


    ImageView mCityImageViewGlide;
    ImageView mWeatherImageViewGlide;
    ImageView mCityImageViewPicasso;
    ImageView mWeatherImageViewPicasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCityImageViewGlide = findViewById(R.id.city_img_glide);
        mWeatherImageViewGlide = findViewById(R.id.weather_img_glide);
        mCityImageViewPicasso = findViewById(R.id.city_img_picasso);
        mWeatherImageViewPicasso = findViewById(R.id.weather_img_picasso);

    }

    public void loadImage(View view) {

        //Callback URL
        String cityUrl = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
        String weatherUrl = "https://tbsila.cdn.turner.com/toonla/images/cnapac/show/picker/item/ok-ko%21-let%27s-be-he/au/character-tile-image-96x100.png";

        //Using Glide
        Glide.with(this).load(cityUrl).into(mCityImageViewGlide);
        Glide.with(this).load(weatherUrl).into(mWeatherImageViewGlide);

        //Using Picasso
        Picasso.get().load(cityUrl).into(mCityImageViewPicasso);
        Picasso.get().load(weatherUrl).into(mWeatherImageViewPicasso);

    }
}
