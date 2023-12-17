package com.informatorio.trabajopracticospring.service.artista;

import com.informatorio.trabajopracticospring.dto.artista.ArtistaCancionesDto;
import com.informatorio.trabajopracticospring.dto.artista.ArtistaDto;

import java.util.UUID;

public interface ArtistaService {
    ArtistaCancionesDto obtenerArtistaPorId(UUID idArtista);
}
