package com.informatorio.trabajopracticospring.controller.cancion;

import com.informatorio.trabajopracticospring.dto.cancion.CancionDto;
import com.informatorio.trabajopracticospring.service.cancion.CancionService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/v1/canciones", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class CancionController {
    private CancionService cancionService;

    @GetMapping
    public List<CancionDto> obtenerTodasLasCanciones (
            @RequestParam(name = "titulo",required = false) String titulo,
            @RequestParam(name = "genero", required = false) String genero,
            @RequestParam(name = "artista", required = false) String artista,
            @RequestParam(name = "album", required = false) String album,
            @RequestParam(name = "orderByRanking", required = false) boolean orderByRanking
    ){
        if (orderByRanking) {
            return cancionService.obtenerCancionesOrdenadasPorRanking(titulo, genero, artista, album);
        } else {
            return cancionService.obtenerCancionesAleatoriamente(titulo, genero, artista, album);
        }
    }
}
