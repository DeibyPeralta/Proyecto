package com.example.proyecto.vistaEventos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.proyecto.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class juanBosco extends AppCompatActivity  implements OnMapReadyCallback {

    private MapView mMapView;
    ToggleButton asistencia;
    TextView estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juan_bosco);

        mMapView = (MapView) findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);

        mMapView.getMapAsync(this);

        asistencia = findViewById(R.id.asistenciaBtn);
        estado = findViewById(R.id.estado);

    }


    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng upc = new LatLng(10.4483192,  -73.2620876);       // Add a marker in upc and move the camera
        map.addMarker(new MarkerOptions().position(upc).title("Marker"));
        map.getUiSettings().setZoomControlsEnabled(true);//habilitar zoom
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(upc, 12));// personalizar zoom

    }

    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }
}
