package com.example.comunicacionactividades;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetalleRecetas extends AppCompatActivity {
    private TextView tv_recet, tv_pasos;
    private ImageView im_fotos;
    private Button btn_volver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle datos = getIntent().getExtras();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detalle_recetas);
        tv_recet = findViewById(R.id.tv_recet);
        tv_pasos = findViewById(R.id.tv_pasos);
        im_fotos = findViewById(R.id.im_foto);
        btn_volver = findViewById(R.id.btn_volver);

        //Voy a insertar los datos
        tv_recet.setText(datos.getString("Nombre"));
        im_fotos.setImageResource(datos.getInt("Foto"));
        tv_pasos.setText(datos.getString("Pasos"));
    }

    public void terminar(View view)
    {
        finish();
    }
}
