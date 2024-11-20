import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class Pantalla_reserva_calendario extends General {
    public Pantalla_reserva_calendario() {
        // VENTANA
        JFrame ventanaPrincipal = crearventana();

        // PANEL
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.white);
        ventanaPrincipal.add(panelPrincipal);

        // TEXTO: COMENCEMOS CON LA RESERVA DE PLAZA
        JLabel bienvenida = new JLabel("COMENCEMOS CON LA RESERVA DE PLAZA");
        bienvenida.setBounds(182, 30, 500, 50);
        bienvenida.setForeground(new Color(63, 106, 184));
        bienvenida.setFont(new Font("Arial", Font.BOLD, 17));
        panelPrincipal.add(bienvenida);

        // SELECCIONAR MES Y AÑO
        JLabel labelMesAño = new JLabel("SELECCIONE EL MES Y AÑO:");
        labelMesAño.setBounds(120, 100, 200, 30);
        panelPrincipal.add(labelMesAño);

        JComboBox<String> comboMes = new JComboBox<>(new String[]{
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        });
        comboMes.setBounds(331, 100, 100, 30);
        panelPrincipal.add(comboMes);

        JComboBox<Integer> comboAño = new JComboBox<>();
        for (int i = 2020; i <= 2030; i++) {
            comboAño.addItem(i);
        }
        comboAño.setBounds(480, 100, 100, 30);
        panelPrincipal.add(comboAño);

        // TABLA DE CALENDARIO
        String[] columnas = {"Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"};
        DefaultTableModel modeloCalendario = new DefaultTableModel(columnas, 0);
        JTable tablaCalendario = new JTable(modeloCalendario);
        tablaCalendario.setRowHeight(30);
        tablaCalendario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Solo una celda seleccionada
        tablaCalendario.setCellSelectionEnabled(true); // Activar selección por celda
        JScrollPane scrollCalendario = new JScrollPane(tablaCalendario);
        scrollCalendario.setBounds(73, 165, 600, 200);
        panelPrincipal.add(scrollCalendario);

        // Renderizador para resaltar solo la celda seleccionada
        tablaCalendario.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (isSelected && value != null) { // Solo colorea la celda seleccionada si tiene valor
                    cell.setBackground(new Color(63, 106, 184));
                    cell.setForeground(Color.white);
                } else {
                    cell.setBackground(Color.white);
                    cell.setForeground(Color.black);
                }
                return cell;
            }
        });

        // ACTUALIZAR CALENDARIO
        actualizarCalendario(comboAño, comboMes, modeloCalendario);

        comboMes.addActionListener(e -> actualizarCalendario(comboAño, comboMes, modeloCalendario));
        comboAño.addActionListener(e -> actualizarCalendario(comboAño, comboMes, modeloCalendario));

        // SELECCIONAR HORA
        JLabel labelHora = new JLabel("SELECCIONE LA HORA:");
        labelHora.setBounds(220, 390, 200, 30);
        panelPrincipal.add(labelHora);

        JComboBox<String> comboHora = new JComboBox<>();
        for (int hora = 0; hora < 24; hora++) {
            for (int min = 0; min < 60; min += 5) { // Intervalos de 5 minutos
                comboHora.addItem(String.format("%02d:%02d", hora, min));
            }
        }
        comboHora.setBounds(420, 390, 100, 30);
        panelPrincipal.add(comboHora);

        // BOTÓN: CONTINUAR
        JButton botonprincipal = new JButton("CONTINUAR CON LA RESERVA");
        botonprincipal.setFocusable(false);
        botonprincipal.setBounds(220, 570, 300, 32);
        botonprincipal.setForeground(Color.white);
        botonprincipal.setFont(new Font("Arial", Font.BOLD, 14));
        botonprincipal.setBackground(Color.RED);
        botonprincipal.setOpaque(true);
        botonprincipal.setBorderPainted(false);
        panelPrincipal.add(botonprincipal);

        botonprincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verificar selección del calendario y la hora
                int fila = tablaCalendario.getSelectedRow();
                int columna = tablaCalendario.getSelectedColumn();

                if (fila == -1 || columna == -1) { // No se seleccionó un día
                    JOptionPane.showMessageDialog(ventanaPrincipal, "Por favor, seleccione un día en el calendario.");
                    return;
                }

                Object diaSeleccionado = tablaCalendario.getValueAt(fila, columna);
                if (diaSeleccionado == null) { // Celda vacía
                    JOptionPane.showMessageDialog(ventanaPrincipal, "Por favor, seleccione un día válido.");
                    return;
                }

                String horaSeleccionada = (String) comboHora.getSelectedItem();
                if (horaSeleccionada == null || horaSeleccionada.isEmpty()) { // Hora no seleccionada
                    JOptionPane.showMessageDialog(ventanaPrincipal, "Por favor, seleccione una hora.");
                    return;
                }

                int añoSeleccionado = (int) comboAño.getSelectedItem();
                int mesSeleccionado = comboMes.getSelectedIndex();

                JOptionPane.showMessageDialog(ventanaPrincipal,
                        "Fecha seleccionada: " + diaSeleccionado + "/" + (mesSeleccionado + 1) + "/" + añoSeleccionado +
                                " a las " + horaSeleccionada);

                ventanaPrincipal.dispose();
                new Pantalla_calles();
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
                ventanaPrincipal.dispose();
                new Pantalla_opciones();
            }
        });

        ventanaPrincipal.setVisible(true);
    }

    private void actualizarCalendario(JComboBox<Integer> comboAño, JComboBox<String> comboMes, DefaultTableModel modeloCalendario) {
        modeloCalendario.setRowCount(0); // Limpiar filas existentes

        int año = (int) comboAño.getSelectedItem();
        int mes = comboMes.getSelectedIndex(); // Enero = 0, Diciembre = 11

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, año);
        cal.set(Calendar.MONTH, mes);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        int primerDiaSemana = cal.get(Calendar.DAY_OF_WEEK) - 2; // Lunes = 0
        if (primerDiaSemana < 0) primerDiaSemana = 6; // Ajustar para domingo

        int diasMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        int[] dias = new int[42];
        for (int i = 0; i < diasMes; i++) {
            dias[primerDiaSemana + i] = i + 1;
        }

        for (int i = 0; i < dias.length; i += 7) {
            modeloCalendario.addRow(new Object[]{
                    dias[i] == 0 ? null : dias[i],
                    dias[i + 1] == 0 ? null : dias[i + 1],
                    dias[i + 2] == 0 ? null : dias[i + 2],
                    dias[i + 3] == 0 ? null : dias[i + 3],
                    dias[i + 4] == 0 ? null : dias[i + 4],
                    dias[i + 5] == 0 ? null : dias[i + 5],
                    dias[i + 6] == 0 ? null : dias[i + 6],
            });
        }
    }
}
