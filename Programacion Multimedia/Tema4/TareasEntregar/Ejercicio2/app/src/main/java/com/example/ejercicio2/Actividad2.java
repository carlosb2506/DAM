package com.example.ejercicio2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class Actividad2 extends Activity {
    private TextView tvNombre, tvDuenio, tvEdad;
    private ImageView ivFoto;
    private Button btnVolver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_actividad2);

        Bundle datos = getIntent().getExtras();
        if (datos != null) {
            tvNombre = findViewById(R.id.tvNombre);
            tvDuenio = findViewById(R.id.tvDuenio);
            tvEdad = findViewById(R.id.tvEdad);
            ivFoto = findViewById(R.id.ivFoto);
            btnVolver = findViewById(R.id.btnVolver);

            //Voy a insertar los datos
            tvNombre.setText(datos.getString("Nombre"));
            tvDuenio.setText(datos.getString("Propietario"));
            tvEdad.setText(datos.getString("Edad") + " " + "Años");
            String raza = datos.getString("Raza");
            switch (raza) {
                case "Gato":
                    ivFoto.setImageResource(datos.getInt("Foto", R.drawable.gato));
                    break;
                case "Perro":
                    ivFoto.setImageResource(datos.getInt("Foto", R.drawable.perro));
                    break;
                case "Caballo":
                    ivFoto.setImageResource(datos.getInt("Foto", R.drawable.caballo));
                        break;
                case "Pájaro":
                    ivFoto.setImageResource(datos.getInt("Foto", R.drawable.pajaro));
                break;
                case "Hamster":
                    ivFoto.setImageResource(datos.getInt("Foto", R.drawable.hamster));
                break;
                case "Serpiente":
                    ivFoto.setImageResource(datos.getInt("Foto", R.drawable.serpiente));
                break;

                default:
                    break;
            }
        }
    }


    public void terminar(View view)
    {
        finish();
    }
}
