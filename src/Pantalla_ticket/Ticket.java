package Pantalla_ticket;

import Main.General_ventanas;
import javax.swing.*;
import java.awt.*;

/**
 * La clase {@code Ticket} representa la pantalla principal para visualizar y gestionar tickets.
 * Utiliza el patrón de diseño State para cambiar dinámicamente entre diferentes vistas.
 * Extiende {@code General_ventanas} para la creación de ventanas.
 */
public class Ticket extends General_ventanas {

    private static TicketState estadoActual;
    private static JPanel panelPrincipal;
    static JFrame ventanaPrincipal;

    /**
     * Constructor de la clase {@code Ticket}.
     * Inicializa la ventana principal y establece el estado inicial de la pantalla.
     */
    public Ticket(){
        // VENTANA
        ventanaPrincipal = crearventana();

        // PANEL
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        ventanaPrincipal.add(panelPrincipal);

        // INICIALIZA EL ESTADO
        setState(new EstadoInicial());
        actualizarPantalla();

        ventanaPrincipal.setVisible(true);
    }

    /**
     * Establece el nuevo estado de la pantalla.
     *
     * @param nuevoEstado El nuevo estado que se establecerá para la pantalla.
     */
    public static void setState(TicketState nuevoEstado) {
        estadoActual = nuevoEstado;
    }

    /**
     * Actualiza la interfaz de usuario según el estado actual.
     * Limpia el panel y agrega nuevos componentes correspondientes al estado.
     */
    public static void actualizarPantalla() {
        panelPrincipal.removeAll();
        estadoActual.mostrarInformacion(panelPrincipal);
        ventanaPrincipal.revalidate();
        ventanaPrincipal.repaint();
    }
}
