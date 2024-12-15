package com.example.amador_gonzalez_eduardo_pmdm02;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.amador_gonzalez_eduardo_pmdm02.databinding.ActivityNavDrawerBinding;
import com.google.android.material.snackbar.Snackbar;

//Clase donde se ejecuta la actividad principal
public class NavDrawer extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavDrawerBinding binding;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        preferences = getPreferences(MODE_PRIVATE);
        if (preferences.getBoolean("idioma", false)) {
            LocaleListCompat appLocale = LocaleListCompat.forLanguageTags("en-EN");
            AppCompatDelegate.setApplicationLocales(appLocale);
        } else {
            LocaleListCompat appLocale = LocaleListCompat.forLanguageTags("es-ES");
            AppCompatDelegate.setApplicationLocales(appLocale);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        setTheme(R.style.Theme_Amador_Gonzalez_Eduardo_PMDM02);

        super.onCreate(savedInstanceState);

        binding = ActivityNavDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarNavDrawer.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_settings)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.fragment_content_nav_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        Snackbar snackbar = Snackbar.make(findViewById(R.id.drawer_layout), R.string.bienvenido, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    /**
     * Método que crea las opciones del menú
     * @param menu Menú que se mostrará
     * @return Valor booleano en true para que se realice la acción
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contextual, menu);
        return true;
    }

    /**
     * Método que gestiona la selección de los items del menú
     * @param item Recoge el item seleccionado
     * @return Valor booleano en true para que se realice la acción
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId(); //Optenemos el id del item pulsado y lo guardamos en una variable

        if(id == R.id.acerca){
            AlertDialog.Builder dialog = new AlertDialog.Builder(this); //Creamos el AlertDialog
            dialog.setTitle(R.string.acerca); //Establecemos título, mensaje y botón para cerrar el dialogo
            dialog.setMessage(R.string.dialogTxt);
            dialog.setNeutralButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {}
            }).create().show();

        } else {
            NavController navController = Navigation.findNavController(this, R.id.fragment_content_nav_drawer);
            return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
        } //Fin if-else

        return true;
    }
}