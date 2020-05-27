package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.proyecto.baseDatos.baseDatos;
import com.example.proyecto.utilidades.utilidadesGuardar;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    private EditText usuariosx, clave;

    conexionSQLiteHelper conexxion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // login
        usuariosx = findViewById(R.id.mailx);
        clave = findViewById(R.id.contraseñax);

        conexxion = new conexionSQLiteHelper(this, "db_usuario", null, 1);

}

    public void Restablecerx(View view){
        Intent restablecer = new Intent(this, resetPass.class);
        startActivity(restablecer);
    }

    public void registro(View view){
        Intent registro = new Intent(this, Registrarse.class);
        startActivity(registro);
    }

public void buscarDatos(View view){
     if ( valiUsu()== true && valiPass()== true){
         Toast.makeText(this, "Usuario confirmado", Toast.LENGTH_SHORT).show();

         Intent inicio = new Intent(this, MainActivity.class);
         startActivity(inicio);
     }else{
         Toast.makeText(this, "Datos erroneos", Toast.LENGTH_SHORT).show();
     }
}

public boolean valiPass(){
    SQLiteDatabase baseDatosx = conexxion.getWritableDatabase();
    String[] parametros = {clave.getText().toString() };
    String[] campos = {utilidadesGuardar.usuario, utilidadesGuardar.correo, utilidadesGuardar.contraseña};

    try {
        Cursor cursorBuscador= baseDatosx.query(utilidadesGuardar.tabla_usuario, campos, utilidadesGuardar.contraseña +"=?", parametros, null, null, null);

        cursorBuscador.moveToFirst();
        if ( !cursorBuscador.getString(0).isEmpty() ){
            return true;
        }else{
            return false;
        }
    }catch (Exception e){
        return false;
    }
}

public boolean valiUsu(){
    SQLiteDatabase baseDatosx = conexxion.getWritableDatabase();
    String[] parametros = {usuariosx.getText().toString() };
    String[] campos = {utilidadesGuardar.usuario, utilidadesGuardar.correo, utilidadesGuardar.contraseña};

    try {
        Cursor cursorBuscador= baseDatosx.query(utilidadesGuardar.tabla_usuario, campos, utilidadesGuardar.usuario +"=?", parametros, null, null, null);

        cursorBuscador.moveToFirst();
        if ( !cursorBuscador.getString(0).isEmpty() ){
            return true;
        }else{
            return false;
        }

    }catch (Exception e){
        return false;
    }
}

}
