package com.example.pillbox;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.editTextTextPersonName2);
        passwordEditText = findViewById(R.id.editTextTextPassword);
    }

    public void btn_signin(View view) {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString();

        if (isValidCredentials(email, password)) {
            // Credenciales válidas
            // Inicia la nueva actividad aquí
            Intent intent = new Intent(this, ListPatientsActivity.class);
            startActivity(intent);
            finish();
        } else {
            // Credenciales no válidas
            Toast.makeText(this, "Credenciales no válidas. Por favor, inténtelo de nuevo.", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValidCredentials(String email, String password) {
        // Usuario "123" y contraseña "123"
        return email.equals("123") && password.equals("123");
    }

    public void btn_help(View view) {
        Intent intent = new Intent(this, YouNeedHelpActivity.class);
        startActivity(intent);
    }

}

