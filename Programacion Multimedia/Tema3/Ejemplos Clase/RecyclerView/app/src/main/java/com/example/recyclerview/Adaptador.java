package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.RecyclerAdaptadorViewHolder> {
    private ArrayList<Persona> lista;

    public Adaptador(ArrayList<Persona> lista) {
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

        private TextView tvNombre;
        private TextView tvApellido;

        public RecyclerAdaptadorViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvApellido = itemView.findViewById(R.id.tvApellido);
        }

        public void bind (int posicion)
        {
            tvNombre.setText(lista.get(posicion).getNombre());
            tvApellido.setText(lista.get(posicion).getApellido());
        }


    }

}
