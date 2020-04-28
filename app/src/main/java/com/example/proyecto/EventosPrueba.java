package com.example.proyecto;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.text.BoringLayout;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import org.json.JSONObject;

public class EventosPrueba extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap, miUbicacion;
    private FusedLocationProviderClient fusedLocationClient;
    private int MY_PERMISSIONS_REQUEST_READ_CONTRACTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_prueba);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }

    Boolean actualPosision = true;
    JSONObject json;
    Double latitudOrigen, longitudOrigen;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        miUbicacion = googleMap;
 //      permisos de ubicacion
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)) {
        } else {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    1);

        }

        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
        } else {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1);

        }

        miUbicacion.setMyLocationEnabled(true );
        miUbicacion.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                if ( actualPosision ){
                    latitudOrigen = location.getLatitude();
                    longitudOrigen = location.getLongitude();

                    actualPosision=false;

                    LatLng miPosicion = new LatLng(latitudOrigen, longitudOrigen);
                    miUbicacion.addMarker(new MarkerOptions().position(miPosicion).title("aqui estoy yo"));
                }
            }
        });

        LatLng upc = new LatLng(10.4483192,  -73.2620876);       // Add a marker in Sydney and move the camera
        mMap.addMarker(new MarkerOptions().position(upc).title("upc valledupar").snippet("Universidad popular del cesar prueba"));//.icon(BitmapDescriptorFactory.fromResource(R.drawable.rio)));
        mMap.getUiSettings().setZoomControlsEnabled(true);//habilitar zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(upc, 14));// personalizar zoom

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }


        }
    }

}
