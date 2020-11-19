package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        tamano();
    }

    private void tamano() {
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamano = pantalla.getScreenSize();
        this.setSize(tamano);
        jLabel1.setSize(tamano);
        Image img = new ImageIcon(getClass().getResource("/img/fondo.png")).getImage();
        ImageIcon fond = new ImageIcon(img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(),Image.SCALE_DEFAULT));
        jLabel1.setIcon(fond);
    }

    class gradiente extends JDesktopPane {

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            int with = getWidth();
            int height = getHeight();

            Color color1 = new Color(45, 100, 254);
            Color color2 = new Color(86, 180, 211);
            GradientPaint gp = new GradientPaint(0, 0, color1, 180, height, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, with, height);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new gradiente();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemAgregar = new javax.swing.JMenuItem();
        itemVerSoporte = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.png"))); // NOI18N

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenu1.setText("Admin");

        itemAgregar.setText("Agregar Soporte");
        itemAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAgregarActionPerformed(evt);
            }
        });
        jMenu1.add(itemAgregar);

        itemVerSoporte.setText("Mantenimiento de Soporte");
        itemVerSoporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVerSoporteActionPerformed(evt);
            }
        });
        jMenu1.add(itemVerSoporte);

        jMenuItem6.setText("Eliminar día registrado");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Entrada");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Registrar Entrada");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Salida");

        jMenuItem2.setText("Registrar Salida");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Reporte");

        jMenuItem3.setText("Generar Reporte");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FrmEntrada internalFrameAgregar = new FrmEntrada();

        int x = (escritorio.getWidth() / 2) - internalFrameAgregar.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - internalFrameAgregar.getHeight() / 2;

        if (internalFrameAgregar.isShowing()) {
            internalFrameAgregar.setLocation(x, y);
        } else {
            escritorio.add(internalFrameAgregar);
            internalFrameAgregar.setLocation(x, y);
            internalFrameAgregar.show();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        FrmSalida internalFrameAgregar = new FrmSalida();
        int x = (escritorio.getWidth() / 2) - internalFrameAgregar.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - internalFrameAgregar.getHeight() / 2;

        if (internalFrameAgregar.isShowing()) {
            internalFrameAgregar.setLocation(x, y);
        } else {
            escritorio.add(internalFrameAgregar);
            internalFrameAgregar.setLocation(x, y);
            internalFrameAgregar.show();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void itemAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAgregarActionPerformed
        // TODO add your handling code here:
        FrmSoporte internalFrameAgregar = new FrmSoporte();
        int x = (escritorio.getWidth() / 2) - internalFrameAgregar.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - internalFrameAgregar.getHeight() / 2;

        if (internalFrameAgregar.isShowing()) {
            internalFrameAgregar.setLocation(x, y);
        } else {
            escritorio.add(internalFrameAgregar);
            internalFrameAgregar.setLocation(x, y);
            internalFrameAgregar.show();
            internalFrameAgregar.btnActualizar.setEnabled(false);
        }
    }//GEN-LAST:event_itemAgregarActionPerformed

    private void itemVerSoporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVerSoporteActionPerformed
        // TODO add your handling code here:
        FrmVer_Soporte internalFrame = new FrmVer_Soporte();
        int x = (escritorio.getWidth() / 2) - internalFrame.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - internalFrame.getHeight() / 2;

        if (internalFrame.isShowing()) {
            internalFrame.setLocation(x, y);
        } else {
            escritorio.add(internalFrame);
            internalFrame.setLocation(x, y);
            internalFrame.show();
        }

    }//GEN-LAST:event_itemVerSoporteActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Frm_Reporte internalFrame = new Frm_Reporte();

        int x = (escritorio.getWidth() / 2) - internalFrame.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - internalFrame.getHeight() / 2;

        if (internalFrame.isShowing()) {
            internalFrame.setLocation(x, y);
        } else {
            escritorio.add(internalFrame);
            internalFrame.setLocation(x, y);
            internalFrame.show();
        }

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        Frm_Dias internalFrame = new Frm_Dias();

        int x = (escritorio.getWidth() / 2) - internalFrame.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - internalFrame.getHeight() / 2;

        if (internalFrame.isShowing()) {
            internalFrame.setLocation(x, y);
        } else {
            escritorio.add(internalFrame);
            internalFrame.setLocation(x, y);
            internalFrame.show();
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem itemAgregar;
    private javax.swing.JMenuItem itemVerSoporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    // End of variables declaration//GEN-END:variables
}
