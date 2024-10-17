import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Pantalla_iniciosesion extends General {

    public Pantalla_iniciosesion(){
        //VENTANA
        JFrame ventanaPrincipal = crearventana();

        //PANEL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        ventanaPrincipal.add(panelPrincipal);

        //TEXTO REGISTRO
        JLabel bienvenida = new JLabel();
        bienvenida.setText("INGRESE SUS DATOS PARA ACCEDER");
        bienvenida.setBounds(175, 260, 500, 100);
        bienvenida.setForeground(Color.red);
        bienvenida.setFont(new Font("Arial", Font.BOLD, 18));
        panelPrincipal.add(bienvenida);


        //AGREGAR BOTON INICIAR SESIÓN
        ImageIcon imagenboton = new ImageIcon("");
        JButton botonprincipal = new JButton("INICIAR SESIÓN");
        botonprincipal.setFocusable(false);
        botonprincipal.setBounds(260, 550, 220, 40);
        botonprincipal.setForeground(Color.white);
        botonprincipal.setFont(new Font("Arial", Font.BOLD, 14));
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

                new Pantalla_opciones();
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

        // AGREGAR CAMPO CORREO
        JLabel etiquetaCorreo = new JLabel("Correo:");
        etiquetaCorreo.setBounds(130, 400, 100, 30);
        panelPrincipal.add(etiquetaCorreo);

        // CAMPO CORREO
        JTextField campoCorreo = new JTextField();
        campoCorreo.setBounds(265, 400, 300, 30);
        panelPrincipal.add(campoCorreo);


        // AGREGAR CAMPO CONTRASEÑA
        JLabel etiquetaContrasena = new JLabel("Contraseña:");
        etiquetaContrasena.setBounds(130, 450, 100, 30);
        panelPrincipal.add(etiquetaContrasena);

        // CAMPO CONTRASEÑA
        JPasswordField campoContrasena = new JPasswordField();
        campoContrasena.setBounds(265, 450, 300, 30);
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