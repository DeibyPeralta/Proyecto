package com.example.proyecto.vistaEventos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.proyecto.R;

public class candelaria extends AppCompatActivity {

    ToggleButton asistencia;
    TextView estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candelaria);

        asistencia = findViewById(R.id.asistenciaBtn);
        estado = findViewById(R.id.estado);
    }

    public void confirmarAsistencia(View view) {

    }
}
