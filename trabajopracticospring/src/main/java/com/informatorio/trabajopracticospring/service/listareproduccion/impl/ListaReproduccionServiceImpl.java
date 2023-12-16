package com.informatorio.trabajopracticospring.service.listareproduccion.impl;

import com.informatorio.trabajopracticospring.repository.listareproduccion.ListaReproduccionRepository;
import com.informatorio.trabajopracticospring.service.listareproduccion.ListaReproduccionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListaReproduccionServiceImpl implements ListaReproduccionService {
    private final ListaReproduccionRepository listaReproduccionRepository;
}
