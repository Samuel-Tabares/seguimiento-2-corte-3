package org.example;

import java.util.Random;

public class Paciente<T> {
    private T nombre;
    private int tiempoAtencion; // en milisegundos

    public Paciente(T nombre) {
        this.nombre = nombre;
        Random rand = new Random();
        this.tiempoAtencion = rand.nextInt(3000) + 2000; // Tiempo de atención entre 2 y 5 segundos
    }

    public T getNombre() {
        return nombre;
    }

    public int getTiempoAtencion() {
        return tiempoAtencion;
    }
}
