package proyecto_1.gui;

import proyecto_1.entidades.Paciente;
import proyecto_1.entidades.Consulta;
import proyecto_1.entidades.Medico;
import proyecto_1.persistencia.PersistenciaFachada;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
        lblBuscIdPac = new javax.swing.JLabel();
        txtBuscIdPac = new javax.swing.JTextField();
        btnBuscarPac = new javax.swing.JButton();
        lblBuscIdMed = new javax.swing.JLabel();
        txtBuscIdMed = new javax.swing.JTextField();
        btnBuscarMed = new javax.swing.JButton();
        lblFechaDesde = new javax.swing.JLabel();
        txtFechaDesde = new javax.swing.JTextField();
        lblFechaHasta = new javax.swing.JLabel();
        txtFechaHasta = new javax.swing.JTextField();
        btnBuscarPeriodo = new javax.swing.JButton();
        btnVerTodos = new javax.swing.JButton();
        panelAgendar = new javax.swing.JPanel();
        lblAgIdPac = new javax.swing.JLabel();
        txtAgIdPac = new javax.swing.JTextField();
        lblAgIdMed = new javax.swing.JLabel();
        txtAgIdMed = new javax.swing.JTextField();
        lblAgFecha = new javax.swing.JLabel();
        txtAgFecha = new javax.swing.JTextField();
        lblVacio = new javax.swing.JLabel();
        btnAgendar = new javax.swing.JButton();
        panelCancelar = new javax.swing.JPanel();
        lblCancelId = new javax.swing.JLabel();
        txtCancelId = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new java.awt.BorderLayout(10, 10));

        // panel busqueda
        panelBusqueda.setLayout(new java.awt.GridLayout(4, 3, 5, 5));

        lblBuscIdPac.setText("ID Paciente:");
        panelBusqueda.add(lblBuscIdPac);
        txtBuscIdPac.setColumns(8);
        panelBusqueda.add(txtBuscIdPac);
        btnBuscarPac.setText("Buscar por Paciente");
        btnBuscarPac.addActionListener(e -> buscarPorPaciente());
        panelBusqueda.add(btnBuscarPac);

        lblBuscIdMed.setText("ID Médico:");
        panelBusqueda.add(lblBuscIdMed);
        txtBuscIdMed.setColumns(8);
        panelBusqueda.add(txtBuscIdMed);
        btnBuscarMed.setText("Buscar por Médico");
        btnBuscarMed.addActionListener(e -> buscarPorMedico());
        panelBusqueda.add(btnBuscarMed);

        lblFechaDesde.setText("Desde (dd/MM/yyyy):");
        panelBusqueda.add(lblFechaDesde);
        txtFechaDesde.setColumns(8);
        panelBusqueda.add(txtFechaDesde);
        lblFechaHasta.setText("Hasta (dd/MM/yyyy):");
        panelBusqueda.add(lblFechaHasta);

        txtFechaHasta.setColumns(8);
        panelBusqueda.add(txtFechaHasta);
        btnBuscarPeriodo.setText("Buscar por Período");
        btnBuscarPeriodo.addActionListener(e -> buscarPorPeriodo());
        panelBusqueda.add(btnBuscarPeriodo);

        btnVerTodos.setText("Ver Todas");
        btnVerTodos.addActionListener(e -> actualizarTabla(fachada.listarConsultas()));
        panelBusqueda.add(btnVerTodos);

        tabsOperaciones.addTab("Búsqueda", panelBusqueda);

        // panel agendar
        panelAgendar.setLayout(new java.awt.GridLayout(4, 2, 5, 5));

        lblAgIdPac.setText("ID Paciente:");
        panelAgendar.add(lblAgIdPac);
        txtAgIdPac.setColumns(8);
        panelAgendar.add(txtAgIdPac);
        lblAgIdMed.setText("ID Médico:");
        panelAgendar.add(lblAgIdMed);
        txtAgIdMed.setColumns(8);
        panelAgendar.add(txtAgIdMed);
        lblAgFecha.setText("Fecha (dd/MM/yyyy):");
        panelAgendar.add(lblAgFecha);
        txtAgFecha.setColumns(8);
        panelAgendar.add(txtAgFecha);
        panelAgendar.add(lblVacio);
        btnAgendar.setText("Agendar Consulta");
        btnAgendar.addActionListener(e -> agendarConsulta());
        panelAgendar.add(btnAgendar);

        tabsOperaciones.addTab("Agendar", panelAgendar);

        // panel cancelar
        panelCancelar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 20));

        lblCancelId.setText("ID de la Consulta:");
        panelCancelar.add(lblCancelId);
        txtCancelId.setColumns(8);
        panelCancelar.add(txtCancelId);
        btnCancelar.setText("Cancelar Consulta");
        btnCancelar.addActionListener(e -> cancelarConsulta());
        panelCancelar.add(btnCancelar);

        tabsOperaciones.addTab("Cancelar", panelCancelar);

        add(tabsOperaciones, java.awt.BorderLayout.NORTH);

        // tabla
        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] { "ID", "Paciente", "Médico", "Fecha" }) {
            boolean[] canEdit = new boolean[] { false, false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabla);
        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void buscarPorPaciente() {
        try {
            int id = Integer.parseInt(txtBuscIdPac.getText().trim());
            Paciente p = fachada.obtenerPacientePorId(id);
            if (p == null) {
                JOptionPane.showMessageDialog(this, "No existe paciente con ID: " + id, "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            List<Consulta> resultado = fachada.consultasPorPaciente(id);
            actualizarTabla(resultado);
            if (resultado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay consultas para el paciente: " + p.getNombre(),
                        "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarPorMedico() {
        try {
            int id = Integer.parseInt(txtBuscIdMed.getText().trim());
            Medico m = fachada.obtenerMedicoPorId(id);
            if (m == null) {
                JOptionPane.showMessageDialog(this, "No existe médico con ID: " + id, "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            List<Consulta> resultado = fachada.consultasPorMedico(id);
            actualizarTabla(resultado);
            if (resultado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay consultas para el médico: " + m.getNombre(),
                        "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarPorPeriodo() {
        String desde = txtFechaDesde.getText().trim();
        String hasta = txtFechaHasta.getText().trim();
        if (desde.isEmpty() || hasta.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese ambas fechas del periodo.", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        List<Consulta> resultado = fachada.consultasPorPeriodo(desde, hasta);
        actualizarTabla(resultado);
        if (resultado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron consultas en ese periodo.", "Sin resultados",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void agendarConsulta() {
        try {
            int idPac = Integer.parseInt(txtAgIdPac.getText().trim());
            int idMed = Integer.parseInt(txtAgIdMed.getText().trim());
            String fecha = txtAgFecha.getText().trim();

            try {
                java.time.LocalDate fechaCons = java.time.LocalDate.parse(fecha,
                        java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                if (fechaCons.isBefore(java.time.LocalDate.now())) {
                    JOptionPane.showMessageDialog(this, "La fecha no puede ser anterior a hoy.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Use dd/MM/yyyy", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Paciente pac = fachada.obtenerPacientePorId(idPac);
            Medico med = fachada.obtenerMedicoPorId(idMed);

            if (pac == null) {
                JOptionPane.showMessageDialog(this, "No existe paciente con ID: " + idPac, "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (med == null) {
                JOptionPane.showMessageDialog(this, "No existe médico con ID: " + idMed, "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            int resp = JOptionPane.showConfirmDialog(this,
                    "Paciente: " + pac.getNombre() + "\nMédico: " + med.getNombre() + "\nFecha: " + fecha
                            + "\n\n¿Confirma agendar la consulta?",
                    "Confirmar", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                Consulta c = new Consulta(1, pac, med, fecha);
                fachada.programarConsulta(c);
                JOptionPane.showMessageDialog(this, "Consulta agendada exitosamente.\nID: " + c.getId(), "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                txtAgIdPac.setText("");
                txtAgIdMed.setText("");
                txtAgFecha.setText("");
                actualizarTabla(fachada.listarConsultas());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores válidos para ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelarConsulta() {
        try {
            int id = Integer.parseInt(txtCancelId.getText().trim());
            Consulta c = fachada.obtenerConsultaPorId(id);
            if (c == null) {
                JOptionPane.showMessageDialog(this, "No existe consulta con ID: " + id, "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            int resp = JOptionPane.showConfirmDialog(this, "¿Cancelar la siguiente consulta?\n\n" + c.toString(),
                    "Confirmar Cancelación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                fachada.cancelarConsulta(id);
                JOptionPane.showMessageDialog(this, "Consulta cancelada exitosamente.", "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                txtCancelId.setText("");
                actualizarTabla(fachada.listarConsultas());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTabla(List<Consulta> lista) {
        modeloTabla.setRowCount(0);
        for (Consulta c : lista) {
            String nomPac = c.getPaciente() != null ? c.getPaciente().getNombre() : "Desconocido";
            String nomMed = c.getMedico() != null ? c.getMedico().getNombre() : "Desconocido";
            modeloTabla.addRow(new Object[] { c.getId(), nomPac, nomMed, c.getFecha() });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnBuscarMed;
    private javax.swing.JButton btnBuscarPac;
    private javax.swing.JButton btnBuscarPeriodo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnVerTodos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAgFecha;
    private javax.swing.JLabel lblAgIdMed;
    private javax.swing.JLabel lblAgIdPac;
    private javax.swing.JLabel lblBuscIdMed;
    private javax.swing.JLabel lblBuscIdPac;
    private javax.swing.JLabel lblCancelId;
    private javax.swing.JLabel lblFechaDesde;
    private javax.swing.JLabel lblFechaHasta;
    private javax.swing.JLabel lblVacio;
    private javax.swing.JPanel panelAgendar;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel panelCancelar;
    private javax.swing.JTable tabla;
    private javax.swing.JTabbedPane tabsOperaciones;
    private javax.swing.JTextField txtAgFecha;
    private javax.swing.JTextField txtAgIdMed;
    private javax.swing.JTextField txtAgIdPac;
    private javax.swing.JTextField txtBuscIdMed;
    private javax.swing.JTextField txtBuscIdPac;
    private javax.swing.JTextField txtCancelId;
    private javax.swing.JTextField txtFechaDesde;
    private javax.swing.JTextField txtFechaHasta;
    // End of variables declaration//GEN-END:variables
}
