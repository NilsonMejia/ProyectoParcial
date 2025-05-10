package edu.sv.catolica.ProyectoParcial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;

@Repository
public interface PrestamoRepository extends JpaRepository<PrestamoEntity, Long> {
}
