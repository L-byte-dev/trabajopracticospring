package com.informatorio.trabajopracticospring.service.listareproduccion.impl;

import com.informatorio.trabajopracticospring.dominio.ListaReproduccion;
import com.informatorio.trabajopracticospring.dominio.Usuario;
import com.informatorio.trabajopracticospring.dto.listareproduccion.CrearListaReproduccionDto;
import com.informatorio.trabajopracticospring.dto.listareproduccion.ListaReproduccionAtributosDto;
import com.informatorio.trabajopracticospring.dto.listareproduccion.ListaReproduccionDto;
import com.informatorio.trabajopracticospring.exception.NotFoundException;
import com.informatorio.trabajopracticospring.exception.UnauthorizedAccessException;
import com.informatorio.trabajopracticospring.mapper.listareproduccion.CrearListaReproduccionMapper;
import com.informatorio.trabajopracticospring.mapper.listareproduccion.ListaReproduccionAtributosMapper;
import com.informatorio.trabajopracticospring.mapper.listareproduccion.ListaReproduccionMapper;
import com.informatorio.trabajopracticospring.repository.cancion.CancionRepository;
import com.informatorio.trabajopracticospring.repository.listareproduccion.ListaReproduccionRepository;
import com.informatorio.trabajopracticospring.repository.usuario.UsuarioRepository;
import com.informatorio.trabajopracticospring.service.listareproduccion.ListaReproduccionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ListaReproduccionServiceImpl implements ListaReproduccionService {
    private final ListaReproduccionRepository listaReproduccionRepository;
    private final CancionRepository cancionRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<ListaReproduccionDto> obtenerListasDeReproduccionPorUsuario(UUID idUsuario) {
        return ListaReproduccionMapper.mapToListasReproduccionDto(listaReproduccionRepository.findByUsuarioIdOrderByCreadoEnDesc(idUsuario), new ArrayList<>());
    }

    @Override
    public void crearListaReproduccion(UUID idUsuario, CrearListaReproduccionDto crearListaReproduccionDto) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new NotFoundException("Usuario","idUsuario",idUsuario.toString()));
        ListaReproduccion listaReproduccion = CrearListaReproduccionMapper.mapToListaReproduccion(crearListaReproduccionDto, new ListaReproduccion());
        listaReproduccion.setId(UUID.randomUUID());
        listaReproduccion.setCanciones(cancionRepository.findAllById(crearListaReproduccionDto.getCanciones()));
        listaReproduccion.setCreadoPor(usuario.getNombreUsuario());
        listaReproduccion.setUsuario(usuario);
        listaReproduccion.setCreadoEn(LocalDateTime.now());

        listaReproduccionRepository.save(listaReproduccion);
    }

    @Override
    public boolean actualizarListaReproduccion(UUID idUsuario, UUID idListaReproduccion, ListaReproduccionAtributosDto listaReproduccionAtributosDto) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new NotFoundException("Usuario","idUsuario",idUsuario.toString()));

        ListaReproduccion listaReproduccion = listaReproduccionRepository.findById(idListaReproduccion)
                .orElseThrow(() -> new NotFoundException("Lista Reproduccion","idListaReproduccion",idListaReproduccion.toString()));

        if (listaReproduccion.getUsuario().equals(usuario)) {
            ListaReproduccionAtributosMapper.mapToListaReproduccion(listaReproduccionAtributosDto, listaReproduccion);
            listaReproduccion.setActualizadoPor(usuario.getNombreUsuario());
            listaReproduccion.setActualizadoEn(LocalDateTime.now());
            listaReproduccionRepository.save(listaReproduccion);

            return Boolean.TRUE;
        } else {
            throw new UnauthorizedAccessException(idUsuario.toString(), idListaReproduccion.toString());
        }
    }
}
