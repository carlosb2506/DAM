package com.example.ejercicio3;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList listaPublicaciones;
    private RecyclerView rvPublicaciones;
    private RecyclerAdaptador adaptador;
    private WebView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        GridLayoutManager layout = new GridLayoutManager(this, 2);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        rvPublicaciones = findViewById(R.id.rvPublicaciones);
        rvPublicaciones.setLayoutManager(layout);

        llenarLista();
        adaptador = new RecyclerAdaptador(listaPublicaciones);
        rvPublicaciones.setAdapter(adaptador);

        video = findViewById(R.id.video);
        WebSettings webSettings = video.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //String url = "https://www.youtube.com/embed/SUk8Z1WSqh0";
        String url = "https://www.youtube.com/embed/iOb11iq7nhQ";

        video.setWebViewClient(new WebViewClient());
        video.loadUrl(url);
    }


    public void llenarLista()
    {
        listaPublicaciones = new ArrayList<Publicacion>();
        listaPublicaciones.add(new Publicacion(R.drawable.movil1, 2000));
        listaPublicaciones.add(new Publicacion(R.drawable.movil2, 30000));
        listaPublicaciones.add(new Publicacion(R.drawable.movil3, 32320));
        listaPublicaciones.add(new Publicacion(R.drawable.movil4, 43420));
        listaPublicaciones.add(new Publicacion(R.drawable.movil5,43460));
    }

}