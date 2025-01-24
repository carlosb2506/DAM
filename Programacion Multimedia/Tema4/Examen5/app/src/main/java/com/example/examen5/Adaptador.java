package com.example.examen5;

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

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {
    private ArrayList<Entrenos> lista;
    private Context contexto;


    public Adaptador(ArrayList<Entrenos> lista) {
        this.lista = lista;
    }

    public void borrar(int posicion){
        lista.remove(posicion);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View vista = inflater.inflate(R.layout.layout_vh_entrenos, parent, false);
        ViewHolder holder = new ViewHolder(vista);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        private ImageView im_deporte;
        private TextView tv_deporte, tv_calorias, tv_fecha;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            im_deporte = itemView.findViewById(R.id.im_deporte);
            tv_deporte = itemView.findViewById(R.id.tv_deporte);
            tv_calorias = itemView.findViewById(R.id.tv_calorias);
            tv_fecha = itemView.findViewById(R.id.tv_fecha);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //int posicion = getAdapterPosition();
                    //Intent i = new Intent(contexto, DetalleRecetas.class);


                    //contexto.startActivity(i);
                }
            });

            itemView.setOnCreateContextMenuListener(this);


        }

        public void bind(int posicion)
        {
            im_deporte.setImageResource(lista.get(posicion).getFoto());
            tv_deporte.setText(lista.get(posicion).getDeporte());
            tv_calorias.setText(String.valueOf(lista.get(posicion).getCalorias()));
            tv_fecha.setText(lista.get(posicion).getFecha());
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle("Seleccione una de las opciones:");
            contextMenu.add(this.getAdapterPosition(), 121, 0, "Borrar");
            contextMenu.add(this.getAdapterPosition(), 122, 0, "Visualizar");
            contextMenu.add(this.getAdapterPosition(), 123, 0, "Crear un nuevo entrenamiento");
        }
    }
}
