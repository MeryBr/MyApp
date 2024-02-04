package com.example.pillbox;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

public class NavigationView extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_patient);

        // Configura la barra de herramientas
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Configura el cajón de navegación
        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        com.google.android.material.navigation.NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            // Aquí maneja los clics en los elementos del menú
            switch (item.getItemId()) {
                case R.id.menu_option1:
                    // Acción para la opción 1
                    break;
                case R.id.menu_option2:
                    // Acción para la opción 2
                    break;
                case R.id.menu_option3:
                    // Acción para la opción 3
                    showLogoutConfirmationDialog(); // Llamada al método de confirmación de salida
                    break;
            }
            return true;
        });

        // Llama al método para cargar la actividad ListPatientActivity
        loadListPatientActivity();
    }

    // Método para mostrar un cuadro de diálogo de confirmación al salir
    private void showLogoutConfirmationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Confirmación")
                .setMessage("¿Estás seguro de que deseas salir?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Lógica para cerrar sesión o salir de la aplicación
                        performLogout();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    // Método para realizar la acción de cerrar sesión o salir
    private void performLogout() {
        // Implementa la lógica para cerrar sesión aquí
        // Esto podría incluir limpiar preferencias compartidas, cerrar sesión en el servidor, etc.
        // Por ejemplo, puedes seguir el ejemplo que te proporcioné anteriormente
    }

    // Método para cargar la actividad ListPatientActivity
    private void loadListPatientActivity() {
        // ... Tu código para cargar la actividad ListPatientActivity
    }
}
