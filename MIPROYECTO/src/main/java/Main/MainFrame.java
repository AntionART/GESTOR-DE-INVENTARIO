package VISTA;

import javax.swing.*;

public class MainFrame extends JFrame {
    private JMenuBar menuBar;
    private JMenu cuentaMenu;
    private JMenuItem miPerfilMenuItem;
    private JMenuItem cerrarSesionMenuItem;

    public MainFrame() {
        setTitle("Gestor de Inventario");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        menuBar = new JMenuBar();

        cuentaMenu = new JMenu("Cuenta");
        miPerfilMenuItem = new JMenuItem("Mi Perfil");
        cerrarSesionMenuItem = new JMenuItem("Cerrar Sesión");

        cerrarSesionMenuItem.addActionListener(e -> {
            dispose();
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        });

        cuentaMenu.add(miPerfilMenuItem);
        cuentaMenu.add(cerrarSesionMenuItem);

        menuBar.add(cuentaMenu);

        setJMenuBar(menuBar);
    }
}