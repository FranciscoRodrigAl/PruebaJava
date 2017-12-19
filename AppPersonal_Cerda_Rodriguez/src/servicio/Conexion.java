/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.driver.OracleDriver;

/**
 *
 * @author Concepción
 */
public class Conexion {
     //Usuario de la bd
    private final String USUARIO = "usuario01";
    //Contraseña del usuario de la bd
    private final String PASS = "usuario01";
    //SID de la bd, este lo registramos en la instalacion
    private final String SID = "XE";
    //Host donde se encuentra la bd
    private final String HOST = "cpc-am-01-01.aws.smartcloud.cl";
    //puerto 1521 es el estandar para este tipo de instalaciones
    private final int PUERTO = 1521;
    //Objeto donde se almacenará la conexión
    public Connection connection;
    
    public Connection getConnection() {
        return connection;
    }
    public void registrarDriver() throws SQLException {
        OracleDriver oracleDriver = new oracle.jdbc.driver.OracleDriver();
        DriverManager.registerDriver(oracleDriver);
    }
    public void conectar() throws SQLException {
        if (connection == null || connection.isClosed() == true) {
            String cadenaConexion = "jdbc:oracle:thin:@" + HOST + ":" + PUERTO + ":" + SID;
            registrarDriver();
            connection = DriverManager.getConnection(cadenaConexion, USUARIO, PASS);           
        }
    }
    /*
     * Método que cierra conexion, una vez hayamos terminado de usar la bd
     */
    public void cerrar() throws SQLException {
        if (connection != null && connection.isClosed() == false) {
            connection.close();
        }
    }
}
