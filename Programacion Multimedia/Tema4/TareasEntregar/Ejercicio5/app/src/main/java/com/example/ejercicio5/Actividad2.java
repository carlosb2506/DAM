package com.example.ejercicio5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.annotation.Nullable;

public class Actividad2 extends Activity {

    private EditText etNombre, etApellidos, etDomicilio, etMaterias, etDepartamento;

    private Spinner spinner;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_actividad2);

        etNombre = findViewById(R.id.etNombre);
        etApellidos = findViewById(R.id.etApellidos);
        etDomicilio = findViewById(R.id.etDomicilio);
        etMaterias = findViewById(R.id.etMaterias);
        etDepartamento = findViewById(R.id.etDepartamento);
        spinner = findViewById(R.id.spinner);

        String[] categorias = {"SUSTITUCIÓN", "FIJO/A"};

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, categorias));
    }

    public void aniadir(View view) {

        String nombre = etNombre.getText().toString();
        String apellidos = etApellidos.getText().toString();
        String direccion = etDomicilio.getText().toString();
        String estado = spinner.getSelectedItem().toString();
        String materias = etMaterias.getText().toString();
        String departamento = etDepartamento.getText().toString();

        if (nombre.isEmpty() || apellidos.isEmpty() || direccion.isEmpty() || departamento.isEmpty() || materias.isEmpty())
        {
            Toast.makeText(this, "Para añadir el profesor/la profesora, debe completar todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Profesor añadido con éxito: " + nombre + " " + apellidos, Toast.LENGTH_SHORT).show();

        Intent i = new Intent();
        i.putExtra("nombre", nombre);
        i.putExtra("apellidos", apellidos);
        i.putExtra("departamento", departamento);
        i.putExtra("materias", materias);
        i.putExtra("estado", estado);

        setResult(RESULT_OK, i);
        finish();
    }

    public void cancelar(View view)
    {
        finish();
    }
}

