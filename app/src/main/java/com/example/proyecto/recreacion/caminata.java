package com.example.proyecto.recreacion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.proyecto.R;
import com.example.proyecto.hoteles.sonesta;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class caminata extends AppCompatActivity implements OnMapReadyCallback {

    private RatingBar calificacionx;
    private Button calificar;
    private MapView mMapView;
    private ImageView aero, wifi, bar, comida;
    private RadioButton recomendar, noRecomendar;
    private Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caminata);

        mMapView = (MapView) findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);

        mMapView.getMapAsync(this);

        recomendar = findViewById(R.id.recomendar);
        noRecomendar = findViewById(R.id.Norecomendar);
        save = findViewById(R.id.button);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });


        aero = findViewById(R.id.nadar);
        aero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(caminata.this, "Rio gautapury cerca", Toast.LENGTH_SHORT).show();
            }
        });

        bar = findViewById(R.id.bar);
        bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(caminata.this, "Excelentes bebidas con vista al rio Guatapury", Toast.LENGTH_SHORT).show();
            }
        });

        comida = findViewById(R.id.comida);
        comida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(caminata.this, "Muy buen desayuno luego de la caminata", Toast.LENGTH_SHORT).show();
            }
        });

        calificacionx = findViewById(R.id.calificacion);
        calificar = findViewById(R.id.calificar);

        calificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ranking = String.valueOf(calificacionx.getRating());
                Toast.makeText(caminata.this, "calificaste con " + ranking + "estrellas", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void validar(){
        String cad="Enviaste: ";

        if ( recomendar.isChecked()==true ) {
            cad += "recomendado";
        }else if( noRecomendar.isChecked()==true ) {
            cad += "No recomendado";
        }
        Toast.makeText(this, cad, Toast.LENGTH_SHORT).show();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng upc = new LatLng(10.509299, -73.261040);       // Add a marker in upc and move the camera
        map.addMarker(new MarkerOptions().position(upc).title("Santo Ecce Homo"));
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

