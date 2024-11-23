package com.example.webview;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;


public class MainActivity extends AppCompatActivity {

    MaterialToolbar menuPrincipal;
    RecyclerView rvProvincias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inicializarComponentes();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_principal,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.opcOrdNom){
            GestionProvincia.ordenarPorNombre(GestionProvincia.getListaPronvincias());
            AdaptadorProvincia adaptadorProvincia = new AdaptadorProvincia(GestionProvincia.getListaPronvincias());
            rvProvincias.setAdapter(adaptadorProvincia);

        } else if (item.getItemId() == R.id.opcOrdNumHab) {
            GestionProvincia.ordenarPorNumHab(GestionProvincia.getListaPronvincias());
            AdaptadorProvincia adaptadorProvincia = new AdaptadorProvincia(GestionProvincia.getListaPronvincias());
            rvProvincias.setAdapter(adaptadorProvincia);
        } else if (item.getItemId() == R.id.opcSalir) {
            crearAlertaSalir();

        }
        return false;
    }

    private void crearAlertaSalir() {
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle("SALIR")
                .setMessage("¿Estas seguro de que quieres salir?")
                .setNegativeButton("No",null)
                .setPositiveButton("Si", (dialog, which) -> finishAffinity())
                .create()
                .show();
    }


    @Override
    protected void onPostResume() {
        super.onPostResume();
        AdaptadorProvincia adaptador = new AdaptadorProvincia(GestionProvincia.getListaPronvincias());
        rvProvincias.setAdapter(adaptador);

    }

    private void inicializarComponentes() {
        menuPrincipal = findViewById(R.id.menuPrincipal);
        rvProvincias = findViewById(R.id.rvProvincia);

        setSupportActionBar(menuPrincipal);

        LinearLayoutManager disposicion = new LinearLayoutManager(getApplicationContext());
        rvProvincias.setLayoutManager(disposicion);

        GestionProvincia.cargaInicialProvincias();


    }
}