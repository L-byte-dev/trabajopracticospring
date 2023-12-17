package com.informatorio.trabajopracticospring.mapper.cancion;

import com.informatorio.trabajopracticospring.dominio.Cancion;
import com.informatorio.trabajopracticospring.dto.cancion.CancionSinArtistaDto;
import com.informatorio.trabajopracticospring.mapper.genero.GeneroMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CancionSinArtistaMapper {
    public static Cancion mapToCancionSinArtista(CancionSinArtistaDto cancionSinArtistaDto, Cancion cancion) {
        cancion.setNombre(cancionSinArtistaDto.getNombre());
        cancion.setRanking(cancionSinArtistaDto.getRanking());
        cancion.setDuracion(cancionSinArtistaDto.getDuracion());
        cancion.setAlbum(cancionSinArtistaDto.getAlbum());
        cancion.setGeneros(GeneroMapper.mapToGeneros(cancionSinArtistaDto.getGenerosDto(), new ArrayList<>()));

        return cancion;
    }

    public static List<Cancion> mapToCancionesSinArtista(Collection<CancionSinArtistaDto> cancionesSinArtistaDto, Collection<Cancion> canciones){
        for (CancionSinArtistaDto cancionSinArtistaDto : cancionesSinArtistaDto) {
            canciones.add(
                    mapToCancionSinArtista(cancionSinArtistaDto, new Cancion())
            );
        }
        return (List<Cancion>) canciones;
    }

    public static CancionSinArtistaDto mapToCancionSinArtistaDto(Cancion cancion, CancionSinArtistaDto cancionSinArtistaDto) {
        cancionSinArtistaDto.setNombre(cancion.getNombre());
        cancionSinArtistaDto.setRanking(cancion.getRanking());
        cancionSinArtistaDto.setDuracion(cancion.getDuracion());
        cancionSinArtistaDto.setAlbum(cancion.getAlbum());
        cancionSinArtistaDto.setGenerosDto(GeneroMapper.mapToGenerosDto(cancion.getGeneros(), new ArrayList<>()));

        return cancionSinArtistaDto;
    }

    public static List<CancionSinArtistaDto> mapToCancionesSinArtistaDto(Collection<Cancion> canciones, Collection<CancionSinArtistaDto> cancionesSinArtistaDto){
        for (Cancion cancion : canciones) {
            cancionesSinArtistaDto.add(
                    mapToCancionSinArtistaDto(cancion, new CancionSinArtistaDto())
            );
        }
        return (List<CancionSinArtistaDto>) cancionesSinArtistaDto;
    }
}
