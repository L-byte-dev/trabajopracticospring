package com.informatorio.trabajopracticospring.dto.usuario;

import com.informatorio.trabajopracticospring.dto.listareproduccion.ListaReproduccionDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UsuarioDto {
    private String nombre;
    private String nombreUsuario;
    private List<ListaReproduccionDto> listasReproduccionDto = new ArrayList<>();
}
