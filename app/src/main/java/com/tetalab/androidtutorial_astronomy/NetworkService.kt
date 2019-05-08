package com.tetalab.androidtutorial_astronomy

import com.tetalab.androidtutorial_astronomy.model.Astronomy
import com.tetalab.androidtutorial_astronomy.model.AstronomyResponse

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {

    private val api: AstronomyAPI

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
                .baseUrl("https://weather.cit.api.here.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        api = retrofit.create(AstronomyAPI::class.java)
    }

    interface LoadData<T> {
        fun onData(data: T)

        fun onFailure()
    }

    fun getAstronomy(callback: LoadData<Astronomy>) {
        val product = "forecast_astronomy"
        val name = "Chicago"
        val app_id = "DemoAppId01082013GAL"
        val app_code = "AJKnXv84fjrb0KIHawS0Tg"

        api.getAstronomy(product, name, app_id, app_code).enqueue(object : Callback<AstronomyResponse> {
            override fun onResponse(call: Call<AstronomyResponse>, response: Response<AstronomyResponse>) {
                if (response.body() == null || response.body()!!.astronomy == null) {
                    callback.onFailure()
                    return
                }
                callback.onData(response.body()!!.astronomy!!)
            }

            override fun onFailure(call: Call<AstronomyResponse>, t: Throwable) {
                callback.onFailure()
            }
        })
    }
}
