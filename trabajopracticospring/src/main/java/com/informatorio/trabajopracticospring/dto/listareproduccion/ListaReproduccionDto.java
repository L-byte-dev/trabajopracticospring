package com.informatorio.trabajopracticospring.dto.listareproduccion;

import com.informatorio.trabajopracticospring.dto.cancion.CancionDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListaReproduccionDto {
    private List<CancionDto> canciones = new ArrayList<>();
    private int cantCanciones = this.canciones.size();
    private String nombre;
    private boolean repite;
    private boolean aleatorio;
    private boolean publica;
}
