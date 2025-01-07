package com.example.ejercicio1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Actividad2 extends Activity {

    private Button btnVolver;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layoutactividad2);

        btnVolver = findViewById(R.id.btnVolver);
    }

    //TERMINO LA APLICACION
    public void volver(View view){

        finish();

    }
}
