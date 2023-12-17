package com.informatorio.trabajopracticospring.service.artista.impl;

import com.informatorio.trabajopracticospring.dominio.Artista;
import com.informatorio.trabajopracticospring.dto.artista.ArtistaCancionesDto;
import com.informatorio.trabajopracticospring.exception.NotFoundException;
import com.informatorio.trabajopracticospring.mapper.artista.ArtistaCancionesMapper;
import com.informatorio.trabajopracticospring.repository.artista.ArtistaRepository;
import com.informatorio.trabajopracticospring.service.artista.ArtistaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ArtistaServiceImpl implements ArtistaService {
    private final ArtistaRepository artistaRepository;

    @Override
    public ArtistaCancionesDto obtenerArtistaPorId(UUID idArtista) {
        Artista artista = artistaRepository.findById(idArtista)
                .orElseThrow(() -> new NotFoundException("Artista","idArtista",idArtista.toString())  );

        return ArtistaCancionesMapper.mapToArtistaCancionesDto(artista, new ArtistaCancionesDto());
    }
}
