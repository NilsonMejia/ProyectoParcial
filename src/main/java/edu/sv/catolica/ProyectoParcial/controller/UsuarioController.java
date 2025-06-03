package edu.sv.catolica.ProyectoParcial.controller;

import edu.sv.catolica.ProyectoParcial.dto.MultaDTO;
import edu.sv.catolica.ProyectoParcial.entities.AutorEntity;
import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;
import edu.sv.catolica.ProyectoParcial.payload.MessageResponse;
import edu.sv.catolica.ProyectoParcial.service.IUsuario;
import edu.sv.catolica.ProyectoParcial.service.UsuarioService;
import edu.sv.catolica.ProyectoParcial.service.impl.UsuarioImpl;
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

    @Transactional(readOnly = true)
    @GetMapping("/GetUsuario")
    public ResponseEntity<?> getAutores() {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito")
                .data(usuario.findAll())
                .build(),
                HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/PostUsuario")
    public ResponseEntity<?> saveUsuarios(@RequestBody UsuarioEntity nuevousuario) {
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito ")
                .data(usuario.save(nuevousuario))
                .build(),
                HttpStatus.OK);

    }
/*
    @Transactional(readOnly = true)
    @GetMapping("/ConsultaInactivos/{cantidad}")
    public List<UsuarioDTO>obtenerUsuariosInactivos(@PathVariable("cantidad") boolean estado){
        return usuario.obtenerUsuariosInactivos(estado);
    }

 */

    @Transactional(readOnly = true)
    @GetMapping("/ConsultaInactivos/{cantidad}")
    public ResponseEntity<?>obtenerUsuariosInactivos(@PathVariable("cantidad") boolean estado){
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Proceso realizado con exito")
                .data(usuario.obtenerUsuariosInactivos(estado))
                .build(),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @Autowired
    private UsuarioService usuarioService;



}












