package edu.sv.catolica.ProyectoParcial.service.impl;


import edu.sv.catolica.ProyectoParcial.dto.MultaDTO;
import edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;
import edu.sv.catolica.ProyectoParcial.service.IUsuario;
import edu.sv.catolica.ProyectoParcial.repository.UsuarioRepository;
import java.util.List;

@Service
public class UsuarioImpl implements IUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> findAll(){

        return usuarioRepository.findAll();

    }
    @Override
    public UsuarioEntity save(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<UsuarioDTO>obtenerUsuariosInactivos(boolean estado ) {
        return usuarioRepository.obtenerUsuariosInactivos(estado);
    }
}