package org.example;

import java.util.Random;

public class Paciente {
    private String nombre;
    private int tiempoAtencion; // en milisegundos

    public Paciente(String nombre) {
        this.nombre = nombre;
        Random rand = new Random();
        this.tiempoAtencion = rand.nextInt(3000) + 2000; // Tiempo de atención entre 2 y 5 segundos
    }

    public String getNombre() {
        return nombre;
    }

    public int getTiempoAtencion() {
        return tiempoAtencion;
    }
}
