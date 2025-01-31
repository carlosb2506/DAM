package com.example.ejercicio1;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Juego extends AppCompatActivity {

    private Dialog dialogPers;
    private TextView tvNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.layout_juego);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainJuego), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnAceptar;
        EditText etTexto;
        dialogPers = new Dialog(this);
        dialogPers.setContentView(R.layout.layout_nombre);

        btnAceptar = dialogPers.findViewById(R.id.btnAceptar);
        etTexto = dialogPers.findViewById(R.id.etNombre);

        btnAceptar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                tvNombre.setText(etTexto.getText().toString());
                dialogPers.cancel();
            }
        });
        dialogPers.show();

        tvNombre = findViewById(R.id.tvNombre);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if (menu instanceof MenuBuilder){

            ((MenuBuilder) menu).setOptionalIconsVisible(true);
        }

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_juego, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int opc = item.getItemId();
        boolean selected = false;
        if (opc == R.id.it_abandonar){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿ESTAS SEGURO DE QUE DESEAS ABANDONARME?");
            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //No hago nadaaa
                }
            });
            builder.create().show();

        }else if (opc == R.id.it_info){

            Intent i = new Intent(this, Instrucciones.class);
            startActivity(i);

        }
        return selected;
    }
}
