package com.example.proyecto.baseDatos;

import java.io.Serializable;

public class dbUsuarios implements Serializable {

    private Integer id;
    private String nameUsuario;
    private String correo;
    private String password;

    public dbUsuarios(){

    }

    public dbUsuarios(int id, String nameUsuario, String correo, String password) {
        this.id = id;
        this.nameUsuario = nameUsuario;
        this.correo = correo;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameUsuario() {
        return nameUsuario;
    }

    public void setNameUsuario(String nameUsuario) {
        this.nameUsuario = nameUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
