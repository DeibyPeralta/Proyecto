package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.proyecto.nocturnos.bodegita;
import com.example.proyecto.nocturnos.cantores;
import com.example.proyecto.nocturnos.palenqueBar;
import com.example.proyecto.nocturnos.patioBar;

public class nocturno extends AppCompatActivity {

    Button palenque, patio, cantores, bodegita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nocturno);

        palenque=findViewById(R.id.candelaria);
        palenque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sicarare = new Intent(nocturno.this, palenqueBar.class);
                startActivity(sicarare);
            }
        });

        patio = findViewById(R.id.sanJuan);
        patio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mayales = new Intent(nocturno.this, patioBar.class);
                startActivity(mayales);
            }
        });

        cantores = findViewById(R.id.acordeon);
        cantores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tativan = new Intent(nocturno.this, cantores.class);
                startActivity(tativan);
            }
        });

        bodegita = findViewById(R.id.leyenda);
        bodegita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tativan = new Intent(nocturno.this, bodegita.class);
                startActivity(tativan);
            }
        });

    }
}
