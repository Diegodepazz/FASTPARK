package Pantalla_registro;

import Main.General_ventanas;
import Pantalla_reserva_vehiculo.Opciones_reserva_ticket;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase Inicio_sesion que representa la ventana para que el usuario inicie sesión en la aplicación.
 * Extiende de la clase General_ventanas.
 */
public class Inicio_sesion extends General_ventanas {

    /**
     * Constructor de la clase Inicio_sesion.
     * Configura la ventana principal, agrega componentes como paneles, etiquetas, campos de texto,
     * botones, y define la funcionalidad para cada botón.
     */
    public Inicio_sesion() {

        //VENTANA
        JFrame ventanaPrincipal = crearventana();

        //PANEL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        ventanaPrincipal.add(panelPrincipal);

        //TEXTO: INGRESE SUS DATOS PARA ACCEDER
        JLabel bienvenida = new JLabel();
        bienvenida.setText("INGRESE SUS DATOS PARA ACCEDER");
        bienvenida.setBounds(175, 260, 500, 100);
        bienvenida.setForeground(new Color(63, 106, 184));
        bienvenida.setFont(new Font("Arial", Font.BOLD, 18));
        panelPrincipal.add(bienvenida);

        //AGREGAR BOTON: INICIAR SESIÓN
        ImageIcon imagenboton = new ImageIcon("");
        JButton botonprincipal = new JButton("INICIAR SESIÓN");
        botonprincipal.setFocusable(false);
        botonprincipal.setBounds(260, 550, 220, 40);
        botonprincipal.setForeground(Color.white);
        botonprincipal.setFont(new Font("Arial", Font.BOLD, 14));
        botonprincipal.setBackground(Color.RED);
        botonprincipal.setOpaque(true);
        botonprincipal.setBorderPainted(false);
        panelPrincipal.add(botonprincipal);

        // Acción del botón "INICIAR SESIÓN"
        botonprincipal.addActionListener(new ActionListener() {
            /**
             * Define la acción al presionar el botón "INICIAR SESIÓN".
             * Abre la ventana Opciones_reserva_ticket y cierra la ventana actual.
             *
             * @param e evento de acción al presionar el botón.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new Opciones_reserva_ticket();
                ventanaPrincipal.dispose();
            }
        });

        //AGREGAR BOTON: RETORNO
        ImageIcon imagenboton1 = new ImageIcon("Imagenes/BOTON_RETORNO.png");
        JButton botonprincipal1 = new JButton("");
        botonprincipal1.setFocusable(false);
        botonprincipal1.setBounds(350, 620, 38, 40);
        botonprincipal1.setIcon(new ImageIcon(imagenboton1.getImage().getScaledInstance(botonprincipal1.getWidth(), botonprincipal1.getHeight(), Image.SCALE_SMOOTH)));
        botonprincipal1.setBorderPainted(false);
        panelPrincipal.add(botonprincipal1);

        // Acción del botón "RETORNO"
        botonprincipal1.addActionListener(new ActionListener() {
            /**
             * Define la acción al presionar el botón "RETORNO".
             * Abre la ventana Opciones_usuario y cierra la ventana actual.
             *
             * @param e evento de acción al presionar el botón.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new Opciones_usuario();
                ventanaPrincipal.dispose();
            }
        });

        // AGREGAR CAMPO CORREO
        JLabel etiquetaCorreo = new JLabel("Correo:");
        etiquetaCorreo.setBounds(130, 400, 100, 30);
        panelPrincipal.add(etiquetaCorreo);

        // RECTÁNGULO: ESCRIBIR CORREO
        JTextField campoCorreo = new JTextField();
        campoCorreo.setBounds(265, 400, 300, 30);
        panelPrincipal.add(campoCorreo);

        // AGREGAR CAMPO CONTRASEÑA
        JLabel etiquetaContrasena = new JLabel("Contraseña:");
        etiquetaContrasena.setBounds(130, 450, 100, 30);
        panelPrincipal.add(etiquetaContrasena);

        // RECTÁNGULO: ESCRIBIR CONTRASEÑA
        JPasswordField campoContrasena = new JPasswordField();
        campoContrasena.setBounds(265, 450, 300, 30);
        panelPrincipal.add(campoContrasena);

        //AGREGAR IMAGEN LOGO
        ImageIcon imagenlogo = new ImageIcon("Imagenes/LOGO.png");
        JLabel logo = new JLabel();
        logo.setBounds(100, 100, 520, 155);
        logo.setIcon(new ImageIcon(imagenlogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(logo);

        ventanaPrincipal.setVisible(true);
    }
}
