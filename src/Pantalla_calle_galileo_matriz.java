import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla_calle_galileo_matriz extends General {
    public Pantalla_calle_galileo_matriz() {
        //VENTANA
        JFrame ventanaPrincipal = crearventana();

        //PANEL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        ventanaPrincipal.add(panelPrincipal);


        //TEXTO: BIENVENIDO
        JLabel bienvenida = new JLabel("¡¡MATRIZ GALILEO!!");
        bienvenida.setBounds(305, 35, 500, 100);
        bienvenida.setForeground(new Color(63, 106, 184));
        bienvenida.setFont(new Font("Arial", Font.BOLD, 19));
        panelPrincipal.add(bienvenida);

        //TEXTO: SE ENCUENTRA EN LA CALLE GUZMÁN EL BUENO
        JLabel calle = new JLabel("USTED SE ENCUENTRA EN LA CALLE GALILEO");
        calle.setBounds(138, 65, 500, 100);
        calle.setForeground(new Color(63, 106, 184));
        calle.setFont(new Font("Arial", Font.BOLD, 17));
        panelPrincipal.add(calle);

        //BOTON: CONTINUAR CON LA RESERVA
        JButton botonprincipal = new JButton("CONTINUAR CON LA RESERVA");
        botonprincipal.setFocusable(false);
        botonprincipal.setBounds(220, 555, 300, 32);
        botonprincipal.setForeground(Color.white);
        botonprincipal.setFont(new Font("Arial", Font.BOLD, 14));
        botonprincipal.setBackground(Color.RED);
        botonprincipal.setOpaque(true);
        botonprincipal.setBorderPainted(false);
        panelPrincipal.add(botonprincipal);

        botonprincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ventanaPrincipal.dispose();
                new Pantalla_calles();  // Aquí puedes pasar la información a la siguiente pantalla si lo necesitas
            }
        });

        //AGREGAR IMAGEN CALLE
        ImageIcon imagenlogo = new ImageIcon("");
        JLabel logo = new JLabel();
        logo.setBounds(100,148,550,180);
        logo.setIcon(new ImageIcon(imagenlogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(logo);

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
                new Pantalla_calle_galileo();
            }
        });

        ventanaPrincipal.setVisible(true);
    }
}
