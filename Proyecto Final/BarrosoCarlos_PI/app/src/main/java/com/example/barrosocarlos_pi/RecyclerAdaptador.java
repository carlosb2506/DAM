package com.example.barrosocarlos_pi;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdaptador extends RecyclerView.Adapter<RecyclerAdaptador.ViewHolder> {

    private ArrayList<Reservas> lista;

    public RecyclerAdaptador(ArrayList<Reservas> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
         View vista = layoutInflater.inflate(R.layout.layout_reservas, parent, false);
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
        private TextView tvNombre, tvDireccion;
        private ImageView ivFoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            ivFoto = itemView.findViewById(R.id.ivFoto);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int posicion = getAdapterPosition();
                    Intent i = new Intent(itemView.getContext(), DetallesPista.class);

                    i.putExtra("Nombre", lista.get(posicion).getNombre());
                    i.putExtra("Foto", lista.get(posicion).getFoto());
                    i.putExtra("Direccion", lista.get(posicion).getDireccion());
                    itemView.getContext().startActivity(i);
                }
            });
        }

        public void bind(Reservas reservas) {
            tvNombre.setText(reservas.getNombre());
            tvDireccion.setText(reservas.getDireccion());
            ivFoto.setImageResource(reservas.getFoto());
        }
    }
}
