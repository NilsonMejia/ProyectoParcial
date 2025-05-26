package edu.sv.catolica.ProyectoParcial.repository;

import edu.sv.catolica.ProyectoParcial.dto.PrestamoDTO;
import edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;


import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<PrestamoEntity, Long> {
  @Query("""
SELECT new edu.sv.catolica.ProyectoParcial.dto.PrestamoDTO(
         p.PrestamoID,
          l.Titulo,
           u.Nombre,
            p.FechaPrestamo
         )   
         FROM PrestamoEntity p JOIN p.libroID l JOIN p.UsuarioID u 
         WHERE p.FechaPrestamo = :fecha
   """)
  List<PrestamoDTO> obtenerPrestamosPorFecha(@Param("fecha") LocalDate fecha);
}
