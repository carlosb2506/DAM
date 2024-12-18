package com.example.recetario;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetalleRecetas extends AppCompatActivity
{
    private TextView tvRecet, tvPasos;
    private ImageView imFotillo;
    private Button btnVolver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Bundle datos = getIntent().getExtras();

        super.onCreate(savedInstanceState);

        setContentView(R.layout.layoutdetalles);

        tvPasos = findViewById(R.id.tvPasos);
        tvRecet = findViewById(R.id.tvRecet);
        imFotillo = findViewById(R.id.imFotillo);
        btnVolver = findViewById(R.id.btnVolver);
        //voy a insertar los datos
        tvRecet.setText(datos.getString("Nombre"));
        imFotillo.setImageResource(datos.getInt("Foto"));
        tvPasos.setText(datos.getString("Pasos"));
    }

    public void terminar(View view){
        finish();
    }
}
