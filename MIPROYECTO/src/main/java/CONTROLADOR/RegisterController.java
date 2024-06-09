package CONTROLADOR;

import Conexion.ConexionMysql;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterController {

    public static void register(String nombre, String apellido, String correo, String contrasena) {
        Connection connection = ConexionMysql.getConnection();
        try {
            String query = "INSERT INTO usuarios (nombre, apellido, correo, contrasena) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setString(2, apellido);
            statement.setString(3, correo);
            statement.setString(4, contrasena);

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al registrar el usuario");
        }
    }
}