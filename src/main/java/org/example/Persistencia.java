package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Persistencia {
    public static void guardarAtencionMedica(String nombreMedico, Especialidad especialidad, int pacientesAtendidos) {
        String sql = "INSERT INTO atencion_medica(nombreMedico, especialidad, pacientesAtendidos) VALUES(?,?,?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreMedico);
            pstmt.setString(2, especialidad.toString());
            pstmt.setInt(3, pacientesAtendidos);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
