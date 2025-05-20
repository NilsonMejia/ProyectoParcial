package edu.sv.catolica.ProyectoParcial.dto;

import org.springframework.data.jpa.repository.Query;

public class UsuarioDTO {
    private long usuarioID;
    private String nombre;
    private String apellido;
    private String email;

    public UsuarioDTO() {}

    public UsuarioDTO(long usuarioID, String nombre, String apellido, String email) {
        this.usuarioID = usuarioID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;


    }

    public long getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(long usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}