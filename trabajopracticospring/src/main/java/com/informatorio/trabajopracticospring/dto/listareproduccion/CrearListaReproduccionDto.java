package com.informatorio.trabajopracticospring.dto.listareproduccion;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class CrearListaReproduccionDto {
    @NotBlank(message = "El nombre de la lista de reproduccion no pueder ser nulo o vacio")
    private String nombre;

    private List<UUID> canciones = new ArrayList<>();
}
