package com.informatorio.trabajopracticospring.dto.genero;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GeneroDto {
    @NotBlank(message = "El nombre del genero no pueder ser nulo o vacio")
    private String nombre;
}
