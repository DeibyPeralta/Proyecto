package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
<<<<<<< HEAD
import com.example.proyecto.fragments.EventosFragment;
=======
>>>>>>> deiby


public class visitar extends AppCompatActivity {

<<<<<<< HEAD
    EventosFragment fragmentMenu;

=======
>>>>>>> deiby
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitar);

<<<<<<< HEAD
        // declaro al fragment
        fragmentMenu = new EventosFragment();

        // es para cargar en el activity el fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFrame, fragmentMenu).commit();
=======

>>>>>>> deiby

    }

}
