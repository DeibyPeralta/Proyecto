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





    // constantes campos tabla eventos
    public static final String tabla_eventos ="eventos";

    public static final String nameEventos = "nameEventos";
    public static final String fechaInicio = "fechaInicio";
    public static final String fechaFin = "fechaFin";
    public static final String descripcion = "descripcion";
    public static final String estrellas = "estrellas";

    public static final String Create_Table_Eventos = "CREATE TABLE " + tabla_eventos
            + " ("+ nameEventos +" Text, "
            + fechaInicio +"text,"
            + fechaFin +"text,"
            + descripcion +"text,"
            + estrellas +" Text)";


    // constantes campos tabla actividades
    public static final String tabla_actividades ="actividades";

    public static final String nameActividad = "nameActividad";
    public static final String fecha = "fecha";
    public static final String descripcionActividad = "descripcion";
    public static final String Calificacion = "estrellas";

    public static final String Create_Table_Actividades = "CREATE TABLE " + tabla_actividades
            + " ("+ nameActividad +" Text, "
            + fecha +"text,"
            + descripcionActividad +"text,"
            + Calificacion +" Text)";



    // constantes campos tabla hoteles
    public static final String tabla_hoteles ="hoteles";

    public static final String nameHotel = "nameActividad";
    public static final String descripcionh = "descripcion";
    public static final String calificacion = "calificacion";
    public static final String direccion = "direccion";

    public static final String Create_Table_hoteles = "CREATE TABLE " + tabla_hoteles
            + " ("+ nameHotel +" Text, "
            + descripcionh +"text,"
            + calificacion +"text,"
            + direccion +" Text)";
}
