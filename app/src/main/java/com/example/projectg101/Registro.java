package com.example.projectg101;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.FileInputStream;

public class Registro extends AppCompatActivity {
    private Button btnRegisterRegister;
    private EditText editEmailRegister, editPassRegister, editConfirmRegister;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegisterRegister = (Button) findViewById(R.id.btnRegisterRegister);
        editEmailRegister = (EditText) findViewById(R.id.editEmailRegister);
        editPassRegister = (EditText) findViewById(R.id.editPassRegister);
        editConfirmRegister = (EditText) findViewById(R.id.editConfirmRegister);

        mAuth = FirebaseAuth.getInstance();

        btnRegisterRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmailRegister.getText().toString().trim();
                String pass = editPassRegister.getText().toString().trim();
                String confirm = editConfirmRegister.getText().toString().trim();

                if (pass.compareTo(confirm) == 0) {
                    mAuth.createUserWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(getApplicationContext(),"Usuario Registrado Correctamente",Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), Login.class);
                                        startActivity(intent);
                                    }
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getApplicationContext(),"Error En Registro", Toast.LENGTH_SHORT).show();
                                    Log.e("ErrorRegister", e.toString());
                                }
                            });
                }else{
                    Toast.makeText(getApplicationContext(),"Confirme Contraseña", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}