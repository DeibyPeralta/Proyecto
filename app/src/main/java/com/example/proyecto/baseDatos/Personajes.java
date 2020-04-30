package com.example.proyecto.baseDatos;

import java.io.Serializable;

public class Personajes implements Serializable { // serializable es para transportar un objeto de fragment a otro
    private String nombre;
    private String info;
    private int imagenId;

    // descripcion larga y foto
    private String descripcion;
    private int imagenDetalles;

    public Personajes(){
    }

    public Personajes(String nombre, String info, int imagenId, String descripcion, int imagenDetalles) {
        this.nombre = nombre;
        this.info = info;
        this.imagenId = imagenId;
        this.descripcion = descripcion;
        this.imagenDetalles = imagenDetalles;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagenDetalles() {
        return imagenDetalles;
    }

    public void setImagenDetalles(int imagenDetalles) {
        this.imagenDetalles = imagenDetalles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}
