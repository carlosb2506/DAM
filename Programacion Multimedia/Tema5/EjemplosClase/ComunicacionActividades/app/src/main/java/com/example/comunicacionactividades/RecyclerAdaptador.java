package com.example.comunicacionactividades;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.DrawerLayoutUtils;

import java.util.ArrayList;

public class RecyclerAdaptador extends RecyclerView.Adapter<RecyclerAdaptador.ViewHolder> {
    private ArrayList<Recetas> lista;
    private Context contexto;

    public RecyclerAdaptador(ArrayList<Recetas> lista, Context contexto) {
        this.lista = lista;
        this.contexto = contexto;
    }

    public String borrar(int posicion)
    {
        String nombre = lista.get(posicion).getNombre();
        lista.remove(posicion);
        notifyDataSetChanged();
        return nombre;
    }
    public void crear(Recetas receta){
        lista.add(receta);
        notifyDataSetChanged();
    }

    public Recetas devolverReceta(int posicion)
    {
        return lista.get(posicion);
    }

    public Recetas modificarReceta(int posicion, int duracion, String pasos)
    {
        Recetas receta = null;
        if (posicion != -1)
        {
            receta = lista.get(posicion);
            receta.setPasos(pasos);
            receta.setTiempo(duracion);
            lista.set(posicion, receta);
            notifyDataSetChanged();
        }
        return receta;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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
        private TextView tv_receta, tv_duracion, tv_dificultad;
        private ImageView im_recetas;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_receta = itemView.findViewById(R.id.tv_receta);
            tv_duracion = itemView.findViewById(R.id.tv_duracion);
            tv_dificultad = itemView.findViewById(R.id.tv_dificultad);
            im_recetas = itemView.findViewById(R.id.im_receta);

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

        public void bind (int posicion)
        {
            tv_receta.setText(lista.get(posicion).getNombre());
            tv_duracion.setText(String.valueOf(lista.get(posicion).getTiempo()));
            tv_dificultad.setText(lista.get(posicion).getDificultad());
            im_recetas.setImageResource(lista.get(posicion).getFoto());
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle("Seleccione una de las opciones:");
            contextMenu.add(this.getAdapterPosition(), 121, 0, "Borrar");
            contextMenu.add(this.getAdapterPosition(), 122, 0, "Modificar");
            contextMenu.add(this.getAdapterPosition(),123,0,"Crear");
        }
    }
}
