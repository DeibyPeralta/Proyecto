package com.example.proyecto.hoteles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.proyecto.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class mayalesPlaza extends AppCompatActivity implements OnMapReadyCallback {

    private RatingBar calificacionx;
    private Button calificar;
    private MapView mMapView;
    private ImageView aero, wifi, bar, comida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mayales_plaza);

        mMapView = (MapView) findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);

        mMapView.getMapAsync(this);

        aero = findViewById(R.id.aeropuerto);
        aero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mayalesPlaza.this, "Traslado aueropuerto (gratis)", Toast.LENGTH_SHORT).show();
            }
        });

        wifi = findViewById(R.id.wifi);
        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mayalesPlaza.this, "Wifi (gratis)", Toast.LENGTH_SHORT).show();
            }
        });

        bar = findViewById(R.id.bar);
        bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mayalesPlaza.this, "Excelentes bebidas en el bar", Toast.LENGTH_SHORT).show();
            }
        });

        comida = findViewById(R.id.comida);
        comida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mayalesPlaza.this, "Muy buen desayuno", Toast.LENGTH_SHORT).show();
            }
        });

        calificacionx = findViewById(R.id.calificacion);
        calificar = findViewById(R.id.calificar);

        calificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ranking = String.valueOf(calificacionx.getRating());
                Toast.makeText(mayalesPlaza.this, "calificaste con " + ranking + "estrellas", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng upc = new LatLng(10.460734, -73.228788);       // Add a marker in upc and move the camera
        map.addMarker(new MarkerOptions().position(upc).title("Hotel sicarare"));
        map.getUiSettings().setZoomControlsEnabled(true);//habilitar zoom
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(upc, 15));// personalizar zoom

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
