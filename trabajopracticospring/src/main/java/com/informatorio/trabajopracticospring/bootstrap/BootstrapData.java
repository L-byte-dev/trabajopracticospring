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
        if (artistaRepository.count() == 0 && generoRepository.count() == 0 && cancionRepository.count() == 0 && usuarioRepository.count() == 0 && listaReproduccionRepository.count() == 0) {
            Artista artista1 = new Artista(UUID.randomUUID(), "Los Fabulosos Cadillacs", new ArrayList<>());
            Artista artista2 = new Artista(UUID.randomUUID(), "Soda Stereo", new ArrayList<>());
            Artista artista3 = new Artista(UUID.randomUUID(), "Almendra", new ArrayList<>());
            Artista artista4 = new Artista(UUID.randomUUID(), "Carlos Gardel", new ArrayList<>());
            Artista artista5 = new Artista(UUID.randomUUID(), "Andrés Calamaro", new ArrayList<>());
            Artista artista6 = new Artista(UUID.randomUUID(), "Fito Páez", new ArrayList<>());
            Artista artista7 = new Artista(UUID.randomUUID(), "Los Gatos", new ArrayList<>());
            Artista artista8 = new Artista(UUID.randomUUID(), "Enanitos Verdes", new ArrayList<>());
            artistaRepository.saveAll(List.of(artista1, artista2, artista3, artista4, artista5, artista6, artista7, artista8));

            Genero genero1 = new Genero(UUID.randomUUID(), "Batucada", new ArrayList<>());
            Genero genero2 = new Genero(UUID.randomUUID(), "Alterlatino", new ArrayList<>());
            Genero genero3 = new Genero(UUID.randomUUID(), "Murga", new ArrayList<>());
            Genero genero4 = new Genero(UUID.randomUUID(), "Rock Alternativo", new ArrayList<>());
            Genero genero5 = new Genero(UUID.randomUUID(), "Folk Rock", new ArrayList<>());
            Genero genero6 = new Genero(UUID.randomUUID(), "Tango", new ArrayList<>());
            Genero genero7 = new Genero(UUID.randomUUID(), "New Wave", new ArrayList<>());
            Genero genero8 = new Genero(UUID.randomUUID(), "Pop Rock", new ArrayList<>());
            Genero genero9 = new Genero(UUID.randomUUID(), "Downtempo", new ArrayList<>());
            Genero genero10 = new Genero(UUID.randomUUID(), "Beat Music", new ArrayList<>());
            generoRepository.saveAll(List.of(genero1, genero2, genero3, genero4, genero5, genero6, genero7, genero8, genero9, genero10));

            Cancion cancion1 = new Cancion(UUID.randomUUID(), "Matador", 1, new ArrayList<>(), 4.33, artista1, "Vasos Vacíos");
            cancion1.getGeneros().addAll(List.of(genero1, genero2, genero3));
            Cancion cancion2 = new Cancion(UUID.randomUUID(), "De música ligera", 2, new ArrayList<>(), 3.32, artista2, "Canción Animal");
            cancion2.getGeneros().add(genero4);
            Cancion cancion3 = new Cancion(UUID.randomUUID(), "Muchacha (Ojos de papel)", 3, new ArrayList<>(), 3.08, artista3, "Almendra");
            cancion3.getGeneros().add(genero5);
            Cancion cancion4 = new Cancion(UUID.randomUUID(), "El dia que me quieras", 4, new ArrayList<>(), 3.21, artista4, "Tango Collection");
            cancion4.getGeneros().add(genero6);
            Cancion cancion5 = new Cancion(UUID.randomUUID(), "Volver", 5, new ArrayList<>(), 2.54, artista4, "Tango Collection");
            cancion5.getGeneros().add(genero6);
            Cancion cancion6 = new Cancion(UUID.randomUUID(), "Cuando pase el temblor", 6, new ArrayList<>(), 3.49, artista2, "Nada Personal");
            cancion6.getGeneros().addAll(List.of(genero2, genero7));
            Cancion cancion7 = new Cancion(UUID.randomUUID(), "Flaca", 7, new ArrayList<>(), 4.37, artista5, "Alta Suciedad");
            cancion7.getGeneros().add(genero8);
            Cancion cancion8 = new Cancion(UUID.randomUUID(), "El amor después del amor", 8, new ArrayList<>(), 5.11, artista6, "El amor después del amor");
            cancion8.getGeneros().addAll(List.of(genero8, genero9));
            Cancion cancion9 = new Cancion(UUID.randomUUID(), "La balsa", 9, new ArrayList<>(), 2.56, artista6, "Los Gatos");
            cancion9.getGeneros().add(genero10);
            Cancion cancion10 = new Cancion(UUID.randomUUID(), "Lamento Boliviano", 10, new ArrayList<>(), 3.43, artista8, "Big Bang");
            cancion10.getGeneros().addAll(List.of(genero4, genero8));
            cancionRepository.saveAll(List.of(cancion1, cancion2, cancion3, cancion4, cancion5, cancion6, cancion7, cancion8, cancion9, cancion10));

            Usuario usuario1 = new Usuario(UUID.randomUUID(), "Usuario 1", "username1", new ArrayList<>());
            usuario1.setCreadoPor("Admin");
            usuario1.setCreadoEn(LocalDateTime.now());
            usuario1.setActualizadoPor("Admin");
            usuario1.setActualizadoEn(LocalDateTime.now());
            Usuario usuario2 = new Usuario(UUID.randomUUID(), "Usuario 2", "NombreDeUsuario2", new ArrayList<>());
            usuario2.setCreadoPor("Admin");
            usuario2.setCreadoEn(LocalDateTime.now());
            usuario2.setActualizadoPor("Admin");
            usuario2.setActualizadoEn(LocalDateTime.now());
            usuarioRepository.saveAll(List.of(usuario1, usuario2));

            ListaReproduccion lista1 = new ListaReproduccion(UUID.randomUUID(), "Lista de reproducción 1", usuario1, new ArrayList<>(), true, false, true);
            lista1.getCanciones().addAll(List.of(cancion1, cancion2, cancion3, cancion4, cancion5));
            lista1.setCreadoPor(usuario1.getNombreUsuario());
            lista1.setCreadoEn(LocalDateTime.now());
            lista1.setActualizadoPor(usuario1.getNombreUsuario());
            lista1.setActualizadoEn(LocalDateTime.now());
            ListaReproduccion lista2 = new ListaReproduccion(UUID.randomUUID(), "Playlist 2", usuario2, new ArrayList<>(), false, true, false);
            lista2.getCanciones().addAll(List.of(cancion6, cancion7, cancion8, cancion9, cancion10));
            lista2.setCreadoPor(usuario2.getNombreUsuario());
            lista2.setCreadoEn(LocalDateTime.now());
            lista2.setActualizadoPor(usuario2.getNombreUsuario());
            lista2.setActualizadoEn(LocalDateTime.now());
            listaReproduccionRepository.saveAll(List.of(lista1, lista2));
        }
    }
}