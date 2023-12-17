package com.informatorio.trabajopracticospring.repository.listareproduccion;

import com.informatorio.trabajopracticospring.dominio.ListaReproduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ListaReproduccionRepository extends JpaRepository<ListaReproduccion, UUID> {
    List<ListaReproduccion> findByPublicaAndNombreContainingIgnoreCase(boolean publica, String nombre);
    List<ListaReproduccion> findByUsuarioIdOrderByCreadoEnDesc(UUID idUsuario);
}
