package com.informatorio.trabajopracticospring.mapper.cancion;

import com.informatorio.trabajopracticospring.dominio.Cancion;
import com.informatorio.trabajopracticospring.dto.cancion.CancionDto;

import java.util.Collection;
import java.util.List;

public class CancionMapper {
    public static Cancion mapToCancion(CancionDto cancionDto, Cancion cancion) {
        cancion.setNombre(cancionDto.getNombre());
        cancion.setRanking(cancionDto.getRanking());
        cancion.setDuracion(cancionDto.getDuracion());
        cancion.setAlbum(cancionDto.getAlbum());

        return cancion;
    }

    public static List<Cancion> mapToCanciones(Collection<CancionDto> cancionesDto, Collection<Cancion> canciones){
        for (CancionDto cancionDto : cancionesDto) {
            canciones.add(
                    mapToCancion(cancionDto, new Cancion())
            );
        }
        return (List<Cancion>) canciones;
    }

    public static CancionDto mapToCancionDto(Cancion cancion, CancionDto cancionDto) {
        cancionDto.setNombre(cancion.getNombre());
        cancionDto.setRanking(cancion.getRanking());
        cancionDto.setDuracion(cancion.getDuracion());
        cancionDto.setAlbum(cancion.getAlbum());

        return cancionDto;
    }

    public static List<CancionDto> mapToCancionesDto(Collection<Cancion> canciones, Collection<CancionDto> cancionesDto){
        for (Cancion cancion : canciones) {
            cancionesDto.add(
                    mapToCancionDto(cancion, new CancionDto())
            );
        }
        return (List<CancionDto>) cancionesDto;
    }
}
