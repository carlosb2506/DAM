package com.example.ejercicio5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class ProfesorModif extends Activity {

    private EditText etNombModif, etApellModif, etDomicModif, etDepartModif, etMateriasModif;
    private ImageView ivModif;
    private Button btnAceptar, btnCancelar;
    private int posicionn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_modif_profesor);

        etNombModif = findViewById(R.id.etNombModif);
        etApellModif = findViewById(R.id.etApellModif);
        etDomicModif = findViewById(R.id.etDomicModif);
        etDepartModif = findViewById(R.id.etDepartModif);
        etMateriasModif = findViewById(R.id.etMateriasModif);
        ivModif = findViewById(R.id.ivModif);
        btnAceptar = findViewById(R.id.btnAceptar);
        btnCancelar = findViewById(R.id.btnCancelar);

        // Recibir los datos del profesor
        Intent intent = getIntent();
        etNombModif.setText(intent.getStringExtra("nombre"));
        etApellModif.setText(intent.getStringExtra("apellidos"));
        etDomicModif.setText(intent.getStringExtra("domicilio"));
        etDepartModif.setText(intent.getStringExtra("departamento"));
        etMateriasModif.setText(intent.getStringExtra("materias"));
        ivModif.setImageResource(intent.getIntExtra("foto", 0));
        posicionn = intent.getIntExtra("Posicion", 0);

        // Implementación del botón Cancelar
        btnCancelar.setOnClickListener(v -> {
            setResult(RESULT_CANCELED);
            finish();
        });

        // Implementación del botón Aceptar
        btnAceptar.setOnClickListener(v -> {
            Intent i = new Intent();
            i.putExtra("nombre", etNombModif.getText().toString());
            i.putExtra("apellidos", etApellModif.getText().toString());
            i.putExtra("domicilio", etDomicModif.getText().toString());
            i.putExtra("departamento", etDepartModif.getText().toString());
            i.putExtra("materias", etMateriasModif.getText().toString());
            i.putExtra("posss", posicionn);

            setResult(RESULT_OK, i);
            finish();
        });
    }
}

