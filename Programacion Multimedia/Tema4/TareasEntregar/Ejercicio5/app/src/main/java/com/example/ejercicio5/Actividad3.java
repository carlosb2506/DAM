package com.example.ejercicio5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Actividad3 extends Activity {

    private TextView tvNombre3, tvApellido3, tvDomicilio3, tvDpeartamento3, tvMaterias3, tvEstado3;
    private ImageView ivPerfil3;
    private Button btnVolver;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_actividad3);

        tvEstado3 = findViewById(R.id.tvEstado3);
        tvNombre3 = findViewById(R.id.tvNombre3);
        tvApellido3 = findViewById(R.id.tvApellido3);
        tvDomicilio3 = findViewById(R.id.tvDomicilio3);
        tvDpeartamento3 = findViewById(R.id.tvDepartamento3);
        tvMaterias3 = findViewById(R.id.tvMaterias3);
        ivPerfil3 = findViewById(R.id.ivPerfil3);
        btnVolver = findViewById(R.id.btnVolver);

        Bundle datos = getIntent().getExtras();

        ivPerfil3.setImageResource(datos.getInt("foto"));
        tvEstado3.setText(datos.getString("estado"));
        tvNombre3.setText(datos.getString("nombre"));
        tvApellido3.setText(datos.getString("apellidos"));
        tvDomicilio3.setText(datos.getString("domicilio"));
        tvDpeartamento3.setText(datos.getString("departamento"));
        tvMaterias3.setText(datos.getString("materias"));


    }

    public void cancelar(View view)
    {
        finish();
    }
}
