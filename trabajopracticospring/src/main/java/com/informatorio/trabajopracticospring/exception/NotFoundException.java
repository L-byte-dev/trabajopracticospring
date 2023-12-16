package com.informatorio.trabajopracticospring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    public NotFoundException(String nombreDeRecurso,String nombreDeAtributo, String valorDeAtributo) {
        super(String.format("No se encuentra el recurso %s con el dato de entrada %s : %s",nombreDeRecurso, nombreDeAtributo, valorDeAtributo));
    }
}