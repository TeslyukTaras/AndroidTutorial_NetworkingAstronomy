package com.tetalab.androidtutorial_astronomy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView

import com.tetalab.androidtutorial_astronomy.model.Astronomy

class MainActivity : AppCompatActivity() {

    private lateinit var networkService: NetworkService
    private lateinit var countryTv: TextView
    private lateinit var stateTv: TextView
    private lateinit var cityTv: TextView
    private lateinit var latitudeTv: TextView
    private lateinit var lontitudeTv: TextView
    private lateinit var timezoneTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        networkService = NetworkService()
        initView()
    }

    private fun initView() {
        countryTv = findViewById(R.id.country_tv)
        stateTv = findViewById(R.id.state_tv)
        cityTv = findViewById(R.id.city_tv)
        latitudeTv = findViewById(R.id.latitude_tv)
        lontitudeTv = findViewById(R.id.longitude_tv)
        timezoneTv = findViewById(R.id.timezone_tv)
    }

    override fun onResume() {
        super.onResume()
        networkService.getAstronomy(object : NetworkService.LoadData<Astronomy> {
            override fun onData(data: Astronomy) {
                Log.d(TAG, "onData received")
                onDataUpdate(data)
            }

            override fun onFailure() {
                Log.d(TAG, "onFailure no data received")
            }
        })
    }

    private fun onDataUpdate(data: Astronomy) {
        countryTv.text = "country: " + data.country
        stateTv.text = "state: " + data.state
        cityTv.text = "city: " + data.city
        latitudeTv.text = "latitude: " + data.latitude
        lontitudeTv.text = "lontitude: " + data.longitude
        timezoneTv.text = "timezone: " + data.timezone
    }

    companion object {

        private val TAG = "MainActivity"
    }
}
