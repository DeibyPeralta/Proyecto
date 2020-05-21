package com.example.proyecto.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto.R;
import com.example.proyecto.informacionPrueba.informacion;

import java.util.ArrayList;

public class adaptadorVisitar extends RecyclerView.Adapter<adaptadorVisitar.informacionViewHolder> implements View.OnClickListener{

    ArrayList<informacion> listainformacion;
    private View.OnClickListener listener;

    public adaptadorVisitar(ArrayList<informacion> listaPersonajes) {
        this.listainformacion=listaPersonajes;
    }

    public class informacionViewHolder extends RecyclerView.ViewHolder{
        TextView txtNombre, txtInformacion;
        ImageView foto;
        public informacionViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtInformacion = itemView.findViewById(R.id.txtInformacion);
            foto = itemView.findViewById(R.id.foto);
        }
    }

    @Override
    public void onClick(View view) {
        if( listener != null ){
            listener.onClick(view);
        }
    }

    @NonNull
    @Override// aca mando la lista al reciclerView
    public informacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_que_visitar, null, false);
        view.setOnClickListener(this);
        return new informacionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adaptadorVisitar.informacionViewHolder holder, int position) {
        holder.txtNombre.setText(listainformacion.get(position).getNombre());
        holder.txtInformacion.setText(listainformacion.get(position).getInfo());
        holder.foto.setImageResource(listainformacion.get(position).getImagenId());
    }

    @Override
    public int getItemCount() {
        return listainformacion.size();
    }

    public void setOnClicListener(View.OnClickListener listener){
        this.listener = listener;
    }

}
