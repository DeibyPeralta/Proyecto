package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.proyecto.fragments.ListaPersonajesFragment;


public class visitar extends AppCompatActivity {

    ListaPersonajesFragment listaFragmentx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitar);

        // llamo al fragment
        listaFragmentx = new ListaPersonajesFragment();

        // es para cargar en el activity el fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.sitioxx, listaFragmentx).commit();

    }

}
