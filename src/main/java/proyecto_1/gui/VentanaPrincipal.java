package proyecto_1.gui;

import proyecto_1.persistencia.PersistenciaFachada;

public class VentanaPrincipal extends javax.swing.JFrame {

    private PersistenciaFachada fachada;

    public VentanaPrincipal() {
        fachada = new PersistenciaFachada();
        initComponents();
        panelEstado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setSize(900, 650);

        // agregar pestañas con paneles personalizados
        tabbedPane.addTab("Pacientes", new PanelPacientes(fachada));
        tabbedPane.addTab("Médicos", new PanelMedicos(fachada));
        tabbedPane.addTab("Inventario", new PanelInventario(fachada));
        tabbedPane.addTab("Consultas", new PanelConsultas(fachada));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        panelEstado = new javax.swing.JPanel();
        lblEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestión Hospitalaria");
        setMinimumSize(new java.awt.Dimension(800, 550));

        tabbedPane.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        getContentPane().add(tabbedPane, java.awt.BorderLayout.CENTER);

        panelEstado.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        panelEstado.add(lblEstado);

        getContentPane().add(panelEstado, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblEstado;
    private javax.swing.JPanel panelEstado;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
