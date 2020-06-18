package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.proyecto.Quevisitar.Nabusimake;
import com.example.proyecto.Quevisitar.atanquez;
import com.example.proyecto.Quevisitar.puebloBello;

public class QueVisitar extends AppCompatActivity {
    Button candelariax, atanquez, puebloBello, sonesta, cienaga;

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

        atanquez = findViewById(R.id.sanJuan);
        atanquez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent atanquezx = new Intent(QueVisitar.this, atanquez.class);
                startActivity(atanquezx);
            }
        });

        puebloBello = findViewById(R.id.acordeon);
        puebloBello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent puebloBellox = new Intent(QueVisitar.this, puebloBello.class);
                startActivity(puebloBellox);
            }
        });

        cienaga = findViewById(R.id.leyenda);
        cienaga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tativan = new Intent(QueVisitar.this, cienagaZapatoca.class);
                startActivity(tativan);
            }
        });


    }
}
