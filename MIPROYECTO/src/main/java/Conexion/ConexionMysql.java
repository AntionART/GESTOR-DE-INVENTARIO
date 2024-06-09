package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMysql {

    public static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    Connection cn;

    public Connection conectar() {
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost/miproyecto", "root", "");
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.out.println("Error de conexión a la base de datos: " + e);
        }
        return cn;
    }
}