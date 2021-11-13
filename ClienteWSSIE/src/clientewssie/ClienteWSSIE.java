/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientewssie;

/**
 *
 * @author ITESZ53
 */
public class ClienteWSSIE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alumno alumno=consultarAlumno("14010009");
        System.out.println(alumno.getNombreCompleto());
    }

    private static Alumno consultarAlumno(java.lang.String noControl) {
        clientewssie.SIEService_Service service = new clientewssie.SIEService_Service();
        clientewssie.SIEService port = service.getSIEServicePort();
        return port.consultarAlumno(noControl);
    }
    
}
