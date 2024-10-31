package org.example;

import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Sistema de Gestión del Hospital");

        // Crear médicos (hilos)
        Medico medico1 = new Medico("Dr. García", Especialidad.CARDIOLOGIA);
        Medico medico2 = new Medico("Dra. Pérez", Especialidad.PEDIATRIA);

        // Crear pacientes
        for (int i = 0; i < 6; i++) {
            Paciente paciente = new Paciente("Paciente " + (i + 1));
            if (i % 2 == 0) {
                medico1.agregarPaciente(paciente);
            } else {
                medico2.agregarPaciente(paciente);
            }
        }

        // Iniciar hilos
        medico1.start();
        medico2.start();

        try {
            medico1.join();
            medico2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Guardar resultados en la base de datos
        Persistencia.guardarAtencionMedica(medico1.getNombre(), medico1.getEspecialidad(), medico1.getTotalPacientesAtendidos());
        Persistencia.guardarAtencionMedica(medico2.getNombre(), medico2.getEspecialidad(), medico2.getTotalPacientesAtendidos());

        System.out.println("Simulación completada.");
    }
}
