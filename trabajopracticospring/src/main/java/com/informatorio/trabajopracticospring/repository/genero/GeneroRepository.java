package com.informatorio.trabajopracticospring.repository.genero;

import com.informatorio.trabajopracticospring.dominio.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, UUID> {
}
