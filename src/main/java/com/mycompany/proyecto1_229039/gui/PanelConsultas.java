package com.mycompany.proyecto1_229039.gui;

import com.mycompany.proyecto1_229039.entidades.Consulta;
import com.mycompany.proyecto1_229039.entidades.Medico;
import com.mycompany.proyecto1_229039.entidades.Paciente;
import com.mycompany.proyecto1_229039.persistencia.PersistenciaFachada;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.List;

public class PanelConsultas extends javax.swing.JPanel {

    private PersistenciaFachada fachada;
    private DefaultTableModel modeloTabla;

    public PanelConsultas(PersistenciaFachada fachada) {
        this.fachada = fachada;
        initComponents();
        modeloTabla = (DefaultTableModel) tabla.getModel();
        actualizarTabla(fachada.listarConsultas());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabsOperaciones = new javax.swing.JTabbedPane();
        panelBusqueda = new javax.swing.JPanel();
        lblBuscarPaciente = new javax.swing.JLabel();
        txtBuscarIdPaciente = new javax.swing.JTextField();
        btnBuscarPac = new javax.swing.JButton();
        lblBuscarMedico = new javax.swing.JLabel();
        txtBuscarIdMedico = new javax.swing.JTextField();
        btnBuscarMed = new javax.swing.JButton();
        lblFechaInicio = new javax.swing.JLabel();
        txtFechaInicio = new javax.swing.JTextField();
        lblFechaFin = new javax.swing.JLabel();
        lblFechaFinLabel = new javax.swing.JLabel();
        txtFechaFin = new javax.swing.JTextField();
        btnBuscarPeriodo = new javax.swing.JButton();
        panelAgendar = new javax.swing.JPanel();
        lblAgendarPaciente = new javax.swing.JLabel();
        txtAgendarIdPaciente = new javax.swing.JTextField();
        lblAgendarMedico = new javax.swing.JLabel();
        txtAgendarIdMedico = new javax.swing.JTextField();
        lblAgendarFecha = new javax.swing.JLabel();
        txtFechaConsulta = new javax.swing.JTextField();
        lblDiagnostico = new javax.swing.JLabel();
        txtDiagnostico = new javax.swing.JTextField();
        lblVacioAgendar = new javax.swing.JLabel();
        btnAgendar = new javax.swing.JButton();
        panelCancelar = new javax.swing.JPanel();
        lblCancelarId = new javax.swing.JLabel();
        txtCancelarId = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new java.awt.BorderLayout(10, 10));

        panelBusqueda.setLayout(new java.awt.GridLayout(4, 3, 5, 5));

        lblBuscarPaciente.setText("ID Paciente:");
        panelBusqueda.add(lblBuscarPaciente);

        txtBuscarIdPaciente.setColumns(8);
        panelBusqueda.add(txtBuscarIdPaciente);

        btnBuscarPac.setText("Buscar por Paciente");
        btnBuscarPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacActionPerformed(evt);
            }
        });
        panelBusqueda.add(btnBuscarPac);

        lblBuscarMedico.setText("ID Médico:");
        panelBusqueda.add(lblBuscarMedico);

        txtBuscarIdMedico.setColumns(8);
        panelBusqueda.add(txtBuscarIdMedico);

        btnBuscarMed.setText("Buscar por Médico");
        btnBuscarMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMedActionPerformed(evt);
            }
        });
        panelBusqueda.add(btnBuscarMed);

        lblFechaInicio.setText("Desde (dd/MM/yyyy):");
        panelBusqueda.add(lblFechaInicio);

        txtFechaInicio.setColumns(8);
        panelBusqueda.add(txtFechaInicio);

        lblFechaFin.setText("Hasta (dd/MM/yyyy):");
        panelBusqueda.add(lblFechaFin);

        panelBusqueda.add(lblFechaFinLabel);

        txtFechaFin.setColumns(8);
        panelBusqueda.add(txtFechaFin);

        btnBuscarPeriodo.setText("Buscar por Período");
        btnBuscarPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPeriodoActionPerformed(evt);
            }
        });
        panelBusqueda.add(btnBuscarPeriodo);

        tabsOperaciones.addTab("Buscar Consultas", panelBusqueda);

        panelAgendar.setLayout(new java.awt.GridLayout(5, 2, 5, 5));

        lblAgendarPaciente.setText("ID Paciente:");
        panelAgendar.add(lblAgendarPaciente);

        txtAgendarIdPaciente.setColumns(8);
        panelAgendar.add(txtAgendarIdPaciente);

        lblAgendarMedico.setText("ID Médico:");
        panelAgendar.add(lblAgendarMedico);

        txtAgendarIdMedico.setColumns(8);
        panelAgendar.add(txtAgendarIdMedico);

        lblAgendarFecha.setText("Fecha (dd/MM/yyyy):");
        panelAgendar.add(lblAgendarFecha);

        txtFechaConsulta.setColumns(8);
        panelAgendar.add(txtFechaConsulta);

        lblDiagnostico.setText("Diagnóstico:");
        panelAgendar.add(lblDiagnostico);

        txtDiagnostico.setColumns(20);
        panelAgendar.add(txtDiagnostico);

        panelAgendar.add(lblVacioAgendar);

        btnAgendar.setText("Agendar Consulta");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });
        panelAgendar.add(btnAgendar);

        tabsOperaciones.addTab("Agendar Consulta", panelAgendar);

        panelCancelar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 20));

        lblCancelarId.setText("ID de la Consulta:");
        panelCancelar.add(lblCancelarId);

        txtCancelarId.setColumns(8);
        panelCancelar.add(txtCancelarId);

        btnCancelar.setText("Cancelar Consulta");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelCancelar.add(btnCancelar);

        tabsOperaciones.addTab("Cancelar Consulta", panelCancelar);

        add(tabsOperaciones, java.awt.BorderLayout.NORTH);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] { "ID", "ID Paciente", "Paciente", "ID Médico", "Médico", "Fecha", "Diagnóstico",
                        "Estado" }) {
            boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabla);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarPacActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscarPacActionPerformed
        buscarPorPaciente();
    }// GEN-LAST:event_btnBuscarPacActionPerformed

    private void btnBuscarMedActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscarMedActionPerformed
        buscarPorMedico();
    }// GEN-LAST:event_btnBuscarMedActionPerformed

    private void btnBuscarPeriodoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscarPeriodoActionPerformed
        buscarPorPeriodo();
    }// GEN-LAST:event_btnBuscarPeriodoActionPerformed

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgendarActionPerformed
        agendarConsulta();
    }// GEN-LAST:event_btnAgendarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarActionPerformed
        cancelarConsulta();
    }// GEN-LAST:event_btnCancelarActionPerformed

    // logica de negocio

    private void buscarPorPaciente() {
        String idStr = txtBuscarIdPaciente.getText().trim();
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ID del paciente.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int id = Integer.parseInt(idStr);
            List<Consulta> resultado = fachada.consultasPorPaciente(id);
            actualizarTabla(resultado);
            if (resultado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron consultas para el paciente ID: " + id,
                        "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarPorMedico() {
        String idStr = txtBuscarIdMedico.getText().trim();
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ID del médico.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int id = Integer.parseInt(idStr);
            List<Consulta> resultado = fachada.consultasPorMedico(id);
            actualizarTabla(resultado);
            if (resultado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron consultas para el médico ID: " + id,
                        "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarPorPeriodo() {
        String inicio = txtFechaInicio.getText().trim();
        String fin = txtFechaFin.getText().trim();
        if (inicio.isEmpty() || fin.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese ambas fechas (dd/MM/yyyy).",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(inicio);
            sdf.parse(fin);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Use dd/MM/yyyy.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        List<Consulta> resultado = fachada.consultasPorPeriodo(inicio, fin);
        actualizarTabla(resultado);
        if (resultado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron consultas en ese período.",
                    "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void agendarConsulta() {
        String idPacStr = txtAgendarIdPaciente.getText().trim();
        String idMedStr = txtAgendarIdMedico.getText().trim();
        String fecha = txtFechaConsulta.getText().trim();
        String diagnostico = txtDiagnostico.getText().trim();

        if (idPacStr.isEmpty() || idMedStr.isEmpty() || fecha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID Paciente, ID Médico y Fecha son obligatorios.",
                    "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(fecha);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Use dd/MM/yyyy.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            int idPac = Integer.parseInt(idPacStr);
            int idMed = Integer.parseInt(idMedStr);

            Paciente pac = fachada.buscarPaciente(idPac);
            if (pac == null) {
                JOptionPane.showMessageDialog(this, "No existe un paciente con ID: " + idPac,
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Medico med = fachada.buscarMedico(idMed);
            if (med == null) {
                JOptionPane.showMessageDialog(this, "No existe un médico con ID: " + idMed,
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int resp = JOptionPane.showConfirmDialog(this,
                    "¿Agendar consulta?\n\nPaciente: " + pac.getNombre()
                            + "\nMédico: " + med.getNombre()
                            + "\nFecha: " + fecha
                            + "\nDiagnóstico: " + (diagnostico.isEmpty() ? "Pendiente" : diagnostico),
                    "Confirmar Cita", JOptionPane.YES_NO_OPTION);

            if (resp == JOptionPane.YES_OPTION) {
                String diag = diagnostico.isEmpty() ? "Pendiente" : diagnostico;
                Consulta c = fachada.agendarConsulta(idPac, idMed, fecha, diag);
                JOptionPane.showMessageDialog(this,
                        "Consulta agendada exitosamente.\n\n"
                                + "ID Consulta: " + c.getId()
                                + "\nPaciente: " + pac.getNombre()
                                + "\nMédico: " + med.getNombre()
                                + "\nFecha: " + fecha
                                + "\nEstado: " + c.getEstado(),
                        "Resumen de la Cita", JOptionPane.INFORMATION_MESSAGE);
                txtAgendarIdPaciente.setText("");
                txtAgendarIdMedico.setText("");
                txtFechaConsulta.setText("");
                txtDiagnostico.setText("");
                actualizarTabla(fachada.listarConsultas());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Los IDs deben ser números válidos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelarConsulta() {
        String idStr = txtCancelarId.getText().trim();
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el ID de la consulta a cancelar.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int id = Integer.parseInt(idStr);
            Consulta c = fachada.buscarConsulta(id);
            if (c == null) {
                JOptionPane.showMessageDialog(this, "No existe una consulta con ID: " + id,
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (c.getEstado().equals("Cancelada")) {
                JOptionPane.showMessageDialog(this, "Esta consulta ya está cancelada.",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Paciente pac = fachada.buscarPaciente(c.getIdPaciente());
            Medico med = fachada.buscarMedico(c.getIdMedico());
            String nomPac = pac != null ? pac.getNombre() : "ID " + c.getIdPaciente();
            String nomMed = med != null ? med.getNombre() : "ID " + c.getIdMedico();

            int resp = JOptionPane.showConfirmDialog(this,
                    "¿Cancelar la siguiente consulta?\n\n"
                            + "ID: " + c.getId()
                            + "\nPaciente: " + nomPac
                            + "\nMédico: " + nomMed
                            + "\nFecha: " + c.getFecha(),
                    "Confirmar Cancelación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (resp == JOptionPane.YES_OPTION) {
                fachada.cancelarConsulta(id);
                JOptionPane.showMessageDialog(this,
                        "Consulta cancelada exitosamente.\nEstado: Cancelada",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                txtCancelarId.setText("");
                actualizarTabla(fachada.listarConsultas());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTabla(List<Consulta> lista) {
        modeloTabla.setRowCount(0);
        for (Consulta c : lista) {
            Paciente pac = fachada.buscarPaciente(c.getIdPaciente());
            Medico med = fachada.buscarMedico(c.getIdMedico());
            String nomPac = pac != null ? pac.getNombre() : "Desconocido";
            String nomMed = med != null ? med.getNombre() : "Desconocido";
            modeloTabla.addRow(new Object[] {
                    c.getId(), c.getIdPaciente(), nomPac,
                    c.getIdMedico(), nomMed,
                    c.getFecha(), c.getDiagnostico(), c.getEstado()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnBuscarMed;
    private javax.swing.JButton btnBuscarPac;
    private javax.swing.JButton btnBuscarPeriodo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAgendarFecha;
    private javax.swing.JLabel lblAgendarMedico;
    private javax.swing.JLabel lblAgendarPaciente;
    private javax.swing.JLabel lblBuscarMedico;
    private javax.swing.JLabel lblBuscarPaciente;
    private javax.swing.JLabel lblCancelarId;
    private javax.swing.JLabel lblDiagnostico;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaFinLabel;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblVacioAgendar;
    private javax.swing.JPanel panelAgendar;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel panelCancelar;
    private javax.swing.JTable tabla;
    private javax.swing.JTabbedPane tabsOperaciones;
    private javax.swing.JTextField txtAgendarIdMedico;
    private javax.swing.JTextField txtAgendarIdPaciente;
    private javax.swing.JTextField txtBuscarIdMedico;
    private javax.swing.JTextField txtBuscarIdPaciente;
    private javax.swing.JTextField txtCancelarId;
    private javax.swing.JTextField txtDiagnostico;
    private javax.swing.JTextField txtFechaConsulta;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    // End of variables declaration//GEN-END:variables
}
