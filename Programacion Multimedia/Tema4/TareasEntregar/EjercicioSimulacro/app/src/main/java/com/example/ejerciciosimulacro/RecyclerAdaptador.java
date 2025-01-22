package com.example.ejerciciosimulacro;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdaptador extends RecyclerView.Adapter<RecyclerAdaptador.ViewHolder> {

    private ArrayList<Jugador> lista;

    public RecyclerAdaptador(ArrayList<Jugador> lista) {
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

    public Jugador jug(int posicion) {
        return lista.get(posicion);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNombre, tvApellidos, tvEstado, tvDorsal;
        private ImageView ivPerfil;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvApellidos = itemView.findViewById(R.id.tvApellidos);
            tvEstado = itemView.findViewById(R.id.tvEstado);
            tvDorsal = itemView.findViewById(R.id.tvDorsal);
            ivPerfil = itemView.findViewById(R.id.ivPerfil);

        }

        public void bind(Jugador jug) {
            ivPerfil.setImageResource(jug.getFoto());
            tvNombre.setText(jug.getNombre());
            tvApellidos.setText(jug.getApellidos());
            tvDorsal.setText(String.valueOf(jug.getDorsal()));
            tvEstado.setText(jug.getEstado());
        }
    }
}


