package com.informatorio.trabajopracticospring.mapper.cancion;

import com.informatorio.trabajopracticospring.dominio.Artista;
import com.informatorio.trabajopracticospring.dominio.Cancion;
import com.informatorio.trabajopracticospring.dto.artista.ArtistaDto;
import com.informatorio.trabajopracticospring.dto.cancion.CancionDto;
import com.informatorio.trabajopracticospring.mapper.artista.ArtistaMapper;
import com.informatorio.trabajopracticospring.mapper.genero.GeneroMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CancionMapper {
    public static Cancion mapToCancion(CancionDto cancionDto, Cancion cancion) {
        cancion.setNombre(cancionDto.getNombre());
        cancion.setRanking(cancionDto.getRanking());
        cancion.setDuracion(cancionDto.getDuracion());
        cancion.setAlbum(cancionDto.getAlbum());
        cancion.setGeneros(GeneroMapper.mapToGeneros(cancionDto.getGenerosDto(), new ArrayList<>()));
        cancion.setArtista(ArtistaMapper.mapToArtista(cancionDto.getArtistaDto(), new Artista()));

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
        cancionDto.setGenerosDto(GeneroMapper.mapToGenerosDto(cancion.getGeneros(), new ArrayList<>()));
        cancionDto.setArtistaDto(ArtistaMapper.mapToArtistaDto(cancion.getArtista(), new ArtistaDto()));

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
