package edu.sv.catolica.ProyectoParcial.repository;

import edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;
import edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {


    List<UsuarioDTO> findPriceLess(double cantidad);

    @Query("""
    SELECT new edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO(
        UsuarioEntity.UsuarioID,UsuarioEntity.Nombre, UsuarioEntity.Apellido, UsuarioEntity.Email 
    )
    FROM PrestamoEntity p
    JOIN UsuarioEntity.UsuarioID 
    GROUP BY UsuarioEntity.UsuarioID, UsuarioEntity.Nombre, UsuarioEntity.Apellido, UsuarioEntity.Email
    ORDER BY COUNT(PrestamoEntity.PrestamoID) DESC
""")
    List<UsuarioDTO> obtenerTop5UsuariosConMasPrestamos(double cantidad);




}
