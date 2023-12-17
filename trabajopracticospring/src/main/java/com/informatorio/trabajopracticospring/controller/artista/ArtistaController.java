package com.informatorio.trabajopracticospring.controller.artista;

import com.informatorio.trabajopracticospring.dto.artista.ArtistaCancionesDto;
import com.informatorio.trabajopracticospring.dto.artista.ArtistaDto;
import com.informatorio.trabajopracticospring.dto.listareproduccion.ListaReproduccionDto;
import com.informatorio.trabajopracticospring.service.artista.ArtistaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/artistas", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class ArtistaController {
    private ArtistaService artistaService;

    @GetMapping("/{idArtista}")
    public ResponseEntity<ArtistaCancionesDto> obtenerArtistaPorId(@PathVariable(name = "idArtista")UUID idArtista){
        ArtistaCancionesDto artistaCancionesDto = artistaService.obtenerArtistaPorId(idArtista);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(artistaCancionesDto);
    }
}
