package com.informatorio.trabajopracticospring.dto.artista;

import com.informatorio.trabajopracticospring.dto.cancion.CancionSinArtistaDto;
import lombok.Data;

import java.util.List;

@Data
public class ArtistaCancionesDto {
    private String nombre;
    private List<CancionSinArtistaDto> canciones;
}
