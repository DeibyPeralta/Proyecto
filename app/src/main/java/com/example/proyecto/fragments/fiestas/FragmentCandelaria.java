package com.example.proyecto.fragments.fiestas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.proyecto.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCandelaria extends Fragment {

    public FragmentCandelaria() {
        // Required empty public constructor
    }

    ToggleButton asistirx;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_candelaria, container, false);
    }

    public void asistir(View view){
        Toast.makeText(getContext(), "sfasdfsdf", Toast.LENGTH_SHORT).show();
    }
}
