/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itesz.com.soap;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import util.ConexionBD;

/**
 *
 * @author ITESZ53
 */
@WebService(serviceName = "SIEService")
public class SIEService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}
