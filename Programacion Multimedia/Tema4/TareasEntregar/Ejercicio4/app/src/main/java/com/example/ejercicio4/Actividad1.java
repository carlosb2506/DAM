package com.example.ejercicio4;

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

public class Actividad1 extends AppCompatActivity {

    private ArrayList<Alumno> listaAlumnos;
    private RecyclerView rvAlumnos;
    private RecyclerAdaptador adaptador;
    private Button btnFalta;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.layout_actividad1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnFalta = findViewById(R.id.btnFalta);
        rvAlumnos = findViewById(R.id.rvAlumnos);

        rvAlumnos.setLayoutManager(new LinearLayoutManager(this));

        llenarLista();
        adaptador = new RecyclerAdaptador(listaAlumnos, this);
        rvAlumnos.setAdapter(adaptador);
    }

    public void llenarLista() {
        listaAlumnos = new ArrayList<>(); // Uso del operador diamante
        listaAlumnos.add(new Alumno(R.drawable.alumno, "Carlos", "Barroso", "C/ Nueva, Nº42", "25/06/2004", 20, "ASISTE"));
        listaAlumnos.add(new Alumno(R.drawable.alumno, "Adrian", "Trujillo", "C/ Florinda, Nº6", "23/02/2004", 20, "ASISTE"));
        listaAlumnos.add(new Alumno(R.drawable.alumno, "Alejandro", "Jimenez", "C/ Remedios, Nº1", "05/11/2004", 20, "ASISTE"));
        listaAlumnos.add(new Alumno(R.drawable.alumno, "Francisco", "Martin", "C/ Velazquez, Nº23", "24/05/2004", 20, "ASISTE"));
        listaAlumnos.add(new Alumno(R.drawable.alumno, "Hugo", "Marquez", "C/ Patin, Nº32", "02/12/2004", 20, "ASISTE"));
        listaAlumnos.add(new Alumno(R.drawable.alumno, "Alvaro", "Gamero", "C/ Florida, Nº67", "18/07/2004", 20, "ASISTE"));
        listaAlumnos.add(new Alumno(R.drawable.alumno, "Jose", "Perez", "C/ Alameda, Nº92", "24/09/2004", 20, "ASISTE"));
        listaAlumnos.add(new Alumno(R.drawable.alumno, "Alejandro", "Maqueda", "C/ Ronda, Nº54", "12/08/2004", 20, "ASISTE"));
    }
}