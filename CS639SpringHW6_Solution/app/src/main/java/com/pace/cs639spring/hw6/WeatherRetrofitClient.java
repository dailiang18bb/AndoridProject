package com.pace.cs639spring.hw6;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

//client that is used for connecting to Weather API.
public class WeatherRetrofitClient {

    //internal retrofit instance
    Retrofit mRetrofit;


    private final String API_KEY = "YOUR_API_KEY";
    private final String BASE_URL = "http://api.worldweatheronline.com/premium/v1/";
    private final String FORMAT = "json";
    private static WeatherRetrofitClient ourInstance = new WeatherRetrofitClient();

    public static WeatherRetrofitClient getInstance() {
        return ourInstance;
    }

    private WeatherService mWeatherService;

    private WeatherRetrofitClient() {
        mRetrofit = new Retrofit.Builder().baseUrl(BASE_URL).build();
        mWeatherService = mRetrofit.create(WeatherService.class);
    }


    public void fetchWeather(double lat, double lon, Callback<ResponseBody> callback) {
        String latLng = String.format("%f,%f", lat, lon);
        mWeatherService.fetchWeather(1, latLng, FORMAT, API_KEY)
                .enqueue(callback);
    }

    private interface WeatherService {
        @GET("weather.ashx")
        Call<ResponseBody> fetchWeather(@Query("num_of_days") int number, @Query("q") String latLng,
                                        @Query("format") String format, @Query("key") String key);
    }

}
