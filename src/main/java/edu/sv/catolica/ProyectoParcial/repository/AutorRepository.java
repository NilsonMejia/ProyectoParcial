package edu.sv.catolica.ProyectoParcial.repository;
import edu.sv.catolica.ProyectoParcial.dto.AutorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import java.util.Optional;


import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Long> {
    @Query("""
    SELECT new edu.sv.catolica.ProyectoParcial.dto.AutorDTO(
        a.AutorID,
        a.Nombre,
        a.Apellido
    )
    FROM AutorEntity a
    WHERE a.AutorID = :id
""")
    Optional<AutorDTO> AutorPorId(@Param("id") Long id);
}
