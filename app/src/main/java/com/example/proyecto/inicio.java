package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    public void login(View view){
        Intent actividad_uno = new Intent(this, Login.class);
        startActivity(actividad_uno);
        finish();
    }

    public void invitado(View view){
        Intent invitadox = new Intent(this, MainActivity.class);
        startActivity(invitadox);
        finish();
    }
}
