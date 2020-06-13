package com.example.proyecto.baseDatos;

import java.io.Serializable;

public class dbEventos implements Serializable {

    private String nameEvento;
    private String fechaInicio;
    private String fechaFin;
    private String descripcion;
    private String estrellas;

    public dbEventos(){

    }

    public dbEventos(String nameEvento, String fechaInicio, String fechaFin, String descripcion, String estrellas) {
        this.nameEvento = nameEvento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.estrellas = estrellas;
    }

    public String getNameEvento() {
        return nameEvento;
    }

    public void setNameEvento(String nameEvento) {
        this.nameEvento = nameEvento;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
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
