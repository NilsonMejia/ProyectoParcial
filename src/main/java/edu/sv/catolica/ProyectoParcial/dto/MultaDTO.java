package edu.sv.catolica.ProyectoParcial.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MultaDTO {
    private Long multaId;
    private Long usuarioID;
    private String nombreUsuario;
    private LocalDate fechaGeneracion;
    private BigDecimal monto;
    private Boolean estado;

    public MultaDTO(Long multaId, String nombreUsuario, LocalDate fechaGeneracion, BigDecimal monto, Boolean estado) {
        this.multaId = multaId;
        this.nombreUsuario = nombreUsuario;
        this.fechaGeneracion = fechaGeneracion;
        this.monto = monto;
        this.estado = estado;
    }

    public Long getMultaId() { return multaId; }
    public void setMultaId(Long multaId) { this.multaId = multaId; }

    public Long getUsuarioID() { return usuarioID; }
    public void setUsuarioID(Long usuarioID) { this.usuarioID = usuarioID; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public LocalDate getFechaGeneracion() { return fechaGeneracion; }
    public void setFechaGeneracion(LocalDate fechaGeneracion) { this.fechaGeneracion = fechaGeneracion; }

    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }

    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }

}

