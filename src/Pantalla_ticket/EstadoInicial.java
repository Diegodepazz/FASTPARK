package Pantalla_ticket;

import Pantalla_reserva_vehiculo.Opciones_reserva_ticket;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

/**
 * Esta clase implementa el estado inicial de la pantalla de visualización de tickets.
 * Muestra la interfaz para ver los tickets registrados y tiene opciones para
 * navegar a otros estados o regresar a la ventana de opciones de reserva de ticket.
 */
public class EstadoInicial implements TicketState {

    /**
     * Método para mostrar la información en el panel de la ventana.
     * Se muestran el título, la imagen del ticket, un botón para ver el ticket
     * y un botón para regresar a la ventana anterior.
     *
     * @param panelPrincipal El panel donde se agregan los componentes visuales.
     */
    @Override
    public void mostrarInformacion(JPanel panelPrincipal) {

        // TÍTULO: VISUALICE LOS TICKETS REGISTRADOS
        JLabel titulo = new JLabel("VISUALICE LOS TICKETS REGISTRADOS");
        titulo.setBounds(215, 80, 500, 100);
        titulo.setForeground(new Color(63, 106, 184));
        titulo.setFont(new Font("Arial", Font.BOLD, 17));
        panelPrincipal.add(titulo);

        // AGREGAR IMAGEN TICKET
        ImageIcon imagenticket = new ImageIcon("Imagenes/FOTO TICKET.png");
        JLabel ticket = new JLabel();
        ticket.setBounds(250, 210, 250, 260);
        ticket.setIcon(new ImageIcon(imagenticket.getImage().getScaledInstance(ticket.getWidth(), ticket.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(ticket);

        // BOTÓN "VER TICKET"
        JButton botonVerTicket = new JButton("VER TICKET");
        botonVerTicket.setFocusable(false);
        botonVerTicket.setBounds(260, 550, 220, 40);
        botonVerTicket.setForeground(Color.white);
        botonVerTicket.setFont(new Font("Arial", Font.BOLD, 16));
        botonVerTicket.setBackground(Color.RED);
        botonVerTicket.setOpaque(true);
        botonVerTicket.setBorderPainted(false);
        panelPrincipal.add(botonVerTicket);

        botonVerTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambiar al estado de tickets listados
                Ticket.setState(new EstadoTicketsListados());
                Ticket.actualizarPantalla();
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
                new Opciones_reserva_ticket();
                Ticket.ventanaPrincipal.dispose(); // Cierra la ventana de tickets
            }
        });
    }
}
