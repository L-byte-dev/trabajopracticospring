package com.informatorio.trabajopracticospring.dto.usuario;

import com.informatorio.trabajopracticospring.dto.listareproduccion.ListaReproduccionDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UsuarioDto {
    @NotBlank(message = "El nombre del usuario no pueder ser nulo o vacio")
    private String nombre;

    @NotBlank(message = "El nombre del usuario no pueder ser nulo o vacio")
    private String nombreUsuario;

    @Valid
    private List<ListaReproduccionDto> listasReproduccionDto = new ArrayList<>();
}
