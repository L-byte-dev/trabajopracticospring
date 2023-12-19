package com.informatorio.trabajopracticospring.dto.cancion;

import com.informatorio.trabajopracticospring.dto.artista.ArtistaDto;
import com.informatorio.trabajopracticospring.dto.genero.GeneroDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CancionDto {
    @NotBlank(message = "El nombre de la cancion no pueder ser nulo o vacio")
    private String nombre;

    @Positive
    private int ranking;

    @Valid
    private List<GeneroDto> generosDto = new ArrayList<>();

    @Positive
    private Double duracion;

    @Valid
    private ArtistaDto artistaDto;

    @NotNull(message = "El nombre del album no pueder ser nulo")
    private String album;
}
