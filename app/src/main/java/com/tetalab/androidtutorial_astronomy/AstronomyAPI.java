package com.tetalab.androidtutorial_astronomy;

import com.tetalab.androidtutorial_astronomy.model.AstronomyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AstronomyAPI {
    @GET("weather/1.0/report.json")
    Call<AstronomyResponse> getAstronomy(
            @Query("product") String product,
            @Query("name") String name,
            @Query("app_id") String appId,
            @Query("app_code") String appCode
            );
}
