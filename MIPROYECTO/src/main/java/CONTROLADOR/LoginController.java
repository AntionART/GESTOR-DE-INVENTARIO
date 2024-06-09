package CONTROLADOR;

import Conexion.ConexionMysql;
import VISTA.MainFrame;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    public static void login(String correo, String contrasena) {
        Connection connection = ConexionMysql.getConnection();
        try {
            String query = "SELECT * FROM usuarios WHERE correo = ? AND contrasena = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, correo);
            statement.setString(2, contrasena);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Actualizar el último acceso
                String updateQuery = "UPDATE usuarios SET ultimo_acceso = CURRENT_TIMESTAMP WHERE id = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setInt(1, resultSet.getInt("id"));
                updateStatement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión");
        }
    }
}
