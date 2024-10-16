import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla_iniciosesion extends General {
    public Pantalla_iniciosesion(){
        //VENTANA
        JFrame ventanaPrincipal = crearventana();

        //PANEL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        ventanaPrincipal.add(panelPrincipal);

        //TEXTO REGISTRO
        JLabel bienvenida = new JLabel();
        bienvenida.setText("INGRESE SUS DATOS PARA ACCEDER");
        bienvenida.setBounds(172, 260, 500, 100);
        bienvenida.setForeground(Color.red);
        bienvenida.setFont(new Font("Arial", Font.BOLD, 20));
        panelPrincipal.add(bienvenida);


        //AGREGAR BOTON INICIAR SESIÓN
        ImageIcon imagenboton = new ImageIcon("");
        JButton botonprincipal = new JButton("INICIAR SESIÓN");
        botonprincipal.setFocusable(false);
        botonprincipal.setBounds(260, 610, 220, 40);
        botonprincipal.setForeground(Color.white);
        botonprincipal.setFont(new Font("Arial", Font.BOLD, 14));
        botonprincipal.setBackground(Color.RED);
        botonprincipal.setIcon(new ImageIcon(imagenboton.getImage().getScaledInstance(botonprincipal.getWidth(), botonprincipal.getHeight(), Image.SCALE_SMOOTH)));
        botonprincipal.setBorderPainted(false);
        panelPrincipal.add(botonprincipal);

        botonprincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.dispose();

                PanelPrincipal vuelvo = new PanelPrincipal();
            }
        });

        // AGREGAR CAMPO CORREO
        JLabel etiquetaCorreo = new JLabel("Correo:");
        etiquetaCorreo.setBounds(100, 400, 100, 30);
        panelPrincipal.add(etiquetaCorreo);

        // CAMPO CORREO
        JTextField campoCorreo = new JTextField();
        campoCorreo.setBounds(200, 400, 300, 30);
        panelPrincipal.add(campoCorreo);


        // AGREGAR CAMPO CONTRASEÑA
        JLabel etiquetaContrasena = new JLabel("Contraseña:");
        etiquetaContrasena.setBounds(100, 450, 100, 30);
        panelPrincipal.add(etiquetaContrasena);

        // CAMPO CONTRASEÑA
        JPasswordField campoContrasena = new JPasswordField();
        campoContrasena.setBounds(200, 450, 300, 30);
        panelPrincipal.add(campoContrasena);


        //AGREGAR IMAGEN LOGO
        ImageIcon imagenlogo = new ImageIcon("res/Pantalla1/LOGO.png");
        JLabel logo = new JLabel();
        logo.setBounds(100,100,520,155);
        logo.setIcon(new ImageIcon(imagenlogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(logo);


        ventanaPrincipal.setVisible(true);

    }



}