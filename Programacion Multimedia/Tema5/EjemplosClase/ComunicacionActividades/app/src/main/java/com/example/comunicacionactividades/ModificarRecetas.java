package com.example.comunicacionactividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ModificarRecetas extends Activity {
    private TextView tv_titu;
    private EditText et_duracion, et_pasos;
    private ImageView im_foto;
    private Button btn_aceptar, btn_cancelar;
    private int posicion;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle datos = getIntent().getExtras();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_modif_receta);

        tv_titu = findViewById(R.id.et_titulitooo);
        et_duracion = findViewById(R.id.et_duracion);
        et_pasos = findViewById(R.id.et_pasos);
        im_foto = findViewById(R.id.im_imag);
        btn_aceptar = findViewById(R.id.btn_aceptar);
        btn_cancelar = findViewById(R.id.btn_cancelar);

        tv_titu.setText(datos.getString("Nombre"));
        et_duracion.setText(String.valueOf(datos.getInt("Duracion")));
        et_pasos.setText(datos.getString("Pasos"));
        im_foto.setImageResource(datos.getInt("Foto"));
        posicion = datos.getInt("Posicion");

        //Implementamos el botón cancelar.
        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btn_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("Duracion", Integer.parseInt(et_duracion.getText().toString()));
                i.putExtra("Pasos", et_pasos.getText().toString());
                i.putExtra("Posicion", posicion);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
