package com.example.tp3_streaming.model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Album {
    private String id;
    private String titulo;
    private int anio;
}
