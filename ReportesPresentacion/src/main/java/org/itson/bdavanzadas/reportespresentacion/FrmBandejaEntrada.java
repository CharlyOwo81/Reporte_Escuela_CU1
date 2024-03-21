/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.bdavanzadas.reportespresentacion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import org.itson.bdavanzadas.reportesdominio.Reporte;
import org.itson.bdavanzadas.reportesdto.ReporteNuevoDTO;
import org.itson.bdavanzadas.reportesnegocios.GestionarIncidencias;
import org.itson.bdavanzadas.reportesnegocios.IFachadaGestionIncidencias;
import org.itson.bdavanzadas.reportespersistencia.IReportesDAO;
import org.itson.bdavanzadas.reportespersistencia.ReportesDAO;

/**
 *
 * @author Oliver Valle
 */
public class FrmBandejaEntrada extends javax.swing.JFrame {

    private IFachadaGestionIncidencias gestionIncidencias ;
    
    /**
     * Creates new form FrmBandejaEntrada
     */
    public FrmBandejaEntrada() {
        initComponents();
        this.gestionIncidencias = new GestionarIncidencias() ;
        refrescarTabla() ;
    }
    
    public FrmBandejaEntrada(IFachadaGestionIncidencias gestionIncidencias) {
        initComponents();
        this.gestionIncidencias = gestionIncidencias ;
        refrescarTabla() ;
    }

    
    public ActionListener botonValidar() {
        ActionListener validarListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReporteNuevoDTO reporteSelec = gestionIncidencias.recuperarReportes().get(tablaReportes.getSelectedRow()) ;
                dispose() ;
                System.out.println((reporteSelec.getAlumno().getNombre())) ;
                FrmValidarReporte frmValidar = new FrmValidarReporte(gestionIncidencias, reporteSelec) ;
                frmValidar.setVisible(true);
            }
        } ;
        
        return validarListener ;
    }
    
    
    
    
    
    public void refrescarTabla() {
        DefaultTableModel modeloTabla = new DefaultTableModel() ;
        List<ReporteNuevoDTO> reportes = gestionIncidencias.recuperarReportes() ;
        Object[] datosTabla = new Object[9];
        modeloTabla.addColumn("CURP");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Grado y Grupo");
        modeloTabla.addColumn("Fecha y Hora");
        modeloTabla.addColumn("Gravedad");
        modeloTabla.addColumn("Motivo");
        modeloTabla.addColumn("Descripción");
        modeloTabla.addColumn("Notificado");
        modeloTabla.addColumn("Validar");
        
        
        
        for (int i = 0; i < reportes.size(); i++) {
            datosTabla[0] = reportes.get(i).getAlumno().getCURP() ;
            datosTabla[1] = reportes.get(i).getAlumno().getNombre() ;
            datosTabla[2] = reportes.get(i).getAlumno().getGradoGrupo() ;
            datosTabla[3] = reportes.get(i).getFechaHora().getTime() ;
            datosTabla[4] = reportes.get(i).getNivelIncidencia() ;
            datosTabla[5] = reportes.get(i).getMotivo() ;
            datosTabla[6] = reportes.get(i).getDescripcion() ;
            if (reportes.get(i).isNotificado()) {
                datosTabla[7] = "NOTIFICADO" ;
            } else {
                datosTabla[7] = "PENDIENTE" ;
            }
            if (reportes.get(i).isValidado()) {
                datosTabla[8] = "VALIDADO" ;
            } 
            
            modeloTabla.addRow(datosTabla);
        }
        
        tablaReportes.setModel(modeloTabla);
        tablaReportes.setRowHeight(30);
        tablaReportes.getColumnModel().getColumn(8).setCellRenderer(new JButtonRenderer("Validar"));
        tablaReportes.getColumnModel().getColumn(8).setCellEditor(new JButtonCellEditor("Validar",botonValidar()));

    }
    
    
//    public void formatearTabla() {
////        tblPersonas.getTableHeader().setBackground(new Color(106, 27, 49));
////        tblPersonas.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 20));
////        tblPersonas.getTableHeader().setForeground(new Color(188, 149, 92));
//
//        ActionListener onEditarClickListener = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //Metodo para seleccionar una persona
//                seleccionar();
//            }
//        };
//        int indiceColumnaSeleccionar = 3;
//        TableColumnModel modeloColumnas = this.tblPersonas.getColumnModel();
//        modeloColumnas.getColumn(indiceColumnaSeleccionar).setCellRenderer(new JButtonRenderer("Seleccionar"));
//        modeloColumnas.getColumn(indiceColumnaSeleccionar).setCellEditor(new JButtonCellEditor("Seleccionar", onEditarClickListener));
//    }
//
//    private void seleccionar() {
//        //Metodo para regresar el empleado seleccionado de la tabla empleados
//        String curp = this.getCurpSeleccionada();
//        FrmHistorialResultados frmHistorialResultados = new FrmHistorialResultados();
//        frmHistorialResultados.setVisible(true);
//        this.dispose();
//    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReportes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bandeja de Reportes");
        setMaximumSize(new java.awt.Dimension(1100, 525));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(189, 189, 189));

        tablaReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CURP", "Nombre", "Grado y Grupo", "Fecha y Hora", "Gravedad", "Motivo", "Descripción", "Notificado", "Validar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaReportes);

        jPanel2.setBackground(new java.awt.Color(250, 248, 245));
        jPanel2.setForeground(new java.awt.Color(250, 248, 245));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(116, 71, 48));
        lblTitulo.setText("Proyecto EUI");
        jPanel2.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, 64));

        lblTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(155, 90, 23));
        lblTitulo1.setText("Bandeja de Entrada");
        jPanel2.add(lblTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, 64));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrmBandejaEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmBandejaEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmBandejaEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmBandejaEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmBandejaEntrada().setVisible(true);
//            }
//        });
//    }
    public class JButtonCellEditor implements TableCellEditor {

    private final JButton button;
    private int row;
    private ActionListener actionListener;

    public JButtonCellEditor(String text, ActionListener actionListener) {
        this.button = new JButton(text);
//        this.button.setFont(new Font("Sans Serif", Font.BOLD, 16));
//        this.button.setBackground(new Color(188, 149, 92));
//        this.button.setForeground(new Color(242, 242, 242));
        this.actionListener = actionListener;
        this.button.addActionListener((ActionEvent evt)->{
            this.actionListener.actionPerformed(
                new ActionEvent(this.button, ActionEvent.ACTION_PERFORMED, this.row+"")
            );
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        return this.button;
    }

    @Override
    public Object getCellEditorValue() {
        return true;
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean stopCellEditing() {
        return true;
    }

    @Override
    public void cancelCellEditing() {}

    @Override
    public void addCellEditorListener(CellEditorListener l) {}

    @Override
    public void removeCellEditorListener(CellEditorListener l) {}
}
    
    public class JButtonRenderer implements TableCellRenderer {

    private final JButton button;

    public JButtonRenderer(String text) {
        this.button = new JButton(text);
//        this.button.setFont(new Font("Sans Serif", Font.BOLD, 16));
//        this.button.setBackground(new Color(188, 149, 92));
//        this.button.setForeground(new Color(242, 242, 242));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this.button;
    }

}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JTable tablaReportes;
    // End of variables declaration//GEN-END:variables
}
