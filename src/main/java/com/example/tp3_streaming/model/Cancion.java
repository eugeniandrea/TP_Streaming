package com.example.tp3_streaming.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cancion {
    private String id;
    private String titulo;
    private String artista;
    private String album;
    private Genero genero;
    private int duracionSegundos;
    private double rating; 
    private LocalDate fechaLanzamiento;

    // requerimiento de recurrencia
    private AtomicInteger reproducciones = new AtomicInteger(0);

    public Cancion(String id, String titulo, String artista, String album, Genero genero, int duracion, double rating){
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.genero = genero;
        this.duracionSegundos = duracion;
        this.reproducciones = new AtomicInteger(0);
        this.fechaLanzamiento = LocalDate.now();
    }



}
