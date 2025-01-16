package com.example.ejercicio5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ProfesorModif extends Activity {

    private EditText etNombModif, etApellModif, etDomicModif , etDepartModif , etMateriasModif ;
    private ImageView ivModif;
    private Button btnAceptar, btnCancelar;
    private int posicion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Bundle datos = getIntent().getExtras();

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

        etNombModif.setText(datos.getString("nombre"));
        etApellModif.setText(datos.getString("apellidos"));
        etDomicModif.setText(datos.getString("domicilio"));
        etDepartModif.setText(datos.getString("departamento"));
        etMateriasModif.setText(datos.getString("materias"));

        ivModif.setImageResource(datos.getInt("foto"));

        //Implementamos el boton cancelar
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);

                finish();
            }
        });

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();

                i.putExtra("nombre", etNombModif.getText().toString());
                i.putExtra("apellidos", etApellModif.getText().toString());
                i.putExtra("domicilio", etDomicModif.getText().toString());
                i.putExtra("departamento", etDepartModif.getText().toString());
                i.putExtra("materias", etMateriasModif.getText().toString());
                i.putExtra("Posicion", posicion);

                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
