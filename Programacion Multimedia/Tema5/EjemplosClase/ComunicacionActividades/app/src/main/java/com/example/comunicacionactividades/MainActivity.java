package com.example.comunicacionactividades;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
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
    private RecyclerAdaptador adaptador;
    private RecyclerView rv_recetas;
    private ArrayList<Recetas> lista;
    private ActivityResultLauncher intercambio, crear;
    private RecetasSQLite admin;
    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LinearLayoutManager layout = new LinearLayoutManager(this);
        admin = new RecetasSQLite(this, "Recetas", null, 1);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Recojo los resultados de la actividad que crea Recetas
        crear = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                Recetas receta;
                ContentValues registro;
                if (o != null && o.getResultCode() == RESULT_OK )
                {
                    bd = admin.getWritableDatabase();
                    receta = (Recetas) o.getData().getSerializableExtra("Receta");
                    adaptador.crear(receta);
                    registro = new ContentValues();
                    registro.put("nombre", receta.getNombre());
                    registro.put("foto", receta.getFoto());
                    registro.put("dificultad", receta.getDificultad());
                    registro.put("pasos", receta.getPasos());
                    registro.put("duracion", receta.getTiempo());
                    bd.insert("Recetas", null,registro);
                    bd.close();
                }
            }
        });

        //Recojo los resultados que me devuelve la actividad.
        intercambio = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                int duracion, posicion;
                String pasos;
                ContentValues registro;
                Recetas receta;
                String[] args;
                //Sólo modificamos la lista si se ha hecho algún cambio y se ha pulsado
                // el botón aceptar.
                if (o != null && o.getResultCode() == RESULT_OK )
                {
                    duracion = o.getData().getIntExtra("Duracion", 0);
                    posicion = o.getData().getIntExtra("Posicion", -1);
                    pasos = o.getData().getStringExtra("Pasos");
                    receta = adaptador.modificarReceta(posicion, duracion, pasos);
                    if (receta!=null){
                        bd = admin.getWritableDatabase();
                        registro = new ContentValues();
                        registro.put("nombre", receta.getNombre());
                        registro.put("foto", receta.getFoto());
                        registro.put("dificultad", receta.getDificultad());
                        registro.put("pasos", receta.getPasos());
                        registro.put("duracion", receta.getTiempo());
                        args = new String[] {receta.getNombre()};
                        bd.update("Recetas", registro, "nombre=?", args);
                        bd.close();
                    }


                }
            }
        });

        rv_recetas = findViewById(R.id.rv_recetas);
        rv_recetas.setLayoutManager(layout);
        lista = new ArrayList<>();
        llenar_lista();
        adaptador = new RecyclerAdaptador(lista, this);
        rv_recetas.setAdapter(adaptador);
    }

    public void llenar_lista()
    {
        bd = admin.getReadableDatabase();
        Cursor c = bd.rawQuery("SELECT nombre, foto, dificultad, duracion, pasos FROM Recetas", null);

        if (c.moveToFirst()){
            do
            {
                lista.add(new Recetas(c.getString(0), c.getInt(1), c.getString(2), c.getInt(3), c.getString(4)));
            }while (c.moveToNext());
        }else {
            lista.add(new Recetas("Puchero andaluz", R.drawable.puchero_andaluz_tradicional, "Media", 120, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum"));

        }
        bd.close();
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        boolean devolver = true;
        Intent i;
        Recetas receta;
        String[] arg;
        switch(item.getItemId())
        {
            case 121:
                //Borra el registro seleccionado.
                adaptador.borrar(item.getGroupId());
                bd = admin.getWritableDatabase();
                arg = new String[]{adaptador.borrar(item.getGroupId())};
                bd.delete("Recetas", "nombre=?", arg);
                bd.close();
                break;
            case 122:
                //Modificar datos
                int posicion = item.getGroupId();
                i = new Intent(this, ModificarRecetas.class);
                receta = adaptador.devolverReceta(posicion);
                i.putExtra("Nombre", receta.getNombre());
                i.putExtra("Foto", receta.getFoto());
                i.putExtra("Pasos", receta.getPasos());
                i.putExtra("Duracion", receta.getTiempo());
                i.putExtra("Posicion", posicion);
                intercambio.launch(i);
                break;

            case 123:
                i = new Intent(this, CrearRecetas.class);
                crear.launch(i);
                break;

            default:
                devolver = super.onContextItemSelected(item);
                break;
        }

        return devolver;
    }
}