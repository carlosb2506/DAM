package com.example.ejercicio1;

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

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{

        private CheckBox cbMarcado;
        private ImageView ivImage;
        private TextView tvDispositivo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cbMarcado = itemView.findViewById(R.id.cbMarcado);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvDispositivo = itemView.findViewById(R.id.tvTexto);

            cbMarcado.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cbMarcado.isChecked())
                    {

                    }
                    else
                    {

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

    }
}
