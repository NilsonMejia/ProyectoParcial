package edu.sv.catolica.ProyectoParcial.repository;

import edu.sv.catolica.ProyectoParcial.dto.MultaDTO;
import edu.sv.catolica.ProyectoParcial.entities.MultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface MultaRepository extends JpaRepository<MultaEntity, Long> {

   @Query("""
    SELECT new edu.sv.catolica.ProyectoParcial.dto.MultaDTO(
        m.MultaID,
        u.Nombre,
        m.FechaGeneracion,
        m.Monto,
        m.Estado
    )
    FROM MultaEntity m
    JOIN m.usuario u
    WHERE m.Monto < :cantidad
""")
    List<MultaDTO> findMultasMenoresA(@Param("cantidad") int cantidad);


}
