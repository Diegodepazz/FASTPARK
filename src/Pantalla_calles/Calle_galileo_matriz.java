package Pantalla_calles;

import Pantalla_ticket.Ticket;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Random;

/**
 * Clase que representa la pantalla para visualizar la matriz de espacios de estacionamiento
 * en la calle Galileo. Permite al usuario seleccionar una plaza disponible y continuar con
 * la reserva o regresar a la pantalla anterior.
 */
public class Calle_galileo_matriz {
    /**
     * Constructor de la clase.
     * Inicializa la interfaz gráfica con la matriz de plazas de estacionamiento,
     * un botón para continuar con la reserva y otro para regresar a la pantalla anterior.
     *
     * @param tipoVehiculo El tipo de vehículo seleccionado por el usuario.
     */
    public Calle_galileo_matriz(String tipoVehiculo) {

        // VENTANA
        JFrame ventanaPrincipal = new JFrame();
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setSize(800, 700);
        ventanaPrincipal.setLayout(new BorderLayout());
        ventanaPrincipal.setLocationRelativeTo(null);

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
                JOptionPane.showMessageDialog(ventanaPrincipal, "POR FAVOR, SELECCIONA UNA PLAZA.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String valorCelda = (String) tablaCalle.getValueAt(filaSeleccionada, columnaSeleccionada);
                if ("No disponible".equals(valorCelda) || "Carretera".equals(valorCelda)) {
                    JOptionPane.showMessageDialog(ventanaPrincipal, "ESPACIO NO DISPONIBLE. SELECCIONE OTRA PLAZA ", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(ventanaPrincipal, "RESERVA REALIZADA CORRECTAMENTE.");
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
     * MÉTODO PARA CREAR LA MATRIZ DE LA CALLE BASADA EN EL TIPO DE VEHÍCULO SELECCIONADO.
     *
     * @param tipoVehiculo El tipo de vehículo seleccionado.
     * @return Una matriz de String que representa la distribución de la calle.
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
     * MÉTODO PARA ASIGNAR EL TIPO DE SITIO EN FUNCIÓN DEL VEHÍCULO.
     *
     * @param tipoVehiculo El tipo de vehículo.
     * @return Un String representando el tipo de sitio.
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