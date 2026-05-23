package com.example.tp3_streaming.strategy;

import com.example.tp3_streaming.model.Cancion;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class RecomendacionPorGenero implements RecomendacionStrategy{
    @Override
    public List<Cancion> recomendar(List<Cancion> catalogo, Cancion base){
        return catalogo.stream()
        // filtro para canciones del mismo genero
        .filter(c -> c.getGenero().equals(base.getGenero()))
        // orden de rating mayor a menor
        .sorted(Comparator.comparingDouble(Cancion::getRating).reversed())
        .collect(Collectors.toList());
    }
}
