package com.example.proyecto;

import android.Manifest;
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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    TextView longitud, latitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void visitar(View view){
        Intent visitar = new Intent(this, visitar.class);
        startActivity(visitar);
    }

public void eventos(View view){
        Intent eventosx = new Intent(this, EventosPrueba.class);
        startActivity(eventosx);
}
    //metodo regresar actividad
    public void login(View view){
        Intent actividad_uno = new Intent(this, Login.class);
        startActivity(actividad_uno);
    }

    public void queHacer(View view){
        Intent queHacer = new Intent(this, QueHacer.class);
        startActivity(queHacer);
    }

}
