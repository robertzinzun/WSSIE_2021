/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author ITESZ53
 */
public class ConexionBD {
    private static ConexionBD conexion;
    private Connection connection;
    private ConexionBD(){
        try {
            Context ctx=new InitialContext();
            DataSource ds=(DataSource) ctx.lookup("jdbc/SIE");
            connection=ds.getConnection();
        } catch (NamingException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static ConexionBD getInstance(){
        if(conexion==null){
            conexion=new ConexionBD();
        }
        return conexion;
    }

    public Connection getConnection() {
        return connection;
    }
    public void cerrar(){
        try {
            connection.close();
            conexion=null;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
