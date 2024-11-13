import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla_calles extends General {
    public Pantalla_calles(){
        //VENTANA
        JFrame ventanaPrincipal = crearventana();

        //PANEL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        ventanaPrincipal.add(panelPrincipal);

        //TEXTO: VISUALICE EN EL MAPA LAS CALLES DISPONIBLES
        JLabel bienvenida = new JLabel();
        bienvenida.setText("VISUALICE EN EL MAPA LAS CALLES DISPONIBLES");
        bienvenida.setBounds(170, 0, 500, 100);
        bienvenida.setForeground(new Color(63, 106, 184));
        bienvenida.setFont(new Font("Arial", Font.BOLD, 16));
        panelPrincipal.add(bienvenida);

        //AGREGAR IMAGEN LOGO
        ImageIcon imagenlogo = new ImageIcon("Imagenes/MAPA CALLES.png");
        JLabel logo = new JLabel();
        logo.setBounds(166,89,385,385);
        logo.setIcon(new ImageIcon(imagenlogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(logo);

        //TEXTO: ESCOJA LA CALLE QUE DESEE PARA APARCAR
        JLabel bienvenida1 = new JLabel();
        bienvenida1.setText("ESCOJA LA CALLE QUE DESEE PARA APARCAR");
        bienvenida1.setBounds(180, 480, 500, 100);
        bienvenida1.setForeground(new Color(63, 106, 184));
        bienvenida1.setFont(new Font("Arial", Font.BOLD, 16));
        panelPrincipal.add(bienvenida1);

        //BOTÓN: CALLE DE GUZMAN EL BUENO
        JButton botonprincipal = new JButton("1.  CALLE DE GUZMAN EL BUENO");
        botonprincipal.setFocusable(false);
        botonprincipal.setBounds(70, 580, 265, 30);
        botonprincipal.setForeground(Color.white);
        botonprincipal.setBackground(new Color(63, 106, 184));
        botonprincipal.setFont(new Font("Arial", Font.BOLD, 12));
        botonprincipal.setOpaque(true);
        //botonprincipal.setIcon(new ImageIcon(imagenboton.getImage().getScaledInstance(botonprincipal.getWidth(), botonprincipal.getHeight(), Image.SCALE_SMOOTH)));
        botonprincipal.setBorderPainted(false);
        panelPrincipal.add(botonprincipal);

        botonprincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.dispose();

                new Pantalla_calle_guzman();
            }
        });

        //BOTÓN: CALLE DE MELÉNDEZ VALDÉS
        JButton botonprincipal1 = new JButton("2.  CALLE DE MELÉNDEZ VALDÉS");
        botonprincipal1.setFocusable(false);
        botonprincipal1.setBounds(70, 618, 265, 30);
        botonprincipal1.setForeground(Color.white);
        botonprincipal1.setBackground(new Color(63, 106, 184));
        botonprincipal1.setFont(new Font("Arial", Font.BOLD, 12));
        botonprincipal1.setOpaque(true);
        //botonprincipal.setIcon(new ImageIcon(imagenboton.getImage().getScaledInstance(botonprincipal.getWidth(), botonprincipal.getHeight(), Image.SCALE_SMOOTH)));
        botonprincipal1.setBorderPainted(false);
        panelPrincipal.add(botonprincipal1);

        botonprincipal1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.dispose();

                new Pantalla_calle_melendez();
            }
        });


        //BOTÓN: CALLE DE GALILEO
        JButton botonprincipal2 = new JButton("3.  CALLE DE GALILEO");
        botonprincipal2.setFocusable(false);
        botonprincipal2.setBounds(380, 580, 265, 30);
        botonprincipal2.setForeground(Color.white);
        botonprincipal2.setBackground(new Color(63, 106, 184));
        botonprincipal2.setFont(new Font("Arial", Font.BOLD, 12));
        botonprincipal2.setOpaque(true);
        //botonprincipal.setIcon(new ImageIcon(imagenboton.getImage().getScaledInstance(botonprincipal.getWidth(), botonprincipal.getHeight(), Image.SCALE_SMOOTH)));
        botonprincipal2.setBorderPainted(false);
        panelPrincipal.add(botonprincipal2);

        botonprincipal2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.dispose();

                new Pantalla_calle_galileo();
            }
        });

        //BOTÓN: CALLE DE FERNÁNDEZ DE LOS RÍOS
        JButton botonprincipal3 = new JButton("4.  CALLE DE FERNÁNDEZ DE LOS RÍOS");
        botonprincipal3.setFocusable(false);
        botonprincipal3.setBounds(380, 618, 265, 30);
        botonprincipal3.setForeground(Color.white);
        botonprincipal3.setBackground(new Color(63, 106, 184));
        botonprincipal3.setFont(new Font("Arial", Font.BOLD, 12));
        botonprincipal3.setOpaque(true);
        //botonprincipal.setIcon(new ImageIcon(imagenboton.getImage().getScaledInstance(botonprincipal.getWidth(), botonprincipal.getHeight(), Image.SCALE_SMOOTH)));
        botonprincipal3.setBorderPainted(false);
        panelPrincipal.add(botonprincipal3);

        botonprincipal3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.dispose();

                new Pantalla_calle_fernandez();
            }
        });


        // BOTON: RETORNO
        ImageIcon imagenboton4 = new ImageIcon("Imagenes/BOTON_RETORNO.png");
        JButton botonprincipal4 = new JButton("");
        botonprincipal4.setFocusable(false);
        botonprincipal4.setBounds(350, 676, 26, 26);
        botonprincipal4.setIcon(new ImageIcon(imagenboton4.getImage().getScaledInstance(botonprincipal4.getWidth(), botonprincipal4.getHeight(), Image.SCALE_SMOOTH)));
        botonprincipal4.setBorderPainted(false);
        panelPrincipal.add(botonprincipal4);

        botonprincipal4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.dispose();
                new Pantalla_reserva_calendario();
            }
        });

        ventanaPrincipal.setVisible(true);
    }
}
