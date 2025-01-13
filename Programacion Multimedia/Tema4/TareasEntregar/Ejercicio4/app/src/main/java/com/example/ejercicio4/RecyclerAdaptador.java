package com.example.ejercicio4;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdaptador extends RecyclerView.Adapter<RecyclerAdaptador.ViewHolder> {

    private ArrayList<Alumno> lista;
    private Context contex;

    public RecyclerAdaptador(ArrayList<Alumno> lista, Context contex)
    {
        this.lista = lista;
        this.contex = contex;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View vista = layoutInflater.inflate(R.layout.layout_recycler_view, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNombre;
        private TextView tvApellidos;
        private ImageView ivPerfil;
        private Button btnFalta;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvApellidos = itemView.findViewById(R.id.tvApellidos);
            ivPerfil = itemView.findViewById(R.id.ivPerfil);
            btnFalta = itemView.findViewById(R.id.btnFalta);

            btnFalta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int posicion = getAdapterPosition();
                    if (lista.get(posicion).getEstado().equals("ASISTE")){
                        lista.get(posicion).setEstado("INJUSTIFICADA");
                        btnFalta.setText("INJUSTIFICADA");
                        btnFalta.setBackgroundColor(Color.RED);
                    }else if (lista.get(posicion).getEstado().equals("INJUSTIFICADA")){
                        lista.get(posicion).setEstado("JUSTIFICADA");
                        btnFalta.setText("JUSTIFICADA");
                        btnFalta.setBackgroundColor(Color.GREEN);
                    }else if (lista.get(posicion).getEstado().equals("JUSTIFICADA")){
                        lista.get(posicion).setEstado("ASISTE");
                        btnFalta.setText("ASISTE");
                        btnFalta.setBackgroundColor(Color.GRAY);
                    }
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int posicion = getAdapterPosition();
                    Intent i = new Intent(contex, Actividad2.class);
                    i.putExtra("Foto", lista.get(posicion).getFoto());
                    i.putExtra("Nombre", lista.get(posicion).getNombre());
                    i.putExtra("Apellidos", lista.get(posicion).getApellidos());
                    i.putExtra("Domicilio", lista.get(posicion).getDomicilio());
                    i.putExtra("FechaNac", lista.get(posicion).getFechaNac());
                    i.putExtra("Edad", lista.get(posicion).getEdad());
                    i.putExtra("Estado", lista.get(posicion).getEstado());
                    contex.startActivity(i);
                }
            });

        }

        public void bind(Alumno alumno) {
            tvNombre.setText(alumno.getNombre());
            tvApellidos.setText(alumno.getApellidos());
            ivPerfil.setImageResource(alumno.getFoto());
        }
    }
}

