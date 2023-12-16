package com.informatorio.trabajopracticospring.dto.listareproduccion;

import lombok.Data;

import java.util.UUID;

@Data
public class ListaReproduccionDto {
    private UUID id;
    private String nombre;
    private int cantCanciones;
}
