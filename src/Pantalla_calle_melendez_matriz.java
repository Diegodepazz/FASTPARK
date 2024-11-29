import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Pantalla_calle_melendez_matriz {

    public Pantalla_calle_melendez_matriz(String tipoVehiculo) {
        // VENTANA
        JFrame ventanaPrincipal = new JFrame("Matriz Guzmán");
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setSize(800, 700);
        ventanaPrincipal.setLayout(new BorderLayout());
        ventanaPrincipal.setLocationRelativeTo(null);

        // PANEL PRINCIPAL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        ventanaPrincipal.add(panelPrincipal, BorderLayout.CENTER);

        // TÍTULO
        JLabel bienvenida = new JLabel("CALLE FERNANDEZ DE LOS RIOS", SwingConstants.CENTER);
        bienvenida.setForeground(new Color(63, 106, 184));
        bienvenida.setFont(new Font("Arial", Font.BOLD, 24));
        panelPrincipal.add(bienvenida, BorderLayout.NORTH);

        // MATRIZ DE LA CALLE
        String[][] calle = crearMatrizCalle(tipoVehiculo);

        // TABLA PARA MOSTRAR LA MATRIZ
        JTable tablaCalle = new JTable(calle.length, calle[0].length) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Deshabilitar edición de celdas
            }
        };

        // Ajustar tamaño de las filas y columnas para hacerlas más grandes y uniformes
        tablaCalle.setRowHeight(60); // Tamaño mayor para las filas
        tablaCalle.getColumnModel().getColumn(0).setPreferredWidth(150); // Columna izquierda más ancha
        tablaCalle.getColumnModel().getColumn(calle[0].length - 1).setPreferredWidth(150); // Columna derecha más ancha
        tablaCalle.getColumnModel().getColumn(1).setPreferredWidth(300); // Columna central (carretera)

        tablaCalle.setFont(new Font("Arial", Font.PLAIN, 16));

        // RENDERIZADOR PARA CENTRAR TEXTO Y APLICAR COLORES
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        tablaCalle.setDefaultRenderer(Object.class, renderer);

        // APLICAR COLORES A LAS CELDAS
        tablaCalle.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                cell.setForeground(Color.BLACK);

                if (value.equals("No disponible")) {
                    cell.setBackground(Color.LIGHT_GRAY);
                } else if (value.equals("Carretera")) {
                    cell.setBackground(Color.DARK_GRAY);
                    cell.setForeground(Color.WHITE);
                } else {
                    cell.setBackground(new Color(144, 238, 144)); // Verde claro para sitios disponibles
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

        JScrollPane scrollPane = new JScrollPane(tablaCalle);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // Añadir un MouseListener para detectar clics en la tabla
        tablaCalle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = tablaCalle.rowAtPoint(e.getPoint());
                int columna = tablaCalle.columnAtPoint(e.getPoint());

                String selectedPlaza = (String) tablaCalle.getValueAt(fila, columna);

                if (selectedPlaza.equals("No disponible")) {
                    JOptionPane.showMessageDialog(ventanaPrincipal, "¡Error! Plaza no disponible.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!selectedPlaza.equals("Carretera")) {
                    JOptionPane.showMessageDialog(ventanaPrincipal, "Has seleccionado: " + selectedPlaza,
                            "Plaza seleccionada", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // BOTÓN: CONTINUAR CON LA RESERVA
        JButton botonPrincipal = new JButton("CONTINUAR CON LA RESERVA");
        botonPrincipal.setFocusable(false);
        botonPrincipal.setForeground(Color.white);
        botonPrincipal.setFont(new Font("Arial", Font.BOLD, 16));
        botonPrincipal.setBackground(Color.RED);
        botonPrincipal.setOpaque(true);
        botonPrincipal.setBorderPainted(false);
        panelPrincipal.add(botonPrincipal, BorderLayout.SOUTH);

        botonPrincipal.addActionListener(e -> {
            ventanaPrincipal.dispose();
            new Pantalla_calles(); // Aquí puedes colocar tu siguiente pantalla
        });

        // VISIBILIDAD
        ventanaPrincipal.setVisible(true);
    }

    private String[][] crearMatrizCalle(String tipoVehiculo) {
        int filas = 10; // Menos filas para que no quede demasiado grande
        int columnas = 3; // Tres columnas: izquierda, central y derecha
        String[][] calle = new String[filas][columnas];
        Random random = new Random();

        // Llenar la matriz con los huecos adecuados
        for (int i = 0; i < filas; i++) {
            // Columna izquierda (un solo hueco de aparcamiento)
            calle[i][0] = random.nextBoolean() ? asignarSitio(tipoVehiculo) : "No disponible";

            // Columna central (solo un hueco de carretera)
            calle[i][1] = "Carretera";

            // Columna derecha (un solo hueco de aparcamiento)
            calle[i][2] = random.nextBoolean() ? asignarSitio(tipoVehiculo) : "No disponible";
        }

        return calle;
    }

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
