package Pantalla_ticket;

import Main.General_ventanas;
import Pantalla_reserva_vehiculo.Opciones_reserva_ticket;
import Pantalla_inicio_app.Inicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ticket extends General_ventanas {
    public Ticket(){
        //VENTANA
        JFrame ventanaPrincipal = crearventana();

        //PANEL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        ventanaPrincipal.add(panelPrincipal);

        //TEXTO: VISUALICE SU INFORMACIÓN DE PLAZA
        JLabel bienvenida = new JLabel();
        bienvenida.setText("¡VISUALICE LA INFORMACIÓN DE SU PLAZA!");
        bienvenida.setBounds(188, 210, 500, 100);
        bienvenida.setForeground(new Color(63, 106, 184));
        bienvenida.setFont(new Font("Arial", Font.BOLD, 17));
        panelPrincipal.add(bienvenida);


        //AGREGAR IMAGEN LOGO
        ImageIcon imagenlogo = new ImageIcon("Imagenes/LOGO.png");
        JLabel logo = new JLabel();
        logo.setBounds(100,100,520,155);
        logo.setIcon(new ImageIcon(imagenlogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(logo);

        //BOTON:
        ImageIcon imagenboton = new ImageIcon("");
        JButton botonprincipal = new JButton("VER TICKET");
        botonprincipal.setFocusable(false);
        botonprincipal.setBounds(260, 550, 220, 40);
        botonprincipal.setForeground(Color.white);
        botonprincipal.setFont(new Font("Arial", Font.BOLD, 16));
        botonprincipal.setBackground(Color.RED);
        botonprincipal.setOpaque(true);
        //botonprincipal.setIcon(new ImageIcon(imagenboton.getImage().getScaledInstance(botonprincipal.getWidth(), botonprincipal.getHeight(), Image.SCALE_SMOOTH)));
        botonprincipal.setBorderPainted(false);
        panelPrincipal.add(botonprincipal);

        botonprincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.dispose();

                new Inicio();
            }
        });

        //AGREGAR IMAGEN TICKET
        ImageIcon imagenticket = new ImageIcon("Imagenes/FOTO TICKET.png");
        JLabel ticket = new JLabel();
        ticket.setBounds(276,300,200,210);
        ticket.setIcon(new ImageIcon(imagenticket.getImage().getScaledInstance(ticket.getWidth(), ticket.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(ticket);

        // BOTON: RETORNO
        ImageIcon imagenboton2 = new ImageIcon("Imagenes/BOTON_RETORNO.png");
        JButton botonprincipal2 = new JButton("");
        botonprincipal2.setFocusable(false);
        botonprincipal2.setBounds(350, 620, 40, 40);
        botonprincipal2.setIcon(new ImageIcon(imagenboton2.getImage().getScaledInstance(botonprincipal2.getWidth(), botonprincipal2.getHeight(), Image.SCALE_SMOOTH)));
        botonprincipal2.setBorderPainted(false);
        panelPrincipal.add(botonprincipal2);

        botonprincipal2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.dispose();
                new Opciones_reserva_ticket();
            }
        });
        ventanaPrincipal.setVisible(true);

    }

}
