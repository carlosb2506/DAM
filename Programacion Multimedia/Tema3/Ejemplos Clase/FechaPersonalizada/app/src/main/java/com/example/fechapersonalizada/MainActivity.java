package com.example.fechapersonalizada;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private FechaPersonalizada etFecha;
    private boolean borrar;
    private WebView wvYoutube;

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
        etFecha = findViewById(R.id.etFecha);
        wvYoutube = findViewById(R.id.wvYoutube);
        //Abrimos video de youtube
        wvYoutube.getSettings().setJavaScriptEnabled(true);

        wvYoutube.setWebViewClient(new WebViewClient());

        wvYoutube.loadUrl("https://www.youtube.com/embed/D21ygg-jtWY");

        //Version 2 del borrar en onKeyUP

        etFecha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Se ha borrado porque la longitud del texto antes del cambio es inferior a la longitud del cambio i2

                if (i1 > i2){
                    borrar = true;
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }45

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("TAG", "afterTextChanged: por aqui entra");
                if (borrar){
                    borrar = false;
                    if (editable.length() == 2){
                        editable.delete(1, editable.length());
                    }
                    else if (editable.length() == 5){
                        editable.delete(4,editable.length());
                    }
                }
            }
        });
    }
}