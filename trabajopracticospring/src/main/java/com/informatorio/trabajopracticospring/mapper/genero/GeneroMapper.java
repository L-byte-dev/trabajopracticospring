package com.informatorio.trabajopracticospring.mapper.genero;

import com.informatorio.trabajopracticospring.dominio.Genero;
import com.informatorio.trabajopracticospring.dto.genero.GeneroDto;

import java.util.Collection;
import java.util.List;

public class GeneroMapper {
    public static Genero mapToGenero(GeneroDto generoDto, Genero genero) {
        genero.setNombre(generoDto.getNombre());
        return genero;
    }

    public static List<Genero> mapToGeneros(Collection<GeneroDto> generosDto, Collection<Genero> generos) {
        for (GeneroDto generoDto : generosDto) {
            generos.add(
                    mapToGenero(generoDto, new Genero())
            );
        }
        return (List<Genero>) generos;
    }

    public static GeneroDto mapToGeneroDto(Genero genero, GeneroDto generoDto) {
        generoDto.setNombre(genero.getNombre());
        return generoDto;
    }

    public static List<GeneroDto> mapToGenerosDto(Collection<Genero> generos, Collection<GeneroDto> generosDto) {
        for (Genero genero : generos) {
            generosDto.add(
                    mapToGeneroDto(genero, new GeneroDto())
            );
        }
        return (List<GeneroDto>) generosDto;
    }
}
