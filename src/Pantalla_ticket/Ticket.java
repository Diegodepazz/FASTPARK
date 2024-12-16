package Pantalla_ticket;

import Main.General_ventanas;
import javax.swing.*;
import java.awt.*;

public class Ticket extends General_ventanas {
    private static TicketState estadoActual;  // MANTIENE EL ESTADO ACTUAL DE LA PANTALLA
    private static JPanel panelPrincipal; //EL PANEL PRINCIPAL DONDE SE AGREGAN LOS COMPONENTES
    static JFrame ventanaPrincipal; //LA VENTANA PRINCIPAL QUE CONTIENE EL PANEL

    public Ticket(){
        // Ventana
        ventanaPrincipal = crearventana();

        // Panel
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        ventanaPrincipal.add(panelPrincipal);

        // INICIALIZA EL ESTADO
        setState(new EstadoInicial()); //ESTABLECE EL ESTADO INCIAL DE LA APLICACIÓN
        actualizarPantalla(); //ACTUALIZA LA PANTALLA SEGÚN EL ESTADO ACTUAL

        ventanaPrincipal.setVisible(true); //HACE VISIBLE LA PANTALLA
    }

    // METODO PARA CABIAR EL ESTADO DE LA PANTALLA
    public static void setState(TicketState nuevoEstado) {
        estadoActual = nuevoEstado; //CAMBIA EL ESTADO ACTUAL A UNO NUEVO
    }

    // METODO PARA ACTUALIZAR LA INTERFAZ CON BASE EN EL ESTADO
    public static void actualizarPantalla() {
        panelPrincipal.removeAll();  // ELIMINA TODOS LOS COMPONENTES DEL PANEL PARA "LIMPIARLO"
        estadoActual.mostrarInformacion(panelPrincipal);  //LLAMA AL MÉTODO PARA AGREGAR NUEVOS COMPONENTES
        ventanaPrincipal.revalidate(); //VUELVE A VALIDAR EL LAYOUT DE LA VENTANA
        ventanaPrincipal.repaint(); //REDIBUJA LA VENTANA
    }
}