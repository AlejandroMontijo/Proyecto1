package com.mycompany.proyecto1_229039.gui;

import com.mycompany.proyecto1_229039.entidades.Medico;
import com.mycompany.proyecto1_229039.persistencia.PersistenciaFachada;
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

        tabla.getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting() == false) {
                int fila = tabla.getSelectedRow();
                if (fila >= 0) {
                    txtId.setText(modeloTabla.getValueAt(fila, 0).toString());
                    txtNombre.setText(modeloTabla.getValueAt(fila, 1).toString());
                    txtEspecialidad.setText(modeloTabla.getValueAt(fila, 2).toString());
                    txtTelefono.setText(modeloTabla.getValueAt(fila, 3).toString());
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
        lblEspecialidad = new javax.swing.JLabel();
        txtEspecialidad = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
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

        txtEspecialidad.setColumns(10);
        panelCampos.add(txtEspecialidad);

        lblTelefono.setText("Teléfono:");
        panelCampos.add(lblTelefono);

        txtTelefono.setColumns(15);
        panelCampos.add(txtTelefono);

        panelSuperior.add(panelCampos, java.awt.BorderLayout.CENTER);

        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 8, 5));

        btnAgregar.setText("Agregar");
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

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        panelBotones.add(btnLimpiar);

        btnVerTodos.setText("Ver Todos");
        btnVerTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodosActionPerformed(evt);
            }
        });
        panelBotones.add(btnVerTodos);

        panelSuperior.add(panelBotones, java.awt.BorderLayout.PAGE_END);

        add(panelSuperior, java.awt.BorderLayout.NORTH);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] { "ID", "Nombre", "Especialidad", "Teléfono" }) {
            boolean[] canEdit = new boolean[] { false, false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabla);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarActionPerformed
        agregarMedico();
    }// GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscarActionPerformed
        buscarMedico();
    }// GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }// GEN-LAST:event_btnLimpiarActionPerformed

    private void btnVerTodosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVerTodosActionPerformed
        actualizarTabla();
    }// GEN-LAST:event_btnVerTodosActionPerformed

    private void agregarMedico() {
        String nombre = txtNombre.getText().trim();
        String especialidad = txtEspecialidad.getText().trim();
        String telefono = txtTelefono.getText().trim();

        if (nombre.isEmpty() || especialidad.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.",
                    "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") == false) {
            JOptionPane.showMessageDialog(this, "El nombre solo debe contener letras.",
                    "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (especialidad.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") == false) {
            JOptionPane.showMessageDialog(this, "La especialidad solo debe contener letras.",
                    "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (telefono.matches("[0-9]{7,15}") == false) {
            JOptionPane.showMessageDialog(this, "El teléfono debe contener entre 7 y 15 dígitos.",
                    "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Medico m = new Medico(0, nombre, especialidad, telefono);
        fachada.agregarMedico(m);
        JOptionPane.showMessageDialog(this, "Médico agregado exitosamente.\nID asignado: " + m.getId(),
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
        limpiarCampos();
        actualizarTabla();
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
            Medico m = fachada.buscarMedico(id);
            if (m != null) {
                txtNombre.setText(m.getNombre());
                txtEspecialidad.setText(m.getEspecialidad());
                txtTelefono.setText(m.getTelefono());
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
            modeloTabla.addRow(new Object[] {
                    m.getId(), m.getNombre(), m.getEspecialidad(), m.getTelefono()
            });
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtEspecialidad.setText("");
        txtTelefono.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnVerTodos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEspecialidad;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtEspecialidad;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
