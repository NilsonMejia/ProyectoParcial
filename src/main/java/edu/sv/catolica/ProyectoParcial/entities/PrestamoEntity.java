package edu.sv.catolica.ProyectoParcial.entities;

import jakarta.persistence.*;
import lombok.*;
import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;
import edu.sv.catolica.ProyectoParcial.entities.LibroEntity;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Prestamo")

public class PrestamoEntity {
    @Id
    @Column(columnDefinition = "INT", name = "Prestamo_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long PrestamoID;

    @ManyToOne
    @JoinColumn(name = "Libro_ID", nullable = false)
    private LibroEntity libroID;

    @ManyToOne
    @JoinColumn(name = "Usuario_ID", nullable = false)
    private UsuarioEntity UsuarioID;

    @Column(columnDefinition = "DATE NOT NULL", name = "Fecha_Prestamo")
    private LocalDate FechaPestamo;

    @Column(columnDefinition = "DATE", name = "Fecha_Devolucion")
    private LocalDate FechaDevolucion;

    @Column(columnDefinition = "BOOLEAN", name = "Estado")
    private boolean Disponible;


}