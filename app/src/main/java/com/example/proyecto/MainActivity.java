package com.example.proyecto;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import com.example.proyecto.fragments.EventosFragment;

public class MainActivity extends AppCompatActivity {

    CardView region, hacer, eventos, fiestas, recreacion, visitar;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        region = findViewById(R.id.cardRegion);
        region.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Falta agregarlo", Toast.LENGTH_SHORT).show();
            }
        });


        hacer = findViewById(R.id.cardHacer);
        hacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent queHacer = new Intent(MainActivity.this, QueHacer.class);
                startActivity(queHacer);
            }
        });

        eventos = findViewById(R.id.cardEventos);
        eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent visitar = new Intent(MainActivity.this, visitar.class);
                startActivity(visitar);
            }
        });

        fiestas = findViewById(R.id.cardFiestas);
        fiestas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Falta agregarlo", Toast.LENGTH_SHORT).show();
            }
        });

        recreacion = findViewById(R.id.cardRecreo);
        recreacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Falta agregarlo", Toast.LENGTH_SHORT).show();
            }
        });

        visitar = findViewById(R.id.cardVisitar);
        visitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Falta agregarle botones y estos que lleven a los pueblos", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void estoy(View view){
        Intent visitar = new Intent(this, EventosPrueba.class);
        startActivity(visitar);
    }

    public void ImagenButton(View view){
        Intent visitar = new Intent(this, EventosFragment.class);
        startActivity(visitar);
    }

    // metodo ocular y mostrar menu overflow
    public boolean  onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.opciones, menu);
        return true;
    }

    // asignar funciones menu overflow
    public boolean onOptionsItemSelected(MenuItem item){
        int i = item.getItemId();

        if ( i == R.id.ubicacion){// ver cual de los botones se escoge
            Intent eventosx = new Intent(this, EventosPrueba.class);
            startActivity(eventosx);
        }
        return super.onOptionsItemSelected(item);
    }



}
