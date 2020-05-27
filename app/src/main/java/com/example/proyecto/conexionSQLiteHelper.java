package com.example.proyecto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.proyecto.utilidades.dbUtilidades;

public class conexionSQLiteHelper extends SQLiteOpenHelper {
    public conexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override// genera las tablas
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(dbUtilidades.Create_Table_Usuario);
    }

    @Override// verifica que no exista una version de la db
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuario");
        onCreate(db);
    }
}
