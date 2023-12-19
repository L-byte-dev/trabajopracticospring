package com.informatorio.trabajopracticospring.dto.artista;

import com.informatorio.trabajopracticospring.dto.cancion.CancionSinArtistaDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class ArtistaCancionesDto {
    @NotBlank(message = "El nombre del artista no pueder ser nulo o vacio")
    private String nombre;

    @Valid
    private List<CancionSinArtistaDto> canciones;
}
