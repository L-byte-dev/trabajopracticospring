package com.informatorio.trabajopracticospring.controller.usuario;

import com.informatorio.trabajopracticospring.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/usuarios", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;
}
