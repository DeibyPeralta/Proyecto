package com.example.proyecto.adaptadores;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class adapterSeccionesQueHacer extends FragmentStatePagerAdapter {

    private final List<Fragment> listaFragments= new ArrayList<>();
    private final List<String> listaTitulos= new ArrayList<>();

    public adapterSeccionesQueHacer(@NonNull FragmentManager fm) {
        super(fm);
    }

    public void addFragments(Fragment fragment, String titulo){
        listaFragments.add(fragment);
        listaTitulos.add(titulo);

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listaTitulos.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listaFragments.get(position);
    }

    @Override
    public int getCount() {// cuantos fragments o pestañas mostrare
        return listaFragments.size();
    }
}
