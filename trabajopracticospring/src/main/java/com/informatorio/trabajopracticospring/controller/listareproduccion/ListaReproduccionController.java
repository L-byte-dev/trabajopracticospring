package com.informatorio.trabajopracticospring.controller.listareproduccion;

import com.informatorio.trabajopracticospring.dto.cancion.CancionDto;
import com.informatorio.trabajopracticospring.dto.listareproduccion.ListaReproduccionDto;
import com.informatorio.trabajopracticospring.service.cancion.CancionService;
import com.informatorio.trabajopracticospring.service.listareproduccion.ListaReproduccionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/listas-reproduccion", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class ListaReproduccionController {
    public ListaReproduccionService listaReproduccionService;
    private CancionService cancionService;

    @GetMapping("/usuario/{idUsuario}")
    public List<ListaReproduccionDto> obtenerListasDeReproduccionPorUsuario(@PathVariable(name = "idUsuario") UUID idUsuario){
        return listaReproduccionService.obtenerListasDeReproduccionPorUsuario(idUsuario);
    }

    @GetMapping("/{idListaReproduccion}")
    public ResponseEntity<List<CancionDto>> obtenerCancionesListasDeReproduccion(@PathVariable(name = "idListaReproduccion") UUID idListaReproduccion){

        List<CancionDto> cancionesDto = cancionService.obtenerCancionesListasDeReproduccion(idListaReproduccion);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cancionesDto);
    }

}
