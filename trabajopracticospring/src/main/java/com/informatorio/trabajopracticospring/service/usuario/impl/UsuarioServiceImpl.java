package com.informatorio.trabajopracticospring.service.usuario.impl;

import com.informatorio.trabajopracticospring.dominio.Usuario;
import com.informatorio.trabajopracticospring.dto.usuario.UsuarioDto;
import com.informatorio.trabajopracticospring.exception.NotFoundException;
import com.informatorio.trabajopracticospring.mapper.usuario.UsuarioMapper;
import com.informatorio.trabajopracticospring.mapper.listareproduccion.ListaReproduccionMapper;
import com.informatorio.trabajopracticospring.repository.usuario.UsuarioRepository;
import com.informatorio.trabajopracticospring.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Transactional
    @Override
    public void crearUsuario(UsuarioDto usuarioDto) {
        Usuario nuevoUsuario = UsuarioMapper.mapToUsuario(usuarioDto, new Usuario());
        nuevoUsuario.setId(UUID.randomUUID());
        nuevoUsuario.setCreadoPor("Admin");
        nuevoUsuario.setCreadoEn(LocalDateTime.now());
        nuevoUsuario.setActualizadoPor("Admin");
        nuevoUsuario.setActualizadoEn(LocalDateTime.now());

        usuarioRepository.save(nuevoUsuario);
    }

    @Override
    public UsuarioDto obtenerUsuarioPorId(UUID idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new NotFoundException("Usuario","idUsuario",idUsuario.toString()));

        UsuarioDto usuarioDto = UsuarioMapper.mapToUsuarioDto(usuario, new UsuarioDto());

        usuarioDto.setListasReproduccionDto(ListaReproduccionMapper.mapToListasReproduccionDto(usuario.getListasReproduccion(), new ArrayList<>()));

        return usuarioDto;
    }
}
