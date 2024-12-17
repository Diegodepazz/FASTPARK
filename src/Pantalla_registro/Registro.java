package Pantalla_registro;

import Main.General_ventanas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase Registro que representa la pantalla para registrar una nueva cuenta.
 * Extiende la clase General_ventanas para heredar las configuraciones comunes de las ventanas.
 */
public class Registro extends General_ventanas {

    /**
     * Constructor de la clase Registro.
     * Configura la ventana, paneles, etiquetas, botones y campos de texto para el registro de usuarios.
     */
    public Registro() {
        // VENTANA: Configuración principal de la ventana
        JFrame ventanaPrincipal = crearventana();

        // PANEL: Configuración del panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        ventanaPrincipal.add(panelPrincipal);

        // TEXTO: Mensaje de bienvenida indicando que el usuario debe registrarse
        JLabel bienvenida = new JLabel();
        bienvenida.setText("INGRESE SUS DATOS PARA REGISTRARSE");
        bienvenida.setBounds(155, 250, 500, 100);
        bienvenida.setForeground(Color.red);
        bienvenida.setFont(new Font("Arial", Font.BOLD, 18));
        panelPrincipal.add(bienvenida);

        // BOTÓN: Registrar cuenta
        ImageIcon imagenboton = new ImageIcon("");
        JButton botonprincipal = new JButton("REGISTRAR CUENTA");
        botonprincipal.setFocusable(false);
        botonprincipal.setBounds(260, 550, 220, 40);
        botonprincipal.setForeground(Color.white);
        botonprincipal.setFont(new Font("Arial", Font.BOLD, 14));
        botonprincipal.setBackground(Color.red);
        botonprincipal.setOpaque(true);
        botonprincipal.setBorderPainted(false);
        panelPrincipal.add(botonprincipal);

        // Acción del botón: Redirige al inicio de sesión
        botonprincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Inicio_sesion();
                ventanaPrincipal.dispose();
            }
        });

        // BOTÓN: Retorno a la pantalla de opciones
        ImageIcon imagenboton1 = new ImageIcon("Imagenes/BOTON_RETORNO.png");
        JButton botonprincipal1 = new JButton("");
        botonprincipal1.setFocusable(false);
        botonprincipal1.setBounds(350, 620, 38, 40);
        botonprincipal1.setIcon(new ImageIcon(imagenboton1.getImage().getScaledInstance(botonprincipal1.getWidth(), botonprincipal1.getHeight(), Image.SCALE_SMOOTH)));
        botonprincipal1.setBorderPainted(false);
        panelPrincipal.add(botonprincipal1);

        // Acción del botón de retorno: Redirige a Opciones_usuario
        botonprincipal1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Opciones_usuario();
                ventanaPrincipal.dispose();
            }
        });

        // ETIQUETA Y CAMPO: Nombre y apellidos
        JLabel camponombre = new JLabel("Nombre y apellidos:");
        camponombre.setBounds(100, 375, 150, 30);
        panelPrincipal.add(camponombre);

        JTextField campoNombre = new JTextField();
        campoNombre.setBounds(265, 375, 300, 30);
        panelPrincipal.add(campoNombre);

        // ETIQUETA Y CAMPO: Correo electrónico
        JLabel campocorreo = new JLabel("Correo:");
        campocorreo.setBounds(100, 425, 100, 30);
        panelPrincipal.add(campocorreo);

        JTextField campoCorreo = new JTextField();
        campoCorreo.setBounds(265, 425, 300, 30);
        panelPrincipal.add(campoCorreo);

        // ETIQUETA Y CAMPO: Contraseña
        JLabel campocontrasena = new JLabel("Contraseña:");
        campocontrasena.setBounds(100, 475, 100, 30);
        panelPrincipal.add(campocontrasena);

        JPasswordField campoContrasena = new JPasswordField();
        campoContrasena.setBounds(265, 475, 300, 30);
        panelPrincipal.add(campoContrasena);

        // IMAGEN: Logo de la aplicación
        ImageIcon imagenlogo = new ImageIcon("Imagenes/LOGO.png");
        JLabel logo = new JLabel();
        logo.setBounds(100, 100, 520, 155);
        logo.setIcon(new ImageIcon(imagenlogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(logo);

        ventanaPrincipal.setVisible(true);
    }
}
