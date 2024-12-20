package Pantalla_calles;

import Main.General_ventanas;
import Pantalla_ticket.Ticket;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Random;
/**
 * Clase que representa la interfaz gráfica para gestionar la Calle_galileo_matriz.
 * Permite visualizar una matriz de plazas disponibles, carreteras y zonas no disponibles, además de gestionar la reserva de plazas.
 */
public class Calle_galileo_matriz extends General_ventanas {
    /**
     * Constructor de la clase.
     * Inicializa la ventana principal, genera la matriz de la calle y permite interactuar con la interfaz gráfica.
     * @param tipoVehiculo Tipo de vehículo para asignar las plazas de la calle (Coche, Coche Eléctrico, Moto, Minusválido).
     */
    public Calle_galileo_matriz(String tipoVehiculo) {

        // VENTANA
        JFrame ventanaPrincipal = crearventana();

        // CAMBIAR EL COLOR DE FONDO DE LA VENTANA A BLANCO
        ventanaPrincipal.getContentPane().setBackground(Color.WHITE);

        // PANEL PRINCIPAL CON GridBagLayout PARA CENTRAR TODO
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBackground(Color.WHITE); // FONDO BLANCO DEL PANEL
        GridBagConstraints gbc = new GridBagConstraints();
        ventanaPrincipal.add(panelPrincipal, BorderLayout.CENTER);

        // TÍTULO: CALLE FERNANDEZ DE LOS RIOS
        JLabel bienvenida = new JLabel("CALLE FERNANDEZ DE LOS RIOS", SwingConstants.CENTER);
        bienvenida.setForeground(new Color(63, 106, 184));
        bienvenida.setFont(new Font("Arial", Font.BOLD, 24));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 20, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(bienvenida, gbc);

        // MATRIZ DE LA CALLE
        String[][] calle = crearMatrizCalle(tipoVehiculo);

        // TABLA PARA MOSTRAR LA MATRIZ
        JTable tablaCalle = new JTable(calle.length, calle[0].length) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // DESHABILITAR EDICIÓN DE CELDAS
            }
        };

        tablaCalle.setRowHeight(38);
        tablaCalle.setFont(new Font("Arial", Font.PLAIN, 14));
        tablaCalle.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                cell.setForeground(Color.BLACK);

                if ("No disponible".equals(value)) {
                    cell.setBackground(Color.LIGHT_GRAY);
                } else if ("Carretera".equals(value)) {
                    cell.setBackground(Color.DARK_GRAY);
                    cell.setForeground(Color.WHITE);
                } else {
                    cell.setBackground(new Color(144, 238, 144)); // VERDE CLARO
                }
                setHorizontalAlignment(SwingConstants.CENTER);
                return cell;
            }
        });

        // RELLENAR LA TABLA
        for (int i = 0; i < calle.length; i++) {
            for (int j = 0; j < calle[i].length; j++) {
                tablaCalle.setValueAt(calle[i][j], i, j);
            }
        }

        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 20, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JScrollPane scrollPane = new JScrollPane(tablaCalle);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        panelPrincipal.add(scrollPane, gbc);

        // PANEL PARA LOS BOTONES
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        panelBotones.setBackground(Color.WHITE);

        JButton botonPrincipal = new JButton("CONTINUAR CON LA RESERVA");
        botonPrincipal.setFocusable(false);
        botonPrincipal.setForeground(Color.WHITE);
        botonPrincipal.setFont(new Font("Arial", Font.BOLD, 16));
        botonPrincipal.setBackground(Color.RED);
        botonPrincipal.setOpaque(true);
        botonPrincipal.setBorderPainted(false);
        botonPrincipal.setPreferredSize(new Dimension(300, 50));
        panelBotones.add(botonPrincipal);

        // VALIDAR LA SELECCIÓN ANTES DE CONTINUAR
        botonPrincipal.addActionListener(e -> {
            int filaSeleccionada = tablaCalle.getSelectedRow();
            int columnaSeleccionada = tablaCalle.getSelectedColumn();

            if (filaSeleccionada == -1 || columnaSeleccionada == -1) {
                JOptionPane.showMessageDialog(ventanaPrincipal, "POR FAVOR, SELECCIONA UNA PLAZA.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String valorCelda = (String) tablaCalle.getValueAt(filaSeleccionada, columnaSeleccionada);
                if ("No disponible".equals(valorCelda) || "Carretera".equals(valorCelda)) {
                    JOptionPane.showMessageDialog(ventanaPrincipal, "Espacio no disponible. Seleccione otra plaza ", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(ventanaPrincipal, "Reserva realizada correctamente.");
                    new Ticket(); // CONTINUAR CON LA SIGUIENTE PANTALLA
                    ventanaPrincipal.dispose();
                }
            }
        });

        ImageIcon imagenboton2 = new ImageIcon("Imagenes/BOTON_RETORNO.png");
        JButton botonprincipal2 = new JButton("");
        botonprincipal2.setFocusable(false);
        botonprincipal2.setPreferredSize(new Dimension(30, 30));
        botonprincipal2.setIcon(new ImageIcon(imagenboton2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        botonprincipal2.setBorderPainted(false);
        panelBotones.add(botonprincipal2);

        botonprincipal2.addActionListener(e -> {
            new Calle_galileo();
            ventanaPrincipal.dispose();
        });

        gbc.gridy = 2;
        gbc.insets = new Insets(20, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(panelBotones, gbc);

        ventanaPrincipal.setVisible(true);
    }
    /**
     * Crea la matriz que representa las plazas de la calle, asignando sitios según el tipo de vehículo,
     * marcando las zonas de carretera y las plazas no disponibles.
     *
     * @param tipoVehiculo Tipo de vehículo para determinar el tipo de plaza asignada.
     * @return Una matriz bidimensional de cadenas que representa la distribución de la calle.
     */
    private String[][] crearMatrizCalle(String tipoVehiculo) {
        int filas = 10;
        int columnas = 3;
        String[][] calle = new String[filas][columnas];
        Random random = new Random();

        for (int i = 0; i < filas; i++) {
            calle[i][0] = random.nextBoolean() ? asignarSitio(tipoVehiculo) : "No disponible";
            calle[i][1] = "Carretera";
            calle[i][2] = random.nextBoolean() ? asignarSitio(tipoVehiculo) : "No disponible";
        }

        return calle;
    }
    /**
     * Asigna un tipo de sitio en función del tipo de vehículo proporcionado.
     * @param tipoVehiculo Tipo de vehículo para determinar el tipo de plaza (Coche, Coche Eléctrico, Moto, Minusválido).
     * @return Una cadena que indica el tipo de sitio asignado (ejemplo: "Sitio Coche").
     */
    private String asignarSitio(String tipoVehiculo) {
        switch (tipoVehiculo) {
            case "Coche":
                return "Sitio Coche";
            case "Coche Eléctrico":
                return "Sitio Eléctrico";
            case "Moto":
                return "Sitio Moto";
            case "Minusválido":
                return "Sitio Minusválido";
            default:
                return "Sitio Genérico";
        }
    }
}