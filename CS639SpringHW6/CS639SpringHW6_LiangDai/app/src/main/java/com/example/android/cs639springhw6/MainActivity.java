package com.example.android.cs639springhw6;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceDetectionClient;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoMetadataBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadataResponse;
import com.google.android.gms.location.places.PlacePhotoResponse;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageView mCityImageView;
    ImageView mWeatherImageViewGlide;
    ImageView mWeatherImageViewPicasso;
    TextView mNoPlaceTextView;
    TextView mWeatherTextViewGlide;
    TextView mWeatherTextViewPicasso;
    TextView mCityNameTextView;
    TextView mGlideTextView;
    TextView mPicassoTextView;

    // For Google Autocomplete
    protected GeoDataClient mGeoDataClient;
    protected PlaceDetectionClient mPlaceDetectionClient;

    //fetch method input
    private static final String MY_API = "10bfd8b24a3f4346b4a25955182304";
    private static final String MY_FORMAT = "json";
    private static final int My_NUM_OF_DAYS = 1;
    String cityName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNoPlaceTextView = findViewById(R.id.no_place_text_view);
        mCityImageView = findViewById(R.id.city_img);
        mWeatherImageViewGlide = findViewById(R.id.weather_img_glide);
        mWeatherImageViewPicasso = findViewById(R.id.weather_img_picasso);
        mWeatherTextViewGlide = findViewById(R.id.weather_text_glide);
        mWeatherTextViewPicasso = findViewById(R.id.weather_text_picasso);
        mCityNameTextView = findViewById(R.id.city_name_text);
        mGlideTextView = findViewById(R.id.text_glide);
        mPicassoTextView = findViewById(R.id.text_picasso);

        // Construct a GeoDataClient.
        mGeoDataClient = Places.getGeoDataClient(this, null);

        googleAuto();
    }


    //Google autocomplete bar
    private void googleAuto() {

        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {

            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.

                String placeDetailsStr = place.getName() + "\n"
                        + place.getId() + "\n"
                        + place.getLatLng().toString() + "\n"
                        + place.getAddress() + "\n"
                        + place.getAttributions();

                cityName = place.getName().toString();
                Log.i("MainActivity", "\nPlace: " + cityName + "\n" + placeDetailsStr);

                mCityNameTextView.setText(place.getName().toString());

                // Set visibility
                mNoPlaceTextView.setVisibility(View.INVISIBLE);
                mGlideTextView.setVisibility(View.VISIBLE);
                mPicassoTextView.setVisibility(View.VISIBLE);

                // Call the place photo method
                getPhotos(place.getId());

                // Call the get weather method
                getWeather();

            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i("MainActivity", "An error occurred: " + status);
            }
        });
    }


    // Request photos and metadata for the specified place.
    private void getPhotos(String placeId) {
        final Task<PlacePhotoMetadataResponse> photoMetadataResponse = mGeoDataClient.getPlacePhotos(placeId);
        photoMetadataResponse.addOnCompleteListener(new OnCompleteListener<PlacePhotoMetadataResponse>() {
            @Override
            public void onComplete(@NonNull Task<PlacePhotoMetadataResponse> task) {
                // Get the list of photos.
                PlacePhotoMetadataResponse photos = task.getResult();
                // Get the PlacePhotoMetadataBuffer (metadata for all of the photos).
                PlacePhotoMetadataBuffer photoMetadataBuffer = photos.getPhotoMetadata();
                // Get the first photo in the list.
                PlacePhotoMetadata photoMetadata = photoMetadataBuffer.get(0);
                // Get the attribution text.
                CharSequence attribution = photoMetadata.getAttributions();
                // Get a full-size bitmap for the photo.
                Task<PlacePhotoResponse> photoResponse = mGeoDataClient.getPhoto(photoMetadata);

                photoResponse.addOnCompleteListener(new OnCompleteListener<PlacePhotoResponse>() {
                    @Override
                    public void onComplete(@NonNull Task<PlacePhotoResponse> task) {
                        PlacePhotoResponse photo = task.getResult();
                        Bitmap bitmap = photo.getBitmap();

                        //set the bitmap to image view
                        mCityImageView.setImageBitmap(bitmap);
                    }
                });
                //release the resources
                photoMetadataBuffer.release();
            }
        });
    }

    //WWO get callback
    public void getWeather() {

        WeatherHttpClient.getInstance().fetchWeatherInfo(MY_API, cityName, MY_FORMAT, My_NUM_OF_DAYS, new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.v("response.isSuccessful()", "Successful");
                    try {

                        //deal with the json
                        JSONObject jsonObject = new JSONObject(response.body().string()).getJSONObject("data");
                        Log.v("MainActivity", "\n" + jsonObject);
                        JSONArray jsonArray = jsonObject.getJSONArray("current_condition");
                        Log.v("MainActivity", "" + jsonArray);
                        JSONObject jsonObject2 = (JSONObject) jsonArray.opt(0);
                        Log.v("MainActivity", "" + jsonObject2);

                        //fetch the temperature
                        String temp = jsonObject2.optString("temp_F");
                        Log.v("MainActivity", "" + temp);

                        //fetch the weather icon
                        JSONArray jsonArray2 = jsonObject2.getJSONArray("weatherIconUrl");
                        String imageUrl = ((JSONObject) jsonArray2.opt(0)).optString("value");
                        Log.v("MainActivity", "" + imageUrl);

                        //fetch the weather text
                        JSONArray jsonArray3 = jsonObject2.getJSONArray("weatherDesc");
                        String weatherDesc = ((JSONObject) jsonArray3.opt(0)).optString("value");
                        Log.v("MainActivity", "" + weatherDesc);

                        // set the weather text
                        mWeatherTextViewGlide.setText(temp + "°, " + weatherDesc);
                        mWeatherTextViewPicasso.setText(temp + "°, " + weatherDesc);

                        // add the weather icon through Picasso and Glide
                        Picasso.get().load(imageUrl).into(mWeatherImageViewPicasso);
                        Glide.with(MainActivity.this).load(imageUrl).into(mWeatherImageViewGlide);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.v("response.isSuccessful()", "Fail");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}

/* testing Picasso and Glide

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


 */
