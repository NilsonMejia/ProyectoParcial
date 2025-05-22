package edu.sv.catolica.ProyectoParcial.service;

import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.entities.MultaEntity;
import edu.sv.catolica.ProyectoParcial.dto.MultaDTO;

import java.math.BigDecimal;
import java.util.List;

public interface IMulta {
    List<MultaEntity> findAll();
    MultaEntity save(MultaEntity multa);

    List<MultaDTO> findMultasMenoresA(int cantidad);
}