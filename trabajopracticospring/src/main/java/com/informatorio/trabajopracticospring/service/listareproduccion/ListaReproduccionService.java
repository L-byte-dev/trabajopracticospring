package com.informatorio.trabajopracticospring.service.listareproduccion;

import com.informatorio.trabajopracticospring.dto.listareproduccion.CrearListaReproduccionDto;
import com.informatorio.trabajopracticospring.dto.listareproduccion.ListaReproduccionDto;

import java.util.List;
import java.util.UUID;

public interface ListaReproduccionService {
    List<ListaReproduccionDto> obtenerListasDeReproduccionPorUsuario(UUID usuario);
    void crearListaReproduccion(UUID idUsuario, CrearListaReproduccionDto crearListaReproduccionDto);
}
