package com.informatorio.trabajopracticospring.mapper.listareproduccion;

import com.informatorio.trabajopracticospring.dominio.ListaReproduccion;
import com.informatorio.trabajopracticospring.dto.listareproduccion.ListaReproduccionDto;

import java.util.Collection;
import java.util.List;

public class ListaReproduccionMapper {
    public static ListaReproduccion mapToListaReproduccion(ListaReproduccionDto listaReproduccionDto, ListaReproduccion listaReproduccion) {
        listaReproduccion.setId(listaReproduccionDto.getId());
        listaReproduccion.setNombre(listaReproduccionDto.getNombre());

        return listaReproduccion;
    }

    public static List<ListaReproduccion> mapToListasReproduccion(Collection<ListaReproduccionDto> listasReproduccionDto, Collection<ListaReproduccion> listasReproduccion) {
        for (ListaReproduccionDto listaReproduccionDto : listasReproduccionDto) {
            listasReproduccion.add(
                    mapToListaReproduccion(listaReproduccionDto, new ListaReproduccion())
            );
        }
        return (List<ListaReproduccion>) listasReproduccion;
    }

    public static ListaReproduccionDto mapToListaReproduccionDto(ListaReproduccion listaReproduccion, ListaReproduccionDto listaReproduccionDto) {
        listaReproduccionDto.setId(listaReproduccion.getId());
        listaReproduccionDto.setNombre(listaReproduccion.getNombre());

        return listaReproduccionDto;
    }

    public static List<ListaReproduccionDto> mapToListasReproduccionDto(Collection<ListaReproduccion> listasReproduccion, Collection<ListaReproduccionDto> listasReproduccionDto) {
        for (ListaReproduccion listaReproduccion : listasReproduccion) {
            listasReproduccionDto.add(
                    mapToListaReproduccionDto(listaReproduccion, new ListaReproduccionDto())
            );
        }
        return (List<ListaReproduccionDto>) listasReproduccionDto;
    }
}
