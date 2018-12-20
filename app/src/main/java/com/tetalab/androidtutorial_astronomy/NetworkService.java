package com.tetalab.androidtutorial_astronomy;

import com.tetalab.androidtutorial_astronomy.model.Astronomy;
import com.tetalab.androidtutorial_astronomy.model.AstronomyResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private AstronomyAPI api;

    public NetworkService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://weather.cit.api.here.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(AstronomyAPI.class);
    }

    public interface LoadData<T> {
        void onData(T data);

        void onFailure();
    }

    public void getAstronomy(final LoadData<Astronomy> callback) {
        String product = "forecast_astronomy";
        String name = "Chicago";
        String app_id = "DemoAppId01082013GAL";
        String app_code = "AJKnXv84fjrb0KIHawS0Tg";

        api.getAstronomy(product, name, app_id, app_code).enqueue(new Callback<AstronomyResponse>() {
            @Override
            public void onResponse(Call<AstronomyResponse> call, Response<AstronomyResponse> response) {
                if (response.body() == null || response.body().getAstronomy() == null) {
                    callback.onFailure();
                    return;
                }
                callback.onData(response.body().getAstronomy());
            }

            @Override
            public void onFailure(Call<AstronomyResponse> call, Throwable t) {
                callback.onFailure();
            }
        });
    }
}
