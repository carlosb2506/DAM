package com.example.ejercicio5;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdaptador extends RecyclerView.Adapter<RecyclerAdaptador.ViewHolder> {

    private ArrayList<Profesor> lista;

    public RecyclerAdaptador(ArrayList<Profesor> lista)
    {
        this.lista = lista;
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
        private TextView tvEstado;
        private TextView tvDepartamento;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvApellidos = itemView.findViewById(R.id.tvApellidos);
            tvEstado = itemView.findViewById(R.id.tvEstado);
            tvDepartamento = itemView.findViewById(R.id.tvDepartamento);
        }

        public void bind(Profesor profesor) {
            tvNombre.setText(profesor.getNombre());
            tvApellidos.setText(profesor.getApellidos());
            tvDepartamento.setText(profesor.getDepartamento());
            tvEstado.setText(profesor.getEstado());
        }
    }
}

