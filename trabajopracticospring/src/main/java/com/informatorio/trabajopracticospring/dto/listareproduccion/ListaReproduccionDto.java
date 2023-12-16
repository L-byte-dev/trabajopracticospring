package com.informatorio.trabajopracticospring.dto.listareproduccion;

import lombok.Data;

import java.util.UUID;

@Data
public class ListaReproduccionDto {
    private String nombre;
    private UUID id;
    private int cantCanciones;
}
