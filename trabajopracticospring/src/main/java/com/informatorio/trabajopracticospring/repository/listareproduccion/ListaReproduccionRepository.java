package com.informatorio.trabajopracticospring.repository.listareproduccion;

import com.informatorio.trabajopracticospring.dominio.ListaReproduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ListaReproduccionRepository extends JpaRepository<ListaReproduccion, UUID> {
}
