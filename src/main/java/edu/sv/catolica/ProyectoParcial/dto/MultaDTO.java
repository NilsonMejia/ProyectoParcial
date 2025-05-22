package edu.sv.catolica.ProyectoParcial.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MultaDTO {
    private Long multaId;
    private String nombreUsuario;
    private LocalDate fechaGeneracion;
    private BigDecimal monto;
    private boolean estado;

    public MultaDTO(Long multaId, String nombreUsuario, LocalDate fechaGeneracion, BigDecimal monto, boolean estado) {
        this.multaId = multaId;
        this.nombreUsuario = nombreUsuario;
        this.fechaGeneracion = fechaGeneracion;
        this.monto = monto;
        this.estado = estado;
    }

    // Getters y setters

    public Long getMultaId() { return multaId; }
    public void setMultaId(Long multaId) { this.multaId = multaId; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public LocalDate getFechaGeneracion() { return fechaGeneracion; }
    public void setFechaGeneracion(LocalDate fechaGeneracion) { this.fechaGeneracion = fechaGeneracion; }

    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }

    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
}

