/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Soporte;
import modelo.SoporteDAO;
import vista.FrmEditarDias;
import vista.FrmSoporte;
import vista.FrmVer_Soporte;
import vista.Principal;

/**
 *
 * @author Absolute
 */
public class ControladorSoporte implements ActionListener {

    private SoporteDAO soporteDao = new SoporteDAO();
    private Soporte soporte = new Soporte();
    private FrmSoporte frmSoporte = new FrmSoporte();
    private FrmVer_Soporte frmVerSoporte = new FrmVer_Soporte();
    private FrmEditarDias frmEditarDias = new FrmEditarDias();
     DateFormat form = new SimpleDateFormat("yyyy-MM-dd");
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorSoporte(FrmSoporte frm) {
        this.frmSoporte = frm;
        
    }

    public ControladorSoporte(FrmVer_Soporte frm) {
        this.frmVerSoporte = frm;
        
        
        
    }
    
    public ControladorSoporte(FrmEditarDias frm){
        this.frmEditarDias = frm;
    }
    
    private void eliminarSoporte(JTable tabla){
        modelo = (DefaultTableModel) tabla.getModel();
        int id = Integer.parseInt(modelo.getValueAt(tabla.getSelectedRow(), 0).toString());
        soporteDao.eliminarSoporte(id);
    
    }
    private void agregarDias(JTable tabla){
        FrmVer_Soporte frVer = new FrmVer_Soporte();
        frVer.menuItemAgregarDia.addActionListener(this);
        modelo = (DefaultTableModel) tabla.getModel();
        frmEditarDias.idSoporte = (int)modelo.getValueAt(tabla.getSelectedRow(), 0);
        int x = (Principal.escritorio.getWidth() / 2) - frmEditarDias.getWidth() / 2;
        int y = (Principal.escritorio.getHeight() / 2) - frmEditarDias.getHeight() / 2;

        
            Principal.escritorio.add(frmEditarDias);
            frmEditarDias.setLocation(x, y);
            frmEditarDias.show();
            frmEditarDias.btnEditar.setEnabled(false);
            
    }

    private void datosActualizar(JTable tabla) {
        try {
            FrmVer_Soporte frVerSoporte = new FrmVer_Soporte();
        frVerSoporte.menuItemEditar.addActionListener(this);
        modelo = (DefaultTableModel) tabla.getModel();
        frmSoporte.txtId.setText(modelo.getValueAt(tabla.getSelectedRow(), 0).toString());
        frmSoporte.txtApellidos.setText(modelo.getValueAt(tabla.getSelectedRow(), 1).toString());
        frmSoporte.txtNombres.setText(modelo.getValueAt(tabla.getSelectedRow(), 2).toString());

        frmSoporte.txtDni.setText(modelo.getValueAt(tabla.getSelectedRow(), 3).toString());
        frmSoporte.txtDomicilio.setText(modelo.getValueAt(tabla.getSelectedRow(), 4).toString());
        frmSoporte.fechas.setDate(form.parse(modelo.getValueAt(tabla.getSelectedRow(), 5).toString()));
        frmSoporte.txtCorreo.setText(modelo.getValueAt(tabla.getSelectedRow(), 6).toString());
        frmSoporte.txtCelular.setText(modelo.getValueAt(tabla.getSelectedRow(), 7).toString());

        int x = (Principal.escritorio.getWidth() / 2) - frmSoporte.getWidth() / 2;
        int y = (Principal.escritorio.getHeight() / 2) - frmSoporte.getHeight() / 2;

        
            Principal.escritorio.add(frmSoporte);
            frmSoporte.setLocation(x, y);
            frmSoporte.show();
            frmSoporte.btnGuardar.setEnabled(false);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error en enviar datos para actualizar"+e);
        }
        
        

    }

    private void actualizar() {
        FrmSoporte frSoporte = new FrmSoporte();
        frSoporte.btnActualizar.addActionListener(this);
        int id = Integer.parseInt(frmSoporte.txtId.getText());
        String nombre = frmSoporte.txtNombres.getText();
        String apellidos = frmSoporte.txtApellidos.getText();
        String dni = frmSoporte.txtDni.getText();
        String domicilio = frmSoporte.txtDomicilio.getText();
        String fecha_Nacimiento = form.format(frmSoporte.fechas.getDate());
        String correo = frmSoporte.txtCorreo.getText();
        String celular = frmSoporte.txtCelular.getText();
        String turno;
        turno = (String) frmSoporte.cboTurno.getSelectedItem();
        String foto = frmSoporte.txtRuta.getText();
        String estado =(String) frmSoporte.cboEstado.getSelectedItem();
        soporte.setId_Soporte(id);
        soporte.setNombres(nombre);
        soporte.setApellidos(apellidos);
        soporte.setDni(dni);
        soporte.setDomicilio(domicilio);
        soporte.setFecha_Nacimiento(fecha_Nacimiento);
        soporte.setCorreo(correo);
        soporte.setCelular(celular);
        soporte.setTurno(turno);
        soporte.setEstado(estado);

        try {
            File ruta = new File(foto);
            byte[] icono = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
            soporte.setFoto(icono);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la foto " + ex);
            soporte.setFoto(null);
        }
        int registrado = soporteDao.modificarSoporte(soporte);
        if (registrado == 1) {
            JOptionPane.showMessageDialog(null, "¡Soporte Actualizado con exito!");
            
        } else {
            JOptionPane.showMessageDialog(null, "¡No se pudo Actualizar!");
        }

    }
    
    private void filtrarSoportes(JTable tabla,String apellido){
        FrmVer_Soporte frVerSoporte = new FrmVer_Soporte();
        frVerSoporte.txtbuscador.addActionListener(this);
        modelo = (DefaultTableModel) tabla.getModel();
        List<Soporte> lista = soporteDao.filtrarSoporte(apellido);
        modelo.setRowCount(0);
        for (int i = 0; i < lista.size(); i++) {
            Object fila[] = new Object[modelo.getColumnCount()];
            fila[0] = lista.get(i).getId_Soporte();
            fila[1] = lista.get(i).getApellidos();
            fila[2] = lista.get(i).getNombres();
            fila[3] = lista.get(i).getDni();
            fila[4] = lista.get(i).getDomicilio();
            fila[5] = lista.get(i).getFecha_Nacimiento();
            fila[6] = lista.get(i).getCorreo();
            fila[7] = lista.get(i).getCelular();
            fila[8] = lista.get(i).getTurno();
            
            fila[9] = lista.get(i).getTotal_horas();
            fila[10] = lista.get(i).getEstado();
            try {
                if (lista.get(i).getFoto() != null) {
                    tabla.setDefaultRenderer(Object.class, new Renderizado());
                byte[] bi = lista.get(i).getFoto();

                BufferedImage image = null;
                InputStream in = new ByteArrayInputStream(bi);
                image = ImageIO.read(in);
                ImageIcon imgi = new ImageIcon(image.getScaledInstance(120, 100, Image.SCALE_DEFAULT));
                tabla.setRowHeight(imgi.getIconHeight());
                fila[11] = new JLabel(imgi);
                }else{
                    fila[11] = new JLabel("No tiene foto");
                }
                
            } catch (IOException e) {
                fila[11] = new JLabel("No imagen");
            }
            modelo.addRow(fila);
        }
        frmVerSoporte.tabla.setModel(modelo);
    }

    private void listarSoportes(JTable tabla) {
        FrmVer_Soporte  frmVerSoport = new FrmVer_Soporte();
        frmVerSoport.btnListarSoporte.addActionListener(this);
        modelo = (DefaultTableModel) tabla.getModel();
        List<Soporte> lista = soporteDao.listarSoportes();
        modelo.setRowCount(0);
        for (int i = 0; i < lista.size(); i++) {
            Object fila[] = new Object[modelo.getColumnCount()];
            fila[0] = lista.get(i).getId_Soporte();
            fila[1] = lista.get(i).getApellidos();
            fila[2] = lista.get(i).getNombres();
            fila[3] = lista.get(i).getDni();
            fila[4] = lista.get(i).getDomicilio();
            fila[5] = lista.get(i).getFecha_Nacimiento();
            fila[6] = lista.get(i).getCorreo();
            fila[7] = lista.get(i).getCelular();
            fila[8] = lista.get(i).getTurno();
            fila[9] = lista.get(i).getTotal_horas();
            fila[10] = lista.get(i).getEstado();

            try {
                if (lista.get(i).getFoto() != null) {
                    tabla.setDefaultRenderer(Object.class, new Renderizado());
                byte[] bi = lista.get(i).getFoto();

                BufferedImage image = null;
                InputStream in = new ByteArrayInputStream(bi);
                image = ImageIO.read(in);
                ImageIcon imgi = new ImageIcon(image.getScaledInstance(120, 100, Image.SCALE_DEFAULT));
                tabla.setRowHeight(imgi.getIconHeight());
                fila[11] = new JLabel(imgi);
                }else{
                    fila[11] = new JLabel("No tiene foto");
                }
                
            } catch (IOException e) {
                fila[11] = new JLabel("No imagen");
            }
            modelo.addRow(fila);
        }
        frmVerSoporte.tabla.setModel(modelo);

    }

    private void agregarSoporte() {
        FrmSoporte frSoporte = new FrmSoporte();
        frSoporte.btnGuardar.addActionListener(this);
        String nombre = frmSoporte.txtNombres.getText();
        String apellidos = frmSoporte.txtApellidos.getText();
        String dni = frmSoporte.txtDni.getText();
        String domicilio = frmSoporte.txtDomicilio.getText();
        String fecha_Nacimiento = form.format(frmSoporte.fechas.getDate());
        String correo = frmSoporte.txtCorreo.getText();
        String celular = frmSoporte.txtCelular.getText();
        String turno;
        turno = (String) frmSoporte.cboTurno.getSelectedItem();
        String foto = frmSoporte.txtRuta.getText();
        String estado = frmSoporte.cboEstado.getSelectedItem().toString().trim();
        soporte.setNombres(nombre);
        soporte.setApellidos(apellidos);
        soporte.setDni(dni);
        soporte.setDomicilio(domicilio);
        soporte.setFecha_Nacimiento(fecha_Nacimiento);
        soporte.setCorreo(correo);
        soporte.setCelular(celular);
        soporte.setTurno(turno);
        soporte.setEstado(estado);

        try {
            File ruta = new File(foto);
            byte[] icono = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
            soporte.setFoto(icono);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la foto " + ex);
            soporte.setFoto(null);
        }
        int registrado = soporteDao.agregarSoporte(soporte);
        if (registrado == 1) {
            JOptionPane.showMessageDialog(null, "¡Soporte registrado con exito!");
        } else {
            JOptionPane.showMessageDialog(null, "¡No se pudo registrar!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmSoporte.btnGuardar) {
            agregarSoporte();
        }
        if (e.getSource() == frmSoporte.btnActualizar) {
            actualizar();
            
            
        }
        if (e.getSource() == frmVerSoporte.btnListarSoporte) {

            listarSoportes(frmVerSoporte.tabla);

        }
        if (e.getSource() == frmVerSoporte.menuItemEditar) {
            datosActualizar(frmVerSoporte.tabla);

        }
        if (e.getSource() == frmVerSoporte.menuItemEliminar) {
            eliminarSoporte(frmVerSoporte.tabla);
            listarSoportes(frmVerSoporte.tabla);
        }
        if (e.getSource() == frmVerSoporte.menuItemAgregarDia) {
            agregarDias(frmVerSoporte.tabla);
        }
        if (e.getSource() == frmVerSoporte.txtbuscador) {
            
            filtrarSoportes(frmVerSoporte.tabla, frmVerSoporte.txtbuscador.getText());
        }

    }
    
    public void actionPerformed(KeyEvent evt) {
        if (evt.getSource() == frmVerSoporte.txtbuscador) {
            filtrarSoportes(frmVerSoporte.tabla, frmVerSoporte.txtbuscador.getText());
        }
    }

    class Renderizado extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof JLabel) {
                JLabel lbl = (JLabel) value;
                return lbl;
            }

            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }

    }

}
