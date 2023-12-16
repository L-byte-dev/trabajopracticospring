package com.informatorio.trabajopracticospring.controller.listareproduccion;

import com.informatorio.trabajopracticospring.dto.listareproduccion.ListaReproduccionDto;
import com.informatorio.trabajopracticospring.service.listareproduccion.ListaReproduccionService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/listas-reproduccion", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class ListaReproduccionController {
    public ListaReproduccionService listaReproduccionService;

    @GetMapping("/usuario/{idUsuario}")
    public List<ListaReproduccionDto> obtenerListasDeReproduccionPorUsuario(@PathVariable(name = "idUsuario") UUID idUsuario){
        return listaReproduccionService.obtenerListasDeReproduccionPorUsuario(idUsuario);
    }
}
