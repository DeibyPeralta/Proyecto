package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import com.example.proyecto.fragments.EventosFragment;


public class visitar extends AppCompatActivity {

 Fragment fragmentMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitar);

        fragmentMenu = new EventosFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFrame, fragmentMenu).commit();

    }

}
