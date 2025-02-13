package com.example.comunicacionactividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class CrearRecetas extends Activity {

    private EditText et_titulo,et_duracion, et_pasos;
    private ImageView im_foto;
    private Button btn_aceptar, btn_cancelar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_crear_receta);

        et_titulo = findViewById(R.id.et_titulitooo);
        et_duracion = findViewById(R.id.et_duracion);
        et_pasos = findViewById(R.id.et_pasos);
        im_foto = findViewById(R.id.im_imag);
        btn_aceptar = findViewById(R.id.btn_aceptar);
        btn_cancelar = findViewById(R.id.btn_cancelar);

        im_foto.setImageResource(R.drawable.puchero_andaluz_tradicional);

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
                int duracion = 0;
                Intent i = new Intent();
                if (et_duracion.getText() != null){
                    duracion =  Integer.parseInt(et_duracion.getText().toString());
                }
                Recetas receta = new Recetas(et_titulo.getText().toString(), R.drawable.puchero_andaluz_tradicional, "facil", duracion, et_pasos.getText().toString());

                i.putExtra("Receta", receta);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
