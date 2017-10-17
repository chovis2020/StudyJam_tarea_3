package com.gdgandroidbolivia.nombredeflores;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Yolanda on 16/10/2017.
 */

public class NombreAdapter extends RecyclerView.Adapter<NombreAdapter.NombreViewholder>{

    List<Flor> dataset;
    Context context;
    onNombreSelectedListener onNombreSelectedListener;

    public interface onNombreSelectedListener{
        void onNombreSelected(Flor flor);
    }

    public NombreAdapter(Context context, onNombreSelectedListener onNombreSelectedListener) {
        this.context = context;
        this.dataset = new ArrayList<>();
        this.onNombreSelectedListener = onNombreSelectedListener;
    }

    public NombreViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flor,parent,false);
        return new NombreViewholder(view);
    }

    public void onBindViewHolder(NombreViewholder holder, int position) {
        Flor flor = dataset.get(position);
        holder.nombre.setText(flor.getNombre());
        holder.imagen.setImageResource(flor.getImagen());

        holder.setOnNombreSelectedListener(flor, onNombreSelectedListener);
    }

    public int getItemCount() {
        return dataset.size();
    }

    public class NombreViewholder extends RecyclerView.ViewHolder {

        View cardView;
        ImageView imagen;
        TextView nombre;

        public NombreViewholder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_main);
            imagen = itemView.findViewById(R.id.imagen_item);
            nombre = itemView.findViewById(R.id.texto_item);
        }

        public void setOnNombreSelectedListener(final Flor flor, final onNombreSelectedListener onNombreSelectedListener) {
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onNombreSelectedListener.onNombreSelected(flor);
                }
            });
        }
    }

    public void setDataset(List<Flor> flor) {
        if (flor == null){
            dataset = new ArrayList<>();
        }
        else{
            dataset = flor;
        }
        notifyDataSetChanged();
    }

}
