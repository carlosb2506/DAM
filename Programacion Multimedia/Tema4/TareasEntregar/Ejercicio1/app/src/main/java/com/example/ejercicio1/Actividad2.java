package com.example.ejercicio1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Actividad2 extends Activity {

    private Button btnVolver;
    private ArrayList<Parking> listaParking; // Especificar el tipo de elementos
    private RecyclerView rvUbicaciones;
    private RecyclerAdaptador adaptador;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Llamar al super primero

        setContentView(R.layout.layoutactividad2);

        btnVolver = findViewById(R.id.btnVolver);
        rvUbicaciones = findViewById(R.id.rvUbicaciones);
        rvUbicaciones.setLayoutManager(new LinearLayoutManager(this));

        llenarLista();
        adaptador = new RecyclerAdaptador(listaParking);
        rvUbicaciones.setAdapter(adaptador);
    }

    // Metodo para llenar la lista de parkings
    public void llenarLista() {
        listaParking = new ArrayList<>(); // Uso del operador diamante
        listaParking.add(new Parking(R.drawable.ubi, "Estación María Zambrano"));
        listaParking.add(new Parking( R.drawable.ubi,"Plaza de la Marina"));
        listaParking.add(new Parking(R.drawable.ubi,"Playa de la Malagueta"));
        listaParking.add(new Parking(R.drawable.ubi,"Parque Tecnológico de Andalucía (PTA)"));
        listaParking.add(new Parking(R.drawable.ubi,"Calle Larios y Centro Histórico"));
        listaParking.add(new Parking(R.drawable.ubi,"Teatinos - Campus Universitario"));
        listaParking.add(new Parking(R.drawable.ubi,"Plaza de la Merced"));
        listaParking.add(new Parking(R.drawable.ubi,"Hospital Regional Universitario"));
        listaParking.add(new Parking(R.drawable.ubi,"Avenida de Andalucía (Corte Inglés)"));
        listaParking.add(new Parking(R.drawable.ubi,"Calle Alcazabilla"));
    }

    // Metodo para volver a la actividad anterior
    public void volver(View view) {
        finish();
    }
}

