/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas.formularios;

import Controlador.CRUDGarantia;
import Modelo.Garantia;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class frmGarantias extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmGarantias
     */
    public frmGarantias() {
        initComponents();
        jRadioLibre.setSelected(true);
        jRadioLibre.setEnabled(false);
        jRadioPrendada.setEnabled(false);
        jRadioPrendada.setSelected(false);
    }

    private void guardarGarantia() {
        CRUDGarantia gg = new CRUDGarantia();
        Garantia gr = new Garantia(0, jTextNombre.getText(), jTextObservacion.getText(), "Libre");
        gg.Guardar(gr);
    }
    private void limpiar() {
        jTextNombre.setText("");
        jTextObservacion.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextObservacion = new javax.swing.JTextField();
        jButtonGuardar = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jRadioPrendada = new javax.swing.JRadioButton();
        jRadioLibre = new javax.swing.JRadioButton();
        jlabelcod = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(0, 161, 154));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(7, 81, 74));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/iconos/garantías.png"))); // NOI18N
        jPanel5.add(jLabel1);

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 160, 140));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator4.setBackground(new java.awt.Color(0, 255, 51));
        jSeparator4.setForeground(new java.awt.Color(7, 81, 74));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 510, 10));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(7, 81, 74));
        jLabel5.setText("Nombre");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jTextNombre.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jTextNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNombre.setBorder(null);
        jTextNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNombreKeyTyped(evt);
            }
        });
        jPanel2.add(jTextNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 250, 40));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(7, 81, 74));
        jLabel8.setText("Observación");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 30));

        jTextObservacion.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jTextObservacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextObservacion.setBorder(null);
        jTextObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextObservacionActionPerformed(evt);
            }
        });
        jPanel2.add(jTextObservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 510, 40));

        jButtonGuardar.setBackground(new java.awt.Color(250, 178, 53));
        jButtonGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/iconos/guardar.png"))); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.setBorder(null);
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 120, 50));

        jButtonActualizar.setBackground(new java.awt.Color(250, 178, 53));
        jButtonActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/iconos/actualizar.png"))); // NOI18N
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.setBorder(null);
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 120, 50));

        jSeparator7.setBackground(new java.awt.Color(0, 255, 51));
        jSeparator7.setForeground(new java.awt.Color(7, 81, 74));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 250, 20));

        jRadioPrendada.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jRadioPrendada.setText("Prendada");
        jPanel2.add(jRadioPrendada, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));

        jRadioLibre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jRadioLibre.setText("Libre");
        jPanel2.add(jRadioLibre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 101, 140, 60));

        jlabelcod.setText("jLabel4");
        jPanel2.add(jlabelcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 0, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 550, 340));

        jPanel3.setBackground(new java.awt.Color(250, 178, 53));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(7, 81, 74));
        jLabel2.setText("Registrar");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 161, 154));
        jLabel3.setText("Nueva Garantía");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 140));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(7, 81, 74));
        jLabel6.setText("Estado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(328, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(260, 260, 260))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel6)
                .addContainerGap(271, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreKeyTyped
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && car != 'á' //Minúsculas
                && car != 'é'
                && car != 'í'
                && car != 'ó'
                && car != 'ú'
                && car != 'Á' //Mayúsculas
                && car != 'É'
                && car != 'Í'
                && car != 'Ó'
                && car != 'Ú'
                && car != 'Ü'
                && car != 'ü'
                && car != 'Ñ'
                && car != 'ñ'
                && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextNombreKeyTyped

    private void jTextObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextObservacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextObservacionActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        CRUDGarantia gr = new CRUDGarantia();
        try {
            if ((jTextNombre.getText().equals(" "))) {
                JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
            } else {
                if (gr.verificarDatos(jTextNombre.getText())) {
                    JOptionPane.showMessageDialog(null, "Ya existe una garantía con el mismo nombre");
                } else {
                    guardarGarantia();
                    limpiar();
                    JOptionPane.showMessageDialog(null, "Datos Guardados Correctamente");
                    frmGestionarGarantias.jButtonAct.doClick();
                }

            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        try {
            if ((jTextNombre.getText().equals(""))) {
                JOptionPane.showMessageDialog(null, "Tiene datos vacíos");
            } else {
                 CRUDGarantia gg = new CRUDGarantia();
                 Garantia gr = new Garantia(Integer.parseInt((String) jlabelcod.getText()), jTextNombre.getText(), jTextObservacion.getText(), "Libre");
                if (gg.actualizar(gr)){
                    JOptionPane.showMessageDialog(null, "Datos Actualizados Correctamente");
                    frmGestionarGarantias.jButtonAct.doClick();
                    dispose();
                }
                else
                   JOptionPane.showMessageDialog(null, "NO SE PUDO ACTUALIZAR");     
                
            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }//GEN-LAST:event_jButtonActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButtonActualizar;
    public static javax.swing.JButton jButtonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioLibre;
    private javax.swing.JRadioButton jRadioPrendada;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator7;
    public static javax.swing.JTextField jTextNombre;
    public static javax.swing.JTextField jTextObservacion;
    public static javax.swing.JLabel jlabelcod;
    // End of variables declaration//GEN-END:variables

}
