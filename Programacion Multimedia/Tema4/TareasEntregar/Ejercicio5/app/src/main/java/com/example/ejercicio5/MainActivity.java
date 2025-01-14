package com.example.ejercicio5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
    private TextView tvNombre, tvApellidos, tvEstado;
    private Button btnAniadir;
    private ActivityResultLauncher<Intent> launcherActividad2;


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

        launcherActividad2 = registerForActivityResult( new ActivityResultContracts.StartActivityForResult(), this::manejarResultado );

        btnAniadir = findViewById(R.id.button);
        btnAniadir.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Actividad2.class);
            launcherActividad2.launch(intent);
        });
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
    }

    public void AniadirProfesor(View view)
    {
        Intent i = new Intent(this, Actividad2.class);
        startActivity(i);
    }

    public void manejarResultado(ActivityResult result) {
        if (result.getResultCode() == RESULT_OK) {
            String nombre = result.getData().getStringExtra("nombre");
            String apellidos = result.getData().getStringExtra("apellidos");
            String departamento = result.getData().getStringExtra("departamento");
            String materias = result.getData().getStringExtra("materias");
            String estado = result.getData().getStringExtra("estado");

            listaProfes.add(new Profesor(R.drawable.perfil, nombre, apellidos, departamento, estado));
            adaptador.notifyItemInserted(listaProfes.size() - 1);
        }
    }
}