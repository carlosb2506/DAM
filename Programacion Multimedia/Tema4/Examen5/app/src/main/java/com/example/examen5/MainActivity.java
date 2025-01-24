package com.example.examen5;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_entrenos;
    private ArrayList<Entrenos> lista;
    private Adaptador adaptador;
    private TextView tv_peso, tv_altura, tv_imc;
    private Button btn_imc;

    private ActivityResultLauncher<Intent> launcherActividad2, launcherAniadirEntreno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LinearLayoutManager layout = new LinearLayoutManager(this);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rv_entrenos = findViewById(R.id.rv_entrenos);
        tv_altura = findViewById(R.id.tv_alturaval);
        tv_peso = findViewById(R.id.tv_pesoval);
        tv_imc = findViewById(R.id.tv_imcval);
        btn_imc = findViewById(R.id.btn_imc);
        rv_entrenos.setLayoutManager(layout);
        launcherActividad2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), this::manejarResultado);
        launcherAniadirEntreno = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), this::manejarResultadoEntreno);



        llenarLista();
        adaptador = new Adaptador(lista);
        rv_entrenos.setAdapter(adaptador);

        tv_altura.setText("174");
        tv_peso.setText("68");
        tv_imc.setText("18");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        boolean devolver = true;
        Intent i;

        switch (item.getItemId()){
            case 121:
                adaptador.borrar(item.getGroupId());
                break;
            case 122:

                int posicion = item.getGroupId();
                Intent intent = new Intent(this, VisualizarEntreno.class);
                intent.putExtra("fecha", lista.get(posicion).getFecha());
                intent.putExtra("hora", lista.get(posicion).getHora());
                intent.putExtra("duracion", lista.get(posicion).getDuracion());
                intent.putExtra("frecuencia", lista.get(posicion).getFrec_cardiaca());
                intent.putExtra("tipo", lista.get(posicion).getDeporte());
                intent.putExtra("foto", lista.get(posicion).getFoto());

                startActivity(intent);

                break;

            case 123:
                i = new Intent(this, AniadirEntrenamiento.class);


                launcherAniadirEntreno.launch(i);

                break;
            default:
                devolver = super.onContextItemSelected(item);
                break;
        }
        return devolver;
    }

    private void llenarLista() {
        lista = new ArrayList<>();
        lista.add(new Entrenos(R.drawable.bici, "Bici", 300, 45, "10:15", "22/01/2025", 145));
        lista.add(new Entrenos(R.drawable.correr, "Correr", 350, 60, "09:45", "21/01/2025", 150));
        lista.add(new Entrenos(R.drawable.pilates, "Pilates", 150, 35, "16:15", "20/01/2025", 125));
        lista.add(new Entrenos(R.drawable.yoga, "Yoga", 130, 30, "10:15", "19/01/2025", 125));
    }

    public void manejarResultadoEntreno(ActivityResult result)
    {
        if (result.getResultCode() == RESULT_OK)
        {
            String tipo = result.getData().getStringExtra("tipo");
            String fecha = result.getData().getStringExtra("fecha");
            String hora = result.getData().getStringExtra("hora");
            int duracion = result.getData().getIntExtra("duracion",0);
            int frecuencia = result.getData().getIntExtra("frecuencia",0);
            int calorias = result.getData().getIntExtra("calorias",0);
            int imagen = result.getData().getIntExtra("imagen",0);

            lista.add(new Entrenos(imagen, tipo, calorias, duracion, hora, fecha, frecuencia));
            adaptador.notifyItemInserted(lista.size() - 1);
        }
    }

    public void btnImc(View view)
    {
        Intent i = new Intent(this, Actividad2.class);
        i.putExtra("Peso", tv_peso.getText().toString());
        i.putExtra("Altura", tv_altura.getText().toString());
        launcherActividad2.launch(i);
    }

    public void manejarResultado(ActivityResult result)
    {
        if (result.getResultCode() == RESULT_OK){
            double peso = (result.getData().getExtras().getDouble("peso"));
            double altura = (result.getData().getExtras().getDouble("altura"));
            float imc = (result.getData().getExtras().getFloat("imc"));

            tv_peso.setText(String.valueOf(peso));
            tv_altura.setText(String.valueOf(altura));
            tv_imc.setText(String.valueOf(imc));
        }
        else
        {
            Toast.makeText(this, "Resul no ok", Toast.LENGTH_SHORT).show();
        }
    }
}