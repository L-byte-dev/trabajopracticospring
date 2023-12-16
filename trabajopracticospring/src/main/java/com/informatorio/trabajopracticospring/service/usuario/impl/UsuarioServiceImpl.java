package com.informatorio.trabajopracticospring.service.usuario.impl;

import com.informatorio.trabajopracticospring.dominio.Usuario;
import com.informatorio.trabajopracticospring.dto.usuario.UsuarioDto;
import com.informatorio.trabajopracticospring.exception.NotFoundException;
import com.informatorio.trabajopracticospring.mapper.usuario.UsuarioMapper;
import com.informatorio.trabajopracticospring.repository.usuario.UsuarioRepository;
import com.informatorio.trabajopracticospring.service.listareproduccion.ListaReproduccionService;
import com.informatorio.trabajopracticospring.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ListaReproduccionService listaReproduccionService;

    @Transactional
    @Override
    public void crearUsuario(UsuarioDto usuarioDto) {
        Usuario nuevoUsuario = UsuarioMapper.mapToUsuario(usuarioDto, new Usuario());
        nuevoUsuario.setId(UUID.randomUUID());
        nuevoUsuario.setCreadoPor("Anonimo");
        nuevoUsuario.setCreadoEn(LocalDateTime.now());

        usuarioRepository.save(nuevoUsuario);
    }

    @Override
    public UsuarioDto obtenerUsuarioPorId(UUID idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new NotFoundException("Usuario","idUsuario",idUsuario.toString()));

        UsuarioDto usuarioDto = UsuarioMapper.mapToUsuarioDto(usuario, new UsuarioDto());

        usuarioDto.setListasReproduccionDto(listaReproduccionService.obtenerListasDeReproduccionPorUsuario(idUsuario));

        return usuarioDto;
    }
}
