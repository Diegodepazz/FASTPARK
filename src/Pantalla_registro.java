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
        bienvenida.setBounds(152, 260, 500, 100);
        bienvenida.setForeground(Color.red);
        bienvenida.setFont(new Font("Arial", Font.BOLD, 20));
        panelPrincipal.add(bienvenida);


        //AGREGAR BOTON REGISTRAR CUENTA
        ImageIcon imagenboton = new ImageIcon("");
        JButton botonprincipal = new JButton("REGISTRAR CUENTA");
        botonprincipal.setFocusable(false);
        botonprincipal.setBounds(260, 610, 220, 40);
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

                PanelPrincipal vuelvo = new PanelPrincipal();
            }
        });

        // AGREGAR CAMPO NOMBRE
        JLabel camponombre = new JLabel("Nombre y apellidos:");
        camponombre.setBounds(100, 400, 150, 30);
        panelPrincipal.add(camponombre);

        // CAMPO NOMBRE
        JTextField campoNombre = new JTextField();
        campoNombre.setBounds(250, 400, 300, 30);
        panelPrincipal.add(campoNombre);


        // AGREGAR CAMPO CORREO
        JLabel campocorreo = new JLabel("Correo:");
        campocorreo.setBounds(100, 450, 100, 30);
        panelPrincipal.add(campocorreo);

        // CAMPO CORREO
        JTextField campoCorreo = new JTextField();
        campoCorreo.setBounds(250, 450, 300, 30);
        panelPrincipal.add(campoCorreo);


        // AGREGAR CAMPO CONTRASEÑA
        JLabel campocontrasena = new JLabel("Contraseña:");
        campocontrasena.setBounds(100, 500, 100, 30);
        panelPrincipal.add(campocontrasena);

        // CAMPO CONTRASEÑA
        JPasswordField campoContrasena = new JPasswordField();
        campoContrasena.setBounds(250, 500, 300, 30);
        panelPrincipal.add(campoContrasena);


        //AGREGAR IMAGEN LOGO
        ImageIcon imagenlogo = new ImageIcon("res/Pantalla1/LOGO.png");
        JLabel logo = new JLabel();
        logo.setBounds(100,100,520,155);
        logo.setIcon(new ImageIcon(imagenlogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(logo);
        ventanaPrincipal.setVisible(true);

    }



}