package com.informatorio.trabajopracticospring.service.usuario;

import com.informatorio.trabajopracticospring.dto.usuario.UsuarioDto;

import java.util.UUID;

public interface UsuarioService {
    void crearUsuario(UsuarioDto usuarioDto);
    UsuarioDto obtenerUsuarioPorId(UUID idUsuario);
}
