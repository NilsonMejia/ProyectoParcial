package edu.sv.catolica.ProyectoParcial.controller;

import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;
import edu.sv.catolica.ProyectoParcial.payload.MessageResponse;
import edu.sv.catolica.ProyectoParcial.service.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
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
    public UsuarioEntity saveUsuarios(@RequestBody UsuarioEntity nuevousuario) {
        return usuario.save(nuevousuario);

    }
}












