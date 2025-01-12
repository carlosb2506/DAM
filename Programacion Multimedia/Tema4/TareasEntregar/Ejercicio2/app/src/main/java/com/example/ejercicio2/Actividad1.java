package com.example.ejercicio2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Actividad1 extends AppCompatActivity {

    private Spinner spinner;
    private EditText etNombre,etEdad,etPropietario;
    private Button btnAgregar;
    private ArrayList<Registro> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.layout_actividad1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinner = findViewById(R.id.spinner);
        etNombre = findViewById(R.id.etNombre);
        etEdad = findViewById(R.id.etEdad);
        etPropietario = findViewById(R.id.etPropietario);
        btnAgregar = findViewById(R.id.btnAgregar);

        String[] categorias = {"Gato", "Perro", "Caballo", "Pájaro", "Hamster", "Serpiente"};

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, categorias));

        lista = new ArrayList<>();
        lista.add(new Registro(etNombre.getText().toString(), etPropietario.getText().toString(), etEdad.getText().toString()));
    }

    public void registrar(View view) {
        if ((etNombre.getText().toString().isEmpty()) || (etEdad.getText().toString().isEmpty()) || (etPropietario.getText().toString().isEmpty())) {
            Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(this, Actividad2.class);
            i.putExtra("Nombre", etNombre.getText().toString());
            i.putExtra("Propietario", etPropietario.getText().toString());
            i.putExtra("Edad", etEdad.getText().toString());
            i.putExtra("Raza", spinner.getSelectedItem().toString());
            startActivity(i);
        }
    }


}