package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // Cambia estos valores según tu configuración de MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/hospital"; // Cambia "hospital" al nombre de tu BD
    private static final String USER = "tu_usuario"; // Reemplaza con tu usuario de MySQL
    private static final String PASSWORD = "tu_contraseña"; // Reemplaza con tu contraseña de MySQL

    public static Connection conectar() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión a la base de datos establecida.");
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
        return conn;
    }
}
