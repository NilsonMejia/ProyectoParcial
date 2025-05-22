package edu.sv.catolica.ProyectoParcial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioDTO {
    private long UsuarioID;
    private String Nombre;
    private String Apellido;
    private String Email;
    private Boolean Estado;

}