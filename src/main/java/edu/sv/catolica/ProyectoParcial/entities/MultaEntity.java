package edu.sv.catolica.ProyectoParcial.entities;


import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;
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
@Table(name = "Multa")

public class MultaEntity {
    @Id
    @Column(columnDefinition = "INT", name = "Multa_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long MultaID;


    @ManyToOne
    @JoinColumn(name = "Usuario_ID", nullable = false)
    private UsuarioEntity usuario ;

    @Column(columnDefinition = "DATE", name = "Fecha_Generacion")
    private LocalDate FechaGeneracion;

    @Column(columnDefinition = "DECIMAL", name = "Monto")
    private BigDecimal Monto;

    @Column (columnDefinition = "BOOLEAN", name = "Estado")
    private Boolean Estado;





}