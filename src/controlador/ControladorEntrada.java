package controlador;

import java.awt.Color;
import java.util.concurrent.TimeUnit;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Entrada;
import modelo.EntradaDAO;
import modelo.Soporte;
import vista.FrmEditarDias;
import vista.FrmEntrada;
import vista.Frm_Reporte;
import vista.FrmSalida;
import vista.Frm_Dias;
import vista.Login;
import vista.Principal;

public class ControladorEntrada implements ActionListener {

    private final Entrada entrada = new Entrada();
    private final EntradaDAO entradaDAO = new EntradaDAO();
    //private final Soporte soporte = new Soporte();
    private FrmEntrada frmEntrada = new FrmEntrada();
    private Frm_Dias frmDias = new Frm_Dias();
    private Frm_Reporte frmReporte = new Frm_Reporte();
    private FrmSalida frmSalida = new FrmSalida();
    private Login frmLogin = new Login();
    private FrmEditarDias frmEditarDias = new FrmEditarDias();
    DateFormat form = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat formHora = new SimpleDateFormat("hh:mm:ss");
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorEntrada(Frm_Reporte frm) {
        this.frmReporte = frm;
    }

    public ControladorEntrada(FrmEntrada frm) {
        this.frmEntrada = frm;

    }

    public ControladorEntrada(FrmSalida frm) {
        this.frmSalida = frm;
    }

    public ControladorEntrada(Frm_Dias frm) {
        this.frmDias = frm;
    }

    public ControladorEntrada(Login log) {
        this.frmLogin = log;
    }

    public ControladorEntrada(FrmEditarDias editar) {
        this.frmEditarDias = editar;
    }

    private void registrarSalida() {
        FrmSalida frSalida = new FrmSalida();
        frSalida.btnRegistrarSalida.addActionListener(this);
        entrada.setId_Soporte(Integer.parseInt(frmSalida.txtId.getText().trim()));
        entrada.setHoraSalida(frmSalida.lblHora.getText().trim());
        entrada.setFechaSalida(frmSalida.lblFecha.getText().trim());
        int validar = entradaDAO.validarEstado(entrada);
        if (validar > 0) {

            int registrado = entradaDAO.registrarSalida(entrada);

            if (registrado == 1) {

                totaldeHorasSumadas(entrada.getId_Soporte());

                JOptionPane.showMessageDialog(null, "Soporte registrado con exito");
            } else {
                JOptionPane.showMessageDialog(null, "Aun no ha registrado la entrada");

            }
        } else {
            JOptionPane.showMessageDialog(null, "El soporte esta deshabilitado");
        }

    }

    private void registrarEntrada() {
        FrmEntrada frentrada = new FrmEntrada();
        frentrada.btnRegistrarEntrada.addActionListener(this);

        entrada.setId_Soporte(Integer.parseInt(frmEntrada.txtId.getText().trim()));
        entrada.setHoraIngreso(frmEntrada.lblHora.getText().trim());
        entrada.setFechaIngreso(frmEntrada.lblFecha.getText().trim());

        int validar = entradaDAO.validarEstado(entrada);
        if (validar > 0) {

            int registrado = entradaDAO.registrarEntrada(entrada);
            if (registrado == 1) {
                JOptionPane.showMessageDialog(null, "Soporte registrado con exito");
            } else {
                JOptionPane.showMessageDialog(null, "Ya se ha registrado");

            }
        } else {
            JOptionPane.showMessageDialog(null, "El soporte esta deshabilitado");
        }

    }

    private void totaldeHorasSumadas(int id) {

        List<Entrada> lista = entradaDAO.horayEntrada(id);

        long totalH = 0L;
        for (int i = 0; i < lista.size(); i++) {
            String fechIngreso = lista.get(i).getFechaIngreso();
            String horaIngreso = lista.get(i).getHoraIngreso();
            String fechaSalida = lista.get(i).getFechaSalida();
            String horaSalida = lista.get(i).getHoraSalida();
            totalH = totalHoras(fechIngreso, horaIngreso, fechaSalida, horaSalida);

        }
        long tiempoEnSegundos = TimeUnit.MILLISECONDS.toSeconds(totalH);

        long horas = (tiempoEnSegundos / 3600);
        long minutos = ((tiempoEnSegundos - horas * 3600) / 60);
        long segundos = (tiempoEnSegundos - (horas * 3600 + minutos * 60));

        String total = horas + ":" + minutos + ":" + segundos;
        System.out.println("totaless " + totalH);
        System.out.println(total);
        entradaDAO.actualizarTotal(id, total);
    }

    private void validarAdministrador() {
        Login login = new Login();
        login.btnConectar.addActionListener(this);
        String usuario = frmLogin.txtuser.getText().trim();
        String contrasena = String.valueOf(frmLogin.txtpassword.getPassword()).trim();
        int valor = entradaDAO.validarAdmin(usuario, contrasena);
        if (valor == 1) {

            JOptionPane.showMessageDialog(null, "Conectado");
            frmLogin.dispose();
            Principal objPrincipal = new Principal();
            objPrincipal.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Datos incorrectos");
        }
    }

    private void eliminarDia(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        int idDia = Integer.parseInt(modelo.getValueAt(tabla.getSelectedRow(), 0).toString());
        int idSoporte = Integer.parseInt(modelo.getValueAt(tabla.getSelectedRow(), 1).toString());
        int valor = entradaDAO.eliminarDia(idDia, idSoporte);
        if (valor == 1) {

            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            filtrarDias(tabla, frmDias.txtbuscador.getText());

        }

    }

    public void listarEntrada(JTable tabla) {
        SimpleDateFormat Formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaComoCadena = Formato.format(new Date());

        modelo = (DefaultTableModel) tabla.getModel();
        List<Entrada> lista = entradaDAO.filtrarEntrada(fechaComoCadena.trim());
        modelo.setRowCount(0);
        for (int i = 0; i < lista.size(); i++) {
            Object fila[] = new Object[modelo.getColumnCount()];
            tabla.setDefaultRenderer(Object.class, new pintarFila());
            fila[0] = lista.get(i).getApellidos();
            fila[1] = lista.get(i).getNombres();
            fila[2] = lista.get(i).getHoraIngreso();
            fila[3] = lista.get(i).getFecha_Nacimiento();
            modelo.addRow(fila);
        }

        frmEntrada.tlbRegistrados.setModel(modelo);
        tabla.getColumnModel().getColumn(3).setMaxWidth(0);

        tabla.getColumnModel().getColumn(3).setMinWidth(0);

        tabla.getColumnModel().getColumn(3).setPreferredWidth(0);
    }

    public void listarSalida(JTable tabla) {
        SimpleDateFormat Formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaComoCadena = Formato.format(new Date());

        modelo = (DefaultTableModel) tabla.getModel();
        List<Entrada> lista = entradaDAO.filtrarSalida(fechaComoCadena.trim());
        modelo.setRowCount(0);
        for (int i = 0; i < lista.size(); i++) {
            Object fila[] = new Object[modelo.getColumnCount()];
            tabla.setDefaultRenderer(Object.class, new pintarFila());
            fila[0] = lista.get(i).getApellidos();
            fila[1] = lista.get(i).getNombres();
            fila[2] = lista.get(i).getHoraSalida();
            fila[3] = lista.get(i).getFecha_Nacimiento();
            modelo.addRow(fila);
        }

        frmSalida.tlbRegistrados.setModel(modelo);
        tabla.getColumnModel().getColumn(3).setMaxWidth(0);

        tabla.getColumnModel().getColumn(3).setMinWidth(0);

        tabla.getColumnModel().getColumn(3).setPreferredWidth(0);
    }

    private void filtrarDias(JTable tabla, String apellido) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<Entrada> lista = entradaDAO.filtrarDias(apellido);
        modelo.setRowCount(0);
        for (int i = 0; i < lista.size(); i++) {
            Object fila[] = new Object[modelo.getColumnCount()];
            fila[0] = lista.get(i).getId_entrada();
            fila[1] = lista.get(i).getId_Soporte();
            fila[2] = lista.get(i).getApellidos();
            fila[3] = lista.get(i).getNombres();
            fila[4] = lista.get(i).getFechaIngreso();
            fila[5] = lista.get(i).getHoraIngreso();
            fila[6] = lista.get(i).getFechaSalida();
            fila[7] = lista.get(i).getHoraSalida();
            String diaEntrada = lista.get(i).getFechaIngreso();
            String horaEntrada = lista.get(i).getHoraIngreso();
            String diaSalida = lista.get(i).getFechaSalida();
            String horaSalida = lista.get(i).getHoraSalida();
            if (diaSalida == null && horaSalida == null) {
                diaSalida = diaEntrada;
                horaSalida = horaEntrada;
                fila[6] = "Sin día de salida";
                fila[7] = "Sin hora de salida";
            }

            fila[8] = calcularHoras(diaEntrada, horaEntrada, diaSalida, horaSalida);
            modelo.addRow(fila);
        }
        frmEntrada.tlbSoportes.setModel(modelo);

    }

    private void editarDias(JTable tabla) {

        try {
            Frm_Dias frDias = new Frm_Dias();
            frDias.menuItemEditar.addActionListener(this);
            modelo = (DefaultTableModel) tabla.getModel();
            frmEditarDias.idEntrada = (int) (modelo.getValueAt(tabla.getSelectedRow(), 0));
            frmEditarDias.idSoporte = (int) (modelo.getValueAt(tabla.getSelectedRow(), 1));
            
            SpinnerDateModel smHoraEntrada = new SpinnerDateModel(formHora.parse(modelo.getValueAt(tabla.getSelectedRow(), 5).toString()) , null, null, Calendar.HOUR_OF_DAY);
                frmEditarDias.horaEntrada = new javax.swing.JSpinner(smHoraEntrada);
                JSpinner.DateEditor dee = new JSpinner.DateEditor(frmEditarDias.horaEntrada, "HH:mm:ss");
                frmEditarDias.horaEntrada.setEditor(dee);
            
            frmEditarDias.dateEntrada.setDate(form.parse(modelo.getValueAt(tabla.getSelectedRow(), 4).toString())); //modelo.getValueAt(tabla.getSelectedRow(), 4).toString()))

            //frmEditarDias.horaEntrada.setValue(modelo.getValueAt(tabla.getSelectedRow(), 5).toString()); //horaEntrada txtHoraEntrada.setText(modelo.getValueAt(tabla.getSelectedRow(), 5).toString());

            if (modelo.getValueAt(tabla.getSelectedRow(), 6).toString().equals("Sin día de salida") && modelo.getValueAt(tabla.getSelectedRow(), 7).toString().equals("Sin hora de salida")) {
                frmEditarDias.dateSalida.setDate(form.parse(modelo.getValueAt(tabla.getSelectedRow(), 4).toString())); // txtFechaSalida.setText(modelo.getValueAt(tabla.getSelectedRow(), 6).toString());

                frmEditarDias.horaSalida.setValue(formHora.parseObject(modelo.getValueAt(tabla.getSelectedRow(), 5).toString()));
                //setValue(formHora.parse(modelo.getValueAt(tabla.getSelectedRow(), 5).toString()));
                //modelo.getValueAt(tabla.getSelectedRow(), 5).toString()); //txtHoraSalida.setText(modelo.getValueAt(tabla.getSelectedRow(), 5).toString());

            } else {
                frmEditarDias.dateSalida.setDate(form.parse(modelo.getValueAt(tabla.getSelectedRow(), 6).toString())); // txtFechaSalida.setText(modelo.getValueAt(tabla.getSelectedRow(), 6).toString());

                //frmEditarDias.horaSalida.setValue(formHora.parseObject(modelo.getValueAt(tabla.getSelectedRow(), 7).toString()));
                
                
                //Date date = new Date();
                SpinnerDateModel sm = new SpinnerDateModel(formHora.parse(modelo.getValueAt(tabla.getSelectedRow(), 7).toString()) , null, null, Calendar.HOUR_OF_DAY);
                frmEditarDias.horaSalida = new javax.swing.JSpinner(sm);
                JSpinner.DateEditor de = new JSpinner.DateEditor(frmEditarDias.horaSalida, "HH:mm:ss");
                frmEditarDias.horaSalida.setEditor(de);
                
//                frmEditarDias.horaSalida = new javax.swing.JSpinner();
//                JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinner1, "HH:mm:ss");
//
//                frmEditarDias.horaSalida.
                        //modelo.getValueAt(tabla.getSelectedRow(), 7).toString()); //txtHoraSalida.setText(modelo.getValueAt(tabla.getSelectedRow(), 7).toString());
            }

            int x = (Principal.escritorio.getWidth() / 2) - frmEditarDias.getWidth() / 2;
            int y = (Principal.escritorio.getHeight() / 2) - frmEditarDias.getHeight() / 2;

            Principal.escritorio.add(frmEditarDias);
            frmEditarDias.setLocation(x, y);
            frmEditarDias.show();
            frmEditarDias.btnAgregarDia.setEnabled(false);

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error al convertir fechas y horas" + e);
        }

    }

    private void agregarDias() {
        FrmEditarDias frEditar = new FrmEditarDias();
        frEditar.btnAgregarDia.addActionListener(this);
        entrada.setId_Soporte(frmEditarDias.idSoporte);
        entrada.setFechaIngreso(form.format(frmEditarDias.dateEntrada.getDate()));  //frmEditarDias.txtFechaEntrada.getText().trim());
        entrada.setHoraIngreso(formHora.format(frmEditarDias.horaEntrada.getValue()));  //frmEditarDias. txtHoraEntrada.getText().trim());
        entrada.setFechaSalida(form.format(frmEditarDias.dateSalida.getDate()));//frmEditarDias.txtFechaSalida.getText().trim());
        entrada.setHoraSalida(formHora.format(frmEditarDias.horaSalida.getValue())); //frmEditarDias.txtHoraSalida.getText().trim());
        int valor = entradaDAO.agregarDias(entrada);
        if (valor > 0) {
            totaldeHorasSumadas(entrada.getId_Soporte());
            JOptionPane.showMessageDialog(null, "Agregado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo Agregar");
        }

    }

    private void editarDias() {
        FrmEditarDias frEditar = new FrmEditarDias();
        frEditar.btnEditar.addActionListener(this);

        entrada.setId_entrada(frmEditarDias.idEntrada);
        entrada.setId_Soporte(frmEditarDias.idSoporte);
        entrada.setFechaIngreso(form.format(frmEditarDias.dateEntrada.getDate()));// frmEditarDias.txtFechaEntrada.getText().trim());
        entrada.setHoraIngreso(formHora.format(frmEditarDias.horaEntrada.getValue())); //frmEditarDias.txtHoraEntrada.getText().trim());
        entrada.setFechaSalida(form.format(frmEditarDias.dateSalida.getDate()));   //frmEditarDias.txtFechaSalida.getText().trim());
        entrada.setHoraSalida(formHora.format(frmEditarDias.horaSalida.getValue()));//frmEditarDias.txtHoraSalida.getText().trim());

        int valor = entradaDAO.editarDias(entrada);

        if (valor > 0) {
            totaldeHorasSumadas(frmEditarDias.idSoporte);
            JOptionPane.showMessageDialog(null, "Editado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo Actualizar");
        }

    }

    private void filtrarSoportes(JTable tabla, String apellido) {

        FrmEntrada frmEntrad = new FrmEntrada();
        frmEntrad.txtbuscador.addActionListener(this);
        modelo = (DefaultTableModel) tabla.getModel();
        List<Soporte> lista = entradaDAO.filtrarSoporteEntrada(apellido);
        modelo.setRowCount(0);
        for (int i = 0; i < lista.size(); i++) {
            Object fila[] = new Object[modelo.getColumnCount()];
            fila[0] = lista.get(i).getId_Soporte();
            fila[1] = lista.get(i).getApellidos();
            fila[2] = lista.get(i).getNombres();

            fila[3] = lista.get(i).getTurno();

            try {
                if (lista.get(i).getFoto() != null) {
                    tabla.setDefaultRenderer(Object.class, new Renderizado());
                    byte[] bi = lista.get(i).getFoto();

                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(120, 100, Image.SCALE_DEFAULT));
                    tabla.setRowHeight(imgi.getIconHeight());
                    fila[4] = new JLabel(imgi);
                } else {
                    fila[4] = new JLabel("No tiene foto");
                }

            } catch (IOException e) {
                fila[4] = new JLabel("No imagen");
            }
            modelo.addRow(fila);
        }
        frmEntrada.tlbSoportes.setModel(modelo);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frmEntrada.btnRegistrarEntrada) {
            if (frmEntrada.txtId.getText().equals("")) {
                listarEntrada(frmEntrada.tlbRegistrados);
            } else {
                registrarEntrada();
                listarEntrada(frmEntrada.tlbRegistrados);
            }
        }

        if (e.getSource() == frmSalida.btnRegistrarSalida) {
            if (frmSalida.txtId.getText().equals("")) {
                listarSalida(frmSalida.tlbRegistrados);
            } else {
                registrarSalida();
                totaldeHorasSumadas(entrada.getId_Soporte());
                listarSalida(frmSalida.tlbRegistrados);
            }
        }
        if (e.getSource() == frmDias.menuItemEliminar) {

            eliminarDia(frmDias.Tabla);
            totaldeHorasSumadas(entrada.getId_Soporte());
        }
        if (e.getSource() == frmLogin.btnConectar) {
            validarAdministrador();
        }
        if (e.getSource() == frmDias.menuItemEditar) {
            editarDias(frmDias.Tabla);

        }

        if (e.getSource() == frmEditarDias.btnEditar) {
            editarDias();
            totaldeHorasSumadas(entrada.getId_Soporte());
        }
        if (e.getSource() == frmEditarDias.btnAgregarDia) {
            agregarDias();
            totaldeHorasSumadas(entrada.getId_Soporte());

        }

    }

    public void actionPerformed(KeyEvent evt) {
        if (evt.getSource() == frmEntrada.txtbuscador) {
            filtrarSoportes(frmEntrada.tlbSoportes, frmEntrada.txtbuscador.getText());
        }
        if (evt.getSource() == frmSalida.txtbuscador) {
            filtrarSoportes(frmSalida.tlbSoportes, frmSalida.txtbuscador.getText());
        }

        if (evt.getSource() == frmReporte.txtbuscador) {
            filtrarSoportes(frmReporte.tabla, frmReporte.txtbuscador.getText());
        }
        if (evt.getSource() == frmDias.txtbuscador) {
            filtrarDias(frmDias.Tabla, frmDias.txtbuscador.getText());
        }

    }

    public void actionPerformed(MouseEvent evt) {

    }

    class pintarFila extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            SimpleDateFormat Formato = new SimpleDateFormat("yyyy-MM-dd");
            String fechaComoCadena = Formato.format(new Date());
            String fechacorta = fechaComoCadena.substring(5, 10);
            if (table.getValueAt(row, 3).toString().substring(5, 10).equals(fechacorta)) {
                setBackground(Color.green);
            } else {
                //setBackground(Color.blue);
            }
            return this;
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

    private long totalHoras(String diaEntrada, String horaEntrada, String diaSalida, String horaSalida) {

        String Entrada = diaEntrada + " " + horaEntrada;
        String salida = diaSalida + " " + horaSalida;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date hEntrada = null;
        Date hSalida = null;
        try {

            hEntrada = format.parse(Entrada);

            hSalida = format.parse(salida);

        } catch (ParseException e) {

        }
        long diferencia = hSalida.getTime() - hEntrada.getTime();

        //long tiempoEnSegundos = TimeUnit.MILLISECONDS.toSeconds(diferencia);
        return diferencia;
    }

    private String calcularHoras(String diaEntrada, String horaEntrada, String diaSalida, String horaSalida) {

        String Entrada = diaEntrada + " " + horaEntrada;
        String salida = diaSalida + " " + horaSalida;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // Date hEntrada = null;
        //Date hSalida = null;
        String total = "";
        try {

            Date hEntrada = format.parse(Entrada);

            Date hSalida = format.parse(salida);
            long diferencia = hSalida.getTime() - hEntrada.getTime();

            long tiempoEnSegundos = TimeUnit.MILLISECONDS.toSeconds(diferencia);

            long horas = (tiempoEnSegundos / 3600);
            long minutos = ((tiempoEnSegundos - horas * 3600) / 60);
            long segundos = (tiempoEnSegundos - (horas * 3600 + minutos * 60));
            total = horas + ":" + minutos + ":" + segundos;

        } catch (ParseException e) {
            System.out.println("Error al calcular hoas " + e);
        }

        return total;
    }

}
