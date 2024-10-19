import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla_principal extends General {
    public Pantalla_principal(){

        //VENTANA
        JFrame ventanaPrincipal =  crearventana();

        //PANEL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        ventanaPrincipal.add(panelPrincipal);

        //BOTÓN: INICIAR
        ImageIcon imagenboton = new ImageIcon("");
        JButton botonprincipal = new JButton("INICIAR");
        botonprincipal.setFocusable(false);
        botonprincipal.setBounds(260, 565, 220, 40);
        botonprincipal.setForeground(Color.white);
        botonprincipal.setFont(new Font("Arial", Font.BOLD, 20));
        botonprincipal.setBackground(new Color(64, 109, 180));
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

        // IMAGEN LOGO
        ImageIcon imagenlogo = new ImageIcon("Imagenes/LOGO.png");
        JLabel logo = new JLabel();
        logo.setBounds(100,100,516,155);
        logo.setIcon(new ImageIcon(imagenlogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(logo);

        // AGREGAR SEGUNDO LOGO (COCHE INICIO)
        ImageIcon imagencocheinicio = new ImageIcon("Imagenes/LOGO_INICIO.png"); // Asegúrate de que el archivo tenga la extensión correcta
        JLabel imagencoheinicio = new JLabel();
        imagencoheinicio.setBounds(110, 300, 516, 155); // Ajusta las coordenadas y el tamaño según sea necesario
        imagencoheinicio.setIcon(new ImageIcon(imagencocheinicio.getImage().getScaledInstance(imagencoheinicio.getWidth(), imagencoheinicio.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(imagencoheinicio);

        ventanaPrincipal.setVisible(true);


    }
}
