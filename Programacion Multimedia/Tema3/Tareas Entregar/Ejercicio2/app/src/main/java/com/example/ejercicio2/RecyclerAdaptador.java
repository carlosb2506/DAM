package com.example.ejercicio2;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdaptador extends RecyclerView.Adapter<RecyclerAdaptador.RecyclerAdaptadorViewHolder> {
    private ArrayList<Tareas> lista;

    public RecyclerAdaptador(ArrayList<Tareas> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public RecyclerAdaptadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View vista = layoutInflater.inflate(R.layout.layouttareas, parent, false);
        RecyclerAdaptadorViewHolder viewHolder = new RecyclerAdaptadorViewHolder(vista);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdaptadorViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class RecyclerAdaptadorViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tvTarea;
        private TextView tvHoras;
        private TextView tvNombres;
        private ToggleButton tbHecha;

        public RecyclerAdaptadorViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTarea = itemView.findViewById(R.id.tvTarea);
            tvHoras = itemView.findViewById(R.id.tvHoras);
            tvNombres = itemView.findViewById(R.id.tvNombres);
            tbHecha = itemView.findViewById(R.id.tbHecha);

            tbHecha.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tbHecha.isChecked()){
                        tbHecha.setBackgroundColor(Color.GREEN);
                    }else
                    {
                        tbHecha.setBackgroundColor(Color.RED);
                    }
                }
            });

        }

        public void bind (int posicion)
        {
            tvTarea.setText(lista.get(posicion).getTareas());
            tvHoras.setText(lista.get(posicion).getHoras());
            tvNombres.setText(lista.get(posicion).getNombres());
            tbHecha.setChecked(lista.get(posicion).getTbHecha());
            if (tbHecha.isChecked()){
                tbHecha.setBackgroundColor(Color.GREEN);
            }else
            {
                tbHecha.setBackgroundColor(Color.RED);
            }
        }
    }
}
