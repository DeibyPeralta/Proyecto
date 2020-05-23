package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import com.example.proyecto.fragments.EventosFragment;


public class visitar extends AppCompatActivity {

    EventosFragment fragmentMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitar);

        // declaro al fragment
        fragmentMenu = new EventosFragment();

        // es para cargar en el activity el fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFrame, fragmentMenu).commit();

    }

}
