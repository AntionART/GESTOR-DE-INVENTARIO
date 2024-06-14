package CONTROLADOR;

import MODELO.RegistroUsuario;
import MODELO.Usuario;
import VISTA.frm_Login;
import VISTA.frm_RegistrarUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controlador_Frm_Login {
    private frm_Login vista;
    private RegistroUsuario modelo;

    public Controlador_Frm_Login(frm_Login vista) {
        this.vista = vista;
        this.modelo = new RegistroUsuario();
        this.vista.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        this.vista.btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirFormularioRegistro();
            }
        });
    }

    private void login() {
        String correo = vista.txtCorreo.getText();
        String contrasena = new String(vista.txtContrasena.getPassword());
        Usuario usuario = modelo.login(correo, contrasena);
        if (usuario != null) {
            JOptionPane.showMessageDialog(vista, "Login exitoso!");
            // Aquí puedes abrir la ventana principal de tu aplicación
        } else {
            JOptionPane.showMessageDialog(vista, "Correo o contraseña incorrectos");
        }
    }

    private void abrirFormularioRegistro() {
        frm_RegistrarUsuario registroVista = new frm_RegistrarUsuario();
        registroVista.setVisible(true);
        vista.dispose();
    }
}