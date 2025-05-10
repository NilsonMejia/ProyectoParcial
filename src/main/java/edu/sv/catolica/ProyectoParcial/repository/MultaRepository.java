package edu.sv.catolica.ProyectoParcial.repository;

import edu.sv.catolica.ProyectoParcial.entities.MultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;

@Repository
public interface MultaRepository extends JpaRepository<MultaEntity, Long> {
}
