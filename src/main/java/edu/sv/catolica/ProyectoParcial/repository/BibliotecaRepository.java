package edu.sv.catolica.ProyectoParcial.repository;

import edu.sv.catolica.ProyectoParcial.entities.BibliotecaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;

@Repository
public interface BibliotecaRepository extends JpaRepository<BibliotecaEntity, Long> {
}
