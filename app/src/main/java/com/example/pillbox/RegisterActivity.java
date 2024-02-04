package com.example.pillbox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private TextView textAppName, textRegister;
    private EditText editTextTextPersonName, editTextTextPersonSur, editTextTextPersonEmail,
            editTextTextPassword2, editTextTextPassword3;

    private Button buttonEnter, buttonHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        textAppName = findViewById(R.id.textAppName);
        textRegister = findViewById(R.id.Register);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPersonSur = findViewById(R.id.editTextTextPersonSur);
        editTextTextPersonEmail = findViewById(R.id.editTextTextPersonEmail);
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2);
        editTextTextPassword3 = findViewById(R.id.editTextTextPassword3);
    }

    public void buttonEnter(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void btn_help(View view) {
        Intent intent = new Intent(this, YouNeedHelpActivity.class);
        startActivity(intent);
    }

}
