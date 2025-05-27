package edu.sv.catolica.ProyectoParcial.repository;

import edu.sv.catolica.ProyectoParcial.dto.BibliotecaDTO;
import edu.sv.catolica.ProyectoParcial.entities.BibliotecaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BibliotecaRepository extends JpaRepository<BibliotecaEntity, Long> {

    @Query("SELECT new edu.sv.catolica.ProyectoParcial.dto.BibliotecaDTO(b.libro,b.FechaDevolucion) " +
            "FROM BibliotecaEntity b " +
            "WHERE b.FechaDevolucion = :fechaDevolucion")
    List<BibliotecaDTO> findFechaDevolucion(@Param("fechaDevolucion") LocalDate fechaDevolucion);


}










