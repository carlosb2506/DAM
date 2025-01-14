package com.example.ejercicio1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdaptador extends RecyclerView.Adapter<RecyclerAdaptador.ViewHolder> {

    private ArrayList<Parking> lista;

    public RecyclerAdaptador(ArrayList<Parking> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View vista = layoutInflater.inflate(R.layout.layout_parking, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.bind(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvUbi;
        private ImageView imIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvUbi = itemView.findViewById(R.id.tvUbi);
            imIcon = itemView.findViewById(R.id.imIcon);
        }

        public void bind(Parking parking) {
            tvUbi.setText(parking.getUbicacion());
            imIcon.setImageResource(parking.getIcono());
        }
    }
}

