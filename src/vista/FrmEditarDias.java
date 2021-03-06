/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorEntrada;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;


/**
 *
 * @author KARLA
 */
public class FrmEditarDias extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmEditarDias
     */
    Date date = new Date();
    SpinnerDateModel sm = new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
    //JSpinner.DateEditor de;// = new JSpinner.DateEditor(horaSalida, "HH:mm:ss");
    
    public int idEntrada=0;
    public int idSoporte=0;
    public FrmEditarDias() {
       
        initComponents();
        dateEntrada.setDateFormatString("yyyy-MM-dd");
        dateSalida.setDateFormatString("yyyy-MM-dd");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateEntrada = new com.toedter.calendar.JDateChooser();
        dateSalida = new com.toedter.calendar.JDateChooser();
        //Date date = new Date();
        //SpinnerDateModel sm = new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
        horaEntrada = new javax.swing.JSpinner(sm);
        //Date date = new Date();
        //SpinnerDateModel sm = new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
        horaSalida = new javax.swing.JSpinner(sm);
        jPanel3 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnAgregarDia = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actualizar Horarios", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Fecha de Entrada:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Fecha de Salida:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Hora de Entrada:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Hora de Salida:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));
        jPanel2.add(dateEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 150, 30));
        jPanel2.add(dateSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 150, 30));

        JSpinner.DateEditor de = new JSpinner.DateEditor(horaEntrada, "HH:mm:ss");
        horaEntrada.setEditor(de);
        jPanel2.add(horaEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 150, 30));

        JSpinner.DateEditor de2 = new JSpinner.DateEditor(horaSalida, "HH:mm:ss");
        horaSalida.setEditor(de2);
        jPanel2.add(horaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 150, 30));

        panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 710, 210));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btnEditar.setText("Actualizar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 252, 58));

        btnAgregarDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calendario.png"))); // NOI18N
        btnAgregarDia.setText(" Agregar Fechas");
        btnAgregarDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDiaActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregarDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 252, 58));

        panel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 680, 100));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/espalda.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        ControladorEntrada obj = new ControladorEntrada(this);
        obj.actionPerformed(evt);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregarDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDiaActionPerformed
        // TODO add your handling code here:
        ControladorEntrada obj = new ControladorEntrada(this);
        obj.actionPerformed(evt);
    }//GEN-LAST:event_btnAgregarDiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarDia;
    public javax.swing.JButton btnEditar;
    public com.toedter.calendar.JDateChooser dateEntrada;
    public com.toedter.calendar.JDateChooser dateSalida;
    public javax.swing.JSpinner horaEntrada;
    public javax.swing.JSpinner horaSalida;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
