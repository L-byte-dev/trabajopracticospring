package com.informatorio.trabajopracticospring.controller.listareproduccion;

import com.informatorio.trabajopracticospring.constants.ConstantsUtils;
import com.informatorio.trabajopracticospring.dto.cancion.CancionDto;
import com.informatorio.trabajopracticospring.dto.listareproduccion.CrearListaReproduccionDto;
import com.informatorio.trabajopracticospring.dto.listareproduccion.ListaReproduccionAtributosDto;
import com.informatorio.trabajopracticospring.dto.listareproduccion.ListaReproduccionDto;
import com.informatorio.trabajopracticospring.dto.respuesta.RespuestaDto;
import com.informatorio.trabajopracticospring.service.cancion.CancionService;
import com.informatorio.trabajopracticospring.service.listareproduccion.ListaReproduccionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    @PostMapping("/usuario/{idUsuario}")
    public ResponseEntity<RespuestaDto> crearListaReproduccion(@PathVariable(name = "idUsuario") UUID idUsuario, @RequestBody CrearListaReproduccionDto crearListaReproduccionDto){
        listaReproduccionService.crearListaReproduccion(idUsuario, crearListaReproduccionDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new RespuestaDto(ConstantsUtils.STATUS_201,ConstantsUtils.MESSAGE_201));
    }

    @PutMapping("/usuario/{idUsuario}/{idListaReproduccion}")
    public ResponseEntity<RespuestaDto> actualizarListaReproduccion(
            @PathVariable(name = "idUsuario") UUID idUsuario,
            @PathVariable(name = "idListaReproduccion") UUID idListaReproduccion,
            @RequestBody ListaReproduccionAtributosDto listaReproduccionAtributosDto) {

        boolean fueActualizado = listaReproduccionService.actualizarListaReproduccion(idUsuario,idListaReproduccion,listaReproduccionAtributosDto);

        if (fueActualizado){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new RespuestaDto(ConstantsUtils.STATUS_200,ConstantsUtils.MESSAGE_200));
        }else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new RespuestaDto(ConstantsUtils.STATUS_500,ConstantsUtils.MESSAGE_500));
        }
    }
}
