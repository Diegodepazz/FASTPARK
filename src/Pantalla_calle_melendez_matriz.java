import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Pantalla_calle_melendez_matriz {

    public Pantalla_calle_melendez_matriz(String tipoVehiculo) {
        // VENTANA
        JFrame ventanaPrincipal = new JFrame();
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setSize(800, 700);
        ventanaPrincipal.setLayout(new BorderLayout());
        ventanaPrincipal.setLocationRelativeTo(null);

        // Cambiar el color de fondo de la ventana a blanco
        ventanaPrincipal.getContentPane().setBackground(Color.WHITE);  // Fondo blanco de la ventana

        // PANEL PRINCIPAL CON GridBagLayout PARA CENTRAR TODO
        JPanel panelPrincipal = new JPanel(new GridBagLayout());

        // Cambiar el color de fondo del panel a blanco
        panelPrincipal.setBackground(Color.WHITE);  // Fondo blanco del panel
        GridBagConstraints gbc = new GridBagConstraints();
        ventanaPrincipal.add(panelPrincipal, BorderLayout.CENTER);

        // TÍTULO
        JLabel bienvenida = new JLabel("CALLE FERNANDEZ DE LOS RIOS", SwingConstants.CENTER);
        bienvenida.setForeground(new Color(63, 106, 184));
        bienvenida.setFont(new Font("Arial", Font.BOLD, 24));

        // Configurar posición del título
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 20, 0); // Margen superior e inferior
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(bienvenida, gbc);

        // MATRIZ DE LA CALLE
        String[][] calle = crearMatrizCalle(tipoVehiculo);

        // TABLA PARA MOSTRAR LA MATRIZ
        JTable tablaCalle = new JTable(calle.length, calle[0].length) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Deshabilitar edición de celdas
            }
        };

        // Ajustar tamaño de las filas y columnas
        int alturaFila = 38; // Ajusta el tamaño según la ventana
        tablaCalle.setRowHeight(alturaFila);
        tablaCalle.setFont(new Font("Arial", Font.PLAIN, 14));

        // Centrar texto y aplicar colores
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

        // Añadir la tabla centrada
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 20, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JScrollPane scrollPane = new JScrollPane(tablaCalle);
        scrollPane.setPreferredSize(new Dimension(600, 400)); // Ajusta tamaño según la ventana
        panelPrincipal.add(scrollPane, gbc);

        // PANEL PARA LOS BOTONES
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        panelBotones.setBackground(Color.WHITE);  // Fondo blanco del panel de botones

        // BOTÓN: CONTINUAR CON LA RESERVA
        JButton botonPrincipal = new JButton("CONTINUAR CON LA RESERVA");
        botonPrincipal.setFocusable(false);
        botonPrincipal.setForeground(Color.white);
        botonPrincipal.setFont(new Font("Arial", Font.BOLD, 16));
        botonPrincipal.setBackground(Color.RED);
        botonPrincipal.setOpaque(true);
        botonPrincipal.setBorderPainted(false);
        botonPrincipal.setPreferredSize(new Dimension(300, 50)); // Tamaño del botón
        panelBotones.add(botonPrincipal);

        botonPrincipal.addActionListener(e -> {
            ventanaPrincipal.dispose();
            new Pantalla_calles(); // Aquí puedes colocar tu siguiente pantalla
        });

        // BOTÓN: RETORNO
        ImageIcon imagenboton2 = new ImageIcon("Imagenes/BOTON_RETORNO.png");
        JButton botonprincipal2 = new JButton("");
        botonprincipal2.setFocusable(false);
        botonprincipal2.setPreferredSize(new Dimension(30, 30));
        botonprincipal2.setIcon(new ImageIcon(imagenboton2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        botonprincipal2.setBorderPainted(false);
        panelBotones.add(botonprincipal2);

        botonprincipal2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaPrincipal.dispose();
                new Pantalla_calle_melendez();
            }
        });

        // Configurar posición de los botones
        gbc.gridy = 2;
        gbc.insets = new Insets(20, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(panelBotones, gbc);

        // VISIBILIDAD
        ventanaPrincipal.setVisible(true);
    }

    private String[][] crearMatrizCalle(String tipoVehiculo) {
        int filas = 10; // Número de filas
        int columnas = 3; // Número de columnas
        String[][] calle = new String[filas][columnas];
        Random random = new Random();

        // Llenar la matriz con los huecos adecuados
        for (int i = 0; i < filas; i++) {
            calle[i][0] = random.nextBoolean() ? asignarSitio(tipoVehiculo) : "No disponible";
            calle[i][1] = "Carretera";
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