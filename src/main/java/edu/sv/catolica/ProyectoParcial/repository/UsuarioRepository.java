package edu.sv.catolica.ProyectoParcial.repository;

import edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {


    List<UsuarioDTO> findPriceLess(double cantidad);

    @Query("""
    SELECT new com.tu.paquete.dto.UsuarioConPrestamoDto(
        u.usuarioID, u.nombre, u.apellido, COUNT(p.prestamoID)
    )
    FROM UsuarioEntity u
    JOIN PrestamoEntity p ON p.usuario = u
    WHERE p.fechaDevolucion IS NULL
    GROUP BY u.usuarioID, u.nombre, u.apellido
""")
    List<UsuarioConPrestamoDto> obtenerUsuariosConPrestamosNoDevueltos();




}
