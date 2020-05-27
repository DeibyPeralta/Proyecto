package com.example.proyecto.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyecto.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentNadar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentNadar extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentNadar() {
        // Required empty public constructor
    }


    public static FragmentNadar newInstance(String param1, String param2) {
        FragmentNadar fragment = new FragmentNadar();
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

    View vista;
    CardView plaza, loperena, mayo, gobernacion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vista = inflater.inflate(R.layout.fragment_nadar, container, false);

        plaza = vista.findViewById(R.id.plazaAl);
        plaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.blankPlaza);
            }
        });

        loperena = vista.findViewById(R.id.loperena);
        loperena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.blankLoperena);
            }
        });

        mayo = vista.findViewById(R.id.mayoPlaza);
        mayo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.blankMayo);
            }
        });

        gobernacion = vista.findViewById(R.id.gobernacion);
        gobernacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.blankGobernacion);
            }
        });
        return vista;
    }
}
