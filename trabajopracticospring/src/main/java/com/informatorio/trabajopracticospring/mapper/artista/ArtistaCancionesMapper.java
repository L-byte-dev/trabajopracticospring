package com.informatorio.trabajopracticospring.mapper.artista;

import com.informatorio.trabajopracticospring.dominio.Artista;
import com.informatorio.trabajopracticospring.dto.artista.ArtistaCancionesDto;
import com.informatorio.trabajopracticospring.mapper.cancion.CancionSinArtistaMapper;

import java.util.ArrayList;

public class ArtistaCancionesMapper {
    public static Artista mapToArtistaCanciones(ArtistaCancionesDto artistaCancionesDto, Artista artista) {
        artista.setNombre(artistaCancionesDto.getNombre());
        artista.setCanciones(CancionSinArtistaMapper.mapToCancionesSinArtista(artistaCancionesDto.getCanciones(), new ArrayList<>()));
        return artista;
    }

    public static ArtistaCancionesDto mapToArtistaCancionesDto(Artista artista, ArtistaCancionesDto artistaCancionesDto) {
        artistaCancionesDto.setNombre(artista.getNombre());
        artistaCancionesDto.setCanciones(CancionSinArtistaMapper.mapToCancionesSinArtistaDto(artista.getCanciones(), new ArrayList<>()));
        return artistaCancionesDto;
    }
}
