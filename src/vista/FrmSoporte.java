package vista;

import controlador.ControladorSoporte;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FrmSoporte extends javax.swing.JInternalFrame {

    public FrmSoporte() {
        initComponents();
        this.closable = false;
        
        txtRuta.setText("src/img/defaultfoto.png");
        
        fechas.setDateFormatString("yyyy-MM-dd");
        
        

    }

    private void buscarFoto() {
        JFileChooser openFile = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        openFile.setFileFilter(fil);
        int returnValue = openFile.showOpenDialog(this);
        if (returnValue == JFileChooser.CANCEL_OPTION) {
            return;
        }
        File archivo = openFile.getSelectedFile();
        this.txtRuta.setText(archivo.getAbsolutePath());
        ImageIcon tmp = new ImageIcon(archivo.getAbsolutePath());
        ImageIcon imagen = new ImageIcon(tmp.getImage().getScaledInstance(
                this.lblFoto.getWidth(),
                this.lblFoto.getHeight(),
                Image.SCALE_DEFAULT));
        this.lblFoto.setIcon(imagen);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtRuta = new javax.swing.JTextField();
        lblFoto = new javax.swing.JLabel();
        btnElegirFoto = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        txtCorreo = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        cboTurno = new javax.swing.JComboBox<>();
        btnActualizar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDomicilio = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        btnCerrar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        fechas = new com.toedter.calendar.JDateChooser();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar Soporte", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nombres: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 100, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Apellidos: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("DNI:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 80, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Estado:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 80, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Fecha Nacimiento:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Correo:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 80, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Celular:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 80, -1));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Turno:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 80, -1));
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 200, -1));
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 200, -1));
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 200, -1));
        jPanel1.add(txtRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 310, 130, -1));

        lblFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, null));
        jPanel1.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, 210, 180));

        btnElegirFoto.setText("Elegir Foto");
        btnElegirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirFotoActionPerformed(evt);
            }
        });
        jPanel1.add(btnElegirFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 350, 150, 30));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 160, 40));
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 200, -1));
        jPanel1.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 200, -1));

        cboTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "T1", "T2" }));
        jPanel1.add(cboTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 130, -1));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 160, 40));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("ID Soporte");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, -1));

        txtId.setEnabled(false);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 100, -1));

        txtDomicilio.setColumns(20);
        txtDomicilio.setRows(5);
        jScrollPane1.setViewportView(txtDomicilio);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 200, 80));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 950, 20));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/espalda.png"))); // NOI18N
        btnCerrar.setText("Regresar");
        btnCerrar.setBorder(null);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, 120, 50));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Domicilio:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 80, -1));

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanel1.add(cboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 130, -1));
        jPanel1.add(fechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 200, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 961, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnElegirFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirFotoActionPerformed
        buscarFoto();
    }//GEN-LAST:event_btnElegirFotoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        ControladorSoporte obj = new ControladorSoporte(this);
        obj.actionPerformed(evt);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        ControladorSoporte obj = new ControladorSoporte(this);
        obj.actionPerformed(evt);
        this.dispose();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnElegirFoto;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JComboBox<String> cboEstado;
    public javax.swing.JComboBox<String> cboTurno;
    public com.toedter.calendar.JDateChooser fechas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFoto;
    public javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtCelular;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtDni;
    public javax.swing.JTextArea txtDomicilio;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtNombres;
    public javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
}
