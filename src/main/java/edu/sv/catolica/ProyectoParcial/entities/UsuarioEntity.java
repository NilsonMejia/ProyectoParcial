package edu.sv.catolica.ProyectoParcial.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usuario")

public class UsuarioEntity {
    @Id
    @Column(columnDefinition = "INT", name = "Usuario_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long UsuarioID;

    @Column(columnDefinition = "VARCHAR(100)")
    private String Nombre;

    @Column(columnDefinition = "VARCHAR(100)")
    private String Apellido;

    @Column(columnDefinition = "VARCHAR(100)")
    private String Email;

    @Column(columnDefinition = "VARCHAR(20)")
    private String Telefono;

    @Column (columnDefinition = "BOOLEAN")
    private Boolean Estado;


}