/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporte;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import modelo.Conexion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Absolute
 */
public class GestionarReporte extends javax.swing.JFrame {

    Connection cn;

    public GestionarReporte() {
        
    }

    

    public void NuevoReporte(int id) {
        
                
                //String path = "src\\reporte\\NuevoReporte.jasper";
               
                
                try {
                    cn = Conexion.getConexion();
                    JasperReport reporte = null;
                    //reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
                    reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/reporte/NuevoReporte.jasper"));
                    Map parametro = new HashMap();
                    parametro.put("id", id);
                    JasperPrint print = JasperFillManager.fillReport(reporte,parametro,cn);
                    JasperViewer view = new JasperViewer(print,false);
                    //view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    view.setVisible(true);
                    //cn.close();
                    
                } catch ( JRException e) {
                    JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
                }
        
        
        
    }

}
