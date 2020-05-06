package com.example.proyecto.utilidades;

public class dbUtilidades {
    // constantes campos tabla usuario
    public static final String tabla_usuario ="usuarios";

   // public static final String campo_id ="id";
    public static final String campo_nombre = "nameUsuario";
    public static final String campo_correo = "correo";
    public static final String campo_password = "password";

    public static final String Create_Table_Usuario = "CREATE TABLE " + tabla_usuario
            + " ("+ campo_nombre +" Text, "
            + campo_correo +"text,"
            + campo_password +" Text)";

}
