package edu.sv.catolica.ProyectoParcial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoDTO {

        private Long prestamoID;
        private String Titulo;
        private String nombreUsuario;
        private LocalDate fechaPrestamo;

    }
