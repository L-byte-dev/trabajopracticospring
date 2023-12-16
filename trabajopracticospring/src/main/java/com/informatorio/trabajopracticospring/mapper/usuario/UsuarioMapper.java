package com.informatorio.trabajopracticospring.mapper.usuario;

import com.informatorio.trabajopracticospring.dominio.Usuario;
import com.informatorio.trabajopracticospring.dto.usuario.UsuarioDto;

public class UsuarioMapper {
    public static Usuario mapToUsuario(UsuarioDto usuarioDto, Usuario usuario) {
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
        return usuario;
    }

    public static UsuarioDto mapToUsuarioDto(Usuario usuario, UsuarioDto usuarioDto) {
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setNombreUsuario(usuario.getNombreUsuario());
        return usuarioDto;
    }
}
