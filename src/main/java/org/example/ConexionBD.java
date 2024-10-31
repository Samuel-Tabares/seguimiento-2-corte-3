package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // Configuración de conexión
    private static final String URL = "jdbc:mysql://localhost:3306/hospital?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection conectar() {
        Connection conn = null;
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión a la base de datos establecida.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver de MySQL. " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
        return conn;
    }
}

