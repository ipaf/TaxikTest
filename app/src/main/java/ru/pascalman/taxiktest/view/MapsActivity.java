package ru.pascalman.taxiktest.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import ru.pascalman.taxiktest.R;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback
{

    private String cityName;
    private double cityLatitude;
    private double cityLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        Intent locationData = getIntent();

        cityName = locationData.getStringExtra("cityName");
        cityLatitude = locationData.getDoubleExtra("cityLatitude", 0);
        cityLongitude = locationData.getDoubleExtra("cityLongitude", 0);

        mapFragment.getMapAsync(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(cityName);
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        LatLng cinema = new LatLng(cityLatitude, cityLongitude);

        googleMap.addMarker(new MarkerOptions().position(cinema).title(cityName));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cinema, 12.0f));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home)
            finish();

        return true;
    }

}