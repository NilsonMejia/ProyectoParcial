package edu.sv.catolica.ProyectoParcial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
