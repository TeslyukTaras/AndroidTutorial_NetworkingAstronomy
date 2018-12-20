package com.tetalab.androidtutorial_astronomy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.tetalab.androidtutorial_astronomy.model.Astronomy;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private NetworkService networkService;
    private TextView countryTv, stateTv, cityTv, latitudeTv, lontitudeTv, timezoneTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        networkService = new NetworkService();
        initView();
    }

    private void initView() {
        countryTv = findViewById(R.id.country_tv);
        stateTv = findViewById(R.id.state_tv);
        cityTv = findViewById(R.id.city_tv);
        latitudeTv = findViewById(R.id.latitude_tv);
        lontitudeTv = findViewById(R.id.longitude_tv);
        timezoneTv = findViewById(R.id.timezone_tv);
    }

    @Override
    protected void onResume() {
        super.onResume();
        networkService.getAstronomy(new NetworkService.LoadData<Astronomy>() {
            @Override
            public void onData(Astronomy data) {
                Log.d(TAG, "onData received");
                onDataUpdate(data);
            }

            @Override
            public void onFailure() {
                Log.d(TAG, "onFailure no data received");
            }
        });
    }

    private void onDataUpdate(Astronomy data) {
        countryTv.setText("country: " + data.getCountry());
        stateTv.setText("state: " + data.getState());
        cityTv.setText("city: " + data.getCity());
        latitudeTv.setText("latitude: " + data.getLatitude());
        lontitudeTv.setText("lontitude: " + data.getLongitude());
        timezoneTv.setText("timezone: " + data.getTimezone());
    }
}
