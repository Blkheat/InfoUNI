package vista;

import controlador.ControladorEntrada;
import controlador.Estilos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class FrmSalida extends javax.swing.JInternalFrame {

    DefaultTableModel modelo;
    Estilos style = new Estilos();

    public FrmSalida() {

        initComponents();
        hora();
        this.modelo = (DefaultTableModel) tlbSoportes.getModel();
        txtbuscador.setBackground(new java.awt.Color(0, 0, 0, 1));
        style.estiloTabla(tlbRegistrados);
        style.estiloTabla(tlbSoportes);
    }

    private void hora() {
        Date fecha = new Date();
        SimpleDateFormat Formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaComoCadena = Formato.format(new Date());
        lblFecha.setText(fechaComoCadena);
        DateFormat hora = new SimpleDateFormat("HH:mm:ss");
        lblHora.setText(hora.format(fecha));
        timer.start();
    }

    Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Aquí el código que queramos ejecutar.
            Date fecha = new Date();
            DateFormat formatohora = new SimpleDateFormat("HH:mm:ss");
            lblHora.setText(formatohora.format(fecha));

        }
    });

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        btnCerrar4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        txtbuscador = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tlbSoportes = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtturno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnRegistrarSalida = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tlbRegistrados = new javax.swing.JTable();
        lblHora = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1410, 674));

        panelFondo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salida", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 1, 36))); // NOI18N
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/espalda.png"))); // NOI18N
        btnCerrar4.setText("Regresar");
        btnCerrar4.setBorder(null);
        btnCerrar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrar4ActionPerformed(evt);
            }
        });
        panelFondo.add(btnCerrar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 10, 100, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(0, 98, 236));
        jSeparator1.setForeground(new java.awt.Color(0, 98, 236));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 310, 20));

        txtbuscador.setBackground(new java.awt.Color(0, 0, 0));
        txtbuscador.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtbuscador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtbuscador.setBorder(null);
        txtbuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscadorKeyReleased(evt);
            }
        });
        jPanel2.add(txtbuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 310, 30));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/busqueda.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 50, 50));

        tlbSoportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Apellidos", "Nombres", "Turno", "Foto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tlbSoportes.setRowHeight(50);
        tlbSoportes.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tlbSoportes.getTableHeader().setReorderingAllowed(false);
        tlbSoportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tlbSoportesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tlbSoportes);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 620, 230));

        panelFondo.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 660, 350));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombres.setEnabled(false);
        jPanel3.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 190, -1));

        jLabel3.setText("Nombres:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel2.setText("Apellidos:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        txtApellidos.setEnabled(false);
        jPanel3.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 190, -1));

        txtturno.setEnabled(false);
        jPanel3.add(txtturno, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 190, -1));

        jLabel4.setText("Turno:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        txtId.setEnabled(false);
        jPanel3.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 190, -1));

        jLabel1.setText("ID:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 30, -1));

        btnRegistrarSalida.setText("Registrar Salida");
        btnRegistrarSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarSalidaActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegistrarSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 180, 50));

        panelFondo.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 660, 210));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tlbRegistrados.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tlbRegistrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Apellidos", "Nombres", "Hora Salida", "Cumpleanos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tlbRegistrados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tlbRegistrados.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tlbRegistrados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tlbRegistrados);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 670, 340));

        lblHora.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblHora.setForeground(new java.awt.Color(0, 153, 51));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHora.setText("Hora");
        jPanel4.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 520, 60));

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(0, 153, 51));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setText("Fecha");
        jPanel4.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 520, 60));

        panelFondo.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 690, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 1410, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarSalidaActionPerformed
        // TODO add your handling code here:
        ControladorEntrada obj = new ControladorEntrada(this);
        obj.actionPerformed(evt);
    }//GEN-LAST:event_btnRegistrarSalidaActionPerformed

    private void txtbuscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscadorKeyReleased
        // TODO add your handling code here:
        ControladorEntrada obj = new ControladorEntrada(this);
        obj.actionPerformed(evt);
    }//GEN-LAST:event_txtbuscadorKeyReleased

    private void btnCerrar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrar4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrar4ActionPerformed

    private void tlbSoportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlbSoportesMouseClicked
        // TODO add your handling code here:
        if (evt.isMetaDown()) {
            if (tlbSoportes.getSelectedRow() != -1) {
                txtId.setText(modelo.getValueAt(tlbSoportes.getSelectedRow(), 0).toString());
                txtNombres.setText(modelo.getValueAt(tlbSoportes.getSelectedRow(), 2).toString());
                txtApellidos.setText(modelo.getValueAt(tlbSoportes.getSelectedRow(), 1).toString());
                txtturno.setText(modelo.getValueAt(tlbSoportes.getSelectedRow(), 3).toString());
            }
        }
    }//GEN-LAST:event_tlbSoportesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar4;
    public javax.swing.JButton btnRegistrarSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel lblFecha;
    public javax.swing.JLabel lblHora;
    private javax.swing.JPanel panelFondo;
    public javax.swing.JTable tlbRegistrados;
    public javax.swing.JTable tlbSoportes;
    public javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtNombres;
    public javax.swing.JTextField txtbuscador;
    public javax.swing.JTextField txtturno;
    // End of variables declaration//GEN-END:variables
}
