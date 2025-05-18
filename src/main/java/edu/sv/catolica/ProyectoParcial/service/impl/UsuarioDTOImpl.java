package edu.sv.catolica.ProyectoParcial.service.impl;



import edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO;
import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;
import edu.sv.catolica.ProyectoParcial.repository.UsuarioRepository;
import edu.sv.catolica.ProyectoParcial.service.IUsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioDTOImpl implements IUsuarioDTO{

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Conversión de Entity a DTO
    private UsuarioDTO convertToDTO(UsuarioEntity entity) {
        return new UsuarioDTO(entity.getUsuarioID(), entity.getNombre(), entity.getApellido(), entity.getEmail());
    }

    // Conversión de DTO a Entity
    private UsuarioEntity convertToEntity(UsuarioDTO dto) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setUsuarioID(dto.getUsuarioID());
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setEmail(dto.getEmail());
        return entity;
    }

    @Override
    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity saved = usuarioRepository.save(convertToEntity(usuarioDTO));
        return convertToDTO(saved);
    }
    @Override
    public List<UsuarioDTO> findPriceLess(double cantidad )
    {
        return usuarioRepository.findPriceLess(cantidad);
    }
}