package proyecto_1.gui;

import proyecto_1.entidades.EquipoMedico;
import proyecto_1.persistencia.PersistenciaFachada;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PanelInventario extends javax.swing.JPanel {

    private PersistenciaFachada fachada;
    private DefaultTableModel modeloTabla;
    private int idSeleccionado = -1;

    public PanelInventario(PersistenciaFachada fachada) {
        this.fachada = fachada;
        initComponents();
        modeloTabla = (DefaultTableModel) tabla.getModel();

        tabla.getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting() == false) {
                int fila = tabla.getSelectedRow();
                if (fila >= 0) {
                    txtId.setText(modeloTabla.getValueAt(fila, 0).toString());
                    txtNombre.setText(modeloTabla.getValueAt(fila, 1).toString());
                    txtCantidad.setText(modeloTabla.getValueAt(fila, 2).toString());
                }
            }
        });

        actualizarTabla();
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
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        panelBotones = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnVerTodos = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        panelOperaciones = new javax.swing.JPanel();
        lblCantidadOp = new javax.swing.JLabel();
        txtCantidadOperacion = new javax.swing.JTextField();
        btnInventariar = new javax.swing.JButton();
        btnDesinventariar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new java.awt.BorderLayout(10, 10));

        panelSuperior.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Equipo Médico"));
        panelSuperior.setLayout(new java.awt.BorderLayout(5, 5));

        panelCampos.setLayout(new java.awt.GridLayout(0, 2, 5, 5));

        lblId.setText("ID:");
        panelCampos.add(lblId);
        txtId.setColumns(10);
        panelCampos.add(txtId);
        lblNombre.setText("Nombre:");
        panelCampos.add(lblNombre);
        txtNombre.setColumns(15);
        panelCampos.add(txtNombre);
        lblCantidad.setText("Cantidad:");
        panelCampos.add(lblCantidad);
        txtCantidad.setColumns(10);
        panelCampos.add(txtCantidad);

        panelSuperior.add(panelCampos, java.awt.BorderLayout.CENTER);

        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 8, 5));

        btnAgregar.setText("Agregar Equipo");
        btnAgregar.addActionListener(e -> agregarEquipo());
        panelBotones.add(btnAgregar);

        btnBuscar.setText("Buscar por ID");
        btnBuscar.addActionListener(e -> buscarEquipo());
        panelBotones.add(btnBuscar);

        btnVerTodos.setText("Ver Todos");
        btnVerTodos.addActionListener(e -> actualizarTabla());
        panelBotones.add(btnVerTodos);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(e -> limpiarCampos());
        panelBotones.add(btnLimpiar);

        panelSuperior.add(panelBotones, java.awt.BorderLayout.PAGE_END);
        add(panelSuperior, java.awt.BorderLayout.NORTH);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] { "ID", "Nombre", "Cantidad" }) {
            boolean[] canEdit = new boolean[] { false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabla);
        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelOperaciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones de Stock"));
        panelOperaciones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        lblCantidadOp.setText("Cantidad a operar:");
        panelOperaciones.add(lblCantidadOp);
        txtCantidadOperacion.setColumns(6);
        panelOperaciones.add(txtCantidadOperacion);

        btnInventariar.setText("Inventariar (+)");
        btnInventariar.addActionListener(e -> inventariar());
        panelOperaciones.add(btnInventariar);

        btnDesinventariar.setText("Desinventariar (-)");
        btnDesinventariar.addActionListener(e -> desinventariar());
        panelOperaciones.add(btnDesinventariar);

        add(panelOperaciones, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void agregarEquipo() {
        String nombre = txtNombre.getText().trim();
        String cantStr = txtCantidad.getText().trim();
        if (nombre.isEmpty() || cantStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre y cantidad son obligatorios.",
                    "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int cantidad = Integer.parseInt(cantStr);
            if (cantidad < 0) {
                JOptionPane.showMessageDialog(this, "La cantidad no puede ser negativa.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            EquipoMedico eq = new EquipoMedico(1, nombre, cantidad);
            fachada.agregarEquipoMedico(eq);
            JOptionPane.showMessageDialog(this, "Equipo agregado exitosamente.\nID asignado: " + eq.getId(),
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
            actualizarTabla();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número válido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarEquipo() {
        String idStr = txtId.getText().trim();
        if (idStr.isEmpty()) {
            idStr = JOptionPane.showInputDialog(this, "Ingrese el ID del equipo a buscar:", "Buscar Equipo",
                    JOptionPane.QUESTION_MESSAGE);
        }
        if (idStr == null || idStr.trim().isEmpty()) {
            return;
        }
        try {
            int id = Integer.parseInt(idStr);
            EquipoMedico eq = fachada.obtenerEquipoPorId(id);
            if (eq != null) {
                idSeleccionado = id;
                txtId.setText(String.valueOf(eq.getId()));
                txtNombre.setText(eq.getNombre());
                txtCantidad.setText(String.valueOf(eq.getCantidad()));
                JOptionPane.showMessageDialog(this, "Equipo encontrado:\n" + eq.toString(),
                        "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró equipo con ID: " + id,
                        "No encontrado", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void inventariar() {
        if (idSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un equipo de la tabla.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String cantStr = txtCantidadOperacion.getText().trim();
        if (cantStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escriba la cantidad a sumar.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int cantidad = Integer.parseInt(cantStr);
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad a operar debe ser positiva.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            EquipoMedico eq = fachada.obtenerEquipoPorId(idSeleccionado);
            if (eq == null) {
                JOptionPane.showMessageDialog(this, "No existe equipo con ID: " + idSeleccionado,
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int resp = JOptionPane.showConfirmDialog(this,
                    "Equipo: " + eq.getNombre() + "\nStock actual: " + eq.getCantidad()
                            + "\n\n¿Sumar " + cantidad + " unidades?",
                    "Confirmar Inventariar", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                fachada.actualizarCantidadEquipo(idSeleccionado, cantidad);
                EquipoMedico act = fachada.obtenerEquipoPorId(idSeleccionado);
                JOptionPane.showMessageDialog(this, "Stock actualizado.\nNuevo stock: " + act.getCantidad(),
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                txtCantidad.setText(String.valueOf(act.getCantidad()));
                actualizarTabla();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void desinventariar() {
        if (idSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un equipo de la tabla.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String cantStr = txtCantidadOperacion.getText().trim();
        if (cantStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escriba la cantidad a restar.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int cantidad = Integer.parseInt(cantStr);
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad a operar debe ser positiva.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            EquipoMedico eq = fachada.obtenerEquipoPorId(idSeleccionado);
            if (eq == null) {
                JOptionPane.showMessageDialog(this, "No existe equipo con ID: " + idSeleccionado,
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (eq.getCantidad() < cantidad) {
                JOptionPane.showMessageDialog(this,
                        "Stock insuficiente.\nStock actual: " + eq.getCantidad() + "\nSolicitado: " + cantidad,
                        "Stock insuficiente", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int resp = JOptionPane.showConfirmDialog(this,
                    "Equipo: " + eq.getNombre() + "\nStock actual: " + eq.getCantidad()
                            + "\n\n¿Restar " + cantidad + " unidades?",
                    "Confirmar Desinventariar", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                fachada.actualizarCantidadEquipo(idSeleccionado, -cantidad);
                EquipoMedico act = fachada.obtenerEquipoPorId(idSeleccionado);
                JOptionPane.showMessageDialog(this, "Stock actualizado.\nNuevo stock: " + act.getCantidad(),
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                txtCantidad.setText(String.valueOf(act.getCantidad()));
                actualizarTabla();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        List<EquipoMedico> lista = fachada.listarEquiposMedicos();
        for (EquipoMedico eq : lista) {
            modeloTabla.addRow(new Object[] { eq.getId(), eq.getNombre(), eq.getCantidad() });
        }
    }

    private void limpiarCampos() {
        idSeleccionado = -1;
        tabla.clearSelection();
        txtId.setText("");
        txtNombre.setText("");
        txtCantidad.setText("");
        txtCantidadOperacion.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDesinventariar;
    private javax.swing.JButton btnInventariar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnVerTodos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCantidadOp;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JPanel panelOperaciones;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCantidadOperacion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
