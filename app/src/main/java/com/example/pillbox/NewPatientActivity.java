package com.example.pillbox;

import android.app.DatePickerDialog;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class NewPatientActivity extends Activity {

    private EditText editDatePatient, editPersonNamePatient, editPersonLastPatient,
            editPhonePatient, editEmailAddressPatient, editPostalAddressPatient,
            editMedicalCentr, editDoctorName, editContactDoctor, editEmailDoctor, editTextAddInfo;

    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_patient);

        initializeViews();

        dateFormatter = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    }

    private void initializeViews() {
        editDatePatient = findViewById(R.id.editDatePatient);
        editPersonNamePatient = findViewById(R.id.editPersonNamePatient);
        editPersonLastPatient = findViewById(R.id.editPersonLastPatient);
        editPhonePatient = findViewById(R.id.editTextPhonePatient);
        editEmailAddressPatient = findViewById(R.id.editEmailAddressPatient);
        editPostalAddressPatient = findViewById(R.id.editPostalAddressPatient);
        editMedicalCentr = findViewById(R.id.editMedicalcentr);
        editDoctorName = findViewById(R.id.editdoctorname);
        editContactDoctor = findViewById(R.id.editContactdoctor);
        editEmailDoctor = findViewById(R.id.editEmailDoctor);
        editTextAddInfo = findViewById(R.id.editTextaddinfo);

        editDatePatient.setOnClickListener(view -> showDatePickerDialog());
    }

    private void showDatePickerDialog() {
        Calendar newCalendar = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                android.R.style.Theme_Holo_Light_Dialog,
                (view, year, monthOfYear, dayOfMonth) -> {
                    Calendar newDate = Calendar.getInstance();
                    newDate.set(year, monthOfYear, dayOfMonth);
                    editDatePatient.setText(dateFormatter.format(newDate.getTime()));
                },
                newCalendar.get(Calendar.YEAR),
                newCalendar.get(Calendar.MONTH),
                newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.getDatePicker().setSpinnersShown(true);
        datePickerDialog.getDatePicker().setCalendarViewShown(false);

        datePickerDialog.show();
    }


    public void btnRegister(View view) {
        String name = editPersonNamePatient.getText().toString();
        String lastname = editPersonLastPatient.getText().toString();
        String birthDate = editDatePatient.getText().toString();
        String phone = editPhonePatient.getText().toString();
        String emailAddress = editEmailAddressPatient.getText().toString();
        String postalAddress = editPostalAddressPatient.getText().toString();
        String medicalCentr = editMedicalCentr.getText().toString();
        String doctorName = editDoctorName.getText().toString();
        String contactDoctor = editContactDoctor.getText().toString();
        String emailDoctor = editEmailDoctor.getText().toString();
        String additionalInfo = editTextAddInfo.getText().toString();

        savePatientData(name, lastname, birthDate, phone, emailAddress, postalAddress,
                medicalCentr, doctorName, contactDoctor, emailDoctor, additionalInfo);

        Toast.makeText(this, "Patient data saved", Toast.LENGTH_SHORT).show();

        Intent resultIntent = new Intent();
        resultIntent.putExtra("newPatient", new Patient(name, lastname));
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    private void savePatientData(String name, String lastname, String birthDate, String phone,
                                 String emailAddress, String postalAddress, String medicalCentr,
                                 String doctorName, String contactDoctor, String emailDoctor,
                                 String additionalInfo) {
        SharedPreferences preferences = getSharedPreferences("PatientData", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Name", name);
        editor.putString("Lastname", lastname);
        editor.putString("BirthDate", birthDate);
        editor.putString("Phone", phone);
        editor.putString("EmailAddress", emailAddress);
        editor.putString("PostalAddress", postalAddress);
        editor.putString("MedicalCentr", medicalCentr);
        editor.putString("DoctorName", doctorName);
        editor.putString("ContactDoctor", contactDoctor);
        editor.putString("EmailDoctor", emailDoctor);
        editor.putString("AdditionalInfo", additionalInfo);
        editor.apply();
    }

    public void btn_help(View view) {
        Intent intent = new Intent(this, YouNeedHelpActivity.class);
        startActivity(intent);
    }
}
