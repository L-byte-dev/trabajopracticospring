package com.informatorio.trabajopracticospring.mapper.listareproduccion;

import com.informatorio.trabajopracticospring.dominio.ListaReproduccion;
import com.informatorio.trabajopracticospring.dto.listareproduccion.ListaReproduccionAtributosDto;

public class ListaReproduccionAtributosMapper {
    public static ListaReproduccion mapToListaReproduccion(ListaReproduccionAtributosDto listaReproduccionAtributosDto, ListaReproduccion listaReproduccion) {
        listaReproduccion.setRepite(listaReproduccionAtributosDto.isRepite());
        listaReproduccion.setAleatorio(listaReproduccionAtributosDto.isAleatorio());
        listaReproduccion.setPublica(listaReproduccionAtributosDto.isPublica());

        return listaReproduccion;
    }

    public static ListaReproduccionAtributosDto mapToListaReproduccionAtributosDto(ListaReproduccion listaReproduccion, ListaReproduccionAtributosDto listaReproduccionAtributosDto) {
        listaReproduccionAtributosDto.setRepite(listaReproduccion.isRepite());
        listaReproduccionAtributosDto.setAleatorio(listaReproduccion.isAleatorio());
        listaReproduccionAtributosDto.setPublica(listaReproduccion.isPublica());

        return listaReproduccionAtributosDto;
    }
}
