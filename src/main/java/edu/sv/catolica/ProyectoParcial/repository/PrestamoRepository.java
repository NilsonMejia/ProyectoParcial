package edu.sv.catolica.ProyectoParcial.repository;

import edu.sv.catolica.ProyectoParcial.dto.PrestamoDTO;
import edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<PrestamoEntity, Long> {
  @Query(""" 
SELECT new edu.sv.catolica.ProyectoParcial.dto.PrestamoDTO()
    L.Titulo,
    P.FechaPestamo,
    U.Nombre 
FROM 
   PrestamoEntity P
JOIN 
    LibroEntity L ON P.libroID = L.LibroID
JOIN 
    UsuarioEntity U ON P.UsuarioID = U.UsuarioID
WHERE 
    P.FechaPrestamo = :fecha
ORDER BY 
    P.FechaPrestamo
""")
List<PrestamoDTO> obtenerPrestamosPorFecha(String fecha);

}
