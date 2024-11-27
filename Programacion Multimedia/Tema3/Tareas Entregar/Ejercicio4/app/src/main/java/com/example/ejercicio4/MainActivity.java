package com.example.ejercicio4;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CuentaBancaria etCuenta;
    private boolean borrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        borrar = false;
        etCuenta = findViewById(R.id.etCuenta);

        etCuenta.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Se ha borrado porque la longitud del texto antes del cambio es inferior a la longitud del cambio i2

                if (i1 > i2){
                    borrar = true;
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("TAG", "afterTextChanged: por aqui entra");
                if (borrar){
                    borrar = false;
                    if (editable.length() == 4){
                        editable.delete(3, editable.length());
                    }
                    else if (editable.length() == 9){
                        editable.delete(8,editable.length());

                    }else if (editable.length() == 14){
                        editable.delete(13,editable.length());
                    }
                }
                // Cambiar el fondo del texto a rojo cuando tenga 16 dígitos
                if (editable.length() == 19) {
                    etCuenta.setBackgroundColor(Color.GREEN);
                    etCuenta.setTextColor(Color.BLACK);
                } else {
                    etCuenta.setBackgroundColor(Color.RED);
                    etCuenta.setTextColor(Color.WHITE);
                }
            }
        });
    }
}

