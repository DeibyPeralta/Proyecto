package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Registrarse extends AppCompatActivity {

    private EditText usuario, clave, correo;
    private Button registrarUsuario, loginUsuario;

    // variables de los datos a registrar

    private String name="";
    private String mail="";
    private String pass="";

    FirebaseAuth autenticaciondb;
    DatabaseReference baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        usuario = findViewById(R.id.userx);
        clave = findViewById(R.id.clave);
        correo = findViewById(R.id.correoxx);

        registrarUsuario = findViewById(R.id.registrarse);
        loginUsuario = findViewById(R.id.logear);

        autenticaciondb = FirebaseAuth.getInstance();
        baseDatos = FirebaseDatabase.getInstance().getReference();// referencia al nodo principal

        registrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = usuario.getText().toString();
                mail = correo.getText().toString();
                pass = clave.getText().toString();

                if ( !name.isEmpty() && !mail.isEmpty() && !pass.isEmpty() ){
                    if ( pass.length() >= 6 ){
                        RegistrarUsers();
                    }else{
                        Toast.makeText(Registrarse.this, "La clave debe tener 6 caracteres", Toast.LENGTH_LONG).show();
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

    private void RegistrarUsers(){
        autenticaciondb.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {// si se registro el usuario
                if ( task.isSuccessful() ){
                    String id = autenticaciondb.getCurrentUser().getUid();// busco el id del usuario
                    // Mapeo de valores
                    Map<String, Object> usuariox = new HashMap<>();
                    usuariox.put("nombre", name);
                    usuariox.put("correo", mail);
                    usuariox.put("clave", pass);

                    baseDatos.child("usuarios").child(id).setValue(usuariox).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful() ){
                                startActivity(new Intent(Registrarse.this, Login.class));
                                finish();
                            }else{
                                Toast.makeText(Registrarse.this, "No se registro linea 100", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(Registrarse.this, "No se registro el usuario, verificar datos", Toast.LENGTH_LONG).show();
                }
            }
        });
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
