package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto.utilidades.dbUtilidades;



public class Registrarse extends AppCompatActivity {

    private EditText usuario, clave, correo;
    private Button loginUsuario, registrarUsuario;

    // variables de los datos a registrar

    private String name="";
    private String mail="";
    private String pass="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        usuario = findViewById(R.id.userx);
        clave = findViewById(R.id.clave);
        correo = findViewById(R.id.correoxx);

        loginUsuario = findViewById(R.id.logear);
        registrarUsuario = findViewById(R.id.registrarse);

        registrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = usuario.getText().toString();
                mail = correo.getText().toString();
                pass = clave.getText().toString();

                if ( !name.isEmpty() && !mail.isEmpty() && !pass.isEmpty() ){
                    if ( pass.length() >= 4 ){
                        RegistrarUsers();
                    }else{
                        Toast.makeText(Registrarse.this, "La clave debe tener 4 caracteres", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(Registrarse.this, "Debes llenar todos los campos", Toast.LENGTH_LONG).show();
                }
            }
        });


        loginUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registrarse.this, Login.class));
                finish();
            }
        });
    }

public void RegistrarUsers(){
    conexionSQLiteHelper conexion = new conexionSQLiteHelper(this, "db_usuario", null, 1);
    SQLiteDatabase baseDatos = conexion.getWritableDatabase();

    String name = usuario.getText().toString();
    String mail = correo.getText().toString();
    String pass = clave.getText().toString();

    if ( !name.isEmpty() && !mail.isEmpty() && !pass.isEmpty() ){
            ContentValues registro = new ContentValues();

            registro.put(dbUtilidades.usuario, name);
            registro.put(dbUtilidades.correo, mail);
            registro.put(dbUtilidades.contraseña, pass);

            if ( buscarDatos() == true || valiCorreo() == true){
                Toast.makeText(this, "Usuario ya registrado", Toast.LENGTH_SHORT).show();
            }else{
               Long idResultado = baseDatos.insert(dbUtilidades.tabla_usuario, null, registro);

                if( idResultado == -1) Toast.makeText(this, "Error with inserting users", Toast.LENGTH_SHORT).show();
                else Toast.makeText(this, "users created", Toast.LENGTH_SHORT).show();

                baseDatos.close();
            }
    }
}

public boolean buscarDatos(){
    conexionSQLiteHelper conexion = new conexionSQLiteHelper(this, "db_usuario", null, 1);
    SQLiteDatabase baseDatos = conexion.getWritableDatabase();

    String[] parametros = { usuario.getText().toString() };
    String[] campos = {dbUtilidades.usuario, dbUtilidades.correo, dbUtilidades.contraseña};

    try {
        Cursor cursorBuscador= baseDatos.query(dbUtilidades.tabla_usuario, campos, dbUtilidades.usuario +"=?", parametros, null, null, null);
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

public boolean valiCorreo(){
    conexionSQLiteHelper conexion = new conexionSQLiteHelper(this, "db_usuario", null, 1);
    SQLiteDatabase baseDatos = conexion.getWritableDatabase();

    String[] parametros = { correo.getText().toString() };
    String[] campos = {dbUtilidades.usuario, dbUtilidades.correo, dbUtilidades.contraseña};

    try {
        Cursor cursorBuscador= baseDatos.query(dbUtilidades.tabla_usuario, campos, dbUtilidades.correo +"=?", parametros, null, null, null);
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





