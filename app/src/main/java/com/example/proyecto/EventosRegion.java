package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.proyecto.hoteles.*;


public class EventosRegion extends AppCompatActivity {

   Button candelariax, mayalesx, tativan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_region);

        candelariax=findViewById(R.id.candelaria);
        candelariax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sicarare = new Intent(EventosRegion.this, Sicarare.class);
                startActivity(sicarare);
            }
        });

        mayalesx = findViewById(R.id.sanJuan);
        mayalesx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mayales = new Intent(EventosRegion.this, mayalesPlaza.class);
                startActivity(mayales);
            }
        });

        tativan = findViewById(R.id.acordeon);
        tativan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tativan = new Intent(EventosRegion.this, tativan.class);
                startActivity(tativan);
            }
        });
    }


}
