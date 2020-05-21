package com.example.proyecto.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener;
import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyecto.adaptadores.adapterSeccionesQueHacer;
import com.example.proyecto.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContenedorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContenedorFragment extends Fragment {

    View vista;
    private AppBarLayout appBar;
    private TabLayout pestañas;
    private ViewPager viewPagerx;

    public ContenedorFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ContenedorFragment newInstance(String param1, String param2) {
        ContenedorFragment fragment = new ContenedorFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           // mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_contenedor, container, false);

        View parentx = (View) container.getParent();

        pestañas = new TabLayout(getActivity());

        // logica de navegacion con el gesto de arrastre del dedo
        viewPagerx = vista.findViewById(R.id.ViewPaperInformacion);

        llenarNewPaginas(viewPagerx);

        // evento arrastrar dedo por pantalla
        viewPagerx.addOnAdapterChangeListener(new SimpleOnPageChangeListener(){});

        return vista;
    }

    private void llenarNewPaginas(ViewPager viewPagerx) {
        adapterSeccionesQueHacer adaptador= new adapterSeccionesQueHacer(getChildFragmentManager());
        adaptador.addFragments(new FragmentPiscina(), "piscina");
        adaptador.addFragments(new FragmentCaminata(), "Caminata");

        viewPagerx.setAdapter(adaptador);
    }

}
