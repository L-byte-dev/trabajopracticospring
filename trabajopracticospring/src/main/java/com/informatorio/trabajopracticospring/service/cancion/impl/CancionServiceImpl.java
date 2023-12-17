package com.informatorio.trabajopracticospring.service.cancion.impl;

import com.informatorio.trabajopracticospring.dominio.Cancion;
import com.informatorio.trabajopracticospring.dominio.ListaReproduccion;
import com.informatorio.trabajopracticospring.dto.cancion.CancionDto;
import com.informatorio.trabajopracticospring.exception.NotFoundException;
import com.informatorio.trabajopracticospring.mapper.cancion.CancionMapper;
import com.informatorio.trabajopracticospring.repository.cancion.CancionRepository;
import com.informatorio.trabajopracticospring.repository.listareproduccion.ListaReproduccionRepository;
import com.informatorio.trabajopracticospring.service.cancion.CancionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class CancionServiceImpl implements CancionService  {
    private final CancionRepository cancionRepository;
    private final ListaReproduccionRepository listaReproduccionRepository;

    @Override
    public List<CancionDto> obtenerTodasLasCanciones(String titulo, String genero, String artista, String album) {
        List<Cancion> canciones = cancionRepository.findByNombreIgnoreCaseOrGenerosNombreIgnoreCaseOrArtistaNombreIgnoreCaseOrAlbumIgnoreCase(titulo, genero, artista, album);
        Collections.shuffle(canciones);
        return CancionMapper.mapToCancionesDto(canciones, new ArrayList<>());
    }

    @Override
    public List<CancionDto> obtenerCancionesPorArtistaOrdenadasPorRanking(String artista) {
        List<Cancion> canciones = cancionRepository.findByArtistaNombreIgnoreCaseOrderByRanking(artista);
        return CancionMapper.mapToCancionesDto(canciones, new ArrayList<>());
    }

    @Override
    public List<CancionDto> obtenerCancionesListasDeReproduccion(UUID listaReproduccionId) {
        ListaReproduccion listaReproduccion = listaReproduccionRepository.findById(listaReproduccionId)
                .orElseThrow(() -> new NotFoundException("Lista de Reproduccion","listaReproduccionId",listaReproduccionId.toString()));

        return CancionMapper.mapToCancionesDto(listaReproduccion.getCanciones(), new ArrayList<>());
    }
}
