package com.example.ejercicio2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvLista;
    private ArrayList<Tareas> lista;
    private RecyclerAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LinearLayoutManager linearlayout = new LinearLayoutManager(this);


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        rvLista = findViewById(R.id.rvLista);
        rvLista.setLayoutManager(linearlayout);
        //Introduce datos en la lista
        anadirDatos();

        //Creamos el adaptador
        adaptador = new RecyclerAdaptador(lista);
        rvLista.setAdapter(adaptador);
    }

    public void anadirDatos()
    {
        lista = new ArrayList<Tareas>();
        lista.add(new Tareas("Planchar", "1h", "Carlos", false));
        lista.add(new Tareas("Lavar Ropa", "30min", "Carlos, Alejandro", false));
        lista.add(new Tareas("Tender Ropa", "15min", "Carlos", false));
        lista.add(new Tareas("Fregar", "1h", "Alejandro", false));
        lista.add(new Tareas("Limpieza", "2h", "Alejandro", false));
        lista.add(new Tareas("Comida", "4h", "Carlos", false));
        lista.add(new Tareas("Compra", "1h", "Carlos, Alejandro", false));
        lista.add(new Tareas("Ordenar", "30min", "Carlos, Alejandro", false));
        lista.add(new Tareas("Planchar", "1h", "Alejandro", false));
    }


}