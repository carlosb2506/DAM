package com.example.ejercicio4;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Actividad2 extends Activity {

    private TextView tvNom, tvApell, tvDomic, tvFecha, tvEdad2, tvEstado;

    private ImageView ivFoto;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_actividad2);

        tvNom = findViewById(R.id.tvNombre2);
        tvApell = findViewById(R.id.tvApellidos2);
        tvDomic = findViewById(R.id.tvDomic);
        tvFecha = findViewById(R.id.tvFecha);
        tvEdad2 = findViewById(R.id.tvEdad2);
        tvEstado = findViewById(R.id.tvEstado);
        ivFoto = findViewById(R.id.ivFotoPerfil);

        Bundle datos = getIntent().getExtras();

        ivFoto.setImageResource(datos.getInt("Foto"));
        tvNom.setText(datos.getString("Nombre"));
        tvApell.setText(datos.getString("Apellidos"));
        tvDomic.setText(datos.getString("Domicilio"));
        tvFecha.setText(datos.getString("FechaNac"));
        tvEdad2.setText(String.valueOf(datos.getInt("Edad")));
        tvEstado.setText(datos.getString("Estado"));

    }
}
