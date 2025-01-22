package com.example.ejemplohilos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tvTitulo, tvResultado;
    private Button btnCalcular;
    private EditText etNum;
    private long resultado;
    private boolean hilo;

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

        tvResultado = findViewById(R.id.tvResultado);
        btnCalcular = findViewById(R.id.btnCalcular);
        etNum = findViewById(R.id.etNum);
        resultado = 0;
        hilo = false;
    }

    public void Calcular(View view)
    {
        if (!hilo){
            hilo = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long numero;
                    resultado = 0;
                    if (etNum != null)
                    {
                        numero = Long.parseLong(etNum.getText().toString());
                        for (int i = 1; i <= numero ; i++)
                        {
                            resultado += i;
                        }


                    }

                    //En el hilo secundario no se puede modificar la interfaz de usuario
                    //se tiene que implementar el metodo post de la vista que se ejecuta cuando termina
                    //el hilo.

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvResultado.setText("RESULTADO : "+ resultado);
                            hilo = false;
                        }
                    });



                    //En el hilo secundario no se puede modificar la interfaz de usuario
                    //se tiene que implementar el metodo post de la vista que se ejecuta cuando termina
                    //el hilo.

                    /*tvResultado.post(new Runnable() {
                        @Override
                        public void run() {
                            tvResultado.setText("RESULTADO : "+ resultado);
                            hilo = false;
                        }
                    });*/
                }
            }).start();
        }
    }
}