package com.mycompany.proyecto1_229039.gui;

import com.mycompany.proyecto1_229039.entidades.EquipoMedico;
import com.mycompany.proyecto1_229039.persistencia.PersistenciaFachada;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PanelInventario extends javax.swing.JPanel {

    private PersistenciaFachada fachada;
    private DefaultTableModel modeloTabla;

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
                    txtUbicacion.setText(modeloTabla.getValueAt(fila, 3).toString());
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
        lblUbicacion = new javax.swing.JLabel();
        txtUbicacion = new javax.swing.JTextField();
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

        panelCampos.setLayout(new java.awt.GridLayout(2, 4, 5, 5));

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

        lblUbicacion.setText("Ubicación:");
        panelCampos.add(lblUbicacion);

        txtUbicacion.setColumns(15);
        panelCampos.add(txtUbicacion);

        panelSuperior.add(panelCampos, java.awt.BorderLayout.CENTER);

        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 8, 5));

        btnAgregar.setText("Agregar Equipo");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        panelBotones.add(btnAgregar);

        btnBuscar.setText("Buscar por ID");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        panelBotones.add(btnBuscar);

        btnVerTodos.setText("Ver Todos");
        btnVerTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodosActionPerformed(evt);
            }
        });
        panelBotones.add(btnVerTodos);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        panelBotones.add(btnLimpiar);

        panelSuperior.add(panelBotones, java.awt.BorderLayout.PAGE_END);

        add(panelSuperior, java.awt.BorderLayout.NORTH);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] { "ID", "Nombre", "Cantidad", "Ubicación" }) {
            boolean[] canEdit = new boolean[] { false, false, false, false };

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
        btnInventariar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventariarActionPerformed(evt);
            }
        });
        panelOperaciones.add(btnInventariar);

        btnDesinventariar.setText("Desinventariar (-)");
        btnDesinventariar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesinventariarActionPerformed(evt);
            }
        });
        panelOperaciones.add(btnDesinventariar);

        add(panelOperaciones, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarActionPerformed
        agregarEquipo();
    }// GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscarActionPerformed
        buscarEquipo();
    }// GEN-LAST:event_btnBuscarActionPerformed

    private void btnVerTodosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVerTodosActionPerformed
        actualizarTabla();
    }// GEN-LAST:event_btnVerTodosActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }// GEN-LAST:event_btnLimpiarActionPerformed

    private void btnInventariarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnInventariarActionPerformed
        inventariar();
    }// GEN-LAST:event_btnInventariarActionPerformed

    private void btnDesinventariarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDesinventariarActionPerformed
        desinventariar();
    }// GEN-LAST:event_btnDesinventariarActionPerformed

    private void agregarEquipo() {
        String nombre = txtNombre.getText().trim();
        String cantStr = txtCantidad.getText().trim();
        String ubicacion = txtUbicacion.getText().trim();

        if (nombre.isEmpty() || cantStr.isEmpty() || ubicacion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.",
                    "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int cantidad;
        try {
            cantidad = Integer.parseInt(cantStr);
            if (cantidad < 0) {
                JOptionPane.showMessageDialog(this, "La cantidad no puede ser negativa.",
                        "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número válido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        EquipoMedico eq = new EquipoMedico(0, nombre, cantidad, ubicacion);
        fachada.agregarEquipo(eq);
        JOptionPane.showMessageDialog(this, "Equipo agregado exitosamente.\nID asignado: " + eq.getId(),
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
        limpiarCampos();
        actualizarTabla();
    }

    private void buscarEquipo() {
        String idStr = txtId.getText().trim();
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID para buscar.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int id = Integer.parseInt(idStr);
            EquipoMedico eq = fachada.buscarEquipo(id);
            if (eq != null) {
                txtNombre.setText(eq.getNombre());
                txtCantidad.setText(String.valueOf(eq.getCantidad()));
                txtUbicacion.setText(eq.getUbicacion());
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
        String idStr = txtId.getText().trim();
        String cantStr = txtCantidadOperacion.getText().trim();
        if (idStr.isEmpty() || cantStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un equipo y escriba la cantidad a sumar.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int id = Integer.parseInt(idStr);
            int cantidad = Integer.parseInt(cantStr);
            EquipoMedico eq = fachada.buscarEquipo(id);
            if (eq == null) {
                JOptionPane.showMessageDialog(this, "No existe equipo con ID: " + id,
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int resp = JOptionPane.showConfirmDialog(this,
                    "¿Sumar " + cantidad + " unidades al equipo '" + eq.getNombre()
                            + "'?\nStock actual: " + eq.getCantidad(),
                    "Confirmar Inventariar", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                if (fachada.inventariar(id, cantidad)) {
                    EquipoMedico actualizado = fachada.buscarEquipo(id);
                    JOptionPane.showMessageDialog(this,
                            "Stock actualizado.\nNuevo stock: " + actualizado.getCantidad(),
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    txtCantidad.setText(String.valueOf(actualizado.getCantidad()));
                    actualizarTabla();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo actualizar el stock.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void desinventariar() {
        String idStr = txtId.getText().trim();
        String cantStr = txtCantidadOperacion.getText().trim();
        if (idStr.isEmpty() || cantStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un equipo y escriba la cantidad a restar.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int id = Integer.parseInt(idStr);
            int cantidad = Integer.parseInt(cantStr);
            EquipoMedico eq = fachada.buscarEquipo(id);
            if (eq == null) {
                JOptionPane.showMessageDialog(this, "No existe equipo con ID: " + id,
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (eq.getCantidad() < cantidad) {
                JOptionPane.showMessageDialog(this,
                        "No hay suficiente stock.\nStock actual: " + eq.getCantidad()
                                + "\nSolicitado: " + cantidad,
                        "Stock insuficiente", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int resp = JOptionPane.showConfirmDialog(this,
                    "¿Restar " + cantidad + " unidades del equipo '" + eq.getNombre()
                            + "'?\nStock actual: " + eq.getCantidad(),
                    "Confirmar Desinventariar", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                if (fachada.desinventariar(id, cantidad)) {
                    EquipoMedico actualizado = fachada.buscarEquipo(id);
                    JOptionPane.showMessageDialog(this,
                            "Stock actualizado.\nNuevo stock: " + actualizado.getCantidad(),
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    txtCantidad.setText(String.valueOf(actualizado.getCantidad()));
                    actualizarTabla();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        List<EquipoMedico> lista = fachada.listarEquipos();
        for (EquipoMedico eq : lista) {
            modeloTabla.addRow(new Object[] {
                    eq.getId(), eq.getNombre(), eq.getCantidad(), eq.getUbicacion()
            });
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtCantidad.setText("");
        txtUbicacion.setText("");
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
    private javax.swing.JLabel lblUbicacion;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JPanel panelOperaciones;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCantidadOperacion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUbicacion;
    // End of variables declaration//GEN-END:variables
}
