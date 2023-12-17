package com.informatorio.trabajopracticospring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorizedAccessException extends RuntimeException {
    public UnauthorizedAccessException(String idUsuario,String idListaReproduccion) {
        super(String.format("El usuario %s no es el creador de la lista de reproducción %s", idUsuario, idListaReproduccion));
    }
}
