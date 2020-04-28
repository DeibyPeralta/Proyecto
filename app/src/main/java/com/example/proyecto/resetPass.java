package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class resetPass extends AppCompatActivity {

    private EditText correo;
    private Button guardar;

    private String correoValidar="";

    private FirebaseAuth autenticacion;

    private ProgressDialog dialogx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);

        correo = findViewById(R.id.correoReset);
        guardar = findViewById(R.id.saveClave);

        autenticacion = FirebaseAuth.getInstance();
        dialogx = new ProgressDialog(this);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                correoValidar = correo.getText().toString();

                if ( !correoValidar.isEmpty() ){
                    dialogx.setMessage("Espera un momento...");
                    dialogx.setCanceledOnTouchOutside(false);// false para que el user no lo quite
                    dialogx.show();
                    ResetPassword();

                    correo.setText("");
                }else{
                    Toast.makeText(resetPass.this, "Debe escribir el correo", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void ResetPassword(){
        autenticacion.setLanguageCode("es");
        autenticacion.sendPasswordResetEmail(correoValidar).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if ( task.isSuccessful() ){
                    Toast.makeText(resetPass.this, "Se envio un correo para restablecer la clave", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(resetPass.this, "No se pudo envir el correo", Toast.LENGTH_LONG).show();
                }
                dialogx.dismiss(); // para ocultar el dialog
            }
        });
    }
}
