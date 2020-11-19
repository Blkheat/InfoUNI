
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    
    private static final String CONEXION_URL = "jdbc:sqlserver://absoluterequiemgotrain.database.windows.net;databaseName=uniinfo;user=yougotme;password=022878524653zA";
    private static Connection con;

    public static Connection getConexion() {
        try {
            con = DriverManager.getConnection(CONEXION_URL);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No hay conexion "+e);
        }

        return con;
    }
    
}
