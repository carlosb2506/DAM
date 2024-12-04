package com.example.recyclerviewejemplo;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdaptador extends RecyclerView.Adapter<RecyclerAdaptador.RecyclerAdaptadorViewHolder> {
    private ArrayList<Persona> lista;

    public RecyclerAdaptador(ArrayList<Persona> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public RecyclerAdaptadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View vista = layoutInflater.inflate(R.layout.layout_persona, parent, false);
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
        private TextView tv_nombre;
        private TextView tv_apellido;

        public RecyclerAdaptadorViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nombre = itemView.findViewById(R.id.tv_nombre);
            tv_apellido = itemView.findViewById(R.id.tv_apellido);
        }

        public void bind (int posicion)
        {
            tv_nombre.setText(lista.get(posicion).getNombre());
            tv_apellido.setText(lista.get(posicion).getApellido());
        }
    }
}
