package com.example.proyecto.baseDatos;

import java.io.Serializable;

public class dbActividades implements Serializable {
    private String nameActividad;
    private String fecha;
    private String descripcion;
    private String estrellas;

    public dbActividades(){

    }

    public dbActividades(String nameActividad, String fecha, String descripcion, String estrellas) {
        this.nameActividad = nameActividad;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.estrellas = estrellas;
    }

    public String getNameActividad() {
        return nameActividad;
    }

    public void setNameActividad(String nameActividad) {
        this.nameActividad = nameActividad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(String estrellas) {
        this.estrellas = estrellas;
    }
}
