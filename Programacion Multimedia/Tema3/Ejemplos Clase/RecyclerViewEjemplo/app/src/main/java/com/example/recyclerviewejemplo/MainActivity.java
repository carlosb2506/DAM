package com.example.recyclerviewejemplo;

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
    private RecyclerView rv_lista;
    private ArrayList<Persona> lista;
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


        rv_lista = findViewById(R.id.rv_lista);
        rv_lista.setLayoutManager(linearlayout);
        //Introduce datos en la lista
        anadirDatos();

        //Creamos el adaptador
        adaptador = new RecyclerAdaptador(lista);
        rv_lista.setAdapter(adaptador);
    }

    public void anadirDatos()
    {
        lista = new ArrayList<Persona>();
        lista.add(new Persona("Juan", "Pérez"));
        lista.add(new Persona("María", "Pérez"));
        lista.add(new Persona("José", "Becerra"));
        lista.add(new Persona("Juan", "Pérez"));
        lista.add(new Persona("María", "Pérez"));
        lista.add(new Persona("José", "Becerra"));
        lista.add(new Persona("Juan", "Pérez"));
        lista.add(new Persona("María", "Pérez"));
        lista.add(new Persona("José", "Becerra"));
    }
}