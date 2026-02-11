package proyecto_1.gui;

import proyecto_1.entidades.Especialidad;
import proyecto_1.entidades.Medico;
import proyecto_1.persistencia.PersistenciaFachada;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PanelMedicos extends javax.swing.JPanel {

    private PersistenciaFachada fachada;
    private DefaultTableModel modeloTabla;

    public PanelMedicos(PersistenciaFachada fachada) {
        this.fachada = fachada;
        initComponents();
        modeloTabla = (DefaultTableModel) tabla.getModel();

        cargarEspecialidades();

        tabla.getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting() == false) {
                int fila = tabla.getSelectedRow();
                if (fila >= 0) {
                    txtId.setText(modeloTabla.getValueAt(fila, 0).toString());
                    txtNombre.setText(modeloTabla.getValueAt(fila, 1).toString());
                }
            }
        });

        actualizarTabla();
    }

    private void cargarEspecialidades() {
        cmbEspecialidad.removeAllItems();
        List<Especialidad> lista = fachada.listarEspecialidades();
        for (Especialidad e : lista) {
            cmbEspecialidad.addItem(e.getNombre());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSuperior = new javax.swing.JPanel();
        panelCampos = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblEspecialidad = new javax.swing.JLabel();
        cmbEspecialidad = new javax.swing.JComboBox<>();
        lblVacio = new javax.swing.JLabel();
        btnNuevaEsp = new javax.swing.JButton();
        panelBotones = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnVerTodos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new java.awt.BorderLayout(10, 10));

        panelSuperior.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Médico"));
        panelSuperior.setLayout(new java.awt.BorderLayout(5, 5));

        panelCampos.setLayout(new java.awt.GridLayout(2, 4, 5, 5));

        lblId.setText("ID:");
        panelCampos.add(lblId);
        txtId.setColumns(10);
        panelCampos.add(txtId);
        lblNombre.setText("Nombre:");
        panelCampos.add(lblNombre);
        txtNombre.setColumns(15);
        panelCampos.add(txtNombre);
        lblEspecialidad.setText("Especialidad:");
        panelCampos.add(lblEspecialidad);
        panelCampos.add(cmbEspecialidad);
        panelCampos.add(lblVacio);

        btnNuevaEsp.setText("+ Nueva Especialidad");
        btnNuevaEsp.addActionListener(e -> nuevaEspecialidad());
        panelCampos.add(btnNuevaEsp);

        panelSuperior.add(panelCampos, java.awt.BorderLayout.CENTER);

        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 8, 5));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(e -> agregarMedico());
        panelBotones.add(btnAgregar);

        btnBuscar.setText("Buscar por ID");
        btnBuscar.addActionListener(e -> buscarMedico());
        panelBotones.add(btnBuscar);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(e -> limpiarCampos());
        panelBotones.add(btnLimpiar);

        btnVerTodos.setText("Ver Todos");
        btnVerTodos.addActionListener(e -> actualizarTabla());
        panelBotones.add(btnVerTodos);

        panelSuperior.add(panelBotones, java.awt.BorderLayout.PAGE_END);
        add(panelSuperior, java.awt.BorderLayout.NORTH);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] { "ID", "Nombre", "Especialidad" }) {
            boolean[] canEdit = new boolean[] { false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabla);
        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void nuevaEspecialidad() {
        String nombre = JOptionPane.showInputDialog(this, "Nombre de la nueva especialidad:",
                "Nueva Especialidad", JOptionPane.QUESTION_MESSAGE);
        if (nombre != null && nombre.trim().isEmpty() == false) {
            Especialidad existente = fachada.obtenerEspecialidadPorNombre(nombre.trim());
            if (existente != null) {
                JOptionPane.showMessageDialog(this, "Ya existe esa especialidad.",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                Especialidad nueva = new Especialidad(1, nombre.trim());
                fachada.agregarEspecialidad(nueva);
                cargarEspecialidades();
                cmbEspecialidad.setSelectedItem(nombre.trim());
                JOptionPane.showMessageDialog(this, "Especialidad agregada exitosamente.",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void agregarMedico() {
        String nombre = txtNombre.getText().trim();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre es obligatorio.",
                    "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") == false) {
            JOptionPane.showMessageDialog(this, "El nombre solo debe contener letras.",
                    "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (cmbEspecialidad.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Seleccione o agregue una especialidad.",
                    "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombreEsp = cmbEspecialidad.getSelectedItem().toString();
        Especialidad esp = fachada.obtenerEspecialidadPorNombre(nombreEsp);
        if (esp == null) {
            JOptionPane.showMessageDialog(this, "Especialidad no encontrada.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Medico m = new Medico(1, nombre, esp);
            fachada.agregarMedico(m);
            JOptionPane.showMessageDialog(this, "Médico agregado exitosamente.\nID asignado: " + m.getId(),
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
            actualizarTabla();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarMedico() {
        String idStr = txtId.getText().trim();
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID para buscar.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int id = Integer.parseInt(idStr);
            Medico m = fachada.obtenerMedicoPorId(id);
            if (m != null) {
                txtNombre.setText(m.getNombre());
                if (m.getEspecialidad() != null) {
                    cmbEspecialidad.setSelectedItem(m.getEspecialidad().getNombre());
                }
                JOptionPane.showMessageDialog(this, "Médico encontrado:\n" + m.toString(),
                        "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró un médico con ID: " + id,
                        "No encontrado", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        List<Medico> lista = fachada.listarMedicos();
        for (Medico m : lista) {
            String esp = m.getEspecialidad() != null ? m.getEspecialidad().getNombre() : "Sin especialidad";
            modeloTabla.addRow(new Object[] { m.getId(), m.getNombre(), esp });
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        if (cmbEspecialidad.getItemCount() > 0) {
            cmbEspecialidad.setSelectedIndex(0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnNuevaEsp;
    private javax.swing.JButton btnVerTodos;
    private javax.swing.JComboBox<String> cmbEspecialidad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEspecialidad;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblVacio;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
