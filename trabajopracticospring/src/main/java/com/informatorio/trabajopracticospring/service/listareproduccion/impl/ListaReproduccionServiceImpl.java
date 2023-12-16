package com.informatorio.trabajopracticospring.service.listareproduccion.impl;

import com.informatorio.trabajopracticospring.dominio.ListaReproduccion;
import com.informatorio.trabajopracticospring.dominio.Usuario;
import com.informatorio.trabajopracticospring.dto.listareproduccion.ListaReproduccionDto;
import com.informatorio.trabajopracticospring.exception.NotFoundException;
import com.informatorio.trabajopracticospring.repository.listareproduccion.ListaReproduccionRepository;
import com.informatorio.trabajopracticospring.repository.usuario.UsuarioRepository;
import com.informatorio.trabajopracticospring.service.listareproduccion.ListaReproduccionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ListaReproduccionServiceImpl implements ListaReproduccionService {
    private final ListaReproduccionRepository listaReproduccionRepository;
    private UsuarioRepository usuarioRepository;

    @Override
    public List<ListaReproduccionDto> obtenerListasDeReproduccionPorUsuario(UUID idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new NotFoundException("Usuario", "idUsuario", idUsuario.toString()));

        List<ListaReproduccionDto> listasDto = new ArrayList<>();
        for (ListaReproduccion lista : usuario.getListasReproduccion()) {
            ListaReproduccionDto listaDto = new ListaReproduccionDto();
            listaDto.setId(lista.getId());
            listaDto.setNombre(lista.getNombre());
            listaDto.setCantCanciones(lista.getCanciones().size());
            listasDto.add(listaDto);
        }
        return listasDto;
    }
}
