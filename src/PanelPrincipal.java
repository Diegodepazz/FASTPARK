import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.*;

public class PanelPrincipal extends General {
    public PanelPrincipal(){

        //VENTANA
        JFrame ventanaPrincipal =  crearventana();

        //PANEL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        ventanaPrincipal.add(panelPrincipal);

        //TEXTO BIENVENIDA
        JLabel bienvenida = new JLabel();
        bienvenida.setText("¡BIENVENIDO!");
        bienvenida.setBounds(290, 340, 300, 100);
        bienvenida.setForeground(Color.RED);
        bienvenida.setFont(new Font("Arial", Font.BOLD, 24));
        panelPrincipal.add(bienvenida);

        //AGREGAR BOTON
        ImageIcon imagenboton = new ImageIcon("");
        JButton botonprincipal = new JButton("INICIAR");
        botonprincipal.setFocusable(false);
        botonprincipal.setBounds(260, 550, 220, 40);
        botonprincipal.setForeground(Color.white);
        botonprincipal.setFont(new Font("Arial", Font.BOLD, 16));
        botonprincipal.setBackground(Color.RED);
        //Nuevo
        botonprincipal.setOpaque(true);
        //botonprincipal.setIcon(new ImageIcon(imagenboton.getImage().getScaledInstance(botonprincipal.getWidth(), botonprincipal.getHeight(), Image.SCALE_SMOOTH)));
        botonprincipal.setBorderPainted(false);
        panelPrincipal.add(botonprincipal);

        botonprincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.dispose();

                new Pantalla_inicio();
            }
        });

        //AGREGAR IMAGEN LOGO
        ImageIcon imagenlogo = new ImageIcon("Imagenes/LOGO.png");
        JLabel logo = new JLabel();
        logo.setBounds(100,100,516,155);
        logo.setIcon(new ImageIcon(imagenlogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(logo);

        ventanaPrincipal.setVisible(true);


    }
}
