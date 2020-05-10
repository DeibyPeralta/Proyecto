package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto.utilidades.utilidadesGuardar;

public class Registrarse extends AppCompatActivity {

    private EditText usuario, clave, correo;
    private Button loginUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        usuario = findViewById(R.id.userx);
        clave = findViewById(R.id.clave);
        correo = findViewById(R.id.correoxx);

        loginUsuario = findViewById(R.id.logear);

        loginUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registrarse.this, Login.class));
                finish();
            }
        });
    }

public void RegistrarUsers(View view){
    conexionSQLiteHelper conexion = new conexionSQLiteHelper(this, "db_usuario", null, 1);
    SQLiteDatabase baseDatos = conexion.getWritableDatabase();

    String name = usuario.getText().toString();
    String mail = correo.getText().toString();
    String pass = clave.getText().toString();

    if ( !name.isEmpty() && !mail.isEmpty() && !pass.isEmpty() ){
            ContentValues registro = new ContentValues();

            registro.put(utilidadesGuardar.usuario, name);
            registro.put(utilidadesGuardar.correo, mail);
            registro.put(utilidadesGuardar.contraseña, pass);

            if ( buscarDatos() == true || valiCorreo() == true){
                Toast.makeText(this, "Usuario ya registrado", Toast.LENGTH_SHORT).show();
            }else{
                Long idResultado = baseDatos.insert(utilidadesGuardar.tabla_usuario, null, registro);

                if( idResultado == -1) Toast.makeText(this, "Error with inserting users", Toast.LENGTH_SHORT).show();
                else Toast.makeText(this, "users created", Toast.LENGTH_SHORT).show();

                baseDatos.close();
            }


        usuario.setText("");
        correo.setText("");
        clave.setText("");
    }else{
        Toast.makeText(Registrarse.this, "Debes llenar todos los campos", Toast.LENGTH_LONG).show();
    }
}

public boolean buscarDatos(){
    conexionSQLiteHelper conexion = new conexionSQLiteHelper(this, "db_usuario", null, 1);
    SQLiteDatabase baseDatos = conexion.getWritableDatabase();

    String[] parametros = { usuario.getText().toString() };
    String[] campos = {utilidadesGuardar.usuario, utilidadesGuardar.correo, utilidadesGuardar.contraseña};

    try {
        Cursor cursorBuscador= baseDatos.query(utilidadesGuardar.tabla_usuario, campos, utilidadesGuardar.usuario +"=?", parametros, null, null, null);
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
    String[] campos = {utilidadesGuardar.usuario, utilidadesGuardar.correo, utilidadesGuardar.contraseña};

    try {
        Cursor cursorBuscador= baseDatos.query(utilidadesGuardar.tabla_usuario, campos, utilidadesGuardar.correo +"=?", parametros, null, null, null);
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


/*

linea 36 para guardar
 baseDatos = FirebaseDatabase.getInstance().getReference();

       Registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String users = usuario.getText().toString();
                String pass = clave.getText().toString();
                String email = correo.getText().toString();

                // Mapeo
                Map<String, Object> usuariox = new HashMap<>();
                usuariox.put("nombre", users);
                usuariox.put("correo", email);
                usuariox.put("clave", pass);

            //    baseDatos.child("Usuarios").child("turistas").push().setValue(usuariox);
                baseDatos.child("Usuarios").push().setValue(usuariox);
            }
        });
*/


    /*  // metodo para guardar usuarios
    public void Registrar(View view){
        // objeto de la clase ya creada
        // se pasan 4 parametos... contesto this, el nombre de la db, el null, y la version de la db
        dbPrueba admin = new dbPrueba(this, "proyectodb", null, 1);// proyecto es el nombre de la base de datos

        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();// poder leer y escribir datos

        String usuariox = usuario.getText().toString();
        String correox = correo.getText().toString();
        String clavex = clave.getText().toString();

        if ( !usuariox.isEmpty() && !clavex.isEmpty() && !correox.isEmpty() ){ // si es diferente a vacia
            ContentValues registro = new ContentValues();

            registro.put("usuariosdb", usuariox);
            registro.put("correodb", correox);
            registro.put("contraseñasdb", clavex);

            baseDeDatos.insert("Usuarios", null, registro);
            baseDeDatos.close();

            usuario.setText("");
            clave.setText("");
            correo.setText("");

            Toast.makeText(this, "Se registro el usuario", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_LONG).show();
        }
    }
*/

}
