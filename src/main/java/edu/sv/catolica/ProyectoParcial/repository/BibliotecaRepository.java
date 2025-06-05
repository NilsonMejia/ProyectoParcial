package edu.sv.catolica.ProyectoParcial.repository;

import edu.sv.catolica.ProyectoParcial.dto.BibliotecaDTO;
import edu.sv.catolica.ProyectoParcial.dto.BibliotecaDTO2;
import edu.sv.catolica.ProyectoParcial.entities.BibliotecaEntity;
import edu.sv.catolica.ProyectoParcial.entities.LibroEntity;
import edu.sv.catolica.ProyectoParcial.entities.PrestamoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BibliotecaRepository extends JpaRepository<BibliotecaEntity, Long> {




    @Query("SELECT new edu.sv.catolica.ProyectoParcial.dto.BibliotecaDTO2(" +
            "b.libro.Titulo, b.FechaDevolucion) " +
            "FROM BibliotecaEntity b " +
            "WHERE b.FechaDevolucion = :fechaDevolucion")
    List<BibliotecaDTO2> findFechaDevolucion(@Param("fechaDevolucion") LocalDate fechaDevolucion);

    @Transactional
    @Modifying
    @Query("DELETE FROM BibliotecaEntity b WHERE b.prestamo.LibroID = :libro")
    void deleteByPrestamoLibro(@Param("libro") LibroEntity libro);

}










