package com.informatorio.trabajopracticospring.service.listareproduccion.impl;

import com.informatorio.trabajopracticospring.dto.listareproduccion.ListaReproduccionDto;
import com.informatorio.trabajopracticospring.mapper.listareproduccion.ListaReproduccionMapper;
import com.informatorio.trabajopracticospring.repository.listareproduccion.ListaReproduccionRepository;
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

    @Override
    public List<ListaReproduccionDto> obtenerListasDeReproduccionPorUsuario(UUID idUsuario) {
        return ListaReproduccionMapper.mapToListasReproduccionDto(listaReproduccionRepository.findByUsuarioIdOrderByCreadoEnDesc(idUsuario), new ArrayList<>());
    }
}
