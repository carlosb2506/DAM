package com.example.examen5;

import android.os.Bundle;
import android.app.Activity;
import androidx.annotation.Nullable;
import android.widget.TextView;
import android.widget.ImageView;


public class VisualizarEntreno extends Activity {

    private TextView tvFecha, tvDur, tvHora, tvFrecuencia, tvTipo;
    private ImageView ivDeporte;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_visualizarentreno);

        tvFecha = findViewById(R.id.tvFecha);
        tvDur = findViewById(R.id.tvDuracion);
        tvHora = findViewById(R.id.tvHora);
        tvFrecuencia = findViewById(R.id.tvFrecuencia);
        tvTipo = findViewById(R.id.tvTipo);
        ivDeporte = findViewById(R.id.ivDeporte);



        Bundle datos = getIntent().getExtras();

        tvFecha.setText(datos.getString("fecha"));
        tvTipo.setText(datos.getString("tipo"));
        tvDur.setText(String.valueOf(datos.getInt("duracion")));
        tvHora.setText(datos.getString("hora"));
        tvFrecuencia.setText(String.valueOf(datos.getInt("frecuencia")));
        ivDeporte.setImageResource(datos.getInt("foto"));
    }
}
