/*
package com.informatorio.trabajopracticospring.bootstrap;

import com.informatorio.trabajopracticospring.dominio.*;
import com.informatorio.trabajopracticospring.repository.artista.ArtistaRepository;
import com.informatorio.trabajopracticospring.repository.cancion.CancionRepository;
import com.informatorio.trabajopracticospring.repository.genero.GeneroRepository;
import com.informatorio.trabajopracticospring.repository.listareproduccion.ListaReproduccionRepository;
import com.informatorio.trabajopracticospring.repository.usuario.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private ArtistaRepository artistaRepository;
    private CancionRepository cancionRepository;
    private GeneroRepository generoRepository;
    private ListaReproduccionRepository listaReproduccionRepository;
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        cargarDatos();
    }

    private void cargarDatos() {
        Artista artista1 = new Artista(UUID.randomUUID(), "Artista 1", new ArrayList<>());
        Artista artista2 = new Artista(UUID.randomUUID(), "Artista 2", new ArrayList<>());
        artistaRepository.saveAll(List.of(artista1, artista2));

        Genero genero1 = new Genero(UUID.randomUUID(), "Género 1", new ArrayList<>());
        Genero genero2 = new Genero(UUID.randomUUID(), "Género 2", new ArrayList<>());
        generoRepository.saveAll(List.of(genero1, genero2));

        Cancion cancion1 = new Cancion(UUID.randomUUID(), "Canción 1", 1, new ArrayList<>(), 3.5, artista1, "Álbum 1");
        cancion1.getGeneros().add(genero1);
        cancionRepository.save(cancion1);

        Cancion cancion2 = new Cancion(UUID.randomUUID(), "Canción 2", 2, new ArrayList<>(), 4.0, artista2, "Álbum 2");
        cancion2.getGeneros().add(genero2);
        cancionRepository.save(cancion2);

        Usuario usuario1 = new Usuario(UUID.randomUUID(), "Usuario 1", "user1", new ArrayList<>());
        Usuario usuario2 = new Usuario(UUID.randomUUID(), "Usuario 2", "user2", new ArrayList<>());
        usuario1.setCreadoPor("Admin");
        usuario1.setCreadoEn(LocalDateTime.now());
        usuario2.setCreadoPor("Admin");
        usuario2.setCreadoEn(LocalDateTime.now());
        usuarioRepository.saveAll(List.of(usuario1, usuario2));

        ListaReproduccion lista1 = new ListaReproduccion(UUID.randomUUID(), "Lista de reproducción 1", usuario1, new ArrayList<>(), true, false, true);
        lista1.getCanciones().add(cancion1);
        lista1.setCreadoPor(usuario1.getNombreUsuario());
        lista1.setCreadoEn(LocalDateTime.now());
        listaReproduccionRepository.save(lista1);

        ListaReproduccion lista2 = new ListaReproduccion(UUID.randomUUID(), "Lista de reproducción 1", usuario2, new ArrayList<>(), false, true, false);
        lista2.getCanciones().add(cancion2);
        lista2.setCreadoPor(usuario2.getNombreUsuario());
        lista2.setCreadoEn(LocalDateTime.now());
        listaReproduccionRepository.save(lista2);
    }
}

 */