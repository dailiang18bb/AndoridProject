package com.example.android.cs639springhw6;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class WeatherHttpClient {

    static final String BASE_URL = "HTTP: http://api.worldweatheronline.com/premium/v1/weather.ashx";
    static final String BASE_URL_2 = "HTTPS: https://api.worldweatheronline.com/premium/v1/weather.ashx";

    private Retrofit mRetrofit;
    private WeatherService mWeatherService;
    private static final WeatherHttpClient ourInstance = new WeatherHttpClient();

    static String url = "?key=10bfd8b24a3f4346b4a25955182304&q=white plains&format=json&num_of_days=1";


    public static WeatherHttpClient getInstance() {
        return ourInstance;
    }


    private WeatherHttpClient() {
        mRetrofit = new Retrofit.Builder().baseUrl(BASE_URL_2).build();
        mWeatherService = mRetrofit.create(WeatherService.class);
    }

    private interface WeatherService {


        @GET("?key=10bfd8b24a3f4346b4a25955182304&q=white plains&format=json&num_of_days=1")
        Call<ResponseBody> getWeatherInfo(@Query("cityName") String cityName);

    }

    public void fetchWeatherInfo(String cityName,Callback<ResponseBody> callback) {

        mWeatherService.getWeatherInfo(cityName).enqueue(callback);
    }
}
