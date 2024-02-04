package com.example.pillbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PatientAdapter extends ArrayAdapter<Patient> {

    public PatientAdapter(@NonNull Context context, @NonNull List<Patient> patients) {
        super(context, 0, patients);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            itemView = inflater.inflate(R.layout.patient_list_item, parent, false);
        }

        Patient currentPatient = getItem(position);

        // Configurar el nombre del paciente
        TextView textViewPatientName = itemView.findViewById(R.id.textViewPatientName);
        if (currentPatient != null) {
            textViewPatientName.setText(currentPatient.getName() + " " + currentPatient.getLastname());
        }

        // Configurar los clics de los botones
        Button btnModify = itemView.findViewById(R.id.btnModify);
        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para modificar datos del paciente
                // Puedes abrir una nueva actividad o un cuadro de diálogo para editar los datos
                // Ejemplo: abrirModificarDatosActivity(currentPatient);
            }
        });

        Button btnAllergies = itemView.findViewById(R.id.btnAllergies);
        btnAllergies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para manejar alergias
                // Puedes abrir una nueva actividad o un cuadro de diálogo para gestionar alergias
                // Ejemplo: abrirGestionarAlergiasActivity(currentPatient);
            }
        });

        Button btnDelete = itemView.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para eliminar el paciente
                // Puedes mostrar un cuadro de diálogo de confirmación antes de eliminar
                // Ejemplo: mostrarDialogoConfirmacionEliminar(currentPatient);
            }
        });

        return itemView;
    }
}
