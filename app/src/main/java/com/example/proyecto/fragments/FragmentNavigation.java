package com.example.proyecto.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
public class FragmentNavigation extends Fragment {

    public FragmentNavigation() {
        // Required empty public constructor
    }

    CardView cardMonumentos, cardParques, cardBalnearios, cardSitios;
    View vista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista =  inflater.inflate(R.layout.fragment_navigation, container, false);

        cardMonumentos = vista.findViewById(R.id.monumentosCard);
        cardMonumentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.fragmentCaminatas3);
            }
        });

        cardSitios = vista.findViewById(R.id.sitiosCard);
        cardSitios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.fragmentNadar2);
            }
        });

        cardParques = vista.findViewById(R.id.parquesCard);
        cardParques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.fragmentParques);
            }
        });

        return vista;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
     /*   Button caminata = view.findViewById(R.id.caminatax);
        Button nadar = view.findViewById(R.id.nadarx);
        Button sitios = view.findViewById(R.id.sitios);
        Button monumentos = view.findViewById(R.id.monumentos);

        final NavController navControlador = Navigation.findNavController(view);

        caminata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navControlador.navigate(R.id.fragmentCaminatas3);
            }
        });

        nadar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navControlador.navigate(R.id.fragmentNadar2);
            }
        });
*/
    }
}
