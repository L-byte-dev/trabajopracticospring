package com.informatorio.trabajopracticospring.dto.artista;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ArtistaDto {
    @NotBlank(message = "El nombre del artista no pueder ser nulo o vacio")
    private String nombre;
}
