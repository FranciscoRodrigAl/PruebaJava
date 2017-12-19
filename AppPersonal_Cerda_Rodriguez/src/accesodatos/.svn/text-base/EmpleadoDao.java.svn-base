/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import negocio.Empleado;
import servicio.Conexion;

/**
 *
 * @author felipecerda
 */
public class EmpleadoDao {
    
    private Empleado empleado;
    private ArrayList<Empleado> lista;

    public EmpleadoDao(Empleado empleado) {
        this.empleado = empleado;
    }   
    
    public boolean agregar() throws SQLException {
        if (!verificarExistencia()) {
            Conexion oracle = new Conexion();
            oracle.conectar();
            Connection conn = oracle.getConnection();
            Statement st = conn.createStatement();
            String query = "INSERT INTO fcs_empleados(codigo,rut,nombre,apellido,celular,email,sueldo_bruto,est_civil,NOM_DEPTO) VALUES ("
                    + empleado.getCodigo() + ",'" + empleado.getRut() + "','" 
                    + empleado.getNombre() + "','"+ empleado.getApellido()+ "',"
                    + empleado.getCelular()+ ",'" + empleado.getEmail() + "',"
                    + empleado.getSueldoBruto() + ",'" +empleado.getEstadoCivil() + "','"
                    + empleado.getNombreDepartamento() + "')";
            st.executeUpdate(query);
            return true;
        }
        return false;
    }
    
    public boolean modificar() throws SQLException {
        if (verificarExistencia()) {
            Conexion oracle = new Conexion();
            oracle.conectar();
            Connection conn = oracle.getConnection();
            Statement st = conn.createStatement();
            String query = "UPDATE fcs_empleados SET rut='" + empleado.getRut()+
                                               "' , nombre= '" + empleado.getNombre()+
                                               "' , apellido='" + empleado.getApellido()+
                                               "' , celular=" + empleado.getCelular()+
                                               "  , email='" + empleado.getEmail()+
                                               "' , sueldo_bruto=" + empleado.getSueldoBruto()+
                                               "  , est_civil='" + empleado.getEstadoCivil()+
                                               "' , nom_depto='" + empleado.getNombreDepartamento()+                    
                                               "' where codigo = " + empleado.getCodigo();
            st.executeUpdate(query);
            return true;
        }
        return false;
    }
    
    public boolean eliminar() throws SQLException {
        if (verificarExistencia()) {
            Conexion oracle = new Conexion();
            oracle.conectar();
            Connection conn = oracle.getConnection();
            Statement st = conn.createStatement();
            String query = "DELETE FROM fcs_empleados WHERE codigo= '" + empleado.getCodigo()+"'";
            st.executeUpdate(query);
            return true;
        }
        return false;
    }
    
    public ArrayList<Empleado> listar() throws SQLException, Exception {
        lista = new ArrayList<>();
        Conexion oracle = new Conexion();
        oracle.conectar();
        Connection conn = oracle.getConnection();        
        Statement st = conn.createStatement();
        String query = "SELECT FCS_EMPLEADOS.CODIGO, FCS_EMPLEADOS.RUT, "
                     + "FCS_EMPLEADOS.NOMBRE, FCS_EMPLEADOS.APELLIDO, "
                     + "FCS_EMPLEADOS.CELULAR, FCS_EMPLEADOS.EMAIL, "
                     + "FCS_EMPLEADOS.SUELDO_BRUTO, FCS_EMPLEADOS.EST_CIVIL, "
                     + "FCS_EMPLEADOS.NOM_DEPTO FROM FCS_EMPLEADOS";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Empleado item = new Empleado();
            item.setCodigo(rs.getInt("CODIGO"));
            item.setRut(rs.getString("RUT"));
            item.setNombre(rs.getString("NOMBRE"));
            item.setApellido(rs.getString("APELLIDO"));
            item.setCelular(rs.getInt("CELULAR"));
            item.setEmail(rs.getString("EMAIL"));
            item.setSueldoBruto(rs.getInt("SUELDO_BRUTO"));
            item.setEstadoCivil(rs.getString("EST_CIVIL"));
            item.setNombreDepartamento(rs.getString("NOM_DEPTO"));
            lista.add(item);
        }
        return lista;        
    }
    
    public boolean verificarExistencia() throws SQLException {
        Conexion oracle = new Conexion();
        oracle.conectar();
        Connection conn = oracle.getConnection();
        Statement st = conn.createStatement();
        String query = "SELECT codigo FROM fcs_empleados where codigo ='" + empleado.getCodigo() + "'";
        ResultSet rs = st.executeQuery(query);
        if (rs != null) {
            return rs.next();
        }
        return false;
    }
    
    public Empleado recuperar() throws SQLException, Exception {
        if(verificarExistencia()){
            Conexion oracle = new Conexion();
            oracle.conectar();
            Connection conn = oracle.getConnection();
            Statement st = conn.createStatement();
            System.out.println(empleado.getCodigo());
            String query = "SELECT * FROM fcs_empleados WHERE codigo = "+ empleado.getCodigo();
            ResultSet resultado = st.executeQuery(query);
            if (resultado != null) {
                while(resultado.next()){
                    empleado.setCodigo(resultado.getInt("CODIGO"));
                    empleado.setRut(resultado.getString("RUT"));
                    empleado.setNombre(resultado.getString("NOMBRE"));
                    empleado.setApellido(resultado.getString("APELLIDO"));
                    empleado.setCelular(resultado.getInt("CELULAR"));
                    empleado.setEmail(resultado.getString("EMAIL"));
                    empleado.setSueldoBruto(resultado.getInt("SUELDO_BRUTO"));
                    empleado.setEstadoCivil(resultado.getString("EST_CIVIL"));
                    empleado.setNombreDepartamento(resultado.getString("NOM_DEPTO"));                  
                }
                return empleado;
            }
        }
        return null;
    }  
    
    //consulta 2
    
    public ArrayList<Empleado> listarPorDepartamento(String nombreDepartamento) throws SQLException, Exception {
        lista = new ArrayList<>();
        Conexion oracle = new Conexion();
        oracle.conectar();
        Connection conn = oracle.getConnection();        
        Statement st = conn.createStatement();
        String query = "SELECT FCS_EMPLEADOS.CODIGO, FCS_EMPLEADOS.RUT, "
                     + "FCS_EMPLEADOS.NOMBRE, FCS_EMPLEADOS.APELLIDO, "
                     + "FCS_EMPLEADOS.CELULAR, FCS_EMPLEADOS.EMAIL, "
                     + "FCS_EMPLEADOS.SUELDO_BRUTO, FCS_EMPLEADOS.EST_CIVIL, "
                     + "FCS_EMPLEADOS.NOM_DEPTO FROM FCS_EMPLEADOS "
                     + "WHERE NOM_DEPTO ='" + nombreDepartamento + "'";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Empleado item = new Empleado();
            item.setCodigo(rs.getInt("CODIGO"));
            item.setRut(rs.getString("RUT"));
            item.setNombre(rs.getString("NOMBRE"));
            item.setApellido(rs.getString("APELLIDO"));
            item.setCelular(rs.getInt("CELULAR"));
            item.setEmail(rs.getString("EMAIL"));
            item.setSueldoBruto(rs.getInt("SUELDO_BRUTO"));
            item.setEstadoCivil(rs.getString("EST_CIVIL"));
            item.setNombreDepartamento(rs.getString("NOM_DEPTO"));
            lista.add(item);
        }
        return lista;        
    }
    
    // consulta 3
    
    public boolean eliminar120() throws SQLException {
        if (verificarExistencia()) {
            Conexion oracle = new Conexion();
            oracle.conectar();
            Connection conn = oracle.getConnection();
            Statement st = conn.createStatement();
            String query = "DELETE FROM fcs_empleados WHERE sueldo_bruto = 120000";
            st.executeUpdate(query);
            return true;
        }
        return false;
    }
    
    // consulta 4 
    
    public boolean subirSueldos() throws SQLException {
        Conexion oracle = new Conexion();
        oracle.conectar();
        Connection conn = oracle.getConnection();
        Statement st = conn.createStatement();
        String query = "UPDATE fcs_empleados SET sueldo_bruto = sueldo_bruto * 1.10" ;                    
        return st.executeUpdate(query) > 0;
    }    
}
