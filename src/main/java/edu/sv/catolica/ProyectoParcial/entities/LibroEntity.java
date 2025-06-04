package edu.sv.catolica.ProyectoParcial.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Libro")

public class LibroEntity {
    @Id
    @Column(columnDefinition = "INT", name = "Libro_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long LibroID;

    @Column(columnDefinition = "VARCHAR(200)", name = "Titulo")
    private String Titulo;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "Autor_ID" , nullable = false)
    private AutorEntity Autor;

    @Column(columnDefinition = "DATE", name = "Año_Publicacion")
    private Date Publicacion;

    @Column(columnDefinition = "VARCHAR(50)", name = "Genero")
    private String Genero;

    @Column (columnDefinition = "BOOLEAN", name = "Disponible")
    private Boolean Disponible;

    @JsonIgnore
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BibliotecaEntity> bibliotecas = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "LibroID", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PrestamoEntity> prestamos = new ArrayList<>();



}