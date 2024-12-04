package com.example.ejercicio1;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnAceptar;
    private RecyclerView rvDispositivos;
    private ArrayList<Dispositivos> listaDispositivos;
    private RecyclerAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnAceptar = findViewById(R.id.btnAceptar);
        rvDispositivos = findViewById(R.id.rvDispositivos);
        rvDispositivos.setLayoutManager(linearLayout);

        llenarLista();

        adaptador = new RecyclerAdaptador(listaDispositivos);
        rvDispositivos.setAdapter(adaptador);
    }

    public void llenarLista(){
        listaDispositivos = new ArrayList<Dispositivos>();

        listaDispositivos.add(new Dispositivos(false, R.drawable.television_150304_640, "TELEVISIÓN"));
        listaDispositivos.add(new Dispositivos(false, R.drawable.iphone_160307_640, "DISPOSITIVO MÓVIL"));
        listaDispositivos.add(new Dispositivos(false, R.drawable.img, "SMARTWATCH"));
        listaDispositivos.add(new Dispositivos(false, R.drawable.img_1, "ORDENADOR FIJO"));
        listaDispositivos.add(new Dispositivos(false, R.drawable.img_2, "ORDENADOR PORTATIL"));
        listaDispositivos.add(new Dispositivos(false, R.drawable.img_3, "TABLETA"));
    }

    public void clc(View view){
        String mensajito = "";
        for (Dispositivos disp : listaDispositivos) {

            if (disp.isMarcado()){
                mensajito += " | " + disp.getDispositivo().toString();
                Log.d("TAG", "va bien esto");

            }
            else
                Log.d("TAG", "no va bien esto");

        }
        Toast.makeText(this,mensajito, Toast.LENGTH_LONG). show();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        boolean modificado = false;
        switch (item.getItemId()){
            case 100:
                adaptador.borrar(item.getGroupId());
                modificado = true;
            default:
                modificado = super.onContextItemSelected(item);
        }
        return  modificado;
    }


}