package com.example.escolarintents;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Camera;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Geocoder geocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        geocoder = new Geocoder(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //LatLng latLng = new LatLng(-23.574194, -46.550631);
        //MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Casa do Aluno").snippet("Felipe Augusto");
        //mMap.addMarker(markerOptions);
        //CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 16);
        //mMap.animateCamera(cameraUpdate);

        try {
            List<Address> addresses = geocoder.getFromLocationName("Rua Persichitti", 1);
            if (addresses.size() > 0){
                Address adress =  addresses.get(0);
                LatLng lc = new LatLng(adress.getLatitude(), adress.getLongitude());
                MarkerOptions markerOptions = new MarkerOptions()
                        .position(lc)
                        .title(adress.getLocality());

                mMap.addMarker(markerOptions);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lc, 16));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}