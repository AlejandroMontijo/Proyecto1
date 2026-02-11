package proyecto_1.gui;

import proyecto_1.entidades.Paciente;
import proyecto_1.persistencia.PersistenciaFachada;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PanelPacientes extends javax.swing.JPanel {

    private PersistenciaFachada fachada;
    private DefaultTableModel modeloTabla;

    public PanelPacientes(PersistenciaFachada fachada) {
        this.fachada = fachada;
        initComponents();
        modeloTabla = (DefaultTableModel) tabla.getModel();

        tabla.getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting() == false) {
                int fila = tabla.getSelectedRow();
                if (fila >= 0) {
                    txtId.setText(modeloTabla.getValueAt(fila, 0).toString());
                    txtNombre.setText(modeloTabla.getValueAt(fila, 1).toString());
                    txtEdad.setText(modeloTabla.getValueAt(fila, 2).toString());
                    txtDireccion.setText(modeloTabla.getValueAt(fila, 3).toString());
                }
            }
        });

        actualizarTabla(fachada.listarPacientes());
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
        lblEdad = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        panelBotones = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        panelFiltros = new javax.swing.JPanel();
        lblFiltroDireccion = new javax.swing.JLabel();
        txtFiltroDireccion = new javax.swing.JTextField();
        lblFiltroEdadMin = new javax.swing.JLabel();
        txtFiltroEdadMin = new javax.swing.JTextField();
        lblFiltroEdadMax = new javax.swing.JLabel();
        txtFiltroEdadMax = new javax.swing.JTextField();
        btnFiltrarDir = new javax.swing.JButton();
        btnFiltrarEdad = new javax.swing.JButton();
        btnFiltrarAmbos = new javax.swing.JButton();
        btnVerTodos = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new java.awt.BorderLayout(10, 10));

        panelSuperior.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Paciente"));
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
        lblEdad.setText("Edad:");
        panelCampos.add(lblEdad);
        txtEdad.setColumns(10);
        panelCampos.add(txtEdad);
        lblDireccion.setText("Dirección:");
        panelCampos.add(lblDireccion);
        txtDireccion.setColumns(15);
        panelCampos.add(txtDireccion);

        panelSuperior.add(panelCampos, java.awt.BorderLayout.CENTER);

        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 8, 5));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(e -> agregarPaciente());
        panelBotones.add(btnAgregar);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(e -> buscarPaciente());
        panelBotones.add(btnBuscar);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(e -> actualizarPaciente());
        panelBotones.add(btnActualizar);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(e -> eliminarPaciente());
        panelBotones.add(btnEliminar);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(e -> limpiarCampos());
        panelBotones.add(btnLimpiar);

        panelSuperior.add(panelBotones, java.awt.BorderLayout.PAGE_END);
        add(panelSuperior, java.awt.BorderLayout.NORTH);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] { "ID", "Nombre", "Edad", "Dirección" }) {
            boolean[] canEdit = new boolean[] { false, false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabla);
        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelFiltros.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));
        panelFiltros.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 4));

        lblFiltroDireccion.setText("Dirección:");
        panelFiltros.add(lblFiltroDireccion);
        txtFiltroDireccion.setColumns(10);
        panelFiltros.add(txtFiltroDireccion);
        lblFiltroEdadMin.setText("Edad mín:");
        panelFiltros.add(lblFiltroEdadMin);
        txtFiltroEdadMin.setColumns(4);
        panelFiltros.add(txtFiltroEdadMin);
        lblFiltroEdadMax.setText("Edad máx:");
        panelFiltros.add(lblFiltroEdadMax);
        txtFiltroEdadMax.setColumns(4);
        panelFiltros.add(txtFiltroEdadMax);

        btnFiltrarDir.setText("Por Dirección");
        btnFiltrarDir.addActionListener(e -> filtrarPorDireccion());
        panelFiltros.add(btnFiltrarDir);

        btnFiltrarEdad.setText("Por Edad");
        btnFiltrarEdad.addActionListener(e -> filtrarPorEdad());
        panelFiltros.add(btnFiltrarEdad);

        btnFiltrarAmbos.setText("Ambos");
        btnFiltrarAmbos.addActionListener(e -> filtrarCombinado());
        panelFiltros.add(btnFiltrarAmbos);

        btnVerTodos.setText("Ver Todos");
        btnVerTodos.addActionListener(e -> actualizarTabla(fachada.listarPacientes()));
        panelFiltros.add(btnVerTodos);

        add(panelFiltros, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void agregarPaciente() {
        String nombre = txtNombre.getText().trim();
        String edadStr = txtEdad.getText().trim();
        String direccion = txtDireccion.getText().trim();

        if (nombre.isEmpty() || edadStr.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.",
                    "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") == false) {
            JOptionPane.showMessageDialog(this, "El nombre solo debe contener letras.",
                    "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int edad;
        try {
            edad = Integer.parseInt(edadStr);
            if (edad < 0 || edad > 120) {
                JOptionPane.showMessageDialog(this, "La edad debe estar entre 0 y 120.",
                        "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un número válido.",
                    "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Paciente p = new Paciente(1, nombre, edad, direccion);
            fachada.agregarPaciente(p);
            JOptionPane.showMessageDialog(this, "Paciente agregado exitosamente.\nID asignado: " + p.getId(),
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
            actualizarTabla(fachada.listarPacientes());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarPaciente() {
        String idStr = txtId.getText().trim();
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID para buscar.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int id = Integer.parseInt(idStr);
            Paciente p = fachada.obtenerPacientePorId(id);
            if (p != null) {
                txtNombre.setText(p.getNombre());
                txtEdad.setText(String.valueOf(p.getEdad()));
                txtDireccion.setText(p.getDireccion());
                JOptionPane.showMessageDialog(this, "Paciente encontrado:\n" + p.toString(),
                        "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró un paciente con ID: " + id,
                        "No encontrado", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarPaciente() {
        String idStr = txtId.getText().trim();
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Primero busque un paciente por ID.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int id = Integer.parseInt(idStr);
            Paciente existente = fachada.obtenerPacientePorId(id);
            if (existente == null) {
                JOptionPane.showMessageDialog(this, "No existe un paciente con ID: " + id,
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String nombre = txtNombre.getText().trim();
            String edadStr = txtEdad.getText().trim();
            String direccion = txtDireccion.getText().trim();
            if (nombre.isEmpty() || edadStr.isEmpty() || direccion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int edad = Integer.parseInt(edadStr);
            int resp = JOptionPane.showConfirmDialog(this,
                    "¿Desea actualizar los datos del paciente ID " + id + "?",
                    "Confirmar Actualización", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                Paciente actualizado = new Paciente(id, nombre, edad, direccion);
                if (fachada.actualizarPaciente(actualizado)) {
                    JOptionPane.showMessageDialog(this, "Paciente actualizado exitosamente.",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                    actualizarTabla(fachada.listarPacientes());
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarPaciente() {
        String idStr = txtId.getText().trim();
        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID para eliminar.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int id = Integer.parseInt(idStr);
            Paciente p = fachada.obtenerPacientePorId(id);
            if (p == null) {
                JOptionPane.showMessageDialog(this, "No existe un paciente con ID: " + id,
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int resp = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de eliminar al paciente?\n\n" + p.toString(),
                    "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                if (fachada.eliminarPaciente(id)) {
                    JOptionPane.showMessageDialog(this, "Paciente eliminado exitosamente.",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();
                    actualizarTabla(fachada.listarPacientes());
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void filtrarPorDireccion() {
        String dir = txtFiltroDireccion.getText().trim();
        if (dir.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese una dirección para filtrar.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        List<Paciente> resultado = fachada.filtrarPacientesPorDireccion(dir);
        actualizarTabla(resultado);
        if (resultado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron pacientes con esa dirección.",
                    "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void filtrarPorEdad() {
        try {
            int min = Integer.parseInt(txtFiltroEdadMin.getText().trim());
            int max = Integer.parseInt(txtFiltroEdadMax.getText().trim());
            List<Paciente> resultado = fachada.filtrarPacientesPorEdad(min, max);
            actualizarTabla(resultado);
            if (resultado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron pacientes en ese rango de edad.",
                        "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos para edad.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void filtrarCombinado() {
        String dir = txtFiltroDireccion.getText().trim();
        try {
            int min = Integer.parseInt(txtFiltroEdadMin.getText().trim());
            int max = Integer.parseInt(txtFiltroEdadMax.getText().trim());
            if (dir.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese dirección para filtro combinado.",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            List<Paciente> resultado = fachada.filtrarPacientesCombinado(dir, min, max);
            actualizarTabla(resultado);
            if (resultado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron pacientes con esos criterios.",
                        "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos de filtro.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTabla(List<Paciente> lista) {
        modeloTabla.setRowCount(0);
        for (Paciente p : lista) {
            modeloTabla.addRow(new Object[] { p.getId(), p.getNombre(), p.getEdad(), p.getDireccion() });
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtDireccion.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFiltrarAmbos;
    private javax.swing.JButton btnFiltrarDir;
    private javax.swing.JButton btnFiltrarEdad;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnVerTodos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblFiltroDireccion;
    private javax.swing.JLabel lblFiltroEdadMax;
    private javax.swing.JLabel lblFiltroEdadMin;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JPanel panelFiltros;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtFiltroDireccion;
    private javax.swing.JTextField txtFiltroEdadMax;
    private javax.swing.JTextField txtFiltroEdadMin;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
