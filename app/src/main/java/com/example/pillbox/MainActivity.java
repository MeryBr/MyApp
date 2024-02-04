package com.example.pillbox;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void btn_help(View view) {
        Intent intent = new Intent(this, YouNeedHelpActivity.class);
        startActivity(intent);
    }

    public void btnRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void btnLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

   }
    public void btnAddPatient(View view) {
        Intent intent = new Intent(this, NewPatientActivity.class);
        startActivity(intent);
    }
}

