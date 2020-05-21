package com.example.proyecto.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyecto.R;
import com.example.proyecto.adaptadores.adaptadorVisitar;
import com.example.proyecto.informacionPrueba.informacion;

import java.util.ArrayList;

import com.example.proyecto.interfaxex.IComunicaFragments;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EventosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<informacion> listaInformacion;
    RecyclerView recyclerPersonajes;
    Activity activityx;
    IComunicaFragments interfaceComunicaFragments;

    public EventosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventosFragment newInstance(String param1, String param2) {
        EventosFragment fragment = new EventosFragment();
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
        View vista = inflater.inflate(R.layout.fragment_eventos, container, false);

        listaInformacion = new ArrayList<>(); // generar la lista
        recyclerPersonajes = vista.findViewById(R.id.recyclerId);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(getContext()));// getContext porque estamos en un fragment

        llenarListaPersonajes();
        adaptadorVisitar adapter = new adaptadorVisitar(listaInformacion);
        recyclerPersonajes.setAdapter(adapter);

        adapter.setOnClicListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Selecciona; "+listaInformacion.get(recyclerPersonajes.getChildAdapterPosition(v)).getNombre(), Toast.LENGTH_SHORT).show();

                // envio detalles por medio de interfacecomuncation
              //  interfaceComunicaFragments.enviarPersonajes(listaInformacion.get(recyclerPersonajes.getChildAdapterPosition(v)));
            }
        });

        return vista;
    }



    private void llenarListaPersonajes() {
        listaInformacion.add(new informacion("Chemesquemena", "Chemesquemena es uno de los 26 corregimientos del municipio colombiano de Valledupar y una de las comunidades que integran el Resguardo indígena Kankuamo, ubicada al norte, en la parte alta de las montañas de la Sierra Nevada de Santa Marta, en el departamento del Cesar", R.drawable.chemesquemena));
        // para mostrar mas solo copy paste
    }



}
