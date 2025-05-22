package edu.sv.catolica.ProyectoParcial.service;

import edu.sv.catolica.ProyectoParcial.dto.MultaDTO;
import edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO;
import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;
import java.util.List;

public interface IUsuario {
    List<UsuarioEntity> findAll();
    UsuarioEntity save(UsuarioEntity usuario);
    List<UsuarioDTO> obtenerUsuariosInactivos(boolean estado);
}