package com.example.recetario;

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
    private ImageView imFotito;
    private Button btnAceptar, btnCancelar;
    private int posicion;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Bundle datos = getIntent().getExtras();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_modif_receta);

        tv_titu = findViewById(R.id.tvRecetilla);
        et_duracion = findViewById(R.id.et_duracion);
        et_pasos = findViewById(R.id.et_pasos);
        imFotito = findViewById(R.id.imFotito);
        btnAceptar = findViewById(R.id.btnAceptar);
        btnCancelar = findViewById(R.id.btnCancelar);

        tv_titu.setText(datos.getString("Nombre"));
        et_duracion.setText(String.valueOf(datos.getInt("Duracion")));
        et_pasos.setText(datos.getString("Pasos"));
        imFotito.setImageResource(datos.getInt("Foto"));
        posicion = datos.getInt("Posicion");

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
                i.putExtra("Duracion", Integer.parseInt(et_duracion.getText().toString()));
                i.putExtra("Pasos", et_pasos.getText().toString());
                i.putExtra("Posicion", posicion);

                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
