import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla_opciones extends General {
    public Pantalla_opciones(){

        //VENTANA
        JFrame ventanaPrincipal = crearventana();

        //PANEL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        ventanaPrincipal.add(panelPrincipal);

        //TEXTO: ELIJA UNA OPCIÓN
        JLabel eligeuncampo = new JLabel();
        eligeuncampo.setText("ELIJA UNA OPCIÓN PARA CONTINUAR");
        eligeuncampo.setBounds(180, 300, 500, 100);
        eligeuncampo.setForeground(new Color(63, 106, 184));
        eligeuncampo.setFont(new Font("Arial", Font.BOLD, 20));
        panelPrincipal.add(eligeuncampo);

        //TEXTO REGISTRO
        JLabel bienvenida = new JLabel();
        bienvenida.setText("¡BIENVENIDO!");
        bienvenida.setBounds(300, 260, 500, 100);
        bienvenida.setForeground(new Color(63, 106, 184));
        bienvenida.setFont(new Font("Arial", Font.BOLD, 20));
        panelPrincipal.add(bienvenida);

        //BOTÓN: RESERVAR PLAZA
        ImageIcon imagenboton = new ImageIcon("");
        JButton botonprincipal = new JButton("RESERVAR PLAZA");
        botonprincipal.setFocusable(false);
        botonprincipal.setBounds(110, 530, 220, 40);
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

                new Pantalla_reserva_calendario();
            }
        });

        //BOTON: VER TICKET
        JButton botonprincipal1 = new JButton("VER TICKET");
        botonprincipal1.setFocusable(false);
        botonprincipal1.setBounds(410, 530, 220, 40);
        botonprincipal1.setForeground(Color.white);
        botonprincipal1.setFont(new Font("Arial", Font.BOLD, 16));
        botonprincipal1.setBackground(Color.RED);
        botonprincipal1.setOpaque(true);
        //botonprincipal1.setIcon(new ImageIcon(imagenboton.getImage().getScaledInstance(botonprincipal1.getWidth(), botonprincipal1.getHeight(), Image.SCALE_SMOOTH)));
        botonprincipal1.setBorderPainted(false);
        panelPrincipal.add(botonprincipal1);

        botonprincipal1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.dispose();

                new Pantalla_verticket();
            }
        });

        // BOTÓN: RETORNO
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
                new Pantalla_inicio();
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