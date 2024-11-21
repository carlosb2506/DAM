package com.example.ejercicio1;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdaptador extends RecyclerView.Adapter<RecyclerAdaptador.ViewHolder> {

    private ArrayList<Dispositivos> lista;

    public RecyclerAdaptador(ArrayList<Dispositivos> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View vista = layoutInflater.inflate(R.layout.dispositivos, parent, false);
        ViewHolder viewHolder = new ViewHolder(vista);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    //Borrar el elemento de la lista
    public void borrar(int posicion){
        lista.remove(posicion);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        private CheckBox cbMarcado;
        private ImageView ivImage;
        private TextView tvDispositivo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cbMarcado = itemView.findViewById(R.id.cbMarcado);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvDispositivo = itemView.findViewById(R.id.tvTexto);
            itemView.setOnCreateContextMenuListener(this);

            cbMarcado.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (cbMarcado.isChecked())
                    {
                        lista.get(position).setMarcado(true);
                    }
                    else
                    {
                        lista.get(position).setMarcado(false);
                    }
                }
            });
        }

        public void bind(int posicion)
        {

            cbMarcado.setChecked(lista.get(posicion).isMarcado());
            ivImage.setImageResource(lista.get(posicion).getFoto());
            tvDispositivo.setText(lista.get(posicion).getDispositivo());
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle("Elija una opción");
            contextMenu.add(this.getAdapterPosition(),100,0,"Borrar");
        }
    }
}
