package com.informatorio.trabajopracticospring.repository.artista;

import com.informatorio.trabajopracticospring.dominio.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, UUID> {
}
