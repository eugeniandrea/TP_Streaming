package com.example.tp3_streaming.strategy;

import com.example.tp3_streaming.model.Cancion;
import java.util.List;

public interface RecomendacionStrategy {
    List<Cancion> recomendar(List<Cancion> catalogo, Cancion base);
}
