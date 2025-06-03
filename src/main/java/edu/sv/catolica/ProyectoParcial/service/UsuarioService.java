package edu.sv.catolica.ProyectoParcial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.sv.catolica.ProyectoParcial.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
