package com.example.ejercicio5;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Profesor> listaProfes;
    private RecyclerView rvProfes;
    private RecyclerAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        rvProfes = findViewById(R.id.rvProfes);

        rvProfes.setLayoutManager(new LinearLayoutManager(this));

        llenarLista();
        adaptador = new RecyclerAdaptador(listaProfes);
        rvProfes.setAdapter(adaptador);
    }

    public void llenarLista() {
        listaProfes = new ArrayList<>(); // Uso del operador diamante
        listaProfes.add(new Profesor(R.drawable.perfil,"Carlos", "Barroso", "Informática", "FIJO"));
        listaProfes.add(new Profesor(R.drawable.perfil,"Ana", "Martínez", "Psicología", "FIJO"));
        listaProfes.add(new Profesor(R.drawable.perfil,"Javier", "Mendoza", "Historia", "SUSTITUCIÓN"));
        listaProfes.add(new Profesor(R.drawable.perfil,"Jose", "Pozo", "Lengua", "FIJO"));
        listaProfes.add(new Profesor(R.drawable.perfil,"Jose Antonio", "Vázquez", "Matemáticas", "SUSTITUCION"));
        listaProfes.add(new Profesor(R.drawable.perfil,"Rafael", "Ángulo", "Lengua", "SUSTITUCIÓN"));
        listaProfes.add(new Profesor(R.drawable.perfil,"Juan", "Borrego", "Informática", "FIJO"));
        listaProfes.add(new Profesor(R.drawable.perfil,"Jose", "Orellana", "Religión", "SUSTITUCIÓN"));


    }
}