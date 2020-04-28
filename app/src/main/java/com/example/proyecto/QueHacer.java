package com.example.proyecto;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

public class QueHacer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_que_hacer);

        final FloatingActionsMenu fabMenu =  findViewById(R.id.menuPrincipal);
        final FloatingActionButton fab1 =  findViewById(R.id.mapas);

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QueHacer.this,  EventosPrueba.class);
                startActivity(intent);
                fabMenu.collapse(); // cierre despues de accionarse
            }
        });
    }


}
