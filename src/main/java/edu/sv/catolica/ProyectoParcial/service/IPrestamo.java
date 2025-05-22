package edu.sv.catolica.ProyectoParcial.service;

import edu.sv.catolica.ProyectoParcial.dto.PrestamoDTO;
import edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPrestamo {
    List<PrestamoEntity> findAll();
    PrestamoEntity save(PrestamoEntity prestamo);
    List<PrestamoDTO> obtenerTop5UsuariosConMasPrestamos(double cantidad);



           
}
