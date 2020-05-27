package com.example.proyecto.utilidades;

public class utilidadesGuardar {
    //tabla usuarios
    public static final String tabla_usuario="usuario";
    public static final String usuario="usuario";
    public static final String correo="correo";
    public static final String contraseña="contraseña";

    public static final String Create_Table_Usuario = "CREATE TABLE " + tabla_usuario
            +" ("+ usuario + " TEXT, "
            + correo + " TEXT, "
            + contraseña +" TEXT)";
}
