package com.example.proyecto.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyecto.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentParques extends Fragment {

    public FragmentParques() {
        // Required empty public constructor
    }

    View vista;
    CardView helado, leyendaVallenata, novalito, cortijos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vista = inflater.inflate(R.layout.fragment_parques, container, false);

        helado = vista.findViewById(R.id.heladox);
        helado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.blankHelado);
            }
        });

        leyendaVallenata = vista.findViewById(R.id.leyenda);
        leyendaVallenata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.blankLeyendaVallenata);
            }
        });

        novalito = vista.findViewById(R.id.novalito);
        novalito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.blankNovalito);
            }
        });

        cortijos = vista.findViewById(R.id.cortijos);
        cortijos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.blankCortijos);
            }
        });

        return vista;
    }
}
