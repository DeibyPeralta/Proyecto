package com.example.proyecto.baseDatos;

import java.io.Serializable;

public class dbHoteles implements Serializable {

    private String nameHotel;
    private String descripcion;
    private String calificacion;
    private String direccion;

    public dbHoteles(){

    }

    public dbHoteles(String nameHotel, String descripcion, String calificacion, String direccion) {
        this.nameHotel = nameHotel;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
        this.direccion = direccion;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


}
