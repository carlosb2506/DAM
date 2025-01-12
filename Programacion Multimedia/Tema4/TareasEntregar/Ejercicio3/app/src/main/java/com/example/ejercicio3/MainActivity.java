package com.example.ejercicio3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private Button btnVolver;
    private ArrayList<Bar> listaBares; // Especificar el tipo de elementos
    private RecyclerView rvBares;

    private RecyclerAdaptador adaptador;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState); // Llamar al super primero

        setContentView(R.layout.activity_main);

        btnVolver = findViewById(R.id.btnVolver);
        rvBares = findViewById(R.id.rvBares);


        rvBares.setLayoutManager(new LinearLayoutManager(this));

        llenarLista();
        adaptador = new RecyclerAdaptador(listaBares);
        rvBares.setAdapter(adaptador);
    }

    // Metodo para llenar la lista de parkings
    public void llenarLista() {
        listaBares = new ArrayList<>(); // Uso del operador diamante
        listaBares.add(new Bar(R.drawable.bar_cuatro_calles, "Bar Cuatro Calles", "C/ Nueva, Nº42"));
        listaBares.add(new Bar( R.drawable.bar_polear,"Café Bar Polear", "C/ Virgen de los Remedios, Nº6"));
        listaBares.add(new Bar(R.drawable.bar_que_punto,"Bar QUE PUNTO", "C/ la Huerta, Nº15"));
        listaBares.add(new Bar(R.drawable.sin_foto,"Cervercería El Sitio", "C/ Virgen de los Remedios, Nº3"));
        listaBares.add(new Bar(R.drawable.bar_la_fabrica,"Restaurante La Fabrica Y Terraza La Pasailla", "C/ Meson, Nº11"));
        listaBares.add(new Bar(R.drawable.sin_foto,"Restaurante La Bodeguita", "C/ Velazquez, Nº9"));
        listaBares.add(new Bar(R.drawable.meson_sabor_andaluz,"Mesón Sabor Andaluz", "C/ la Huerta, Nº3"));
        listaBares.add(new Bar(R.drawable.sin_foto,"Bar Plaza", "Plaza Ayuntamiento, Nº12"));
    }

    // Metodo para volver a la actividad anterior
    public void volver(View view) {
        finish();
    }
}

