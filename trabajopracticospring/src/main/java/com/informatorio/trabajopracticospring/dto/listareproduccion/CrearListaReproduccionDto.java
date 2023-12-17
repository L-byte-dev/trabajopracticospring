package com.informatorio.trabajopracticospring.dto.listareproduccion;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CrearListaReproduccionDto {
    private String nombre;
    private List<UUID> canciones;
}
