package com.tetalab.androidtutorial_astronomy

import com.tetalab.androidtutorial_astronomy.model.AstronomyResponse

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AstronomyAPI {
    @GET("weather/1.0/report.json")
    fun getAstronomy(
            @Query("product") product: String,
            @Query("name") name: String,
            @Query("app_id") appId: String,
            @Query("app_code") appCode: String
    ): Call<AstronomyResponse>
}
