package edu.sv.catolica.ProyectoParcial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import edu.sv.catolica.ProyectoParcial.entities.LibroEntity;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<LibroEntity, Long> {
    @Query("SELECT l FROM LibroEntity l WHERE l.Titulo =:Titulo")
    List<LibroEntity> buscarPorTitulo(@Param("Titulo") String Titulo);

    @Transactional
    @Modifying
    @Query("DELETE FROM LibroEntity l WHERE l.LibroID = :LibroID")
    void delete(@Param("LibroID") long LibroID);

//    @Transactional
//    @Modifying
//    @Query("DELETE FROM LibroEntity l WHERE l.LibroID = :LibroID")
//    void deleteByLibroID(@Param("LibroID")long LibroID);



}

