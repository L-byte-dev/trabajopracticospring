package com.informatorio.trabajopracticospring.repository.cancion;

import com.informatorio.trabajopracticospring.dominio.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, UUID> {
}
