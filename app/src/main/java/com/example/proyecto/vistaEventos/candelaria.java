package com.example.proyecto.vistaEventos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.proyecto.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class candelaria extends AppCompatActivity {

    private GoogleMap mMap;
    ToggleButton asistencia;
    TextView estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candelaria);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync((OnMapReadyCallback) this);

        asistencia = findViewById(R.id.asistenciaBtn);
        estado = findViewById(R.id.estado);
    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //      permisos de ubicacion
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)) {
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},1);
        }

        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        }


        LatLng upc = new LatLng(10.4483192,  -73.2620876);       // Add a marker in Sydney and move the camera
        mMap.addMarker(new MarkerOptions().position(upc).title("upc valledupar").snippet("Universidad popular del cesar prueba"));//.icon(BitmapDescriptorFactory.fromResource(R.drawable.rio)));
        mMap.getUiSettings().setZoomControlsEnabled(true);//habilitar zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(upc, 14));// personalizar zoom

    }

    public void confirmarAsistencia(View view) {

    }
}
