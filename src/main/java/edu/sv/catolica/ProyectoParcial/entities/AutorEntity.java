package edu.sv.catolica.ProyectoParcial.entities;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Autor")
@JsonPropertyOrder({ "autorID", "nombre", "apellido" })

public class AutorEntity {
    @Id
    @Column(columnDefinition = "INT", name = "Autor_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AutorID;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    @NotBlank(message = "El nombre no puede estar vacío")
    private String Nombre;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    @NotBlank(message = "El apellido no puede estar vacío")
    private String Apellido;
}