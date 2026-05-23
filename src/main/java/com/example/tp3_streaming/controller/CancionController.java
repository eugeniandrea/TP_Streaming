package com.example.tp3_streaming.controller;

import com.example.tp3_streaming.model.Cancion;
import com.example.tp3_streaming.service.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/canciones")
public class CancionController {

    @Autowired
    private CancionService cancionService;

    // devuelve la lista completa
    @GetMapping
    public List<Cancion> listar() {
        return cancionService.getCatalogo();
    }

    // Este es para sumar reproducciones por ID
    @PostMapping("/{id}/reproducir")
    public void reproducir(@PathVariable String id) {
        cancionService.incrementarReproduccion(id);
    }

    // ranking de las 10 mejores
    @GetMapping("/top10")
    public List<Cancion> top10() {
        return cancionService.getTop10();
    }
    
    // busca una cancion por el titulo exacto
    @GetMapping("/buscar")
    public Cancion buscar(@RequestParam String titulo) {
        return cancionService.buscarPorTituloBinario(titulo);
    }
}