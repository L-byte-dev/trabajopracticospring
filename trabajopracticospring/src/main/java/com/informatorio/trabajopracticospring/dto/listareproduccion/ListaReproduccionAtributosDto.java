package com.informatorio.trabajopracticospring.dto.listareproduccion;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ListaReproduccionAtributosDto {
    @NotNull(message = "El valor no puede ser nulo")
    private boolean repite;

    @NotNull(message = "El valor no puede ser nulo")
    private boolean aleatorio;

    @NotNull(message = "El valor no puede ser nulo")
    private boolean publica;
}
