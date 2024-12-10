package Pantalla_calles;

import Main.General_ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calle_galileo extends General_ventanas {
    public Calle_galileo() {
        //VENTANA
        JFrame ventanaPrincipal = crearventana();

        //PANEL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        ventanaPrincipal.add(panelPrincipal);

        // DESPLEGABLE: TIPO DE VEHÍCULO
        String[] tiposVehiculos = {"Coche", "Coche Eléctrico", "Moto", "Minusválido"};
        JComboBox<String> desplegableVehiculos = new JComboBox<>(tiposVehiculos);
        desplegableVehiculos.setBounds(270, 409, 200, 30);
        panelPrincipal.add(desplegableVehiculos);

        //TEXTO: SE ENCUENTRA EN LA CALLE GUZMÁN EL BUENO
        JLabel calle = new JLabel("USTED SE ENCUENTRA EN LA CALLE GALILEO");
        calle.setBounds(182, 65, 500, 100);
        calle.setForeground(new Color(63, 106, 184));
        calle.setFont(new Font("Arial", Font.BOLD, 17));
        panelPrincipal.add(calle);

        //AGREGAR IMAGEN LOGO
        ImageIcon imagenlogo = new ImageIcon("Imagenes/FOTO PARKING.png");
        JLabel logo = new JLabel();
        logo.setBounds(195,175,350,120);
        logo.setIcon(new ImageIcon(imagenlogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(logo);

        //TEXTO: ELIJA EL TIPO DE VEHÍCULO QUE DESEE ESTACIONAR
        JLabel vehiculo = new JLabel("ELIJA EL TIPO DE VEHÍCULO QUE DESEE ESTACIONAR:");
        vehiculo.setBounds(145, 315, 500, 100);
        vehiculo.setForeground(new Color(63, 106, 184));
        vehiculo.setFont(new Font("Arial", Font.BOLD, 17));
        panelPrincipal.add(vehiculo);

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
                // Obtener el tipo de vehículo seleccionado
                String tipoVehiculoSeleccionado = (String) desplegableVehiculos.getSelectedItem();

                // Mostrar el tipo de vehículo seleccionado o pasar la información
                JOptionPane.showMessageDialog(ventanaPrincipal,
                        "Tipo de vehículo seleccionado: " + tipoVehiculoSeleccionado,
                        "Información de reserva",
                        JOptionPane.INFORMATION_MESSAGE);

                ventanaPrincipal.dispose();
                new Calle_galileo_matriz(tipoVehiculoSeleccionado);  // Aquí puedes pasar la información a la siguiente pantalla si lo necesitas
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
                new Mapa_calles();
            }
        });

        ventanaPrincipal.setVisible(true);
    }
}