package com.example.recetario;

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
    private ArrayList<Recetas> lista;

    private Context contexto;

    public RecyclerAdaptador(ArrayList<Recetas> lista, Context contexto) {
        this.lista = lista;
        this.contexto = contexto;
    }

    public void borrar(int posicion){
        lista.remove(posicion);
        notifyDataSetChanged();
    }

    public Recetas devolverRecetas(int posicion){
        return lista.get(posicion);
    }

    public void modificarReceta(int posicion,int duracion,String pasos)
    {
        Recetas receta = lista.get(posicion);
        receta.setPasos(pasos);
        receta.setTiempo(duracion);
        lista.set(posicion, receta);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_viewholder, parent, false);
        ViewHolder holder = new ViewHolder(view);
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

        private TextView tvReceta, tvDuracion, tvDificultad;
        private ImageView imReceta;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvReceta = itemView.findViewById(R.id.tvReceta);
            tvDuracion = itemView.findViewById(R.id.tvDuracion);
            tvDificultad = itemView.findViewById(R.id.tvDificultad);
            imReceta = itemView.findViewById(R.id.imReceta);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int posicion = getAdapterPosition();
                    Intent i = new Intent(contexto, DetalleRecetas.class);

                    i.putExtra("Nombre", lista.get(posicion).getNombre());
                    i.putExtra("Foto", lista.get(posicion).getFoto());
                    i.putExtra("Pasos", lista.get(posicion).getPasos());

                    contexto.startActivity(i);
                }
            });

            itemView.setOnCreateContextMenuListener(this);
        }

        public void bind(int posicion){
            tvReceta.setText(lista.get(posicion).getNombre());
            tvDuracion.setText( String.valueOf(lista.get(posicion).getTiempo()));
            tvDificultad.setText(lista.get(posicion).getDificultad());
            imReceta.setImageResource(lista.get(posicion).getFoto());
        }


        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle("Seleccione una de las opciones:");
            contextMenu.add(this.getAdapterPosition(), 121, 0, "Borrar");
            contextMenu.add(this.getAdapterPosition(), 122, 0, "Modificar");
        }
    }
}

