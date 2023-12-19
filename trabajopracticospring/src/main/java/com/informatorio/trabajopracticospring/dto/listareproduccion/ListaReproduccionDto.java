package com.informatorio.trabajopracticospring.dto.listareproduccion;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class ListaReproduccionDto {
    @NotNull(message = "El id de la lista de reproduccion no puede ser nulo")
    private UUID id;

    @NotBlank(message = "El nombre de la lista de reproduccion no pueder ser nulo o vacio")
    private String nombre;

    @NotNull(message = "Las canciones de la lista de reproduccion no pudern ser nula")
    @Min(0)
    private int cantCanciones;
}
