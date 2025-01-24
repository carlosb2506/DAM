package com.example.examen5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Actividad2 extends Activity {

    private EditText etPeso, etAltura;
    private TextView tvImc;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_actividad2);

        Bundle datos = getIntent().getExtras();

        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        tvImc = findViewById(R.id.tv_imcc);

        etPeso.setText(datos.getString("Peso"));
        etAltura.setText(datos.getString("Altura"));

    }

    public void cancelar(View view)
    {
        finish();
    }

    public void CalcularImc(View view)
    {
        double peso = Double.parseDouble(etPeso.getText().toString());
        double altura = Double.parseDouble(etAltura.getText().toString());

        float imc = (float) (peso / (altura * altura));
        Log.d("TAG", "CalcularImc: " + (peso / (altura * altura)));

        tvImc.setText(Float.toString(imc));
    }

    public void registarDatos(View view)
    {
        double peso = Double.parseDouble(etPeso.getText().toString());
        double altura = Double.parseDouble(etAltura.getText().toString());
        float imc = Float.parseFloat(tvImc.getText().toString());

        Toast.makeText(this, "Datos Registrados con éxito", Toast.LENGTH_SHORT).show();

        Intent i = new Intent();
        i.putExtra("peso", peso);
        i.putExtra("altura", altura);
        i.putExtra("imc", imc);

        setResult(RESULT_OK, i);
        Log.d("TAG", "pone result ok");
        finish();
    }
}
