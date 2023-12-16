package com.informatorio.trabajopracticospring.controller.listareproduccion;

import com.informatorio.trabajopracticospring.service.listareproduccion.ListaReproduccionService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/listas-reproduccion", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class ListaReproduccionController {
    public ListaReproduccionService listaReproduccionService;
}
