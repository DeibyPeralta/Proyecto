package com.example.proyecto.fragments.parques;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyecto.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankNovalito extends Fragment {

    public BlankNovalito() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_novalito, container, false);
    }
}