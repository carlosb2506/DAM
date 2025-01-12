package com.example.ejercicio3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdaptador extends RecyclerView.Adapter<RecyclerAdaptador.ViewHolder> {

    private ArrayList<Bar> lista;

    // Constructor
    public RecyclerAdaptador(ArrayList<Bar> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View vista = layoutInflater.inflate(R.layout.layout_restaurantes, parent, false);
        return new ViewHolder(vista); // Simplificado
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(lista.get(position)); // Pasar el objeto Parking directamente
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    // ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNombre;
        private TextView tvDireccion;
        private ImageView ivBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            ivBar = itemView.findViewById(R.id.ivBar);
        }

        // Metodo bind actualizado
        public void bind(Bar bar) {
            tvNombre.setText(bar.getNombre());
            tvDireccion.setText(bar.getDireccion());
            ivBar.setImageResource(bar.getFoto());
        }
    }
}

