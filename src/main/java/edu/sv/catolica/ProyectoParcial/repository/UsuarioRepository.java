package edu.sv.catolica.ProyectoParcial.repository;

import edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;
import edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Query("""
    SELECT new edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO(
        u.UsuarioID,
        u.Nombre,
        u.Apellido,
        u.Email,
        u.Estado
    )
    FROM UsuarioEntity u
    WHERE u.Estado = :estado
""")
    List<UsuarioDTO> obtenerUsuariosInactivos(boolean estado);


    //Optional<Object> findByNombre(String nombreUsuario);
}
