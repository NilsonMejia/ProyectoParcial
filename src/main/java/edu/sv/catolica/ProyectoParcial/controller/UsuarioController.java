package edu.sv.catolica.ProyectoParcial.controller;

import edu.sv.catolica.ProyectoParcial.dto.MultaDTO;
import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;
import edu.sv.catolica.ProyectoParcial.payload.MessageResponse;
import edu.sv.catolica.ProyectoParcial.service.IUsuario;
import edu.sv.catolica.ProyectoParcial.service.impl.UsuarioImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import edu.sv.catolica.ProyectoParcial.dto.UsuarioDTO;
import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;
import edu.sv.catolica.ProyectoParcial.service.IUsuario;
import java.util.List;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
    @Autowired
    private IUsuario usuario;
    @Autowired
    private UsuarioImpl usuarioImpl;

    @Transactional(readOnly = true)
    @GetMapping("/GetUsuario")
    public ResponseEntity<?> getAutores() {
        try {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Proceso realizado con exito")
                    .data(usuario.findAll())
                    .build(),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Error al obtener los usuarios")
                            .data(e.getMessage())
                            .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Transactional
    @PostMapping("/PostUsuario")
    public ResponseEntity<?> saveUsuarios(@RequestBody UsuarioEntity nuevousuario) {
        try {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Proceso realizado con exito ")
                    .data(usuario.save(nuevousuario))
                    .build(),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Error al enviar los datos")
                            .data(e.getMessage())
                            .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }

    @Transactional(readOnly = true)
    @GetMapping("/ConsultaInactivos/{cantidad}")
    public ResponseEntity<?>obtenerUsuariosInactivos(@PathVariable("cantidad") boolean estado){
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito")
                .data(usuario.obtenerUsuariosInactivos(estado))
                .build(),
                HttpStatus.OK);
    }

    @PutMapping("/ActualizarUsuario/{id}")
    public ResponseEntity<?> actualizarUsuario(
            @PathVariable Long id,
            @RequestBody UsuarioDTO dto) {
        try {
            UsuarioEntity actualizado = usuarioImpl.actualizarUsuario(id, dto);
            return ResponseEntity.ok(actualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @Transactional
    @DeleteMapping("/Eliminar/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        usuario.delete(id);
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Usuario eliminado con éxito.")
                .build(), HttpStatus.OK);
    }




}












