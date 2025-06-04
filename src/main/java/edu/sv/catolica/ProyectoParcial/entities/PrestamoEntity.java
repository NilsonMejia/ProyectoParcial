package edu.sv.catolica.ProyectoParcial.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;
import edu.sv.catolica.ProyectoParcial.entities.LibroEntity;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;

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
    @JsonIgnore
    @JoinColumn(name = "Libro_ID", nullable = false)
    private LibroEntity LibroID;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "Usuario_ID", nullable = false)
    private UsuarioEntity UsuarioID;

    @Column(columnDefinition = "DATE NOT NULL", name = "Fecha_Prestamo")
    private LocalDate FechaPrestamo;

    @Column(columnDefinition = "DATE", name = "Fecha_Devolucion")
    private LocalDate FechaDevolucion;

    @Column(columnDefinition = "BOOLEAN", name = "Estado")
    private boolean Disponible;

    @JsonIgnore
    @OneToMany(mappedBy = "prestamo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BibliotecaEntity> bibliotecas;

}