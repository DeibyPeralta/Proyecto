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

public class Login extends AppCompatActivity {

    private EditText usuariosx, clave;
    private Button logearsexx, registrarsexx;

    // creo objeto
    private FirebaseAuth autenticacion;

    private String mail = "";
    private String pass = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // login
        usuariosx = findViewById(R.id.mailx);
        clave = findViewById(R.id.contraseñax);

        logearsexx = findViewById(R.id.logear);
        registrarsexx = findViewById(R.id.registrarse);

        autenticacion = FirebaseAuth.getInstance();

        logearsexx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mail = usuariosx.getText().toString();
                pass = clave.getText().toString();

                if ( !mail.isEmpty() && !pass.isEmpty() ){
                    loginUsers();
                }else {
                    Toast.makeText(Login.this, "Debes llenar todos los campos", Toast.LENGTH_LONG).show();
                }
            }
        });

        registrarsexx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Registrarse.class));
                finish();
            }
        });
    }
    
    public void Restablecerx(View view){
        startActivity(new Intent(Login.this, resetPass.class));
    }
private void loginUsers(){
        autenticacion.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if( task.isSuccessful() ){
                    startActivity(new Intent(Login.this, EventosPrueba.class));
                    finish();
                }else{
                    Toast.makeText(Login.this, "No se pudo iniciar sesion, comprovar datos", Toast.LENGTH_LONG).show();
                }
            }
        });
}

    @Override
    protected void onStart() {
        super.onStart();

        if ( autenticacion.getCurrentUser() != null ){
            startActivity(new Intent(Login.this, EventosPrueba.class));
            finish();
        }
    }

// metodo para consultar datos
  /*  private void Consultar(View view){

        // objeto que busco
        baseDatos.child("Usuarios");


        baseDatos.addChildEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String Correo = DataSnapshot.child("correo").getValue().toString();

                    usuariosx.setText(Correo);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
  */
    
}
