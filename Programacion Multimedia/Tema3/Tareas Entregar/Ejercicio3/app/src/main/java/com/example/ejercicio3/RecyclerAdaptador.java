package com.example.ejercicio3;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdaptador extends RecyclerView.Adapter<RecyclerAdaptador.ViewHolder>{

    private ArrayList<Publicacion> lista;

    public RecyclerAdaptador(ArrayList<Publicacion> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View vista = layoutInflater.inflate(R.layout.layoutpublicaciones, parent, false);
        ViewHolder viewHolder = new ViewHolder(vista);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    //Borro el elemento de la lista
    public void borrar(int posicion){
        lista.remove(posicion);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener
    {
        private TextView tv_numLikes;
        private ImageView iv_publicacion;
        private ImageView iv_icono;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_numLikes = itemView.findViewById(R.id.tv_numLikes);
            iv_publicacion = itemView.findViewById(R.id.iv_publicacion);
            iv_icono = itemView.findViewById(R.id.iv_icono);
            itemView.setOnCreateContextMenuListener(this);
        }

        public void bind(int posicion)
        {
            tv_numLikes.setText("" + lista.get(posicion).getNumLikes());
            iv_publicacion.setImageResource(lista.get(posicion).getPublicacion());
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle("Elija una opción");
            contextMenu.add(this.getAdapterPosition(), 100, 0, "Borrar");
        }
    }
}
