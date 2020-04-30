package com.example.proyecto.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto.R;
import com.example.proyecto.baseDatos.Personajes;

import java.util.ArrayList;


public class adaptadorPersonajes extends RecyclerView.Adapter<adaptadorPersonajes.PersonajesViewHolder> implements View.OnClickListener {

    ArrayList<Personajes> listaPersonajes;
    private View.OnClickListener listener;

    // genero un constructor de lista personajes
    public adaptadorPersonajes(ArrayList<Personajes> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    @NonNull
    @Override
    public PersonajesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_que_visitar, null, false);
        view.setOnClickListener(this);
// le asigno la item_list
        return new PersonajesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adaptadorPersonajes.PersonajesViewHolder holder, int position) {
        // mando los datos a la vista
        holder.txtNombres.setText(listaPersonajes.get(position).getNombre());
        holder.txtInformacion.setText(listaPersonajes.get(position).getInfo());
        holder.foto.setImageResource(listaPersonajes.get(position).getImagenId());
    }

    @Override
    public int getItemCount() {
        // retorno la lista
        return listaPersonajes.size();
    }

    // eventos para el click en el recycleview
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if ( listener != null ){
            listener.onClick(v);
        }
    }
    // eventos para el click en el recycleview

    public class PersonajesViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombres, txtInformacion;
        ImageView foto;

        public PersonajesViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombres = itemView.findViewById(R.id.txtNombre );
            txtInformacion = itemView.findViewById(R.id.txtInformacion );
            foto = itemView.findViewById(R.id.foto);
        }
    }
}
