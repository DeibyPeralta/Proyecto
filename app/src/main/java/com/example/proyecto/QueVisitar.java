package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.proyecto.Quevisitar.Nabusimake;

public class QueVisitar extends AppCompatActivity {
    Button candelariax, mayalesx, tativan, sonesta, Maranata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_que_visitar);


        candelariax=findViewById(R.id.candelaria);
        candelariax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sicarare = new Intent(QueVisitar.this, Nabusimake.class);
                startActivity(sicarare);
            }
        });

        mayalesx = findViewById(R.id.sanJuan);
        mayalesx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mayales = new Intent(QueVisitar.this, mayalesPlaza.class);
                startActivity(mayales);
            }
        });

        tativan = findViewById(R.id.acordeon);
        tativan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tativan = new Intent(QueVisitar.this, com.example.proyecto.hoteles.tativan.class);
                startActivity(tativan);
            }
        });

        sonesta = findViewById(R.id.leyenda);
        sonesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tativan = new Intent(QueVisitar.this, tativan.class);
                startActivity(tativan);
            }
        });

        Maranata = findViewById(R.id.cafe);
        Maranata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tativan = new Intent(QueVisitar.this, tativan.class);
                startActivity(tativan);
            }
        });
    }
