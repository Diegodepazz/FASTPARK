import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Pantalla_calle_galileo_matriz {

    public Pantalla_calle_galileo_matriz(String tipoVehiculo) {
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
        JLabel bienvenida = new JLabel("¡¡MATRIZ GUZMAN!!", SwingConstants.CENTER);
        bienvenida.setForeground(new Color(63, 106, 184));
        bienvenida.setFont(new Font("Arial", Font.BOLD, 19));
        panelPrincipal.add(bienvenida, BorderLayout.NORTH);

        // MATRIZ DE LA CALLE
        String[][] calle = crearMatrizCalle(tipoVehiculo);

        // TABLA PARA MOSTRAR LA MATRIZ
        JTable tablaCalle = new JTable(calle.length, calle[0].length);
        for (int i = 0; i < calle.length; i++) {
            for (int j = 0; j < calle[i].length; j++) {
                tablaCalle.setValueAt(calle[i][j], i, j);
            }
        }
        tablaCalle.setRowHeight(30);
        JScrollPane scrollPane = new JScrollPane(tablaCalle);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // Añadir un MouseListener para detectar clics en la tabla
        tablaCalle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Obtener la fila y columna del clic
                int fila = tablaCalle.rowAtPoint(e.getPoint());
                int columna = tablaCalle.columnAtPoint(e.getPoint());

                String selectedPlaza = (String) tablaCalle.getValueAt(fila, columna);

                // Si la plaza está ocupada (no disponible)
                if (selectedPlaza.equals("No disponible")) {
                    JOptionPane.showMessageDialog(ventanaPrincipal, "¡Error! Plaza no disponible.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(ventanaPrincipal, "Has seleccionado: " + selectedPlaza,
                            "Plaza seleccionada", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // BOTÓN: CONTINUAR CON LA RESERVA
        JButton botonPrincipal = new JButton("CONTINUAR CON LA RESERVA");
        botonPrincipal.setFocusable(false);
        botonPrincipal.setForeground(Color.white);
        botonPrincipal.setFont(new Font("Arial", Font.BOLD, 14));
        botonPrincipal.setBackground(Color.RED);
        botonPrincipal.setOpaque(true);
        botonPrincipal.setBorderPainted(false);
        panelPrincipal.add(botonPrincipal, BorderLayout.SOUTH);

        botonPrincipal.addActionListener(e -> {
            ventanaPrincipal.dispose();
            new Pantalla_calles();  // Aquí puedes colocar tu siguiente pantalla
        });

        // VISIBILIDAD
        ventanaPrincipal.setVisible(true);
    }

    private String[][] crearMatrizCalle(String tipoVehiculo) {
        String[][] calle = new String[3][10]; // Tres filas y diez columnas
        Random random = new Random();

        // Lado izquierdo y derecho con sitios del tipo seleccionado
        for (int i = 0; i < calle[0].length; i++) {
            calle[0][i] = random.nextBoolean() ? asignarSitio(tipoVehiculo) : "No disponible";
            calle[2][i] = random.nextBoolean() ? asignarSitio(tipoVehiculo) : "No disponible";
        }

        // Fila del medio: Carretera
        for (int i = 0; i < calle[1].length; i++) {
            calle[1][i] = "Carretera";
        }

        return calle;
    }

    private String asignarSitio(String tipoVehiculo) {
        // Retorna el sitio según el tipo de vehículo seleccionado
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

    public static void main(String[] args) {
        new Pantalla_calle_guzman_matriz("Coche"); // Cambia "Coche" por el tipo de vehículo que quieras probar
    }
}
