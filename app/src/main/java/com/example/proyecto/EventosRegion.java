package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;



public class EventosRegion extends AppCompatActivity {

   // FragmentCandelaria fragmen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_region);

       // fragmen = new FragmentCandelaria();
    }

    public void candelaria(View view){
        // es para cargar en el activity el fragment
      //  getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFrame, fragmen).commit();
    }
}
