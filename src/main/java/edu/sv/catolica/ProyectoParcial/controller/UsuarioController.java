package edu.sv.catolica.ProyectoParcial.controller;

import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;
import edu.sv.catolica.ProyectoParcial.service.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import edu.sv.catolica.ProyectoParcial.entities.UsuarioEntity;
import edu.sv.catolica.ProyectoParcial.service.IUsuario;
import java.util.List;

@RestController
@RequestMapping("/process")
public class UsuarioController {
    @Autowired
    private IUsuario usuario;

    @Transactional(readOnly = true)
    @GetMapping("/Usuario")
    public List<UsuarioEntity> getUsuarios() {
        return usuario.findAll();
    }

    @Transactional
    @PostMapping("/Usuario")
    public UsuarioEntity saveUsuarios(@RequestBody UsuarioEntity nuevousuario) {
        return usuario.save(nuevousuario);

    }
}












