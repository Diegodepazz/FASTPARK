package Pantalla_calles;

import Main.General_ventanas;
import Pantalla_calendario.Reserva_calendario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase Mapa_calles que extiende de General_ventanas.
 * Representa una interfaz gráfica para visualizar un mapa con calles disponibles y seleccionar una calle para aparcar.
 */
public class Mapa_calles extends General_ventanas {

    /**
     * Constructor de la clase Mapa_calles.
     * Configura la ventana principal y los elementos gráficos necesarios.
     */
    public Mapa_calles() {
        // VENTANA
        JFrame ventanaPrincipal = crearventana();

        // PANEL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        ventanaPrincipal.add(panelPrincipal);

        // TEXTO: VISUALICE EN EL MAPA LAS CALLES DISPONIBLES
        JLabel bienvenida = new JLabel();
        bienvenida.setText("VISUALICE EN EL MAPA LAS CALLES DISPONIBLES");
        bienvenida.setBounds(170, 0, 500, 100);
        bienvenida.setForeground(new Color(63, 106, 184));
        bienvenida.setFont(new Font("Arial", Font.BOLD, 16));
        panelPrincipal.add(bienvenida);

        // AGREGAR IMAGEN LOGO
        ImageIcon imagenlogo = new ImageIcon("Imagenes/MAPA CALLES.png");
        JLabel logo = new JLabel();
        logo.setBounds(166, 89, 410, 410);
        logo.setIcon(new ImageIcon(imagenlogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(logo);

        // TEXTO: ESCOJA LA CALLE QUE DESEE PARA APARCAR
        JLabel bienvenida1 = new JLabel();
        bienvenida1.setText("ESCOJA LA CALLE QUE DESEE PARA APARCAR:");
        bienvenida1.setBounds(180, 495, 500, 100);
        bienvenida1.setForeground(new Color(63, 106, 184));
        bienvenida1.setFont(new Font("Arial", Font.BOLD, 16));
        panelPrincipal.add(bienvenida1);

        // BOTÓN: CALLE DE GUZMAN EL BUENO
        JButton botonprincipal = new JButton("1.  CALLE DE GUZMAN EL BUENO");
        botonprincipal.setFocusable(false);
        botonprincipal.setBounds(74, 580, 265, 30);
        botonprincipal.setForeground(Color.white);
        botonprincipal.setBackground(new Color(63, 106, 184));
        botonprincipal.setFont(new Font("Arial", Font.BOLD, 12));
        botonprincipal.setOpaque(true);
        botonprincipal.setBorderPainted(false);
        panelPrincipal.add(botonprincipal);

        /**
         * Acción del botón para seleccionar la Calle_guzmanelbueno.
         * Abre una nueva ventana correspondiente y cierra la ventana actual.
         */
        botonprincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Calle_guzmanelbueno();
                ventanaPrincipal.dispose();
            }
        });

        // BOTÓN: CALLE DE MELÉNDEZ VALDÉS
        JButton botonprincipal1 = new JButton("2.  CALLE DE MELÉNDEZ VALDÉS");
        botonprincipal1.setFocusable(false);
        botonprincipal1.setBounds(74, 618, 265, 30);
        botonprincipal1.setForeground(Color.white);
        botonprincipal1.setBackground(new Color(63, 106, 184));
        botonprincipal1.setFont(new Font("Arial", Font.BOLD, 12));
        botonprincipal1.setOpaque(true);
        botonprincipal1.setBorderPainted(false);
        panelPrincipal.add(botonprincipal1);

        /**
         * Acción del botón para seleccionar la Calle_melendezvaldes.
         * Abre una nueva ventana correspondiente y cierra la ventana actual.
         */
        botonprincipal1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Calle_melendezvaldes();
                ventanaPrincipal.dispose();
            }
        });

        // BOTÓN: CALLE DE GALILEO
        JButton botonprincipal2 = new JButton("3.  CALLE DE GALILEO");
        botonprincipal2.setFocusable(false);
        botonprincipal2.setBounds(384, 580, 265, 30);
        botonprincipal2.setForeground(Color.white);
        botonprincipal2.setBackground(new Color(63, 106, 184));
        botonprincipal2.setFont(new Font("Arial", Font.BOLD, 12));
        botonprincipal2.setOpaque(true);
        botonprincipal2.setBorderPainted(false);
        panelPrincipal.add(botonprincipal2);

        /**
         * Acción del botón para seleccionar la Calle_galileo.
         * Abre una nueva ventana correspondiente y cierra la ventana actual.
         */
        botonprincipal2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Calle_galileo();
                ventanaPrincipal.dispose();
            }
        });

        // BOTÓN: CALLE DE FERNÁNDEZ DE LOS RÍOS
        JButton botonprincipal3 = new JButton("4.  CALLE DE FERNÁNDEZ DE LOS RÍOS");
        botonprincipal3.setFocusable(false);
        botonprincipal3.setBounds(384, 618, 265, 30);
        botonprincipal3.setForeground(Color.white);
        botonprincipal3.setBackground(new Color(63, 106, 184));
        botonprincipal3.setFont(new Font("Arial", Font.BOLD, 12));
        botonprincipal3.setOpaque(true);
        botonprincipal3.setBorderPainted(false);
        panelPrincipal.add(botonprincipal3);

        /**
         * Acción del botón para seleccionar la Calle_fernandezdelosrios.
         * Abre una nueva ventana correspondiente y cierra la ventana actual.
         */
        botonprincipal3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Calle_fernandezdelosrios();
                ventanaPrincipal.dispose();
            }
        });

        // BOTÓN: RETORNO
        ImageIcon imagenboton4 = new ImageIcon("Imagenes/BOTON_RETORNO.png");
        JButton botonprincipal4 = new JButton("");
        botonprincipal4.setFocusable(false);
        botonprincipal4.setBounds(350, 676, 26, 26);
        botonprincipal4.setIcon(new ImageIcon(imagenboton4.getImage().getScaledInstance(botonprincipal4.getWidth(), botonprincipal4.getHeight(), Image.SCALE_SMOOTH)));
        botonprincipal4.setBorderPainted(false);
        panelPrincipal.add(botonprincipal4);

        /**
         * Acción del botón de retorno.
         * Regresa a la ventana de Reserva_calendario y cierra la ventana actual.
         */
        botonprincipal4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Reserva_calendario();
                ventanaPrincipal.dispose();
            }
        });

        ventanaPrincipal.setVisible(true);
    }
}
