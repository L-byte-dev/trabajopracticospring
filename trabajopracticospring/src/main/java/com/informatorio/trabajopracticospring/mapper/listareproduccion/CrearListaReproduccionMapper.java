package com.informatorio.trabajopracticospring.mapper.listareproduccion;

import com.informatorio.trabajopracticospring.dominio.ListaReproduccion;
import com.informatorio.trabajopracticospring.dto.listareproduccion.CrearListaReproduccionDto;

public class CrearListaReproduccionMapper {
    public static ListaReproduccion mapToListaReproduccion(CrearListaReproduccionDto crearListaReproduccionDto, ListaReproduccion listaReproduccion) {
        listaReproduccion.setNombre(crearListaReproduccionDto.getNombre());

        return listaReproduccion;
    }

    public static CrearListaReproduccionDto mapToCrearListaReproduccionDto(ListaReproduccion listaReproduccion, CrearListaReproduccionDto crearListaReproduccionDto) {
        crearListaReproduccionDto.setNombre(listaReproduccion.getNombre());

        return crearListaReproduccionDto;
    }
}
