package modelo;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EntradaDAO {

    private Connection cn = null;
    private PreparedStatement stm;
    private ResultSet rs = null;

    public EntradaDAO() {
    }
    
    
    public void actualizarTotal(int id,String horas){
        
        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("{call sp_sumarlasHoras(?,?)}");
            stm.setInt(1, id);
            stm.setString(2, horas);
            stm.executeUpdate();
            stm.clearParameters();
            //stm.close();
        } catch (SQLException e) {
            System.out.println("actualizar hora"+e);
        }
    }
    
    public List horayEntrada(int id){
        List<Entrada> lista = new ArrayList<>();
        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("{call sp_horayFechaEntrada(?)}");
            stm.setInt(1, id);
            
            rs = stm.executeQuery();
            while (rs.next()) {
                Entrada obj = new Entrada();
                obj.setFechaIngreso(rs.getString(1));
                obj.setHoraIngreso(rs.getString(2));
                obj.setFechaSalida(rs.getString(3));
                obj.setHoraSalida(rs.getString(4));
                
                lista.add(obj);
            }
//            stm.clearParameters();
//            stm.close();
//            rs.close();
        } catch (SQLException e) {
            System.out.println(""+e);
        }
        return lista;
    }

    public List filtrarEntrada(String fecha) {
        List<Entrada> lista = new ArrayList<>();
        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("{call sp_entrada(?)}");
            stm.setString(1, fecha);
            rs = stm.executeQuery();
            while (rs.next()) {
                Entrada obj = new Entrada();
                obj.setApellidos(rs.getString(1));
                obj.setNombres(rs.getString(2));
                obj.setHoraIngreso(rs.getString(3));
                obj.setFecha_Nacimiento(rs.getString(4));
                lista.add(obj);
            }
            stm.clearParameters();
            stm.close();
            rs.close();
            //cn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }

    public List filtrarSalida(String fecha) {
        List<Entrada> lista = new ArrayList<>();
        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("{call sp_salida(?)}");
            stm.setString(1, fecha);
            rs = stm.executeQuery();
            while (rs.next()) {
                Entrada obj = new Entrada();
                obj.setApellidos(rs.getString(1));
                obj.setNombres(rs.getString(2));
                obj.setHoraSalida(rs.getString(3));
                obj.setFecha_Nacimiento(rs.getString(4));
                lista.add(obj);
            }
            stm.clearParameters();
            stm.close();
            rs.close();
           // cn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }

    public List filtrarDias(String apellido) {
        List<Entrada> lista = new ArrayList<>();
        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("{call sp_listarDias(?)}");
            stm.setString(1, apellido);
            rs = stm.executeQuery();
            while (rs.next()) {
                Entrada obj = new Entrada();
                obj.setId_entrada(rs.getInt(1));
                obj.setId_Soporte(rs.getInt(2));
                obj.setApellidos(rs.getString(3));
                obj.setNombres(rs.getString(4));
                obj.setFechaIngreso(rs.getString(5));
                obj.setHoraIngreso(rs.getString(6));
                obj.setFechaSalida(rs.getString(7));
                obj.setHoraSalida(rs.getString(8));

                lista.add(obj);
            }
            stm.clearParameters();
            stm.close();
            rs.close();
            //cn.close();
        } catch (SQLException e) {
            System.out.println("error " + e);

        }
        return lista;
    }
    
    public int validarAdmin (String usuario, String contrasena){
        int validar = 0;
        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("{call sp_validarAdministrador(?,?)}");
            stm.setString(1, usuario);
            stm.setString(2, contrasena);
            rs = stm.executeQuery();
            if (rs.next()) {
                validar=1;
            }
            rs.close();
            stm.clearParameters();
            stm.close();
            //cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error validar admin base de datos"+e);
        }
        return validar;
    }
    
    public int validarEstado(Entrada obj){
        int valir = 0;
        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("{call sp_validarEstado(?)}");
            stm.setInt(1, obj.getId_Soporte());
            rs=stm.executeQuery();
            if (rs.next()) {
                valir=1;
            }
            rs.close();
            stm.clearParameters();
            stm.close();
            //cn.close();
        } catch (SQLException e) {
            System.out.println("Error"+e.getMessage());
        }
        return valir;
    }

    public List filtrarSoporteEntrada(String apellido) {
        List<Soporte> lista = new ArrayList<>();
        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("{call sp_filtrarSoporteParaEntrada(?)}");
            stm.setString(1, apellido);
            rs = stm.executeQuery();
            while (rs.next()) {
                Soporte obj = new Soporte();
                obj.setId_Soporte(rs.getInt(1));
                obj.setApellidos(rs.getString(2));
                obj.setNombres(rs.getString(3));
                obj.setTurno(rs.getString(4));
                obj.setFoto(rs.getBytes(5));
                
                lista.add(obj);
            }
            stm.clearParameters();
            stm.close();
            rs.close();
            //cn.close();
        } catch (SQLException e) {
            System.out.println("error " + e);

        }
        return lista;
    }
    
    public int agregarDias(Entrada obj){
        int validar =0;
        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("{call sp_agregarDias(?,?,?,?,?)}");
            stm.setInt(1, obj.getId_Soporte());
            stm.setString(2, obj.getHoraIngreso());
            stm.setString(3, obj.getFechaIngreso());
            stm.setString(4, obj.getHoraSalida());
            stm.setString(5, obj.getFechaSalida());
            validar = stm.executeUpdate();
            stm.clearParameters();
            stm.close();
        } catch (SQLException e) {
            System.out.println(""+e);
        }
        return validar;
    }
    
    public int editarDias(Entrada obj){
        int validar=0;
        
        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("{call sp_EditarDias(?,?,?,?,?,?)}");
            stm.setInt(1, obj.getId_Soporte());
            stm.setInt(2, obj.getId_entrada());
            stm.setString(3, obj.getFechaIngreso());
            stm.setString(4, obj.getHoraIngreso());
            stm.setString(5, obj.getFechaSalida());
            stm.setString(6, obj.getHoraSalida());
            validar = stm.executeUpdate();
            stm.clearParameters();
            stm.close();
            //cn.close();
        } catch (SQLException e) {
            System.out.println("Error Editar el dia" + e);
        }
        
        
        return validar;
    }

    public int registrarEntrada(Entrada obj) {
        int valor = 0;
        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("{call sp_registrarEntrada(?,?,?)}");
            stm.setInt(1, obj.getId_Soporte());
            stm.setString(2, obj.getHoraIngreso());
            stm.setString(3, obj.getFechaIngreso());
            valor = stm.executeUpdate();
            stm.clearParameters();
            stm.close();
            //cn.close();
        } catch (SQLException e) {
            System.out.println("Error registro de entrada" + e);
        }
        return valor;
    }

    public int registrarSalida(Entrada obj) {
        int valor = 0;
        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("{call sp_registrarSalida(?,?,?)}");
            stm.setInt(1, obj.getId_Soporte());
            stm.setString(2, obj.getHoraSalida());
            stm.setString(3, obj.getFechaSalida());
            valor = stm.executeUpdate();
            stm.clearParameters();
            stm.close();
            //cn.close();
        } catch (SQLException e) {
            System.out.println("Error registro de salida" + e);
        }
        return valor;
    }

    public int eliminarDia(int idDia, int idSoporte) {
        int valor = 0;
        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("{call sp_eliminardia(?,?)}");
            stm.setInt(1, idDia);
            stm.setInt(2, idSoporte);
            valor = stm.executeUpdate();
            stm.clearParameters();
            stm.close();
           // cn.close();
        } catch (SQLException ex) {
            System.out.println("Error eliminar dia " + ex);
        }
        return valor;
    }

}
