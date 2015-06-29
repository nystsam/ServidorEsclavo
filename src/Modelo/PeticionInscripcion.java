/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import Utils.Utils;

/**
 *
 * @author LAB_A112
 */
public class PeticionInscripcion extends Peticion implements Serializable {
    
    private String nombreRed;
    private String ipMaestro;
    private int puertoMaestro;

    public PeticionInscripcion(String nombreRed, String ipMaestro, int puertoMaestro) {
        super();
        this.nombreRed = nombreRed;
        this.ipMaestro = ipMaestro;
        this.puertoMaestro = puertoMaestro;
    }
    
    public PeticionInscripcion(){
        super();
    }
    
    @Override
    public boolean ejecutarPeticion(){
        
        Red red = new Red(this.nombreRed, null);
        
        red.setIp(this.ipMaestro);
        red.setPuerto(this.puertoMaestro);
        
        Utils.listaRedes.getLista().add(red);
        
        return false;
    }
    
}
