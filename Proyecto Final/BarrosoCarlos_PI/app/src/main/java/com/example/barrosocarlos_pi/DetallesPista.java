package com.example.barrosocarlos_pi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetallesPista extends AppCompatActivity {

    private TextView tvNombrePista, tvDireccionPista;

    private ImageView ivFotoPista;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle datos = getIntent().getExtras();

        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_detalles);

        tvNombrePista = findViewById(R.id.tvNombrePista);
        tvDireccionPista = findViewById(R.id.tvDireccionPista);
        ivFotoPista = findViewById(R.id.ivImagenPista);
        //btnVolver = findViewById(R.id.btnVolver);
        //voy a insertar los datos
        tvNombrePista.setText(datos.getString("Nombre"));
        ivFotoPista.setImageResource(datos.getInt("Foto"));
        tvDireccionPista.setText(datos.getString("Direccion"));

    }

    public void cancelar(View view){
        finish();
    }
}
