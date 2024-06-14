package CONTROLADOR;

import MODELO.RegistroUsuario;
import MODELO.Usuario;
import VISTA.frm_Login;
import VISTA.frm_RegistrarUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controlador_Frm_Registrar_Usuario {
    private frm_RegistrarUsuario vista;
    private RegistroUsuario modelo;

    public Controlador_Frm_Registrar_Usuario(frm_RegistrarUsuario vista) {
        this.vista = vista;
        this.modelo = new RegistroUsuario();
        this.vista.btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });
    }

    private void registrarUsuario() {
        String nombre = vista.setNombre.getText();
        String apellido = vista.setApellido.getText();
        String correo = vista.setCorreo.getText();
        String contrasena = new String(vista.setContrasena.getPassword());
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setCorreo(correo);
        usuario.setContrasena(contrasena);

        if (modelo.registrarUsuario(usuario)) {
            JOptionPane.showMessageDialog(vista, "Usuario registrado exitosamente!");
            frm_Login loginVista = new frm_Login();
            loginVista.setVisible(true);
            vista.dispose();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al registrar el usuario");
        }
    }
}
