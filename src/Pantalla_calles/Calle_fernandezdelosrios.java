package Pantalla_calles;

import Main.General_ventanas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa la interfaz gráfica para la calle Fernández de los Ríos.
 * Permite al usuario seleccionar un tipo de vehículo y continuar con el proceso de reserva.
 */
public class Calle_fernandezdelosrios extends General_ventanas {
    /**
     * Constructor de la clase Calle_fernandezdelosrios.
     * Configura la ventana principal, paneles, componentes gráficos y su funcionalidad.
     */
    public Calle_fernandezdelosrios() {

        // VENTANA: CONFIGURACIÓN DE LA VENTANA PRINCIPAL
        JFrame ventanaPrincipal = crearventana();

        // PANEL: CONFIGURACIÓN DEL PANEL PRINCIPAL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        ventanaPrincipal.add(panelPrincipal);

        // DESPLEGABLE: TIPO DE VEHÍCULO
        String[] tiposVehiculos = {"Coche", "Coche Eléctrico", "Moto", "Minusválido"};
        JComboBox<String> desplegableVehiculos = new JComboBox<>(tiposVehiculos);
        desplegableVehiculos.setBounds(270, 409, 200, 30);
        panelPrincipal.add(desplegableVehiculos);

        // TEXTO: USTED SE ENCUENTRA EN LA CALLE FERNANDEZ DE LOS RÍOS
        JLabel calle = new JLabel("USTED SE ENCUENTRA EN LA CALLE FERNANDEZ DE LOS RÍOS");
        calle.setBounds(110, 65, 800, 100);
        calle.setForeground(new Color(63, 106, 184));
        calle.setFont(new Font("Arial", Font.BOLD, 17));
        panelPrincipal.add(calle);

        // LOGO
        ImageIcon imagenlogo = new ImageIcon("Imagenes/FOTO PARKING.png");
        JLabel logo = new JLabel();
        logo.setBounds(195, 175, 350, 120);
        logo.setIcon(new ImageIcon(imagenlogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(logo);

        // TEXTO: ELIJA EL TIPO DE VEHÍCULO QUE DESEE ESTACIONAR
        JLabel vehiculo = new JLabel("ELIJA EL TIPO DE VEHÍCULO QUE DESEE ESTACIONAR:");
        vehiculo.setBounds(145, 315, 500, 100);
        vehiculo.setForeground(new Color(63, 106, 184));
        vehiculo.setFont(new Font("Arial", Font.BOLD, 17));
        panelPrincipal.add(vehiculo);

        // BOTÓN: CONTINUAR CON LA RESERVA
        JButton botonprincipal = new JButton("CONTINUAR CON LA RESERVA");
        botonprincipal.setFocusable(false);
        botonprincipal.setBounds(220, 555, 300, 32);
        botonprincipal.setForeground(Color.white);
        botonprincipal.setFont(new Font("Arial", Font.BOLD, 14));
        botonprincipal.setBackground(Color.RED);
        botonprincipal.setOpaque(true);
        botonprincipal.setBorderPainted(false);
        panelPrincipal.add(botonprincipal);

        /**
         * Acción del botón para continuar con la reserva.
         * Obtiene el tipo de vehículo seleccionado y abre la siguiente pantalla.
         */
        botonprincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // OBTENER TIPO DE VEHÍCULO SELECCIONADO
                String tipoVehiculoSeleccionado = (String) desplegableVehiculos.getSelectedItem();

                // MOSTRAR EL TIPO DE VEHÍCULO SELECCIONADO POR EL USUARIO
                JOptionPane.showMessageDialog(ventanaPrincipal,
                        "Tipo de vehículo seleccionado: " + tipoVehiculoSeleccionado,
                        "Información de reserva",
                        JOptionPane.INFORMATION_MESSAGE);

                // PASAR A LA SIGUIENTE PANTALLA
                new Calle_fernandezdelosrios_matriz(tipoVehiculoSeleccionado);
                ventanaPrincipal.dispose();
            }
        });

        // BOTÓN: RETORNO AL MAPA DE CALLES
        ImageIcon imagenboton2 = new ImageIcon("Imagenes/BOTON_RETORNO.png");
        JButton botonprincipal2 = new JButton("");
        botonprincipal2.setFocusable(false);
        botonprincipal2.setBounds(350, 620, 40, 40);
        botonprincipal2.setIcon(new ImageIcon(imagenboton2.getImage().getScaledInstance(botonprincipal2.getWidth(), botonprincipal2.getHeight(), Image.SCALE_SMOOTH)));
        botonprincipal2.setBorderPainted(false);
        panelPrincipal.add(botonprincipal2);

        /**
         * Acción del botón para retornar al mapa de calles.
         * Cierra la ventana actual y abre la pantalla del mapa.
         */
        botonprincipal2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Mapa_calles();
                ventanaPrincipal.dispose();
            }
        });

        // MOSTRAR LA VENTANA PRINCIPAL
        ventanaPrincipal.setVisible(true);
    }
}
