package com.informatorio.trabajopracticospring.mapper.artista;

import com.informatorio.trabajopracticospring.dominio.Artista;
import com.informatorio.trabajopracticospring.dto.artista.ArtistaDto;

public class ArtistaMapper {
    public static Artista mapToArtista(ArtistaDto artistaDto, Artista artista) {
        artista.setNombre(artistaDto.getNombre());
        return artista;
    }

    public static ArtistaDto mapToArtistaDto(Artista artista, ArtistaDto artistaDto) {
        artistaDto.setNombre(artista.getNombre());
        return artistaDto;
    }
}
