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
@Table(name = "Autor")

public class AutorEntity {
    @Id
    @Column(columnDefinition = "INT", name = "Autor_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AutorID;

    @Column(columnDefinition = "VARCHAR(100)")
    private String Nombre;

    @Column(columnDefinition = "VARCHAR(100)")
    private String Apellido;



}