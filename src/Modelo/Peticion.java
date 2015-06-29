/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author LAB_A112
 */
public abstract class Peticion implements Serializable{
    
    private String nombrePeticion;
    
    public Peticion(String nombrePeticion){
        this.nombrePeticion = nombrePeticion;
    }
    
    public boolean ejecutarPeticion(){
    
        return false;
    }
}
