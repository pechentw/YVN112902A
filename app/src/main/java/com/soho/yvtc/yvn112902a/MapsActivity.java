package com.soho.yvtc.yvn112902a;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        // Add a marker in Sydney and move the camera
        LatLng tp = new LatLng(25.0453075,121.5170364);
        LatLng sydney = new LatLng(24.930916,121.1716999);
        LatLng m1 = new LatLng(24.960916,121.1784999);
        LatLng m2 = new LatLng(24.945916,121.1016999);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in TY"));
        mMap.addMarker(new MarkerOptions().position(m1).title("M1"));
        mMap.addMarker(new MarkerOptions().position(m2).title("M2"));
        CameraPosition cameraPos = new CameraPosition.Builder().target(sydney).zoom(15.0f).tilt(65).build();
        CameraUpdate cameraUpt = CameraUpdateFactory.newCameraPosition(cameraPos);  // 地圖相機鏡頭動畫行程設定
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tp));
        mMap.animateCamera(cameraUpt, 5000, null);

        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
