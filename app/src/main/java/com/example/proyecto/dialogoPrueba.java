package com.example.proyecto;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class dialogoPrueba extends DialogFragment {

    public static final String argumentoTitulo = "Title";
    public static final String argumentoFullSnipper = "full_snipper";

    public String title;
    public String fullSnipper;

    public static dialogoPrueba newInstance(String title, String fullSnipper){
        dialogoPrueba fragmentDialog= new dialogoPrueba();

        Bundle b = new Bundle();
        b.putString(argumentoTitulo, title);
        b.putString(argumentoFullSnipper, fullSnipper);
        fragmentDialog.setArguments(b);
            return fragmentDialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle argumentos = getArguments();

        title = argumentos.getString(argumentoTitulo);
        fullSnipper = argumentos.getString(argumentoFullSnipper);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        Dialog dialogx = new AlertDialog.Builder(getActivity()).setTitle(title).setMessage(fullSnipper).create();

        return dialogx;
    }
}
