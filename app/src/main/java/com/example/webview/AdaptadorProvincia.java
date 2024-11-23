package com.example.webview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorProvincia extends RecyclerView.Adapter<AdaptadorProvincia.HolderProvincia> {
   Context contexto;

   List<Provincia> dataSet;

    public AdaptadorProvincia(List<Provincia> listaProvincias) {
        this.dataSet = listaProvincias;
    }

    @NonNull
    @Override
    public AdaptadorProvincia.HolderProvincia onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        contexto = parent.getContext();
        View view = LayoutInflater.from(contexto).inflate(R.layout.item_provincia,parent,false);
        return new HolderProvincia(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorProvincia.HolderProvincia holder, int position) {
        Provincia provincia = dataSet.get(position);
        holder.imgImagen.setImageResource(provincia.getImagen());
        holder.txtNombre.setText(provincia.getNombre());
        holder.txtNumHab.setText(String.valueOf(provincia.getNumHabitantes()));
        holder.txtMunicipio.setText(provincia.getMunicipio());

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://es.wikipedia.org/wiki/" + provincia.getNombre();

                Intent intent = new Intent(contexto, WebViewActivity.class);
                intent.putExtra("direccion",url);
                contexto.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class HolderProvincia extends RecyclerView.ViewHolder{
        ImageView imgImagen;
        TextView txtNombre;
        TextView txtNumHab;
        TextView txtMunicipio;
        CardView card;

        public HolderProvincia(@NonNull View itemView) {
            super(itemView);
            imgImagen = itemView.findViewById(R.id.imgProvincia);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtNumHab = itemView.findViewById(R.id.txtNumHab);
            txtMunicipio = itemView.findViewById(R.id.txtMunicipio);
            card = itemView.findViewById(R.id.card);
         }
    }
}
