package com.pace.cs639spring.hw6;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoMetadataBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadataResponse;
import com.google.android.gms.location.places.PlacePhotoResponse;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    protected GeoDataClient mGeoDataClient;

    TextView mPlaceName;
    ImageView mPlaceImage;
    TextView mWeather;
    ImageView mWeatherIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mPlaceName = findViewById(R.id.place_name);
        mPlaceImage = findViewById(R.id.place_image);
        mWeather = findViewById(R.id.weather);
        mWeatherIcon = findViewById(R.id.weather_icon);
        mGeoDataClient = Places.getGeoDataClient(this);
        configurePlaceAutocompleteFragment();
    }


    public void configurePlaceAutocompleteFragment() {
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                populatePlace(place);
            }

            @Override
            public void onError(Status status) {
                Log.i("PLACE_PICKER", "An error occurred: " + status);
            }
        });


    }

    private void populatePlace(Place place) {
        mPlaceName.setText(place.getName());
        getPhotoForPlace(place.getId());
        fetchWeatherForLocation(place.getLatLng());
    }

    // Request photos and metadata for the specified place.
    private void getPhotoForPlace(String placeId) {
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
                // Get a full-size bitmap for the photo.
                Task<PlacePhotoResponse> photoResponse = mGeoDataClient.getPhoto(photoMetadata);
                photoResponse.addOnCompleteListener(new OnCompleteListener<PlacePhotoResponse>() {
                    @Override
                    public void onComplete(@NonNull Task<PlacePhotoResponse> task) {
                        PlacePhotoResponse photo = task.getResult();
                        Bitmap bitmap = photo.getBitmap();
                        mPlaceImage.setVisibility(bitmap == null ? View.GONE : View.VISIBLE);
                        mPlaceImage.setImageBitmap(bitmap);
                    }
                });
            }
        });
    }

    private void fetchWeatherForLocation(LatLng latLng) {
        WeatherRetrofitClient.getInstance().fetchWeather(latLng.latitude, latLng.longitude, new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    //convert response body into a string
                    JSONObject responseJSON = new JSONObject(response.body().string());
                    //get the current condition from the JSONObject
                    JSONObject currentCondition = responseJSON.optJSONObject("data").optJSONArray("current_condition").getJSONObject(0);
                    //get the degrees value from the JSONObject
                    String degrees = currentCondition.getString("temp_F");
                    //get the weather description from the JSONObject
                    String weather = currentCondition.getJSONArray("weatherDesc").optJSONObject(0).optString("value");
                    mWeather.setText(getString(R.string.degree_comma_description, degrees, weather));
                    //get the weather icon url
                    String url = currentCondition.getJSONArray("weatherIconUrl").optJSONObject(0).optString("value");
                    mWeatherIcon.setVisibility(url == null ? View.GONE : View.VISIBLE);
                    Picasso.with(MainActivity.this).load(url).fit().centerCrop().into(mWeatherIcon);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i("PLACE_PICKER", "An error occurred: " + t);
            }
        });
    }
}
