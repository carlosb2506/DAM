package com.example.recyclerview;

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
    private ArrayList<Persona> lista;
    private Adaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rvLista = findViewById(R.id.rvLista);
        rvLista.setLayoutManager(linearLayout);
        aniadirDatos();

        adaptador = new Adaptador(lista);
        rvLista.setAdapter(adaptador);
    }

    public void  aniadirDatos(){
        lista = new ArrayList<Persona>();
        lista.add(new Persona("juan", "Pérez"));
        lista.add(new Persona("rosa", "Melano"));
        lista.add(new Persona("elpho", "john"));
        lista.add(new Persona("adri", "barillo"));
        lista.add(new Persona("fran", "castizo"));
        lista.add(new Persona("ale", "protozoo"));
        lista.add(new Persona("jose", "juarro"));
        lista.add(new Persona("reye", "badillo"));
        lista.add(new Persona("juan", "ropero"));
        lista.add(new Persona("hugo", "antonio"));
        lista.add(new Persona("antonio", "melancolico"));
        lista.add(new Persona("juan", "castillo"));
        lista.add(new Persona("rosa", "melpene"));
        lista.add(new Persona("nolasco", "grind"));
        lista.add(new Persona("fran", "malito"));
    }
}