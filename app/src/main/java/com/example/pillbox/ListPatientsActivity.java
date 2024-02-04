package com.example.pillbox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListPatientsActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ADD_PATIENT = 1;

    private List<Patient> patients;
    private PatientAdapter adapter;

    private ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null && data.hasExtra("newPatient")) {
                        Patient newPatient = data.getParcelableExtra("newPatient");

                        addPatient(newPatient);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_patient);

        ListView listView = findViewById(R.id.listViewPatientName);

        patients = new ArrayList<>();
        adapter = new PatientAdapter(this, patients);
        listView.setAdapter(adapter);

        ImageButton imageAddNewPatientButton = findViewById(R.id.imageaddnewpatient);

        imageAddNewPatientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad NewPatientActivity con startActivityForResult
                Intent intent = new Intent(ListPatientsActivity.this, NewPatientActivity.class);
                activityResultLauncher.launch(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    public void btnHelp(View view) {
        Intent intent = new Intent(this, YouNeedHelpActivity.class);
        startActivity(intent);
    }

    protected void addPatient(Patient patient) {
        patients.add(patient);
        adapter.notifyDataSetChanged();
    }
}
