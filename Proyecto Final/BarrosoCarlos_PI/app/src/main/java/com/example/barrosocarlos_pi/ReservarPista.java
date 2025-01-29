package com.example.barrosocarlos_pi;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReservarPista extends AppCompatActivity {

    private Button btnVolver;
    private ArrayList<Reservas> listaParking; // Especificar el tipo de elementos
    private RecyclerView rvUbicaciones;
    private RecyclerAdaptador adaptador;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Llamar al super primero

        setContentView(R.layout.pistas_reservas);

        rvUbicaciones = findViewById(R.id.rvPistas);
        rvUbicaciones.setLayoutManager(new LinearLayoutManager(this));

        llenarLista();
        adaptador = new RecyclerAdaptador(listaParking);
        rvUbicaciones.setAdapter(adaptador);
    }

    public void llenarLista() {
        listaParking = new ArrayList<>(); // Uso del operador diamante
        listaParking.add(new Reservas(R.drawable.ayto_alcala, "PISTA DE PADEL AZUL", "C. Greco, 2, 11693 Alcalá del Valle, Cádiz"));
        listaParking.add(new Reservas(R.drawable.pista_padel_verde, "PISTA DE PADEL VERDE", "C. Greco, 2, 11693 Alcalá del Valle, Cádiz"));
        listaParking.add(new Reservas(R.drawable.ayto_alcala, "PISTA DE TENIS 1", "CA-455, 82, 11693 Alcalá del Valle, Cádiz"));
        listaParking.add(new Reservas(R.drawable.ayto_alcala, "PISTA DE TENIS 2", "CA-455, 82, 11693 Alcalá del Valle, Cádiz"));
        listaParking.add(new Reservas(R.drawable.ayto_alcala, "CAMPO DE FÚTBOL", "C. Estella del Marques, 22, 11693 Alcalá del Valle, Cádiz"));


    }

}

