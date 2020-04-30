package com.example.proyecto.baseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbPrueba extends SQLiteOpenHelper{

    // constructor
    public dbPrueba(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase DataBase) {
        DataBase.execSQL("create table Usuarios(codigo int primary key AUTOINCREMENT, nombre text, correo text, clave text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
