package com.example.recetario;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
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
    private ActivityResultLauncher intercambio;


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

        //Recojo los resultados que me devuelve la actividad
        intercambio = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                int duracion, posicion;
                String pasos;
                //Solo modificamos la lista si se ha hecho algun cambio y se ha pùlsado el boton aceptar
                     if (o != null && o.getResultCode() == RESULT_OK)
                     {
                         duracion = o.getData().getIntExtra("Duracion",0);
                         posicion = o.getData().getIntExtra("Posicion",0);
                         pasos = o.getData().getStringExtra("Pasos");
                         adaptador.modificarReceta(posicion,duracion,pasos);
                     }
            }
        });

        rvReceta = findViewById(R.id.rvRecetas);
        rvReceta.setLayoutManager(layout);

        lista = new ArrayList<>();


        lista.add(new Recetas("Pucherito", R.drawable.recipe, "facil", 23, "pasitos"));

        adaptador = new RecyclerAdaptador(lista, this);
        rvReceta.setAdapter(adaptador);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        boolean devolver = true;
        Intent i;
        Recetas receta;
        switch (item.getItemId()){
            case 121:
                //Borrar el registro seleccionado
                adaptador.borrar(item.getGroupId());
                break;
            case 122:
                //Modificar datos
                int posicion = item.getGroupId();
                i = new Intent(this, ModificarRecetas.class);
                receta = adaptador.devolverRecetas(posicion);

                i.putExtra("Nombre", receta.getNombre());
                i.putExtra("Foto", receta.getFoto());
                i.putExtra("Pasos", receta.getPasos());
                i.putExtra("Duracion", receta.getTiempo());
                i.putExtra("Posicion", posicion);
                intercambio.launch(i);

                break;
            default:
                devolver = super.onContextItemSelected(item);
                break;


        }

        return devolver;
    }
}