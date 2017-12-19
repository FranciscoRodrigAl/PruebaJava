/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import accesodatos.EmpleadoDao;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipecerda
 */
public class Empleado {
    
    private int codigo;
    private String rut;
    private String nombre;
    private String apellido;
    private int celular;
    private String email;
    private int sueldoBruto;
    private String estadoCivil;
    private String nombreDepartamento;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0 && codigo <= 100) {
            this.codigo = codigo;
        } else {
            throw new Exception();
        }        
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) throws Exception {
        if (!rut.isEmpty()) {
            this.rut = rut;
        } else {
            throw new Exception();
        }        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if (!nombre.isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new Exception();
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (!apellido.isEmpty()) {
            this.apellido = apellido;
        }

    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) throws Exception {
        if (celular > 99999999) {
            this.celular = celular;
        } else {
            throw new Exception();
        }        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(int sueldoBruto) throws Exception {
        if (sueldoBruto >= 120000) {
            this.sueldoBruto = sueldoBruto;
        } else {
            throw new Exception();
        }        
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) throws Exception {
        if (estadoCivil.equalsIgnoreCase("C") || estadoCivil.equalsIgnoreCase("S") || estadoCivil.equalsIgnoreCase("V")) {
            this.estadoCivil = estadoCivil;  
        } else {
            throw new Exception();
        }        
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) throws Exception {
        if (nombreDepartamento.equalsIgnoreCase("Informática") || nombreDepartamento.equalsIgnoreCase("Redes") || 
            nombreDepartamento.equalsIgnoreCase("Administración") || nombreDepartamento.equalsIgnoreCase("Finanzas") ||
            nombreDepartamento.equalsIgnoreCase("Bienestar"))
        {
            this.nombreDepartamento = nombreDepartamento;
        } else {
            throw new Exception();
        }        
    }

    public Empleado() {
    }
    
    public boolean agregar() throws SQLException {
        EmpleadoDao item = new EmpleadoDao(this);
        return item.agregar();
    }
    
    public boolean modificar() throws SQLException {
        EmpleadoDao item = new EmpleadoDao(this);
        return item.modificar();
    }
    
    public boolean eliminar() throws SQLException {
        EmpleadoDao item = new EmpleadoDao(this);
        return item.eliminar();
    }
    
    public ArrayList<Empleado> listar() throws Exception {
        EmpleadoDao item = new EmpleadoDao(this);
        return item.listar();
    } 
    
    public Empleado recuperar() throws Exception{
        EmpleadoDao item = new EmpleadoDao(this);
        return item.recuperar();
    }
    // consulta 2
    public ArrayList<Empleado> listarPorDepartamento(String nombreDepartamento) throws Exception {
        EmpleadoDao item = new EmpleadoDao(this);
        return item.listarPorDepartamento(nombreDepartamento);
    }
    
    // consulta 3
    public boolean eliminar120 () throws SQLException {
        EmpleadoDao item = new EmpleadoDao(this);
        return item.eliminar120();
    }
    
    // consulta 4
    
    public boolean subirSueldos () throws SQLException {
        EmpleadoDao item = new EmpleadoDao(this);
        return item.subirSueldos();
    }
}
