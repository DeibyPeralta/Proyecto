package com.example.proyecto.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyecto.R;
import com.example.proyecto.adaptadores.adaptadorPersonajes;
import com.example.proyecto.baseDatos.Personajes;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaPersonajesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaPersonajesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<Personajes> listaPersonajes;
    RecyclerView recyclerPersonajes;
    Activity activityx;

    public ListaPersonajesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaPersonajesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaPersonajesFragment newInstance(String param1, String param2) {
        ListaPersonajesFragment fragment = new ListaPersonajesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // necesario para mostrar la lista en el fragment
        View vista = inflater.inflate(R.layout.fragment_lista_personajes, container, false);

        listaPersonajes = new ArrayList<>(); // generar la lista
        recyclerPersonajes = vista.findViewById(R.id.recyclerId);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(getContext()));// getContext porque estamos en un fragment

        llenarListaPersonajes();
        adaptadorPersonajes adapter = new adaptadorPersonajes(listaPersonajes);
        recyclerPersonajes.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Selecciona; "+listaPersonajes.get(recyclerPersonajes.getChildAdapterPosition(v)).getNombre(), Toast.LENGTH_SHORT).show();

            }
        });

        return vista;
    }

    private void llenarListaPersonajes() {
        listaPersonajes.add(new Personajes("La mina", getString(R.string.laMina), R.drawable.la_mina,"Goku es un personaje de tragon ball super", R.drawable.ic_launcher_background));

        listaPersonajes.add(new Personajes("Atanquez", getString(R.string.pruebaAtanques), R.drawable.atanques,"Goku es un personaje de tragon ball super", R.drawable.ic_launcher_background));

        listaPersonajes.add(new Personajes("Chemesquemena", "Goku es un personaje de tragon ball super", R.drawable.chemesquemenax,"Goku es un personaje de tragon ball super", R.drawable.ic_launcher_background));

        listaPersonajes.add(new Personajes("chemesquemena", "Goku es un personaje de tragon ball super", R.drawable.chemesquemena,"Goku es un personaje de tragon ball super", R.drawable.ic_launcher_background));

        listaPersonajes.add(new Personajes("atanques", getString(R.string.pruebaAtanques), R.drawable.atanquez,"Goku es un personaje de tragon ball super", R.drawable.ic_launcher_background));

        // para mostrar mas solo copy paste
    }


}
