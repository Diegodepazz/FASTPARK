package Pantalla_registro;

import Main.General_ventanas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Extiende la clase General_ventanas.
 * Representa una ventana que permite al usuario elegir entre iniciar sesión o registrarse.
 * Contiene botones y acciones para acceder hacia las ventanas de inicio de sesión y registro.
 */
public class Opciones_usuario extends General_ventanas {

    /**
     * Constructor de la clase Opciones_usuario.
     * Inicializa y configura los componentes gráficos de la ventana.
     */
    public Opciones_usuario() {

        // Ventana principal.
        JFrame ventanaPrincipal = crearventana();

        // Panel principal.
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        ventanaPrincipal.add(panelPrincipal);

        // Texto de bienvenida.
        JLabel bienvenida = new JLabel();
        bienvenida.setText("INICIE SESIÓN O REGÍSTRESE PARA CONTINUAR");
        bienvenida.setBounds(130, 295, 500, 100);
        bienvenida.setForeground(new Color(63, 106, 184));
        bienvenida.setFont(new Font("Arial", Font.BOLD, 20));
        panelPrincipal.add(bienvenida);

        // Botón para iniciar sesión.
        JButton botonprincipal = new JButton("INICIAR SESIÓN");
        botonprincipal.setFocusable(false);
        botonprincipal.setBounds(260, 450, 220, 40);
        botonprincipal.setForeground(Color.white);
        botonprincipal.setFont(new Font("Arial", Font.BOLD, 15));
        botonprincipal.setBackground(Color.RED);
        botonprincipal.setOpaque(true);
        botonprincipal.setBorderPainted(false);
        panelPrincipal.add(botonprincipal);

        // Acción del botón para iniciar sesión.
        botonprincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Inicio_sesion(); // Abre la ventana de inicio de sesión.
                ventanaPrincipal.dispose(); // Cierra la ventana actual.
            }
        });

        // Botón para registrar una cuenta.
        JButton botonprincipal1 = new JButton("REGISTRAR CUENTA");
        botonprincipal1.setFocusable(false);
        botonprincipal1.setBounds(260, 520, 220, 40);
        botonprincipal1.setForeground(Color.white);
        botonprincipal1.setFont(new Font("Arial", Font.BOLD, 15));
        botonprincipal1.setBackground(Color.RED);
        botonprincipal1.setOpaque(true);
        botonprincipal1.setBorderPainted(false);
        panelPrincipal.add(botonprincipal1);

        // Acción del botón para registrar una cuenta.
        botonprincipal1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Registro(); // Abre la ventana de registro.
                ventanaPrincipal.dispose(); // Cierra la ventana actual.
            }
        });

        // Imagen del logo.
        ImageIcon imagenlogo = new ImageIcon("Imagenes/LOGO.png");
        JLabel logo = new JLabel();
        logo.setBounds(100, 100, 520, 155);
        logo.setIcon(new ImageIcon(imagenlogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(logo);

        // Hacer visible la ventana.
        ventanaPrincipal.setVisible(true);
    }
}
