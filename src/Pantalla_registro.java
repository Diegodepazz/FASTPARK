import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla_registro extends General {
    public Pantalla_registro(){
        //VENTANA
        JFrame ventanaPrincipal = crearventana();

        //PANEL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        ventanaPrincipal.add(panelPrincipal);

        //TEXTO REGISTRO
        JLabel bienvenida = new JLabel();
        bienvenida.setText("INGRESE SUS DATOS PARA REGISTRARSE");
        bienvenida.setBounds(155, 250, 500, 100);
        bienvenida.setForeground(Color.red);
        bienvenida.setFont(new Font("Arial", Font.BOLD, 18));
        panelPrincipal.add(bienvenida);


        //AGREGAR BOTON REGISTRAR CUENTA
        ImageIcon imagenboton = new ImageIcon("");
        JButton botonprincipal = new JButton("REGISTRAR CUENTA");
        botonprincipal.setFocusable(false);
        botonprincipal.setBounds(260, 550, 220, 40);
        botonprincipal.setForeground(Color.white);
        botonprincipal.setFont(new Font("Arial", Font.BOLD, 14));
        botonprincipal.setBackground(Color.red);
        //Nuevo
        botonprincipal.setOpaque(true);
        botonprincipal.setIcon(new ImageIcon(imagenboton.getImage().getScaledInstance(botonprincipal.getWidth(), botonprincipal.getHeight(), Image.SCALE_SMOOTH)));
        botonprincipal.setBorderPainted(false);
        panelPrincipal.add(botonprincipal);

        botonprincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.dispose();

                new Pantalla_iniciosesion();
            }
        });

        //AGREGAR BOTON RETORNO
        ImageIcon imagenboton1 = new ImageIcon("Imagenes/BOTON_RETORNO.png");
        JButton botonprincipal1 = new JButton("");
        botonprincipal1.setFocusable(false);
        botonprincipal1.setBounds(350, 620, 38, 40);
        botonprincipal1.setIcon(new ImageIcon(imagenboton1.getImage().getScaledInstance(botonprincipal1.getWidth(), botonprincipal1.getHeight(), Image.SCALE_SMOOTH)));
        botonprincipal1.setBorderPainted(false);
        panelPrincipal.add(botonprincipal1);

        botonprincipal1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.dispose();

                new Pantalla_inicio();
            }
        });

        // AGREGAR CAMPO NOMBRE
        JLabel camponombre = new JLabel("Nombre y apellidos:");
        camponombre.setBounds(100, 375, 150, 30);
        panelPrincipal.add(camponombre);

        // CAMPO NOMBRE
        JTextField campoNombre = new JTextField();
        campoNombre.setBounds(265, 375, 300, 30);
        panelPrincipal.add(campoNombre);


        // AGREGAR CAMPO CORREO
        JLabel campocorreo = new JLabel("Correo:");
        campocorreo.setBounds(100, 425, 100, 30);
        panelPrincipal.add(campocorreo);

        // CAMPO CORREO
        JTextField campoCorreo = new JTextField();
        campoCorreo.setBounds(265, 425, 300, 30);
        panelPrincipal.add(campoCorreo);


        // AGREGAR CAMPO CONTRASEÑA
        JLabel campocontrasena = new JLabel("Contraseña:");
        campocontrasena.setBounds(100, 475, 100, 30);
        panelPrincipal.add(campocontrasena);

        // CAMPO CONTRASEÑA
        JPasswordField campoContrasena = new JPasswordField();
        campoContrasena.setBounds(265, 475, 300, 30);
        panelPrincipal.add(campoContrasena);


        //AGREGAR IMAGEN LOGO
        ImageIcon imagenlogo = new ImageIcon("Imagenes/LOGO.png");
        JLabel logo = new JLabel();
        logo.setBounds(100,100,520,155);
        logo.setIcon(new ImageIcon(imagenlogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(logo);
        ventanaPrincipal.setVisible(true);

    }



}