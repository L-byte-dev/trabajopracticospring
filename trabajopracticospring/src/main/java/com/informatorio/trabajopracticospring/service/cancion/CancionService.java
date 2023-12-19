package com.informatorio.trabajopracticospring.service.cancion;

import com.informatorio.trabajopracticospring.dto.cancion.CancionDto;
import com.informatorio.trabajopracticospring.dto.cancion.CancionSinArtistaDto;

import java.util.List;
import java.util.UUID;

public interface CancionService {
    List<CancionDto> obtenerCancionesAleatoriamente(String titulo, String genero, String artista, String album);
    List<CancionDto> obtenerCancionesOrdenadasPorRanking(String titulo, String genero, String artista, String album);
    List<CancionDto> obtenerCancionesListasDeReproduccion(UUID usuario);
}
