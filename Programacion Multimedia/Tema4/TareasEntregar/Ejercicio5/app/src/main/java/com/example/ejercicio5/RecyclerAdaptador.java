package com.example.ejercicio5;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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

    private ArrayList<Profesor> lista;
    private Context contex;

    public RecyclerAdaptador(ArrayList<Profesor> lista, Context context)
    {
        this.lista = lista;
        this.contex = context;
    }

    public void borrar(int posicion){
        lista.remove(posicion);
        notifyDataSetChanged();
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


    public void modificar(Profesor profesor, int posicion){
        lista.set(posicion, profesor);
        notifyDataSetChanged();
    }

    public Profesor profe (int posicion){
        return lista.get(posicion);
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        private TextView tvNombre;
        private TextView tvApellidos;
        private TextView tvEstado;
        private TextView tvDepartamento;
        private ImageView ivPerfil;

        public ViewHolder(@NonNull View itemView)  {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvApellidos = itemView.findViewById(R.id.tvApellidos);
            tvEstado = itemView.findViewById(R.id.tvEstado);
            tvDepartamento = itemView.findViewById(R.id.tvDepartamento);
            ivPerfil = itemView.findViewById(R.id.ivPerfil);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int posicion = getAdapterPosition();
                    Intent i = new Intent(contex, Actividad3.class);
                    i.putExtra("foto", lista.get(posicion).getFoto());
                    i.putExtra("nombre", lista.get(posicion).getNombre());
                    i.putExtra("apellidos", lista.get(posicion).getApellidos());
                    i.putExtra("domicilio", lista.get(posicion).getDomicilio());
                    i.putExtra("departamento", lista.get(posicion).getDepartamento());
                    i.putExtra("estado", lista.get(posicion).getEstado());
                    i.putExtra("materias", lista.get(posicion).getMaterias());
                    contex.startActivity(i);
                }
            });

            itemView.setOnCreateContextMenuListener(this);

        }

        public void bind(Profesor profesor)
        {
            ivPerfil.setImageResource(profesor.getFoto());
            tvNombre.setText(profesor.getNombre());
            tvApellidos.setText(profesor.getApellidos());
            tvDepartamento.setText(profesor.getDepartamento());
            tvEstado.setText(profesor.getEstado());
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle("Seleccione una opción:");
            contextMenu.add(this.getAdapterPosition(), 121, 0, "Borrar");
            contextMenu.add(this.getAdapterPosition(), 122, 0, "Modificar");
        }
    }
}

