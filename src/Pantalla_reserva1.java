import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla_reserva1 extends General {
    public Pantalla_reserva1(){
        //VENTANA
        JFrame ventanaPrincipal = crearventana();

        //PANEL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        ventanaPrincipal.add(panelPrincipal);

        //TEXTO: COMENCEMOS CON LA RESERVA DE PLAZA
        JLabel bienvenida = new JLabel();
        bienvenida.setText("COMENCEMOS CON LA RESERVA DE PLAZA");
        bienvenida.setBounds(175, 230, 500, 100);
        bienvenida.setForeground(new Color(63, 106, 184));
        bienvenida.setFont(new Font("Arial", Font.BOLD, 17));
        panelPrincipal.add(bienvenida);

        //TEXTO: ELIJA EL TIPO DE VEHÍCULO QUE DESEE
        JLabel bienvenida1 = new JLabel();
        bienvenida1.setText("ELIJA EL TIPO DE VEHÍCULO QUE DESEE");
        bienvenida1.setBounds(200, 258, 500, 100);
        bienvenida1.setForeground(new Color(63, 106, 184));
        bienvenida1.setFont(new Font("Arial", Font.BOLD, 16));
        panelPrincipal.add(bienvenida1);

        // COMBO BOX PARA SELECCIÓN DE VEHÍCULO
        String[] opcionesVehiculo = {"Coche", "Moto", "Coche Eléctrico", "Minusválido"};
        JComboBox<String> comboVehiculo = new JComboBox<>(opcionesVehiculo);
        comboVehiculo.setBounds(260, 433, 220, 30);
        panelPrincipal.add(comboVehiculo);

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
                String vehiculoSeleccionado = (String) comboVehiculo.getSelectedItem();
                JOptionPane.showMessageDialog(ventanaPrincipal, "Vehículo seleccionado: " + vehiculoSeleccionado);
                ventanaPrincipal.dispose();
                new Pantalla_reserva1();
            }
        });

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
                new Pantalla_opciones();
            }
        });

        //AGREGAR IMAGEN LOGO
        ImageIcon imagenlogo = new ImageIcon("Imagenes/LOGO.png");
        JLabel logo = new JLabel();
        logo.setBounds(100, 100, 520, 155);
        logo.setIcon(new ImageIcon(imagenlogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(logo);

        ventanaPrincipal.setVisible(true);
    }
}
