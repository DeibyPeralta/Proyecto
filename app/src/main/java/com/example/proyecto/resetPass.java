package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class resetPass extends AppCompatActivity {

    private EditText correox, clavex;
    String datosUpate="";
    conexionSQLiteHelper conexxion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);

        correox = findViewById(R.id.correoReset);
        clavex = findViewById(R.id.newPass);

        conexxion = new conexionSQLiteHelper(this, "db_usuario", null, 1);
    }


}
