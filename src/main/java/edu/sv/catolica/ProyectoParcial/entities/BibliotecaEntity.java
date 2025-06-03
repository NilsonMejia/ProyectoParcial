package edu.sv.catolica.ProyectoParcial.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;

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
@Table(name = "Biblioteca")

public class BibliotecaEntity {
    @Id
    @Column(columnDefinition = "INT", name = "Biblioteca_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long BibliotecaID;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "Libro_ID" , nullable = false)
    private LibroEntity libro;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "Prestamo_ID" , nullable = false)
    private PrestamoEntity prestamo;

    @Column( columnDefinition = "DATE")
    private LocalDate FechaPrestamo;

    @Column( columnDefinition = "DATE")
    private LocalDate FechaDevolucion;

    @Column (columnDefinition = "BOOLEAN")
    private Boolean Disponible;





}