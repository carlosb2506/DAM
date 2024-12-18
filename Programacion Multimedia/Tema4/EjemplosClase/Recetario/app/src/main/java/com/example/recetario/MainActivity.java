package com.example.recetario;

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

    private RecyclerAdaptador adaptador;
    private RecyclerView rvReceta;
    private ArrayList<Recetas> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        LinearLayoutManager layout = new LinearLayoutManager(this);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rvReceta = findViewById(R.id.rvRecetas);
        rvReceta.setLayoutManager(layout);

        lista = new ArrayList<>();


        lista.add(new Recetas("Pucherito", R.drawable.recipe, "facil", 23, "pasitos"));

        adaptador = new RecyclerAdaptador(lista, this);
        rvReceta.setAdapter(adaptador);
    }

}