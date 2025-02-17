package com.example.menus;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tv_texto;
    private ConstraintLayout layout;
    private Dialog dialogPers;


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

        layout = findViewById(R.id.main);
        tv_texto = findViewById(R.id.tv_texto);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if (menu instanceof MenuBuilder){

            ((MenuBuilder) menu).setOptionalIconsVisible(true);
        }

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ejemplo, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int opc = item.getItemId();
        boolean selected = false;
        if (opc == R.id.it_color){
            tv_texto.setTextColor(Color.RED);
            selected = true;
        } else if(opc == R.id.it_fondo){
            layout.setBackgroundColor(Color.CYAN);
            selected = true;
        }else if (opc == R.id.it_salir){

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

        } else if (opc == R.id.itPreferencias) {
            Button btnAceptar;
            EditText etTexto;
            dialogPers = new Dialog(this);
            dialogPers.setContentView(R.layout.layout_preferencias);

            btnAceptar = dialogPers.findViewById(R.id.btnAceptar);
            etTexto = dialogPers.findViewById(R.id.etNombre);

            btnAceptar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tv_texto.setText(etTexto.getText().toString());
                    dialogPers.cancel();
                }
            });
            dialogPers.show();
        }
        return selected;
    }
}