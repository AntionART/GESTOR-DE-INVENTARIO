package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMysql {
    private static final String URL = "jdbc:mysql://localhost:3306/miproyecto";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection cn;

    public static Connection conectar() {
        try {
            if (cn == null || cn.isClosed()) {
                cn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión Exitosa");
            }
        } catch (SQLException e) {
            System.out.println("Error de conexión a la base de datos: " + e);
        }
        return cn;
    }
}
