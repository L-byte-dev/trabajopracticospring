package com.informatorio.trabajopracticospring.dto.cancion;

import com.informatorio.trabajopracticospring.dto.genero.GeneroDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CancionSinArtistaDto {
    private String nombre;
    private int ranking;
    private List<GeneroDto> generosDto = new ArrayList<>();
    private Double duracion;
    private String album;
}
