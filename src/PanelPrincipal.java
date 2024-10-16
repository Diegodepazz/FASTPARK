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
        bienvenida.setBounds(270, 330, 300, 100);
        bienvenida.setForeground(Color.RED);
        bienvenida.setFont(new Font("Arial", Font.BOLD, 32));
        panelPrincipal.add(bienvenida);

        //AGREGAR BOTON
        ImageIcon imagenboton = new ImageIcon("res/FLECHA2.png");
        JButton botonprincipal = new JButton();
        botonprincipal.setBounds(330, 520, 110, 110);
        botonprincipal.setBackground(Color.white);
        botonprincipal.setIcon(new ImageIcon(imagenboton.getImage().getScaledInstance(botonprincipal.getWidth(), botonprincipal.getHeight(), Image.SCALE_SMOOTH)));
        botonprincipal.setBorderPainted(false);
        panelPrincipal.add(botonprincipal);

        botonprincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.dispose();

                Panel2 panel2 = new Panel2();
            }
        });

        //AGREGAR IMAGEN LOGO
        ImageIcon imagenlogo = new ImageIcon("res/Pantalla1/LOGO.png");
        JLabel logo = new JLabel();
        logo.setBounds(100,100,516,155);
        logo.setIcon(new ImageIcon(imagenlogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(logo);

        ventanaPrincipal.setVisible(true);

    }

}