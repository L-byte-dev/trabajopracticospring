package com.informatorio.trabajopracticospring.controller.usuario;

import com.informatorio.trabajopracticospring.constants.ConstantsUtils;
import com.informatorio.trabajopracticospring.dto.respuesta.RespuestaDto;
import com.informatorio.trabajopracticospring.dto.usuario.UsuarioDto;
import com.informatorio.trabajopracticospring.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/usuarios", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Transactional
    @PostMapping
    public ResponseEntity<RespuestaDto> crearUsuario(@RequestBody UsuarioDto usuarioDto){
        usuarioService.crearUsuario(usuarioDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new RespuestaDto(ConstantsUtils.STATUS_201,ConstantsUtils.MESSAGE_201));
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDto> obtenerUsuarioPorId(@PathVariable(name = "idUsuario") UUID idUsuario){
        UsuarioDto usuarioDto = usuarioService.obtenerUsuarioPorId(idUsuario);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usuarioDto);
    }
}
