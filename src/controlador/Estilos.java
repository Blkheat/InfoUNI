/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Absolute
 */
public class Estilos extends DefaultTableCellRenderer {

    private int columna;

    public Estilos() {
    }

   
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        SimpleDateFormat Formato = new SimpleDateFormat("yyyy-MM-dd");
    String fechaComoCadena = Formato.format(new Date());
    String fechaConvertido =  fechaComoCadena.substring(5, 10);
    String datocumpleano = (String)table.getValueAt(row,columna);
    String convertido = datocumpleano.substring(5, 10);
        if (convertido.equals(fechaConvertido)) {
            setBackground(Color.orange);
        } else {
            //setBackground(Color.blue);
        }
        return this;
    }

    public void estiloTabla(JTable tabla) {
        //JTableHeader header = tabla.getTableHeader();
        tabla.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabla.getTableHeader().setOpaque(false);
        tabla.getTableHeader().setBackground(new Color(32, 136, 203));
        tabla.getTableHeader().setForeground(new Color(32, 136, 203));
        tabla.setRowHeight(25);

    }

}
