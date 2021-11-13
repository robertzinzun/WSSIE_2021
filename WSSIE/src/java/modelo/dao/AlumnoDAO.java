/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.dto.Alumno;
import util.ConexionBD;

/**
 *
 * @author ITESZ53
 */
public class AlumnoDAO {
    public Alumno consultarAlumno(String noControl){
        String sql="select nocontrol,nombre_completo,sexo,promedio,creditos,IDCARRERA,nombre_carrera,IDESTATUS,estatus\n" +
        ",telefono,email from vAlumnos where nocontrol=?";
        Alumno alumno=new Alumno();
        try{
            PreparedStatement ps=ConexionBD.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, noControl);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                alumno.setNoControl(noControl);
                alumno.setNombreCompleto(rs.getString("nombre_completo"));
                alumno.setSexo(rs.getString("sexo"));
                alumno.setPromedio(rs.getFloat("promedio"));
                alumno.setCreditos(rs.getInt("creditos"));
                alumno.setIdCarrera(rs.getInt("idCarrera"));
                alumno.setNombreCarrera(rs.getString("nombre_carrera"));
                alumno.setIdEstatus(rs.getInt("idEstatus"));
                alumno.setEstatus(rs.getString("estatus"));
                alumno.setTelefono(rs.getString("telefono"));
                alumno.setEmail(rs.getString("email"));  
            }
            rs.close();
            ps.close();
            ConexionBD.getInstance().cerrar();
        }
        catch(SQLException e){
            System.out.println("Error en la ejecución de la consulta:"+sql);
            System.out.println("Error:"+e.getMessage());
        }
        return alumno;
    }
}
