package com.example.ejemplotema3;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextView tvEleccion;
    private Adapter adaptador;
    private final String [] lista = new String[] {"Programacion Multimedia", "Horas de libre configuracion", "Procesos"};
    private Button btnMostrar;
    private EditText etPreferencia;
    private ListView listaPreferencia;
    private ArrayAdapter<String> adaptPreferencias;
    private ArrayList<String> arrayPref;

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

        spinner = findViewById(R.id.spinner);
        tvEleccion = findViewById(R.id.tvEleccion);

        btnMostrar = findViewById(R.id.btnMostrar);
        etPreferencia = findViewById(R.id.etPreferecia);
        listaPreferencia = findViewById(R.id.listaPreferencia);

        arrayPref = new ArrayList<String>();

        //Inicializamos el adaptaqdor para indicarle cuales van a ser sus datos y que tipo de lista va a ser

        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, lista);

        adaptPreferencias = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayPref);

        listaPreferencia.setAdapter(adaptPreferencias);

        spinner.setAdapter((SpinnerAdapter) adaptador);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tvEleccion.setText(lista[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                tvEleccion.setText("");
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayPref.add(etPreferencia.getText().toString());
                adaptPreferencias.notifyDataSetChanged();
            }
        });
        //Añadimos un evento cuando se pulsa un elemento de la vista.
        //Se mostrara un Toast con la información
        listaPreferencia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(),arrayPref.get(i).toString(), Toast.LENGTH_LONG).show();
            }
        });

        //});
    }


}