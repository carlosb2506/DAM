package com.example.ejerciciosimulacro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

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

    private ArrayList<Jugador> listaJug;
    private RecyclerView rvJug;
    private RecyclerAdaptador adaptador;
    private Button btnAniadir;

    private ActivityResultLauncher<Intent> launcherActividad2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvJug = findViewById(R.id.rvJug);
        rvJug.setLayoutManager(new LinearLayoutManager(this));

        llenarLista();
        adaptador = new RecyclerAdaptador(listaJug);
        rvJug.setAdapter(adaptador);

        launcherActividad2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), this::manejarResultado);

        btnAniadir = findViewById(R.id.button);
        btnAniadir = findViewById(R.id.button);
        btnAniadir.setOnClickListener(v -> {
            Intent i = new Intent(this, Actividad2.class);
            launcherActividad2.launch(i);
        });
    }

    public void llenarLista() {
        listaJug = new ArrayList<>();
        listaJug.add(new Jugador(R.drawable.ubi, "Carlos", "Barroso", 99, 31, "DELANTERO", "TITULAR"));
        listaJug.add(new Jugador(R.drawable.ubi, "Francisco", "Ruiz", 69, 18, "LATERAL DERECHO", "TITULAR"));
        listaJug.add(new Jugador(R.drawable.ubi, "Javier", "Mendoza", 42, 24, "CENTRAL", "SUPLENTE"));
        listaJug.add(new Jugador(R.drawable.ubi, "Jose", "Pozo", 22, 21, "CENTROCAMPISTA", "TITULAR"));
        listaJug.add(new Jugador(R.drawable.ubi, "Jose Antonio", "Vázquez", 2, 19, "CENTRAL", "SUPLENTE"));
        listaJug.add(new Jugador(R.drawable.ubi, "Rafael", "Ángulo", 32, 23, "LATERAL IZQUIERDO", "TITULAR"));
        listaJug.add(new Jugador(R.drawable.ubi, "Juan", "Borrego", 58, 21, "CENTROCAMPISTA", "SUPLENTE"));
    }

    public void manejarResultado(ActivityResult result) {
        if (result.getResultCode() == RESULT_OK) {
            String nombre = result.getData().getStringExtra("nombre");
            String apellidos = result.getData().getStringExtra("apellidos");
            String posicion = result.getData().getStringExtra("posicion");
            int edad = result.getData().getIntExtra("edad",0);
            int dorsal = result.getData().getIntExtra("dorsal",0);
            String estado = result.getData().getStringExtra("estado");

            listaJug.add(new Jugador(R.drawable.ubi, nombre, apellidos, dorsal, edad, posicion,  estado));
            adaptador.notifyItemInserted(listaJug.size() - 1);
        }
    }
}