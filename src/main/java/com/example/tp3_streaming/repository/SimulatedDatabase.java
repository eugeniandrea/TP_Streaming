package com.example.tp3_streaming.repository;

import com.example.tp3_streaming.model.Cancion;
import com.example.tp3_streaming.model.Genero;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SimulatedDatabase {
    private List<Cancion> canciones = new ArrayList<>();

    public SimulatedDatabase() {
        // datos de prueba 
        canciones.add(new Cancion("1", "In the End", "Linkin Park", "Hybrid Theory", Genero.ROCK, 216, 4.9));
        canciones.add(new Cancion("2", "Numb", "Linkin Park", "Meteora", Genero.ROCK, 187, 4.8));
        canciones.add(new Cancion("3", "Clair de Lune", "Debussy", "Suite bergamasque", Genero.CLASICA, 300, 5.0));
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }
}
