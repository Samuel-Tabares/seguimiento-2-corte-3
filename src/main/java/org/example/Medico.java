package org.example;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Thread {
    private String nombre;
    private Especialidad especialidad;
    private List<Paciente> pacientesAtendidos;
    private int totalPacientesAtendidos;

    public Medico(String nombre, Especialidad especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.pacientesAtendidos = new ArrayList<>();
        this.totalPacientesAtendidos = 0;
    }

    @Override
    public void run() {
        while (!pacientesAtendidos.isEmpty()) {
            try {
                Paciente paciente = pacientesAtendidos.remove(0);
                System.out.println(nombre + " está atendiendo a " + paciente.getNombre() + " en " + especialidad);
                Thread.sleep(paciente.getTiempoAtencion());
                totalPacientesAtendidos++;
                System.out.println(nombre + " ha terminado de atender a " + paciente.getNombre());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void agregarPaciente(Paciente paciente) {
        pacientesAtendidos.add(paciente);
    }

    public int getTotalPacientesAtendidos() {
        return totalPacientesAtendidos;
    }

    public String getNombre() {
        return nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
