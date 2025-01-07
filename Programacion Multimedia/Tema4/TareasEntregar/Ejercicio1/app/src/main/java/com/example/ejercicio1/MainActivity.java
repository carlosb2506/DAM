package com.example.ejercicio1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etUser, etPassword;
    private TextView tvNumFallos;
    private Integer contador;

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
        contador = 0;

        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);
        tvNumFallos = findViewById(R.id.tvNumFallos);
    }

    public void Entrar(View view)
    {
        if ((etUser.getText().toString().equals("carlitos")) && (etPassword.getText().toString().equals("12345")))
        {
            Intent i = new Intent(this, Actividad2.class);
            startActivity(i);
        }
        else
        {
            contador++;
            tvNumFallos.setText(contador.toString());
        }
    }
}