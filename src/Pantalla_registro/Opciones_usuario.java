package Pantalla_registro;

import Main.General_ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Opciones_usuario extends General_ventanas {
    public Opciones_usuario(){

        //VENTANA
        JFrame ventanaPrincipal = crearventana();

        //PANEL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        ventanaPrincipal.add(panelPrincipal);

        //TEXTO: INICIE SESIÓN O REGÍSTRESE PARA CONTINUAR
        JLabel bienvenida = new JLabel();
        bienvenida.setText("INICIE SESIÓN O REGÍSTRESE PARA CONTINUAR");
        bienvenida.setBounds(130, 295, 500, 100);
        bienvenida.setForeground(new Color(63, 106, 184));
        bienvenida.setFont(new Font("Arial", Font.BOLD, 20));
        panelPrincipal.add(bienvenida);


        //AGREGAR BOTON: INICIO DE SESIÓN
        ImageIcon imagenboton = new ImageIcon("");
        JButton botonprincipal = new JButton("INICIAR SESIÓN");
        botonprincipal.setFocusable(false);
        botonprincipal.setBounds(260, 450, 220, 40);
        botonprincipal.setForeground(Color.white);
        botonprincipal.setFont(new Font("Arial", Font.BOLD, 15));
        botonprincipal.setBackground(Color.RED);
        botonprincipal.setOpaque(true);
        //botonprincipal.setIcon(new ImageIcon(imagenboton.getImage().getScaledInstance(botonprincipal.getWidth(), botonprincipal.getHeight(), Image.SCALE_SMOOTH)));
        botonprincipal.setBorderPainted(false);
        panelPrincipal.add(botonprincipal);

        botonprincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Inicio_sesion();
                ventanaPrincipal.dispose();
            }
        });

        //AGREGAR BOTON1: REGISTRAR CUENTA
        ImageIcon imagenboton1 = new ImageIcon("");
        JButton botonprincipal1 = new JButton("REGISTRAR CUENTA");
        botonprincipal1.setFocusable(false);
        botonprincipal1.setBounds(260, 520, 220, 40);
        botonprincipal1.setForeground(Color.white);
        botonprincipal1.setFont(new Font("Arial", Font.BOLD, 15));
        botonprincipal1.setBackground(Color.red);
        botonprincipal1.setOpaque(true);
        //botonprincipal1.setIcon(new ImageIcon(imagenboton.getImage().getScaledInstance(botonprincipal.getWidth(), botonprincipal.getHeight(), Image.SCALE_SMOOTH)));
        botonprincipal1.setBorderPainted(false);
        panelPrincipal.add(botonprincipal1);

        botonprincipal1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Registro();
                ventanaPrincipal.dispose();
            }
        });

        //AGREGAR IMAGEN LOGO
        ImageIcon imagenlogo = new ImageIcon("Imagenes/LOGO.png");
        JLabel logo = new JLabel();
        logo.setBounds(100,100,520,155);
        logo.setIcon(new ImageIcon(imagenlogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(logo);

        ventanaPrincipal.setVisible(true);

    }

}