/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Peticion;
import Utils.Utils;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LAB_A112
 */
public class PeticionesMaestro extends Thread {
    
    private final Socket so;
    
    public PeticionesMaestro(Socket so){
        
        this.so = so;
        
    }
    
    @Override
    public void run(){
          
        try {
            ObjectInputStream input = new ObjectInputStream(this.so.getInputStream());
            
            Peticion peticion = (Peticion) input.readObject();
            
            // Asigna el ip del servidor maestro de llegada
            Utils.ipMaestroLlegada = this.so.getInetAddress().getHostAddress();
            peticion.ejecutarPeticion();
            
            
            if(this.debeNotificarCambio(peticion)){
                ObjectOutputStream output = new ObjectOutputStream(this.so.getOutputStream());    
                output.writeObject(Utils.listaArchivos);
                output.flush();
                
            }

            so.close();
            
        } catch (IOException ex) {
            Logger.getLogger(PeticionesMaestro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PeticionesMaestro.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
    
    public boolean debeNotificarCambio(Peticion peticion){
        
        if(peticion.getNombrePeticion().equals("I") || peticion.getNombrePeticion().equals("M") ||
           peticion.getNombrePeticion().equals("E")){
                return true;
        }
        
        return false;
    }
    
    
}
