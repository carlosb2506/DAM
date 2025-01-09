package com.example.ejercicio2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class MainActivity extends Activity {
    private TextView tvNombre, tvDuenio, tvEdad;
    private ImageView ivFoto;
    private Button btnVolver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle datos = getIntent().getExtras();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_actividad2
        );
        tvNombre = findViewById(R.id.tvNombre);
        tvDuenio = findViewById(R.id.tvDuenio);
        tvEdad = findViewById(R.id.tvEdad);
        ivFoto = findViewById(R.id.ivFoto);
        btnVolver = findViewById(R.id.btnVolver);

        //Voy a insertar los datos
        tvNombre.setText(datos.getString("Nombre"));
        ivFoto.setImageResource(datos.getInt("Foto"));
        tvDuenio.setText(datos.getString("Pasos"));


    }

    public void terminar(View view)
    {
        finish();
    }
}
