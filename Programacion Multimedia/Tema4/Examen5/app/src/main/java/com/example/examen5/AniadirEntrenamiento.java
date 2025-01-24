package com.example.examen5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.annotation.Nullable;

public class AniadirEntrenamiento extends Activity {

    private Spinner spinner;
    private EditText etFecha, etDur, etHora, etFrecu;
    private ImageView ivPerfil;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_aniadirentrenamiento);

        spinner = findViewById(R.id.spinner);

        String[] categorias = {"YOGA", "BICI", "PILATES", "CORRER",};

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, categorias));

        etFecha = findViewById(R.id.etFechaEntre);
        etDur = findViewById(R.id.etDurEntre);
        etHora = findViewById(R.id.etHoraEntre);
        etFrecu = findViewById(R.id.etFrecuenciaCard);
        ivPerfil = findViewById(R.id.ivDeporte);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spinner.getSelectedItem().toString().equals("YOGA")){
                    ivPerfil.setImageResource(R.drawable.yoga);
                }
                else if (spinner.getSelectedItem().toString().equals("BICI")){
                    ivPerfil.setImageResource(R.drawable.bici);
                }
                else if (spinner.getSelectedItem().toString().equals("PILATES")){
                    ivPerfil.setImageResource(R.drawable.pilates);
                }
                else if (spinner.getSelectedItem().toString().equals("CORRER")){
                    ivPerfil.setImageResource(R.drawable.correr);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                ivPerfil.setImageResource(R.drawable.logo);

            }
        });
    }
    public void aniadir(View view) {

        String fecha = etFecha.getText().toString();
        String hora = etHora.getText().toString();

        int duracion = Integer.parseInt(etDur.getText().toString());
        int frecuencia = Integer.parseInt(etFrecu.getText().toString());
        int imagen = 0;

        int calorias = 0;
        String tipo = "";
        if (spinner.getSelectedItem().toString().equals("YOGA")){
            calorias = 6 * duracion;
            tipo = "Yoga";
            imagen = R.drawable.yoga;
        }
        else if (spinner.getSelectedItem().toString().equals("BICI")){
            calorias = 9 * duracion;
            tipo = "Bici";
            imagen = R.drawable.bici;

        }
        else if (spinner.getSelectedItem().toString().equals("PILATES")){
            calorias = 3 * duracion;
            tipo = "Pilates";
            imagen = R.drawable.pilates;

        }
        else if (spinner.getSelectedItem().toString().equals("CORRER")){
            calorias = 13 * duracion;
            tipo = "Correr";
            imagen = R.drawable.correr;

        }


        Toast.makeText(this, "Entrenamiento añadido con éxito", Toast.LENGTH_SHORT).show();

        Intent i = new Intent();
        i.putExtra("fecha", fecha);
        i.putExtra("hora", hora);
        i.putExtra("duracion", duracion);
        i.putExtra("frecuencia", frecuencia);
        i.putExtra("calorias", calorias);
        i.putExtra("tipo", tipo);
        i.putExtra("imagen", imagen);

        setResult(RESULT_OK, i);
        finish();
    }


}
