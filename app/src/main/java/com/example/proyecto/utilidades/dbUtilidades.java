package com.example.proyecto.utilidades;

public class dbUtilidades {
    // constantes campos tabla usuario
    public static final String tabla_usuario ="usuarios";

    public static final String usuario = "nameUsuario";
    public static final String correo = "correo";
    public static final String contraseña = "password";

    public static final String Create_Table_Usuario = "CREATE TABLE " + tabla_usuario
            + " ("+ usuario +" Text, "
            + correo +"text,"
            + contraseña +" Text)";

}
