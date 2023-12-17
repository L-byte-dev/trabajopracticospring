package com.informatorio.trabajopracticospring.service.cancion;

import com.informatorio.trabajopracticospring.dto.cancion.CancionDto;

import java.util.List;
import java.util.UUID;

public interface CancionService {
    List<CancionDto> obtenerCancionesListasDeReproduccion(UUID usuario);
}
