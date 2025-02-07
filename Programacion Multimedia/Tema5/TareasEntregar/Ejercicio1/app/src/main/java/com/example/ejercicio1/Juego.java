package com.example.ejercicio1;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Juego extends AppCompatActivity {

    private Dialog dialogPers;
    private TextView tvNombre;
    private ImageView[] imagenes;
    private ImageView cartaClikada;
    private int cartaAlmcenada;
    private ArrayList<Cartas> listaCartas;
    private int contadorGiro = 0;
    private Handler manejador;
    private String nombre;
    private int intentos = 0;
    private boolean pistaUsada = false;


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

        listaCartas = new ArrayList<Cartas>();

        imagenes = new ImageView[6];
        imagenes[0] = findViewById(R.id.imagen1);
        imagenes[1] = findViewById(R.id.imagen2);
        imagenes[2] = findViewById(R.id.imagen3);
        imagenes[3] = findViewById(R.id.imagen4);
        imagenes[4] = findViewById(R.id.imagen5);
        imagenes[5] = findViewById(R.id.imagen6);



        for (ImageView imagen : imagenes) {
            imagen.setImageResource(R.drawable.carta_reversa);
        }

        for (ImageView imagen : imagenes) {
            imagen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickear(view);
                }
            });
        }

        llenarLista();

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
                nombre = etTexto.getText().toString();
                tvNombre.setText("Intentos de " + nombre + " : " + intentos);

                dialogPers.cancel();
            }
        });
        dialogPers.show();

        tvNombre = findViewById(R.id.tvNombre);


    }

    public void clickear(View view) {

        if (intentos >= 5) {

            mostrarAlertDialog();
            return;
        }

        contadorGiro++;
        cartaClikada = (ImageView) view;
        int contador = 0;
        boolean encontrada = false;

        while ((contador < listaCartas.size()) && !encontrada) {
            if (cartaClikada.equals(imagenes[contador])) {
                encontrada = true;
            } else {
                contador++;
            }
        }

        if (contadorGiro < 2) {
            cartaAlmcenada = contador;
        } else if (contadorGiro == 2) {

            if (contador != cartaAlmcenada) {
                imagenes[contador].setImageResource(listaCartas.get(contador).getFoto());
                imagenes[cartaAlmcenada].setImageResource(listaCartas.get(cartaAlmcenada).getFoto());
                contadorGiro = 0;

                final int finalContador = contador;
                if (listaCartas.get(contador).getFoto() != listaCartas.get(cartaAlmcenada).getFoto()) {
                    manejador = new Handler(Looper.getMainLooper());


                    manejador.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            imagenes[finalContador].setImageResource(R.drawable.carta_reversa);
                            imagenes[cartaAlmcenada].setImageResource(R.drawable.carta_reversa);
                            intentos++;
                            tvNombre.setText("Intentos de " + nombre + " : " + intentos);
                        }
                    }, 2000);
                }
            } else {
                contadorGiro--;
            }
        }
    }

    private void mostrarAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Fin de la partida");
        builder.setMessage("Has alcanzado 5 intentos. ¿Qué deseas hacer?");

        builder.setPositiveButton("Resetear partida", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resetearPartida();
            }
        });

        builder.setNegativeButton("Abandonar partida", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.create().show();
    }

    private void resetearPartida() {

        intentos = 0;
        contadorGiro = 0;
        pistaUsada = false;

        for (ImageView carta : imagenes) {
            carta.setImageResource(R.drawable.carta_reversa);
            carta.setClickable(true);
        }
        tvNombre.setText("Intentos de " + nombre + " : " + intentos);
    }

    public void llenarLista()
    {
        listaCartas.add(new Cartas(false, R.drawable.carta2));
        listaCartas.add(new Cartas(false, R.drawable.carta1));
        listaCartas.add(new Cartas(false, R.drawable.carta3));
        listaCartas.add(new Cartas(false, R.drawable.carta3));
        listaCartas.add(new Cartas(false, R.drawable.carta2));
        listaCartas.add(new Cartas(false, R.drawable.carta1));
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

        }else if (opc == R.id.it_pista){
            if (!pistaUsada) {
                // Marcar que ya se usó la pista
                pistaUsada = true;

                // Llamar a la función para girar una carta aleatoria
                girarCartaAleatoria();

            } else {
                // Si el botón ya fue usado, mostrar un mensaje o deshabilitarlo
                Toast.makeText(this, "Ya has usado la pista.", Toast.LENGTH_SHORT).show();
            }

        } else if (opc == R.id.it_resetear) {
            resetearPartida();
        }
        return selected;
    }

    private void girarCartaAleatoria() {
        // Buscar cartas que no han sido giradas (imagen reversa)
        ArrayList<Integer> cartasNoGiradas = new ArrayList<>();
        for (int i = 0; i < imagenes.length; i++) {
            if (imagenes[i].getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.carta_reversa).getConstantState())) {
                cartasNoGiradas.add(i);
            }
        }

        if (!cartasNoGiradas.isEmpty()) {
            // Elegir una carta aleatoria
            int indiceAleatorio = cartasNoGiradas.get((int) (Math.random() * cartasNoGiradas.size()));

            // Mostrar la carta durante 2 segundos
            imagenes[indiceAleatorio].setImageResource(listaCartas.get(indiceAleatorio).getFoto());

            // Volver a darle la vuelta después de 2 segundos
            Handler manejador = new Handler(Looper.getMainLooper());
            manejador.postDelayed(new Runnable() {
                @Override
                public void run() {
                    imagenes[indiceAleatorio].setImageResource(R.drawable.carta_reversa);
                }
            }, 2000); // 2 segundos
        } else {
            Toast.makeText(this, "Ya todas las cartas han sido giradas.", Toast.LENGTH_SHORT).show();
        }
    }
}
