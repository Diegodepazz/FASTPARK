package Pantalla_ticket;

import Pantalla_calles.Mapa_calles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EstadoTicketsListados implements TicketState {

    @Override
    public void mostrarInformacion(JPanel panelPrincipal) {
        // TEXTO: TICKETS
        JLabel bienvenida = new JLabel();
        bienvenida.setText("TICKETS");
        bienvenida.setBounds(330, 50, 500, 100);
        bienvenida.setForeground(new Color(63, 106, 184));
        bienvenida.setFont(new Font("Arial", Font.BOLD, 18));
        panelPrincipal.add(bienvenida);

        // TEXTO: EL HISTORIAL DE LOS TICKETS ES
        JLabel bienvenida2 = new JLabel();
        bienvenida2.setText("EL HISTORIAL DE LOS TICKETS ES: ");
        bienvenida2.setBounds(250, 125, 500, 70);
        bienvenida2.setFont(new Font("Arial", Font.BOLD, 14));
        bienvenida2.setForeground(new Color(63, 106, 184));
        panelPrincipal.add(bienvenida2);

        // SIMULAR LA LISTA DE TICKETS Y SUS ESTADOS
        String[] tickets = {"TICKET 1", "TICKET 2", "TICKET 3", "TICKET 4", "TICKET 5", "TICKET 6"};
        String[] estados = {"PAGADO", "PENDIENTE", "PENDIENTE", "PAGADO", "PAGADO", "PAGADO"};

        for (int i = 0; i < tickets.length; i++) {
            JLabel ticketLabel = new JLabel(tickets[i]);
            ticketLabel.setBounds(160, 200 + (i * 60), 200, 40);
            ticketLabel.setForeground(new Color(63, 106, 184)); // COLOR IGUAL AL TÍTULO
            ticketLabel.setFont(new Font("Arial", Font.BOLD, 18)); // FUENTE IGUAL AL TÍTULO
            panelPrincipal.add(ticketLabel);

            JLabel estadoLabel = new JLabel(estados[i]);
            estadoLabel.setBounds(340, 200 + (i * 60), 100, 40);
            estadoLabel.setFont(new Font("Arial", Font.BOLD, 14)); // NEGRITA PARA TODOS LOS ESTADOS

            if (estados[i].equals("PAGADO")) {
                estadoLabel.setForeground(new Color(0, 128, 0)); // VERDE PARA "PAGADO"
            } else {
                estadoLabel.setForeground(Color.RED); // ROJO PARA "PENDIENTE"
            }

            panelPrincipal.add(estadoLabel);

            // CREAR UN BOTÓN DE PAGAR SOLO SI EL ESTADOS ES "PENDIENTE"
            if (estados[i].equals("PENDIENTE")) {
                JButton botonPagar = new JButton("PAGAR");
                botonPagar.setBounds(470, 205 + (i * 60), 100, 40); // TAMAÑO ADECUADO
                botonPagar.setBackground(new Color(255, 0, 0));
                botonPagar.setForeground(Color.WHITE); // Letras en blanco
                botonPagar.setFont(new Font("Arial", Font.BOLD, 14)); //NEGRITA
                botonPagar.setOpaque(true); // HACER EL FONDO SÓLIDO
                botonPagar.setFocusPainted(false); // ELIMINAR BORDE
                botonPagar.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(255, 0, 0), 2),
                        BorderFactory.createEmptyBorder(5, 15, 5, 15)
                ));

                // ACCIÓN DE PAGAR
                botonPagar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Cambiar el estado del ticket a "Pagado"
                        estadoLabel.setText("PAGADO");
                        estadoLabel.setForeground(new Color(0, 128, 0)); // VERDE PARA ESTADO "APAGADO"
                        estadoLabel.setFont(new Font("Arial", Font.BOLD, 14)); // NEGRITA

                        // Actualizar el texto del botón a "PAGADO"
                        botonPagar.setText("PAGADO");
                        botonPagar.setBackground(new Color(169, 169, 169)); // CAMBIAR COLOR A GRIS PARA INDICAR QUE YA SE PAGÓ
                        botonPagar.setEnabled(false); // DESACTIVAR EL BOTÓN DE PAGAR

                        // Actualizar el borde del botón a gris
                        botonPagar.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(new Color(169, 169, 169), 2), // CAMBIAR EL BORDE A GRIS
                                BorderFactory.createEmptyBorder(5, 15, 5, 15) // CREAR UN MÁRGEN INTERNO
                        ));
                    }
                });

                panelPrincipal.add(botonPagar); //AÑADIR EL BOTÓN AL PANEL
            } else {
                // SI EL TICKET YA ESTÁ PAGADO, MOSTRAR EL BOTÓN EN GRIS
                JButton botonPagado = new JButton("PAGADO");
                botonPagado.setBounds(470, 205 + (i * 60), 100, 40); // TAMAÑO ADECUADO
                botonPagado.setBackground(new Color(169, 169, 169)); //COLOR GRIS
                botonPagado.setForeground(Color.WHITE); // LETRAS EN BLANCO
                botonPagado.setFont(new Font("Arial", Font.BOLD, 14)); // NEGRITA
                botonPagado.setOpaque(true);
                botonPagado.setFocusPainted(false); // ELIMINAR EL BORDE
                botonPagado.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(169, 169, 169), 2), // BORDES REDONDOS EN GRIS
                        BorderFactory.createEmptyBorder(5, 15, 5, 15) // CREAR UN MARGEN INTERNO
                ));
                botonPagado.setEnabled(false); // DESACTIVAR EL BOTÓN PARA QUE NO SEA INTERACTIVO
                panelPrincipal.add(botonPagado); // AÑADIR EL BOTÓN AL PANEL
            }
        }

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
                // Volver al estado inicial
                Ticket.setState(new EstadoInicial()); // Cambiar al estado inicial
                Ticket.actualizarPantalla();          // Actualizar la pantalla
            }
        });

    }
}