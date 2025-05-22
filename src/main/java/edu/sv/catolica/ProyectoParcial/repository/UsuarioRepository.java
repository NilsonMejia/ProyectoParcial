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

    

    @Query("""
    SELECT new edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO(
       p.UsuarioID.UsuarioID,
       p.UsuarioID.Nombre,
       p.UsuarioID.Apellido,
       p.UsuarioID.Email
       )
       FROM PrestamoEntity p
       GROUP BY p.UsuarioID.UsuarioID, p.UsuarioID.Nombre,p.UsuarioID.Apellido,p.UsuarioID.Email
       ORDER BY COUNT(p.PrestamoID) DESC
""")
    List<UsuarioDTO> obtenerTop5UsuariosConMasPrestamos(double cantidad);






}
