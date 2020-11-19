package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SoporteDAO {

    private Connection cn = null;
    private PreparedStatement stm;
    private ResultSet rs = null;

    public SoporteDAO() {

    }

    public List filtrarSoporte(String apellido) {
        List<Soporte> lista = new ArrayList<>();
        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("{call sp_filtrarSoporte(?)}");
            stm.setString(1, apellido);
            rs = stm.executeQuery();
            while (rs.next()) {
                Soporte obj = new Soporte();
                obj.setId_Soporte(rs.getInt(1));
                obj.setApellidos(rs.getString(2));
                obj.setNombres(rs.getString(3));
                obj.setDni(rs.getString(4));
                obj.setDomicilio(rs.getString(5));
                obj.setFecha_Nacimiento(rs.getString(6));
                obj.setCorreo(rs.getString(7));
                obj.setCelular(rs.getString(8));
                obj.setTurno(rs.getString(9));
                obj.setTotal_horas(rs.getString(10));
                obj.setEstado(rs.getString(11));
                obj.setFoto(rs.getBytes(12));
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

    public List listarSoportes() {
        List<Soporte> lista = new ArrayList<>();

        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("{call sp_verSoporte}");
            rs = stm.executeQuery();
            while (rs.next()) {
                Soporte obj = new Soporte();
                obj.setId_Soporte(rs.getInt(1));
                obj.setApellidos(rs.getString(2));
                obj.setNombres(rs.getString(3));
                obj.setDni(rs.getString(4));
                obj.setDomicilio(rs.getString(5));
                obj.setFecha_Nacimiento(rs.getString(6));
                obj.setCorreo(rs.getString(7));
                obj.setCelular(rs.getString(8));
                obj.setTurno(rs.getString(9));
                obj.setTotal_horas(rs.getString(10));
                obj.setEstado(rs.getString(11));
                obj.setFoto(rs.getBytes(12));
                lista.add(obj);
                
            }
            stm.clearParameters();
               stm.close();
               rs.close();
               // cn.close();
        } catch (SQLException e) {
            System.out.println("error " + e);
        }
        return lista;
    }

    public void eliminarSoporte(int id) {

        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("{call sp_eliminarSoporte(?)}");
            stm.setInt(1, id);
            stm.executeUpdate();
            stm.clearParameters();
            stm.close();
           // cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SoporteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int modificarSoporte(Soporte obj) {
        int valor = 0;
        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("{call sp_actualizarSoporte(?,?,?,?,?,?,?,?,?,?,?)}");
            stm.setInt(1, obj.getId_Soporte());
            stm.setString(2, obj.getNombres());
            stm.setString(3, obj.getApellidos());
            stm.setString(4, obj.getDni());
            stm.setString(5, obj.getDomicilio());
            stm.setString(6, obj.getFecha_Nacimiento());
            stm.setString(7, obj.getCorreo());
            stm.setString(8, obj.getCelular());
            stm.setString(9, obj.getTurno());
            stm.setBytes(10, obj.getFoto());
            stm.setString(11, obj.getEstado());
            valor = stm.executeUpdate();
            stm.clearParameters();
            stm.close();
           // cn.close();
        } catch (SQLException e) {
            System.out.println("Error al modificar " + e);
        }
        return valor;
    }

    //funcion para agregar soporte que devuelve 1 si se ha agregado ó 0 (cero) si no se agregó
    public int agregarSoporte(Soporte obj) {
        int valor = 0;

        try {
            cn = Conexion.getConexion();
            stm = cn.prepareCall("{call sp_agregarSoporte(?,?,?,?,?,?,?,?,?,?)}");
            stm.setString(1, obj.getNombres());
            stm.setString(2, obj.getApellidos());
            stm.setString(3, obj.getDni());
            stm.setString(4, obj.getDomicilio());
            stm.setString(5, obj.getFecha_Nacimiento());
            stm.setString(6, obj.getCorreo());
            stm.setString(7, obj.getCelular());
            stm.setString(8, obj.getTurno());
            stm.setBytes(9, obj.getFoto());
            stm.setString(10, obj.getEstado());

            valor = stm.executeUpdate();
            stm.clearParameters();
            stm.close();
           // cn.close();
        } catch (SQLException e) {
            System.out.println("Error " + e);
            
        }

        return valor;

    }

}
