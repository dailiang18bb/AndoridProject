package com.example.android.cs639springhw6;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * call example URL
 * https://api.worldweatheronline.com/premium/v1/weather.ashx?key=10bfd8b24a3f4346b4a25955182304&q=white plains&format=json&num_of_days=1
 *
 * World Weather API
 * 10bfd8b24a3f4346b4a25955182304
 */


public class WeatherHttpClient {

    private static final String MY_API = "10bfd8b24a3f4346b4a25955182304";
    private static final String MY_FORMAT = "json";
    private static final int My_NUM_OF_DAYS = 1;
    String cityName = "";

    // Base URL
    static final String BASE_URL = "http://api.worldweatheronline.com/premium/v1/";
    static final String BASE_URL_2 = "https://api.worldweatheronline.com/premium/v1/";


    private Retrofit mRetrofit;
    private WeatherService mWeatherService;
    private static final WeatherHttpClient ourInstance = new WeatherHttpClient();



    public static WeatherHttpClient getInstance() {
        return ourInstance;
    }

    //constructor
    private WeatherHttpClient() {
        mRetrofit = new Retrofit.Builder().baseUrl(BASE_URL_2).build();
        mWeatherService = mRetrofit.create(WeatherService.class);
    }


    private interface WeatherService {
        @GET("weather.ashx")
        Call<ResponseBody> getWeatherInfo(@Query("key") String mAPI, @Query("q") String cityName, @Query("format") String mFormat, @Query("num_of_days") int numOfDays);
    }


    // Sent the request to the server
    public void fetchWeatherInfo(String API, String cityName, String format, int num, Callback<ResponseBody> callback) {
        mWeatherService.getWeatherInfo(API, cityName, format, num).enqueue(callback);
    }
}
