package com.example.tp3_streaming.service;

import com.example.tp3_streaming.model.Cancion;
import com.example.tp3_streaming.model.Genero;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CancionService {
    private List<Cancion> catalogo = new ArrayList<>();

    // para que no este vacio
    public CancionService() {
        catalogo.add(new Cancion("1", "In the End", "Linkin Park", "Hybrid Theory", Genero.ROCK, 216, 4.9));
        catalogo.add(new Cancion("2", "Numb", "Linkin Park", "Meteora", Genero.ROCK, 187, 4.8));
        catalogo.add(new Cancion("3", "Clair de Lune", "Debussy", "Suite", Genero.CLASICA, 300, 5.0));
    }

    // Para ver todas las canciones
    public List<Cancion> getCatalogo() {
        return catalogo;
    }

    // para que sume una reproducción cuando alguien escucha
    public void incrementarReproduccion(String id) {
        catalogo.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .ifPresent(c -> c.getReproducciones().incrementAndGet());
    }

    // Saca las 10 que mas se escuchan
    public List<Cancion> getTop10(){
        return catalogo.stream()
            .sorted((c1, c2) -> Integer.compare(c2.getReproducciones().get(), c1.getReproducciones().get()))
            .limit(10)
            .collect(Collectors.toList());
    }

    // promedio de tiempo segun el genero que pida
    public Double promedioDuracionPorGenero (Genero genero){
        return catalogo.stream()
            .filter(c -> c.getGenero().equals(genero))
            .collect(Collectors.averagingInt(Cancion::getDuracionSegundos));
    }

    // busqueda binaria (tengo que ordenar por titulo si o si)
    public Cancion buscarPorTituloBinario (String titulo){
        catalogo.sort(Comparator.comparing(Cancion::getTitulo));
        int index = Collections.binarySearch(catalogo,
            new Cancion(null, titulo, null, null, null, 0, 0),
            Comparator.comparing(Cancion::getTitulo));
        return (index >= 0) ? catalogo.get(index) : null;
    }

    // arma una lista que no se pase de los minutos que le doy
    public List<Cancion> generarPlaylist(int minutosMax) {
        int segundosMax = minutosMax * 60;
        int acumulado = 0;
        List<Cancion> playlist = new ArrayList<>();
        
        for(Cancion c : catalogo){
            if (acumulado + c.getDuracionSegundos() <= segundosMax) {
                playlist.add(c);
                acumulado += c.getDuracionSegundos();
            }
        }
        return playlist;
    }
}
